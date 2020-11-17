package ruokapaivakirja.domain;

import java.time.LocalDate;

public class Meal {
    private LocalDate date;
    private Dish dish;
    private String name;

    public Meal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
            
}
