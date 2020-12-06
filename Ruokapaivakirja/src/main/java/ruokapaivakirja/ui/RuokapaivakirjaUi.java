package ruokapaivakirja.ui;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import ruokapaivakirja.dao.SqlDishDao;
import ruokapaivakirja.domain.MealService;
import ruokapaivakirja.domain.Meal;
import ruokapaivakirja.dao.SqlMealDao;
import ruokapaivakirja.domain.DishService;

public class RuokapaivakirjaUi extends Application {
    private Stage stage;
    private MealService mealService;
    private DishService dishService;
    private Scene mainScene;
    private Scene dishScene;
    
    
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
        
        FXMLLoader dishSceneLoader = new FXMLLoader(getClass().getClassLoader().getResource("DishView.fxml"));
        Parent dishPane = dishSceneLoader.load();
        DishViewController dishViewController = dishSceneLoader.getController();
        dishViewController.setDishService(dishService);
        dishViewController.setApplication(this);
        dishScene = new Scene(dishPane);
        
        FXMLLoader mainSceneLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainView.fxml"));
        Parent mainPane = mainSceneLoader.load();
        MainViewController mainViewController = mainSceneLoader.getController();
        mainViewController.setDishService(dishService);
        mainViewController.setMealService(mealService);
        mainViewController.setApplication(this);
        mainScene = new Scene(mainPane);
    }

    @Override
    public void start(Stage stage) throws Exception {
            this.stage = stage;
            stage.setTitle("Ruokapäiväkirja");
            stage.setScene(mainScene);
            stage.show();
        }
    
    public void setMainScene() {
        stage.setScene(mainScene);
    }
    
    public void setDishScene() {
        stage.setScene(dishScene);
    }
    
    public static void main(String[] args) {
           launch(args);
        }
    }
