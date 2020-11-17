package ruokapaivakirja.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import ruokapaivakirja.domain.MealService;

public class RuokapaivakirjaUi extends Application {
    private Stage stage;
    private MealService mealService;
    private Scene mainScene;
    
    @Override
    public void init() throws Exception {
        mealService = new MealService();
        
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
