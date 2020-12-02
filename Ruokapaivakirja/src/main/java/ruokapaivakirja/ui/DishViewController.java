package ruokapaivakirja.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.DishService;
import ruokapaivakirja.domain.Meal;

/**
 * FXML Controller class
 *
 * @author jarkko
 */
public class DishViewController implements Initializable {
    private DishService dishService;
    private RuokapaivakirjaUi application;
    private ObservableList<Dish> dishList;
    
    @FXML
    private TextField dvDescription;
    @FXML
    private TextField dvCalories;
    @FXML
    private TextField dvProteins;
    @FXML
    private TextField dvCarbs;
    @FXML
    private TextField dvSugars;
    @FXML
    private TextField dvFats;
    @FXML
    private TableView<Dish> tbMeals;
    @FXML
    private TableColumn<Dish, Integer> colId;
    @FXML
    private TableColumn<Dish, String> colDescription;
    @FXML
    private TableColumn<Dish, Integer> colCalories;
    @FXML
    private TableColumn<Dish, Double> colProteins;
    @FXML
    private TableColumn<Dish, Double> colCarbs;
    @FXML
    private TableColumn<Dish, Double> colSugars;
    @FXML
    private TableColumn<Dish, Double> colFats;
    @FXML
    private Button dvAddDish;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));
        colProteins.setCellValueFactory(new PropertyValueFactory<>("proteins"));
        colCarbs.setCellValueFactory(new PropertyValueFactory<>("carbs"));
        colSugars.setCellValueFactory(new PropertyValueFactory<>("sugars"));
        colFats.setCellValueFactory(new PropertyValueFactory<>("fats"));
    }    
    
    // Changes Scene to MainScene
    @FXML
    public void changeToMainView(ActionEvent event) throws IOException {
        application.setMainScene();
    }

    @FXML
    private void addDish(ActionEvent event) {
        dishService.createDish(dvDescription.getText(), Integer.parseInt(dvCalories.getText()), Double.parseDouble(dvProteins.getText()), Double.parseDouble(dvCarbs.getText()), Double.parseDouble(dvSugars.getText()), Double.parseDouble(dvFats.getText()));
        tbMeals.getItems().setAll(dishService.getDishes());
        dvDescription.setText("");
        dvCalories.setText("");
        dvProteins.setText("");
        dvCarbs.setText("");
        dvSugars.setText(""); 
        dvFats.setText("");        
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    public void setApplication(RuokapaivakirjaUi application) {
        this.application = application;
    }
    
}