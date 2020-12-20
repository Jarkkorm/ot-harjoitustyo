package ruokapaivakirja;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ruokapaivakirja.dao.SqlDishDao;
import ruokapaivakirja.dao.SqlMealDao;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.DishService;
import ruokapaivakirja.domain.Meal;
import ruokapaivakirja.domain.MealService;

/**
 *
 * @author jarkko
 */
public class MealServiceTest {
    private static final double DELTA = 1e-15;
    private static SqlMealDao sqlMealDao;
    private static MealService mealService;
    private static SqlDishDao sqlDishDao;
    private static DishService dishService;
    
    public MealServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            sqlDishDao = new SqlDishDao("test.db");
            sqlMealDao = new SqlMealDao("test.db", sqlDishDao);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            
        }
        dishService = new DishService(sqlDishDao);
        mealService = new MealService(sqlMealDao, sqlDishDao);
    }
    
    
    @AfterClass
    public static void tearDownClass() {
        boolean result = new File("test.db").delete();    
    }
    
    @Before
    public void setUp() {
        Dish dish = dishService.createDish("Ahven", 84, 17.1, 10.0, 2.1, 0.0);
        Meal meal = mealService.createMeal(Date.valueOf("2020-12-20"), dish, "Aamiainen");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void categoriesRight() {
        List categories = new ArrayList<String>();
        categories.add( "Aamiainen" );
        categories.add( "Lounas" );
        categories.add( "Välipala" );
        categories.add( "Päivällinen" );
        categories.add( "Iltapala" );
        
        assertArrayEquals(categories.toArray(), mealService.getCategories().toArray());
    }
    
    @Test
    public void createdMealCategoryRight() {        
        assertEquals("Aamiainen", mealService.getMeals().get(0).getCategory());
    }
    
    @Test
    public void createdMealDishRight() {       
        assertEquals("Ahven", mealService.getMeals().get(0).getDish().toString());
    }
    
    @Test
    public void mealSetDoneRight() {
        mealService.markDone(0);
        assertEquals(0, mealService.getMeals().get(0).getDone());
    }

    @Test
    public void changeMealChangesMealDate() {
        mealService.changeMeal(1 , Date.valueOf("2020-12-19"), mealService.getMeals().get(0).getDish(), "Aamiainen");
        assertEquals(Date.valueOf("2020-12-19"), mealService.getMeals().get(0).getDate());
    }

    @Test
    public void changeMealChangesMealCategory() {
        mealService.changeMeal(1, Date.valueOf("2020-12-20"), mealService.getMeals().get(0).getDish(), "Välipala");
        assertEquals("Välipala", mealService.getMeals().get(0).getCategory());
    }

    @Test
    public void getDayCaloriesGetsRight() {
        assertEquals(84, mealService.getDayCalories(Date.valueOf("2020-12-19")));
    }    

    @Test
    public void getDoneMealsRight() {
        Dish dish = dishService.createDish("Porkkana", 84, 17.1, 10.0, 2.1, 0.0);
        Meal meal = mealService.createMeal(Date.valueOf("2020-12-20"), dish, "Aamiainen");
        mealService.markDone(meal.getId());
        assertEquals(1, mealService.getAllDone().size());
    }
}