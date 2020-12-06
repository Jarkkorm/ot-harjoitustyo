package ruokapaivakirja.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.converter.StringConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.DishService;
import ruokapaivakirja.ui.RuokapaivakirjaUi;
import ruokapaivakirja.domain.Meal;
import ruokapaivakirja.domain.MealService;

/**
 * FXML Controller class
 *
 * @author jarkko
 */
public class MainViewController implements Initializable {
    private MealService mealService;
    private DishService dishService;
    private RuokapaivakirjaUi application;
    private ObservableList<Meal> mealList;
    private ObservableList<Dish> dishList;
    private ObservableList<String> categories;

    @FXML
    private DatePicker fxDate;
    @FXML
    private ChoiceBox<String> fxCategory;
    @FXML
    private ChoiceBox<Dish> fxDish;
    @FXML
    private TableView<Meal> tbMealTable;
    @FXML
    private TableColumn<Meal, Integer> tbId;
    @FXML
    private TableColumn<Meal, Date> tbDate;
    @FXML
    private TableColumn<Meal, String> tbCategory;
    @FXML
    private TableColumn<Meal, Dish> tbDish;
    
    public void changeToDishView(ActionEvent event) {
        application.setDishScene();
    }   
    
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
    
    public void setMealService(MealService mealService) {
        this.mealService = mealService;
        showMealList();
        addToChoiseDishList();
        addToChoiseCategories();
                
    }

    public void setApplication(RuokapaivakirjaUi application) {
        this.application = application;
    }
    
    /**
     * Initializes the controller class.
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tbCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tbDish.setCellValueFactory(new PropertyValueFactory<>("dish"));      
    }
    
    public void showMealList() {
        mealList = FXCollections.observableArrayList(mealService.getMeals());
        tbMealTable.setItems(mealList);
    }
    
    public void addToChoiseDishList() {
        dishList = FXCollections.observableArrayList(dishService.getDishes());
        fxDish.setItems(dishList);
    }

    public void addToChoiseCategories() {
        categories = FXCollections.observableArrayList(mealService.getCategories());
        fxCategory.setItems(categories);
    }
    
    @FXML
    private void addMeal(ActionEvent event) {
        Meal addedMeal = mealService.createMeal(Date.valueOf(fxDate.getValue()), fxDish.getValue(), fxCategory.getValue());                                                                                                   
        mealList.add(addedMeal);
    }
}