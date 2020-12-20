package ruokapaivakirja.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ruokapaivakirja.domain.Dish;

/**
 * Implements DishDao
 */
public class SqlDishDao implements DishDao<Dish> {
    
    private String dbURL;
    private Connection connection;
    private PreparedStatement stmt;
    private Statement s;
    private List<Dish> dishes;
    
    /**
     * Creates new SqlDishDao with given parameters
     * @param dbURL
     * @throws SQLException
     */
    public SqlDishDao(String dbURL) throws SQLException {
        this.dbURL = dbURL;
        initializeDB();
        dishes = new ArrayList<>();
    }

    /**
     * Initializes new table for dishes
     * @throws SQLException
     */    
    private void initializeDB() throws SQLException {
        startConnection();
        s.execute("CREATE TABLE IF NOT EXISTS dish (id INTEGER PRIMARY KEY, description TEXT NOT NULL, calories INTEGER, proteins REAL, carbs REAL, sugars REAL, fats REAL);");
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
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Dish> getAll() throws SQLException {
        startConnection();
        ResultSet rs = s.executeQuery("SELECT * FROM dish;");
        while (rs.next()) {
            dishes.add(new Dish(rs.getInt("id"), rs.getString("description"), rs.getInt("calories"), rs.getDouble("proteins"), rs.getDouble("carbs"), rs.getDouble("sugars"), rs.getDouble("fats")));
        }
        closeConnection();
        return dishes;
    }

    /**
     * Stores new dish to database and returns it with id
     * @param dish
     * @return
     * @throws SQLException
     */
    @Override
    public Dish create(Dish dish) throws SQLException {
        startConnection();
        stmt = connection.prepareStatement("INSERT INTO dish (description, calories, proteins, carbs, sugars, fats) VALUES (?,?,?,?,?,?);");
        stmt.setString(1, dish.getDescription());
        stmt.setInt(2, dish.getCalories());
        stmt.setDouble(3, dish.getProteins());
        stmt.setDouble(4, dish.getCarbs());
        stmt.setDouble(5, dish.getSugars());
        stmt.setDouble(6, dish.getFats());
        Integer id = stmt.executeUpdate();
        stmt.close();
        closeConnection();
        return new Dish(id, dish.getDescription(), dish.getCalories(), dish.getProteins(), dish.getCarbs(), dish.getSugars(), dish.getFats());
    }

    /**
     * Gets dish with specified id
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Dish read(int id) throws Exception {
        startConnection();
        stmt = connection.prepareStatement("SELECT * FROM dish WHERE id = ?;)");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Dish foundDish = new Dish(rs.getInt("id"), rs.getString("description"), rs.getInt("calories"), rs.getDouble("proteins"), rs.getDouble("carbs"), rs.getDouble("sugars"), rs.getDouble("fats"));
        stmt.close();
        closeConnection();
        return foundDish;
    }
}
