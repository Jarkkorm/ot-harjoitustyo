package ruokapaivakirja;

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
public class DishTest {
    private static final double DELTA = 1e-15;
    Meal meal;
    Dish dish;
    
    public DishTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void dishNimiOikeinTest() {
        assertEquals("Ahven", dish.getDescription());
    }

    @Test
    public void dishKaloritOikeinTest() {
        assertEquals(84, dish.getCalories(), DELTA);
    }

    @Test
    public void dishProteiinitOikeinTest() {
        assertEquals(17.1, dish.getProteins(), DELTA);
    }

    @Test
    public void dishHiilihydraatitOikeinTest() {
        assertEquals(10.0, dish.getCarbs(), DELTA);
    }
    
    @Test
    public void dishSokeritOikeinTest() {
        assertEquals(0.0, dish.getSugars(), DELTA);
    }
    
    @Test
    public void dishRasvatOikeinTest() {
        assertEquals(0.0, dish.getFats(), DELTA);
    }
}
