package ruokapaivakirja.ui;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import ruokapaivakirja.dao.SqlDishDao;
import ruokapaivakirja.domain.MealService;
import ruokapaivakirja.domain.Meal;
import ruokapaivakirja.dao.SqlMealDao;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.DishService;

/**
 * Creates programs ui
 */
public class RuokapaivakirjaUi extends Application {
    private Stage stage;
    private MealService mealService;
    private DishService dishService;
    private Scene mainScene;
    private Scene dishScene;
    private Scene reportsScene;
    MainViewController mainViewController;
    DishViewController dishViewController;
    ReportsViewController reportsViewController;
    DishListView listView = new DishListView();
    
    /**
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        InputStream input = RuokapaivakirjaUi.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(input);
        String dataBase = properties.getProperty("db");
        SqlDishDao dishDao =new SqlDishDao("dataBase");
        SqlMealDao mealDao = new SqlMealDao("dataBase",dishDao);
        mealService = new MealService(mealDao, dishDao);
        dishService = new DishService(dishDao);
        listView.setDishService(dishService);
        
        FXMLLoader dishSceneLoader = new FXMLLoader(getClass().getClassLoader().getResource("DishView.fxml"));
        Parent dishPane = dishSceneLoader.load();
        dishViewController = dishSceneLoader.getController();
        dishViewController.setDishListView(listView);
        dishViewController.setDishService(dishService);
        dishViewController.setApplication(this);
        dishScene = new Scene(dishPane);
        
        FXMLLoader mainSceneLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainView.fxml"));
        Parent mainPane = mainSceneLoader.load();
        mainViewController = mainSceneLoader.getController();
        mainViewController.setDishListView(listView);
        mainViewController.setDishService(dishService);
        mainViewController.setMealService(mealService);
        mainViewController.setApplication(this);
        mainScene = new Scene(mainPane);
        
        FXMLLoader reportsSceneLoader = new FXMLLoader(getClass().getClassLoader().getResource("ReportsView.fxml"));
        Parent reportsPane = reportsSceneLoader.load();
        reportsViewController = reportsSceneLoader.getController();
        reportsViewController.setMealService(mealService);
        reportsViewController.setApplication(this);
        reportsScene = new Scene(reportsPane);
    }

    /**
     * Starts application
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
            this.stage = stage;
            stage.setTitle("Ruokapäiväkirja");
            stage.setScene(mainScene);
            stage.show();
        }
    
    /**
     * Changes scene to MainScene
     */
    public void setMainScene() {
        stage.setScene(mainScene);
    }
    
    /**
     *  Changes scene to DishScene
     */
    public void setDishScene() {
        stage.setScene(dishScene);
    }

    /**
     *  Changes scene to ReportsScene
     */
    public void setReportsScene() {
        stage.setScene(reportsScene);
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
           launch(args);
        }

    }
