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

public class RuokapaivakirjaUi extends Application {
    private Stage stage;
    private MealService mealService;
    private Scene mainScene;
    
    @Override
    public void init() throws Exception {
        InputStream input = new FileInputStream("resources/config.properties");
        Properties properties = new Properties();
        properties.load(input);
        String dataBase = properties.getProperty("db");
        SqlDishDao dishDao =new SqlDishDao("dataBase");
        SqlMealDao mealDao = new SqlMealDao("dataBase",dishDao);
        mealService = new MealService(mealDao, dishDao);
        
        FXMLLoader sceneLoader =new FXMLLoader(getClass().getClassLoader().getResource("FXML.fxml"));
        Parent mainPane = sceneLoader.load();
        FXMLController fxmlController = sceneLoader.getController();
        fxmlController.setMealService(mealService);
        mainScene = new Scene(mainPane);
    }

    @Override
    public void start(Stage stage) throws Exception {
            this.stage = stage;
            stage.setTitle("Ruokapäiväkirja");
            stage.setScene(mainScene);
            stage.show();
        }
    
        public static void main(String[] args) {
           launch(args);
        }
    }
