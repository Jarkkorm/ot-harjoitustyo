package ruokapaivakirja.domain;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Class that stores data of Meal
 * 
 */
public class Meal {
    private int id;
    private Date date;
    private Dish dish;
    private String category;
    private int done;

    /**
     * Creates a Meal without id
     * @param date
     * @param dish
     * @param category
     */
    public Meal(Date date, Dish dish, String category) {
        this.date = date;
        this.dish = dish;
        this.category = category;
        this.done = 0;
    }
    
    /**
     * Creates a Meal with all fields
     * @param i
     * @param date
     * @param dish
     * @param string
     * @param i1
     */
    public Meal(int id, Date date, Dish dish, String category, int done) {
        this.id = id;
        this.date = date;
        this.dish = dish;
        this.category = category;
        this.done = done;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public Dish getDish() {
        return dish;
    }

    /**
     *
     * @param dish
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    /**
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     */
    public void setDone() {
        this.done = 1;
    }

    /**
     *
     * @return
     */
    public int getDone() {
        return done;
    }

}
