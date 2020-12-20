package ruokapaivakirja.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ruokapaivakirja.domain.Dish;
import ruokapaivakirja.domain.Meal;

/**
 * Implements MealDao
 */
public class SqlMealDao implements MealDao {
    private String dbURL;
    private Connection connection;
    private PreparedStatement stmt;
    private Statement s;
    private DishDao dishDao;
    
    /**
     * Creates new SqlMealDao with given parameters
     * @param dbURL
     * @param dishDao
     * @throws SQLException
     */
    public SqlMealDao(String dbURL, DishDao dishDao) throws SQLException {
        this.dbURL = dbURL;
        this.dishDao = dishDao;
        initializeDB();
    }
   
    /**
     * Initializes new table for meals
     * @throws SQLException
     */
    private void initializeDB() throws SQLException {
        startConnection();
        s.execute("CREATE TABLE IF NOT EXISTS meal (id INTEGER PRIMARY KEY, date DATE, mealdish INTEGER, category TEXT, done INTEGER, FOREIGN KEY (mealdish) REFERENCES dish(id));");
        closeConnection();
    }

    /**
     * Starts new connection to the database.
     */
    private void startConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + dbURL);
        s = connection.createStatement();
    }

    /**
     * Closes connection to the database.
     */    
    private void closeConnection() throws SQLException {
        s.close();
        connection.close();
    }
    
    /**
     * Stores new meal to database and returns it with id
     * @param meal
     * @return
     * @throws Exception
     */
    @Override
    public Meal create(Meal meal) throws SQLException {
        startConnection();
        stmt = connection.prepareStatement("INSERT INTO meal (date, mealdish, category, done) VALUES (?,?,?,?); SELECT last_insert_rowid();");
        stmt.setDate(1, meal.getDate());
        stmt.setInt(2, meal.getDish().getId());
        stmt.setString(3, meal.getCategory());
        stmt.setInt(4, meal.getDone());
        int id = stmt.executeUpdate();
        stmt.close();
        closeConnection();
        meal.setId(id);
        return meal;
    }

    /**
     * Gets all active stored meal as list
     * @return
     * @throws SQLException
     */
    @Override
    public List<Meal> getAll() throws Exception {
        List<Meal> meals = new ArrayList<>();
        startConnection();
        ResultSet rs = s.executeQuery("SELECT * FROM meal WHERE done = 0;");
        try {
            while (rs.next()) {
                Dish dish = dishDao.read(rs.getInt("mealdish"));
                meals.add(new Meal(rs.getInt("id"), rs.getDate("date"), dish, rs.getString("category"), rs.getInt("done")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();      
        return meals;
    }

    /**
     * Sets meal with id to done
     * @param id
     * @throws Exception
     */
    @Override
    public void setDone(int id) throws SQLException {
        startConnection();
        stmt = connection.prepareStatement("UPDATE meal SET done = 1 WHERE id = ?;");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        closeConnection();
    }

    /**
     * Gets list of meals of specified date
     * @param date
     * @return
     * @throws Exception
     */
    @Override
    public List<Meal> getAllOfDay(Date date) throws Exception {
        List<Meal> meals = new ArrayList<>();
        startConnection();
        stmt = connection.prepareStatement("SELECT * FROM meal WHERE date = ?;");
        stmt.setDate(1, date);               
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Dish dish = dishDao.read(rs.getInt("mealdish"));
                meals.add(new Meal(rs.getInt("id"), rs.getDate("date"), dish, rs.getString("category"), rs.getInt("done")));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();      
        return meals;    
    }

    /**
     * Changes specified meal
     * @param meal
     * @throws Exception
     */
    @Override
    public void updateMeal(Meal meal) throws Exception  {
        startConnection();
        stmt = connection.prepareStatement("UPDATE meal SET date = ?, mealdish = ?, category = ? WHERE id = ?;");
        stmt.setDate(1, meal.getDate());
        stmt.setInt(2, meal.getDish().getId());
        stmt.setString(3, meal.getCategory());
        stmt.setInt(4, meal.getId());
        stmt.executeUpdate();
        stmt.close();
        closeConnection();        
    }
    
    /**
     * Removes meal that has specified id
     * @param id
     * @throws Exception
     */
    @Override    
    public void removeMeal(int id) throws Exception {
        startConnection();
        stmt = connection.prepareStatement("DELETE FROM meal WHERE id = ?;");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();        
        closeConnection();
    }
    
    /**
     * Gets list of all meals 
     * @return
     * @throws Exception
     */
    @Override
    public List<Meal> getAllDone() throws Exception {
        List<Meal> meals = new ArrayList<>();
        startConnection();
        ResultSet rs = s.executeQuery("SELECT * FROM meal WHERE done = 1;");
        try {
            while (rs.next()) {
                Dish dish = dishDao.read(rs.getInt("mealdish"));
                meals.add(new Meal(rs.getInt("id"), rs.getDate("date"), dish, rs.getString("category"), rs.getInt("done")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();      
        return meals;
    }    
}
