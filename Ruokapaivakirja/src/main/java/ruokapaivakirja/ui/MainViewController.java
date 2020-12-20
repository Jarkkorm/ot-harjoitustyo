package ruokapaivakirja.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.DishService;
import ruokapaivakirja.ui.RuokapaivakirjaUi;
import ruokapaivakirja.domain.Meal;
import ruokapaivakirja.domain.MealService;

/**
 * FXML Controller class
 * Controls paivakirja view
 */
public class MainViewController implements Initializable {
    private MealService mealService;
    private DishService dishService;
    private RuokapaivakirjaUi application;
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
    @FXML
    private Label lbCalories;
    @FXML
    private Label lbId;  
    
    /**
     *
     * @param dishService
     */
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
        addToChoiseDishList();
    }
    
    /**
     *
     * @param mealService
     */
    public void setMealService(MealService mealService) {
        this.mealService = mealService;
        showMealList();
        addToChoiseCategories();       
    }

    /**
     *
     * @param application
     */
    public void setApplication(RuokapaivakirjaUi application) {
        this.application = application;
    }
    
    /**
     * Initializes the controller class.
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    /**
     * Gets all meals that are not done and sets them to table
     */
    public void showMealList() {
        ObservableList<Meal> mealList = FXCollections.observableArrayList(mealService.getMeals());
        tbId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tbCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tbDish.setCellValueFactory(new PropertyValueFactory<>("dish"));
        tbMealTable.setItems(mealList);
    }
    
    /**
     * Sets Dishes to ChoiseBox 
     */
    public void addToChoiseDishList() {
        fxDish.setItems(dishList);
    }

    /**
     * Sets Categories to ChoiseBox
     */
    public void addToChoiseCategories() {
        categories = FXCollections.observableArrayList(mealService.getCategories());
        fxCategory.setItems(categories);
    }

    void setDishListView(DishListView listView) {
        this.dishList = listView.getDishList();
    }

    /**
     * When meal is selected sets meals information for editing
     */
    @FXML
    private void onMealSelected(MouseEvent event) {
        Meal meal = tbMealTable.getSelectionModel().getSelectedItem();
        lbId.setText(Integer.toString(meal.getId()));
        fxDate.setValue(meal.getDate().toLocalDate());
        fxDish.setValue(meal.getDish());
        fxCategory.setValue(meal.getCategory());
    }

    /**
     * When date is selected sets summarized calories to calories label
     */    
    @FXML
    private void dpDateSelected(ActionEvent event) throws Exception {
        Date date = Date.valueOf(fxDate.getValue());
        lbCalories.setText(Integer.toString(mealService.getDayCalories(date)));
    }

    /**
     * When button clicked sends fields information to mealservice
     * for creation of new meal and updates meal table
     */
    @FXML
    private void addMeal(ActionEvent event) {
        mealService.createMeal(Date.valueOf(fxDate.getValue()), fxDish.getValue(), fxCategory.getValue());
        showMealList();
    }

    /**
     * When button clicked sends fields information to mealservice
     * for updating meals information and updates meal table
     */    
    @FXML
    private void changeMeal(ActionEvent event) {
        if (Integer.parseInt(lbId.getText()) > 0) {
            mealService.changeMeal(Integer.parseInt(lbId.getText()), Date.valueOf(fxDate.getValue()), fxDish.getValue(), fxCategory.getValue());
            showMealList();
        }
    }

    /**
     * When button clicked sends fields information to mealservice
     * for deletion of meal and updates meal table
     */
    @FXML
    private void deleteMeal(ActionEvent event) {
        mealService.deleteMeal(Integer.parseInt(lbId.getText()));
        showMealList();    
    }

    /**
     * When button clicked sends fields information to mealservice
     * for setting it done, emptyes fields and updates meal table
     */
    @FXML
    private void setDone(ActionEvent event) {
        mealService.markDone(Integer.parseInt(lbId.getText()));
        lbId.setText("0");
        fxDate.getEditor().clear();
        fxCategory.valueProperty().set(null);
        fxDish.valueProperty().set(null);
        showMealList();
    }

    /**
     * Asks application change scene to dishview
     * @param event
     */
    @FXML
    public void changeToDishView(ActionEvent event) {
        application.setDishScene();
    }

    /**
     * Asks application change scene to reportsview
     * @param event
     */
    @FXML
    public void changeToReportsView(ActionEvent event) {
        application.setReportsScene();
    }

    /**
     * Closes application
     * @param event
     */    
    @FXML
    private void closeApplication(ActionEvent event) {
        System.exit(0);
    }
}