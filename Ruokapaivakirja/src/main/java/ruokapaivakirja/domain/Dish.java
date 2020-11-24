package ruokapaivakirja.domain;

/**
 *
 * @author jarkko
 */
public class Dish {
    
    private String description;
    private int calories;
    private double proteins;
    private double carbohydrates;
    private double sugar;
    private double fat;

    public Dish(String description, int calories, double proteins, double carbohydrates, double sugar, double fat) {
        this.description = description;
        this.calories = calories;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
        this.sugar = fat;
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

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
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