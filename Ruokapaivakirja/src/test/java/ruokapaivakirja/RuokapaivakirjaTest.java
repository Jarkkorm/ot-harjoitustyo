package ruokapaivakirja;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ruokapaivakirja.domain.Meal;

/**
 *
 * @author jarkko
 */
public class RuokapaivakirjaTest {
    
    Meal meal;
    
    public RuokapaivakirjaTest() {
    }
    
     @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void mealinNimiOikeinTest() {
        meal = new Meal("Makaronilaatikko");
        assertEquals("Makaronilaatikko", meal.getName());
    }
}
