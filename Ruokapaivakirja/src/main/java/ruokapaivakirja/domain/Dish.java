package ruokapaivakirja.domain;

/**
 *
 * @author jarkko
 */
public class Dish {
    private int id;
    private String description;
    private int calories;
    private double proteins;
    private double carbs;
    private double sugars;
    private double fats;

    public Dish(String description, int calories, double proteins, double carbs, double sugars, double fats) {
        this.description = description;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.sugars = sugars;
        this.fats = fats;
    }

    public Dish(int id, String description, int calories, double proteins, double carbs, double sugars, double fats) {
        this.id = id;
        this.description = description;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.sugars = sugars;
        this.fats = fats;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }    

    public double getFats() {
        return fats;
    }
}