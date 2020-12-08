package ruokapaivakirja;

import java.sql.Date;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.Meal;

/**
 *
 * @author jarkko
 */
public class MealTest {
    private static final double DELTA = 1e-15;
    Meal meal;
    Dish dish;
    
    public MealTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dish = new Dish("Ahven", 84, 17.1, 10.0, 2.1, 0.0);
        meal = new Meal(Date.valueOf("2020-11-31"),dish,"aamiainen");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void mealDateOikeinTest() {
        assertEquals(Date.valueOf("2020-11-31"), meal.getDate());
    }

    @Test
    public void mealDishDescriptionOikeinTest() {
        assertEquals("Ahven", meal.getDish().getDescription());
    }

    @Test
    public void mealCategoryOikeinTest() {
        assertEquals("aamiainen", meal.getCategory());
    }
    
    @Test
    public void setMealDateOikeinTest() {
        meal.setDate(Date.valueOf("2020-12-11"));
        assertEquals(Date.valueOf("2020-12-11"), meal.getDate());
    }

    @Test
    public void setMealDishDescriptionOikeinTest() {
        meal.setDate(Date.valueOf("2020-12-11"));
        assertEquals("Ahven", meal.getDish().getDescription());
    }

    @Test
    public void setMealCategoryOikeinTest() {
        meal.setCategory("Välipala");
        assertEquals("Välipala", meal.getCategory());
    }
    
    @Test
    public void setIdOikeinTest() {
        meal.setId(0);
        assertEquals(0, meal.getId());
    }
    
    @Test
    public void setDoneOikeinTest() {
        meal.setDone();
        assertEquals(1, meal.getDone());
    }
}
