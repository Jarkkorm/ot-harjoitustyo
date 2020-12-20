package ruokapaivakirja.domain;

/**
 * Class that stores data of Dish
 * 
 */
public class Dish {
    private int id;
    private String description;
    private int calories;
    private double proteins;
    private double carbs;
    private double sugars;
    private double fats;

    /**
     * Creates a Dish without id
     * @param description
     * @param calories
     * @param proteins
     * @param carbs
     * @param sugars
     * @param fats
     */
    public Dish(String description, int calories, double proteins, double carbs, double sugars, double fats) {
        this.description = description;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.sugars = sugars;
        this.fats = fats;
    }

    /**
     * Creates a Dish with all fields
     * @param id
     * @param description
     * @param calories
     * @param proteins
     * @param carbs
     * @param sugars
     * @param fats
     */
    public Dish(int id, String description, int calories, double proteins, double carbs, double sugars, double fats) {
        this.id = id;
        this.description = description;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.sugars = sugars;
        this.fats = fats;
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
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public int getCalories() {
        return calories;
    }

    /**
     *
     * @param calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     *
     * @return
     */
    public double getProteins() {
        return proteins;
    }

    /**
     *
     * @param proteins
     */
    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    /**
     *
     * @return
     */
    public double getCarbs() {
        return carbs;
    }

    /**
     *
     * @param carbs
     */
    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    /**
     *
     * @return
     */
    public double getSugars() {
        return sugars;
    }

    /**
     *
     * @param sugars
     */
    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    /**
     *
     * @param fats
     */
    public void setFats(double fats) {
        this.fats = fats;
    }    

    /**
     *
     * @return
     */
    public double getFats() {
        return fats;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.getDescription();
    }
}