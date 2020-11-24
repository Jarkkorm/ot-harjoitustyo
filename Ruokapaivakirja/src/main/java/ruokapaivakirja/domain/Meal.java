package ruokapaivakirja.domain;

import java.time.LocalDate;

public class Meal {
    private int id;
    private LocalDate date;
    private Dish dish;
    private int category;
    private int done;

    public Meal(LocalDate date, Dish dish, int category) {
        this.date = date;
        this.dish = dish;
        this.category = category;
        this.done = 0;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setDone() {
        this.done = 1;
    }
    

}
