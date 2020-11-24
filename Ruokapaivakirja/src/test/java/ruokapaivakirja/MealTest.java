package ruokapaivakirja;

import java.time.LocalDate;
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
        meal = new Meal(LocalDate.of(2020, Month.MAY, 15),dish,2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void mealDateOikeinTest() {
        assertEquals(LocalDate.of(2020, Month.MAY, 15), meal.getDate());
    }

    @Test
    public void mealDishDescriptionOikeinTest() {
        assertEquals("Ahven", meal.getDish().getDescription());
    }

    @Test
    public void mealCategoryOikeinTest() {
        assertEquals(2, meal.getCategory());
    }
}
