package com.accenture.steelbody;
import com.accenture.steelbody.container.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.ArrayList;


public class DatabaseWorker
{
    private Connection connection;

    public boolean open()
    {
        boolean hasSignal = false;
        try
        {
            Class.forName("org.sqlite.JDBC");
            String projectPath = System.getProperty("user.dir");
            String databasePath = "jdbc:sqlite:" + projectPath +
                    "/src/main/resources/com/accenture/steelbody/database/SteelBodyDatabase.db";
            connection = DriverManager.getConnection(databasePath);
            System.out.println("Connection successfully completed!");
            hasSignal = true;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Connection failed!");
        }
        return hasSignal;
    }


    public ObservableList select(String currentTable)
    {
        try {
            Statement statement = connection.createStatement();
            ObservableList<TableContainer> data = FXCollections.observableArrayList();
            String query;
            ResultSet rs;
            if (currentTable.equals("Product")) {
                query = "SELECT id, name, id_manufacturer, description, price FROM product";
                rs = statement.executeQuery(query);
                while (rs.next())
                {
                    Product container = new Product();
                    container.setId(rs.getInt("id"));
                    container.setName(rs.getString("name"));
                    container.setIdManufacturer(rs.getInt("id_manufacturer"));
                    container.setDescription(rs.getString("description"));
                    container.setPrice(rs.getInt("price"));
                    data.add(container);
                }
            } else if (currentTable.equals("Shop")) {
                query = "SELECT id, name, id_address FROM shop";
                rs = statement.executeQuery(query);
                while (rs.next())
                {
                    Shop container = new Shop();
                    container.setId(rs.getInt("id"));
                    container.setName(rs.getString("name"));
                    container.setIdAddress(rs.getInt("id_address"));
                    data.add(container);
                }
            } else if (currentTable.equals("Availability")) {
                query = "SELECT id, id_shop, id_product, num_of FROM availability";
                rs = statement.executeQuery(query);
                while (rs.next())
                {
                    Availability container = new Availability();
                    container.setId(rs.getInt("id"));
                    container.setIdShop(rs.getInt("id_shop"));
                    container.setIdProduct(rs.getInt("id_product"));
                    container.setNumOf(rs.getInt("num_of"));
                    data.add(container);
                }
            } else if (currentTable.equals("Address")) {
                query = "SELECT id, country, town, street, house FROM address";
                rs = statement.executeQuery(query);
                while (rs.next())
                {
                    Address container = new Address();
                    container.setId(rs.getInt("id"));
                    container.setCountry(rs.getString("country"));
                    container.setTown(rs.getString("town"));
                    container.setStreet(rs.getString("street"));
                    container.setHouse(rs.getInt("house"));
                    data.add(container);
                }
            } else if (currentTable.equals("Manufacturer")) {
                query = "SELECT id, name FROM manufacturer";
                rs = statement.executeQuery(query);
                while (rs.next())
                {
                    Manufacturer container = new Manufacturer();
                    container.setId(rs.getInt("id"));
                    container.setName(rs.getString("name"));
                    data.add(container);
                }
            } else if (currentTable.equals("User")) {
                query = "SELECT id, status, name, email, password FROM user";
                rs = statement.executeQuery(query);
                while (rs.next())
                {
                    User container = new User();
                    container.setId(rs.getInt("id"));
                    container.setStatus(rs.getInt("status"));
                    container.setName(rs.getString("name"));
                    container.setEmail(rs.getString("email"));
                    container.setPassword(rs.getString("password"));
                    data.add(container);
                }
            } else if (currentTable.equals("UserOrder")) {
                query = "SELECT id, id_user, id_availability, num_of FROM user_order";
                rs = statement.executeQuery(query);
                while (rs.next())
                {
                    UserOrder container = new UserOrder();
                    container.setId(rs.getInt("id"));
                    container.setIdUser(rs.getInt("id_user"));
                    container.setIdAvailability(rs.getInt("id_availability"));
                    container.setNumOf(rs.getInt("num_of"));
                    data.add(container);
                }
            } else {
                System.out.println("There is no such table!");
                statement.close();
                return null;
            }
            rs.close();
            statement.close();
            System.out.println("Query successfully completed!");
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
            return null;
        }
    }


    public ArrayList onEnterQuery()
    {
        try
        {
            Statement statement = connection.createStatement();
            ArrayList<User> data = new ArrayList<>();
            String query = "SELECT id, status, name, email, password FROM user";
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next())
            {
                User container = new User();
                container.setId(rs.getInt("id"));
                container.setStatus(rs.getInt("status"));
                container.setName(rs.getString("name"));
                container.setEmail(rs.getString("email"));
                container.setPassword(rs.getString("password"));
                data.add(container);
            }
            rs.close();
            statement.close();
            System.out.println("Query successfully completed!");
            return data;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
            return null;
        }
    }


    public void insert(User o)
    {
        try
        {
            String query =
                    "INSERT INTO user (status, name, email, password) VALUES (" +
                            o.getStatus() +  ", '" +
                            o.getName()   + "', '" +
                            o.getEmail()  + "', '" +
                            o.getPassword()  + "')";

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }


    public void insert(Availability o)
    {
        try
        {
            String query =
                    "INSERT INTO availability (id_shop, id_product, num_of) VALUES (" +
                            o.getIdShop() +  ", " +
                            o.getIdProduct()   + ", " +
                            o.getNumOf()  + ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }

    public void insert(Address o)
    {
        try
        {
            String query =
                    "INSERT INTO address (country, town, street, house) VALUES ('" +
                            o.getCountry() +  "', '" +
                            o.getTown()   + "', '" +
                            o.getStreet()  + "', " +
                            o.getHouse()  + ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }


    public void insert(Manufacturer o)
    {
        try
        {
            String query =
                    "INSERT INTO manufacturer (name) VALUES ('" +
                            o.getName()  + "')";

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }


    public void insert(Product o)
    {
        try
        {
            String query =
                    "INSERT INTO product (name, id_manufacturer, description, price) VALUES ('" +
                            o.getName() +  "', " +
                            o.getIdManufacturer()   + ", '" +
                            o.getDescription()  + "', " +
                            o.getPrice()  + ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }


    public void insert(Shop o)
    {
        try
        {
            String query =
                    "INSERT INTO shop (name, id_address) VALUES ('" +
                            o.getName() +  "', " +
                            o.getIdAddress()  + ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }


    public void insert(UserOrder o)
    {
        try
        {
            String query =
                    "INSERT INTO user_order (id_user, id_availability, num_of) VALUES (" +
                            o.getIdUser() +  ", " +
                            o.getIdAvailability()   + ", " +
                            o.getNumOf()  + ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }


    public void delete(Product o, int id)
    {
        try
        {
            String query = "DELETE FROM product WHERE id = "+ o.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }

    public void delete(Address o, int id)
    {
        try
        {
            String query = "DELETE FROM address WHERE id = "+ o.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }

    public void delete(Availability o, int id)
    {
        try
        {
            String query = "DELETE FROM availability WHERE id = "+ o.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }

    public void delete(Manufacturer o, int id)
    {
        try
        {
            String query = "DELETE FROM manufacturer WHERE id = "+ o.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }

    public void delete(Shop o, int id)
    {
        try
        {
            String query = "DELETE FROM shop WHERE id = "+ o.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }

    public void delete(User o, int id)
    {
        try
        {
            String query = "DELETE FROM user WHERE id = "+ o.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }

    public void delete(UserOrder o, int id)
    {
        try
        {
            String query = "DELETE FROM user_order WHERE id = "+ o.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            System.out.println("Query successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Query failed!");
        }
    }


    public void close()
    {
        try
        {
            connection.close();
            System.out.println("Disconnection successfully completed!");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Disconnection failed!");
        }
    }
}
