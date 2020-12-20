package ruokapaivakirja.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.DishService;
import ruokapaivakirja.domain.Meal;
import ruokapaivakirja.domain.MealService;

/**
 * FXML Controller class
 * Controls Reports view
 */
public class ReportsViewController implements Initializable {
    private MealService mealService;
    private RuokapaivakirjaUi application;

    @FXML
    private TableView<Meal> tbDoneTable;
    @FXML
    private TableColumn<Meal, Integer> tbId;
    @FXML
    private TableColumn<Meal, Date> tbDate;
    @FXML
    private TableColumn<Meal, String> tbCategory;
    @FXML
    private TableColumn<Meal, Dish> tbDish;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void setMealService(MealService mealService) {
        this.mealService = mealService;
        setReports();
    }

    /**
     * Gets all meals that are done and sets them to table
     */
    private void setReports() {
        ObservableList<Meal> mealList = FXCollections.observableArrayList(mealService.getAllDone());
        tbId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tbCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tbDish.setCellValueFactory(new PropertyValueFactory<>("dish"));
        tbDoneTable.setItems(mealList);
    }
    
    public void setApplication(RuokapaivakirjaUi application) {
        this.application = application;
    }

    /**
     *  Asks application change scene to mainview
     * @param event
     * @throws IOException
     */
    @FXML
    public void changeToMainView(ActionEvent event) throws IOException {
        application.setMainScene();
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
     * Closes application
     * @param event
     */
    @FXML
    private void closeApplication(ActionEvent event) {
        System.exit(0);
    }   

}
