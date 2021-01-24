import java.sql.*;

public class Database {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/CarList";

    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static final String DATABASE = "LabaWeb№4";
    public static final String TABLE = "car";

    public static final String ID = "ID";
    public static final String NAME = "Name";
    public static final String PRICE = "Price";
    public static final String MAX_SPEED = "Max_Speed";

    static {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String user;
    private String pass;

    public Database() {
        this.user = USER;
        this.pass = PASSWORD;
    }



    public void out() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, user, pass);
        Statement statement = connection.createStatement();

        statement.execute(String.format("USE %s", DATABASE));
        ResultSet resultSet = statement.executeQuery(String.format("SELECT %s, %s, %s, %s, %s FROM %s",
                ID, NAME, PRICE, MAX_SPEED, TABLE));

        while (resultSet.next()) {
            int id = resultSet.getInt(ID);
            String Name = resultSet.getString(NAME);
            int Price = resultSet.getInt(PRICE);
            int MaxSpeed = resultSet.getInt(MAX_SPEED);

            System.out.print("ID: " + id + "\n");
            System.out.print("\t Name: " + Name + "\n");
            System.out.print("\t Price: " + Price + "\n");
            System.out.print("\t MaxSpeed: " + MaxSpeed + "\n");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }


    public String get(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, user, pass);
        Statement statement = connection.createStatement();

        statement.execute(String.format("USE %s", DATABASE));
        ResultSet resultSet = statement.executeQuery(
                String.format("SELECT %s, %s, %s, %s, %s FROM %s WHERE %s = %d",
                        ID, NAME, PRICE, MAX_SPEED, TABLE, ID, id));

        String result = null;
        if (resultSet.next()) {
            result = String.format(
                    "ID: %d\n\t Name: %s\n\t Price: %s\n\t MaxSpeed: %d",
                    resultSet.getInt(ID), resultSet.getString("Name"),
                    resultSet.getString("Price"), resultSet.getInt("MaxSpeed")
            );
        }

        resultSet.close();
        statement.close();
        connection.close();

        return result;
    }

    public void add(int id, String Name, int Price, int MaxSpeed) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, user, pass);
        Statement statement = connection.createStatement();

        statement.execute(String.format("USE %s", DATABASE));
        statement.execute(String.format("INSERT INTO %s VALUES (%d, '%s', '%s', %d, %d)",
                TABLE, id, Name, Price, MaxSpeed));

        statement.close();
        connection.close();
    }

    public void set(int id, String column, String value) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, user, pass);
        Statement statement = connection.createStatement();

        statement.execute(String.format("USE %s", DATABASE));
        statement.execute(String.format("UPDATE %s SET %s = %s WHERE %s = %d",
                TABLE, column, value, ID, id));

        statement.close();
        connection.close();
    }


    public void remove(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, user, pass);
        Statement statement = connection.createStatement();

        statement.execute(String.format("USE %s", DATABASE));
        statement.execute(String.format("DELETE FROM %s WHERE %s=%d", TABLE, ID, id));

        statement.close();
        connection.close();
    }


}
