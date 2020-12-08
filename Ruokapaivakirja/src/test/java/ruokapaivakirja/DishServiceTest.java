package ruokapaivakirja;

import java.io.File;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ruokapaivakirja.dao.SqlDishDao;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.DishService;

/**
 *
 * @author jarkko
 */
public class DishServiceTest {
    private static final double DELTA = 1e-15;
    private static SqlDishDao sqlDishDao;
    private static DishService dishService;
    
    public DishServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            sqlDishDao = new SqlDishDao("test.db");
        } catch (SQLException sqlException) {
            
        }
        dishService = new DishService(sqlDishDao);
    }
    
    @AfterClass
    public static void tearDownClass() {
        boolean result = new File("test.db").delete();
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createDishSuccesfull() {
        dishService.createDish("description", 1, 2, 3, 4, 5);
        assertEquals("description", dishService.getDishes().get(0).getDescription());
    }
    
    @Test
    public void createdDishCalories() {
        assertEquals(1, dishService.getDishes().get(0).getCalories());
    }
    
    @Test
    public void createdDishProteins() {
        assertEquals(2.0, dishService.getDishes().get(0).getProteins(), DELTA);
    }
    
    @Test
    public void createdDishSugars() {
        assertEquals(4.0, dishService.getDishes().get(0).getSugars(), DELTA);
    }
    
    @Test
    public void createdDishFats() {
        assertEquals(5.0, dishService.getDishes().get(0).getFats(), DELTA);
    } 
}
