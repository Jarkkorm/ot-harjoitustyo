
package ruokapaivakirja.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.DishService;

/**
 * Handles views where view of dishes is needed 
 * @author jarkko
 */
public class DishListView {
    private ObservableList<Dish> dishList;
    private DishService dishService;

    /**
     *
     */
    public DishListView() {
        
    }

    /**
     *
     * @return
     */
    public ObservableList<Dish> getDishList() {
        return dishList;
    }

    /**
     *
     * @param dishList
     */
    public void setDishList(ObservableList<Dish> dishList) {
        this.dishList = dishList;
    }

    void setDishService(DishService dishService) {
        this.dishService = dishService;
        this.dishList = FXCollections.observableArrayList(dishService.getDishes());
    }
    
    
}
