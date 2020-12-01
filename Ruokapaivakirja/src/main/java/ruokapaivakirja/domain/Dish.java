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
    private double sugar;
    private double fat;

    public Dish(String description, int calories, double proteins, double carbs, double sugar, double fat) {
        this.description = description;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.sugar = sugar;
        this.sugar = fat;
    }

    public Dish(int id, String description, int calories, double proteins, double carbs, double sugar, double fat) {
        this.id = id;
        this.description = description;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.sugar = sugar;
        this.sugar = fat;
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

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }    

    public double getFat() {
        return fat;
    }
}