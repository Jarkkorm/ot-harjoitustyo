package ruokapaivakirja.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ruokapaivakirja.domain.Dish;

/**
 *
 * @author jarkko
 */
public class SqlDishDao implements DishDao<Dish> {
    
    private String dbURL;
    private Connection connection;
    private PreparedStatement stmt;
    private Statement s;
    private List<Dish> dishes;
    
    public SqlDishDao(String dbURL) throws SQLException {
        this.dbURL = dbURL;
        initializeDB();
        dishes = new ArrayList<>();
    }

    private void initializeDB() throws SQLException {
        startConnection();
        s.execute("CREATE TABLE IF NOT EXISTS dish (id INTEGER PRIMARY KEY, description TEXT NOT NULL, calories INTEGER, proteins REAL, carbs REAL, sugars REAL, fats REAL);");
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
    public List<Dish> getAll() throws SQLException {
        startConnection();
        ResultSet rs = s.executeQuery("SELECT * FROM dish;");
        while (rs.next()) {
            dishes.add(new Dish(rs.getInt("id"), rs.getString("description"), rs.getInt("calories"), rs.getDouble("proteins"), rs.getDouble("carbs"), rs.getDouble("sugars"), rs.getDouble("fats")));
        }
        closeConnection();
        return dishes;
    }

    @Override
    public void create(Dish dish) throws SQLException {
        startConnection();
        stmt = connection.prepareStatement("INSERT INTO dish (description, calories, proteins, carbs, sugars, fats) VALUES (?,?,?,?,?,?);");
        stmt.setString(1, dish.getDescription());
        stmt.setInt(2, dish.getCalories());
        stmt.setDouble(3, dish.getProteins());
        stmt.setDouble(4, dish.getCarbs());
        stmt.setDouble(5, dish.getSugars());
        stmt.setDouble(6, dish.getFats());
        stmt.executeUpdate();
        stmt.close();
        closeConnection();
    }

    @Override
    public Dish read(int id) throws Exception {
        startConnection();
        stmt = connection.prepareStatement("SELECT * FROM dish WHERE id = ?;)");
        stmt.setInt(1, id);
        ResultSet dish = stmt.executeQuery();
        Dish foundDish = new Dish(dish.getInt("id"), dish.getString("description"), dish.getInt("calories"), dish.getDouble("proteins"), dish.getDouble("carbs"), dish.getDouble("sugars"), dish.getDouble("fats"));
        stmt.close();
        closeConnection();
        return foundDish;
    }
}
