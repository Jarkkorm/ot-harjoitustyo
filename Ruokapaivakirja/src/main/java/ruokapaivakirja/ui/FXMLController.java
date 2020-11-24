package ruokapaivakirja.ui;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private DatePicker fxDate;
    @FXML
    private ChoiceBox<String> fxCategory;
    @FXML
    private ChoiceBox<Meal> fxMeal;
    @FXML
    private TableView<Meal> fxPlan;
    @FXML
    private TableColumn<Meal, Date> fxPlanDate;
    @FXML
    private TableColumn<Meal, Integer> fxPlanCategory;
    @FXML
    private TableColumn<Meal, String> fxPlanMeal;
    @FXML
    private TableColumn<Meal, Integer> fxMealCalories;
    
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
        //tableView.setItems(mealList);

    }
    public void initialize(){

    }

    @FXML
    private void addMeal(ActionEvent event) {
        //mealList.add(new Meal(category.getText()));
        //mealService.addToMeal(category.getText());
    }
}

