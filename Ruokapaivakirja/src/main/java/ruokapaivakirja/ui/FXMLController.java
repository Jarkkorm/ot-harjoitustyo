package ruokapaivakirja.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ruokapaivakirja.domain.Meal;
import ruokapaivakirja.domain.MealService;

/**
 * FXML Controller class
 *
 * @author jarkko
 */
public class FXMLController implements Initializable {
    private MealService mealService;
    
    @FXML
    private TextField category;
    @FXML
    private ListView<Meal> listView;
    
    public void setMealService(MealService mealService){
            this.mealService = mealService;
    }
    
    private ObservableList<Meal> mealList;
    
    /**
     * Initializes the controller class.
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mealList = FXCollections.observableArrayList();
        //mealList = mealService.getMealList();
        listView.setItems(mealList);

    }
    public void initialize(){

    }

    @FXML
    private void addMeal(ActionEvent event) {
        mealList.add(new Meal(category.getText()));
        //mealService.addToMeal(category.getText());
    }
}

