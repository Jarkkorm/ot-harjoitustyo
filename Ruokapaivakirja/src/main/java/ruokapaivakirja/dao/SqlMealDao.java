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
 *
 * @author jarkko
 */
public class SqlMealDao implements MealDao {
    private List<Meal> meals;
    private String dbURL;
    private Connection connection;
    private PreparedStatement stmt;
    private Statement s;
    private DishDao dishDao;
    
    public SqlMealDao(String dbURL, DishDao dishDao) throws SQLException {
        this.dbURL = dbURL;
        this.dishDao = dishDao;
        initializeDB();
        meals = new ArrayList<>();
    }
    
    private void initializeDB() throws SQLException {
        startConnection();
        s.execute("CREATE TABLE IF NOT EXISTS Meal (id INTEGER PRIMARY KEY, date DATE, mealdish INTEGER, category INTEGER, done INTEGER, FOREIGN KEY (mealdish) REFERENCES dish(id));");
        closeConnection();
    }

    private void startConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + dbURL);
        s = connection.createStatement();
    }
    
    private void closeConnection() throws SQLException {
        s.close();
        connection.close();
    }
    
    @Override
    public void create(Meal meal, Dish dish) throws Exception {
        startConnection();
        stmt = connection.prepareStatement("INSERT INTO meal (date, mealdish, category, done) VALUES (?,?,?,?);");
        stmt.setDate(1, meal.getDate());
        stmt.setInt(2, dish.getId());
        stmt.setInt(3, meal.getCategory());
        stmt.setInt(4, meal.getDone());
        stmt.executeUpdate();
        stmt.close();
        closeConnection();
    }

    @Override
    public List<Meal> getAll() throws SQLException {
        startConnection();
        ResultSet rs = s.executeQuery("SELECT * FROM meal;");
        try {
            while (rs.next()) {
                Dish dish = dishDao.read(rs.getInt("mealdish"));
                meals.add(new Meal(rs.getInt("id"), rs.getDate("date"), dish, rs.getInt("category"), rs.getInt("done")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return meals;
    }

    @Override
    public void setDone(int id) throws Exception {
        for (Meal t : meals) {
            if (t.getId() == id) {
                t.setDone();
            }
        }
    }
    
}
