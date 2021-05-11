import java.sql.*;

import static java.lang.System.out;

public class DBConnectionManager {

    private Connection conn;
    private Statement stmt;

    public DBConnectionManager(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
        stmt =  conn.createStatement();
    }

    public void makeQuery(String sql_cmd) throws SQLException
    {


    }

    public ResultSet showTable(String tableName) throws SQLException
    {
        return stmt.executeQuery("SELECT * FROM " + tableName + ";");
    }
    public void insert(String tableName, DBStored obj) throws SQLException
    {
        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(tableName);
        sb.append(" ");
        sb.append(obj.getFields());
        sb.append(" VALUES ");
        sb.append(obj.getValues());
        sb.append(";");

        out.println(sb.toString());
        stmt.execute(sb.toString());


    }

    public void delete(String tableName, int carID) throws SQLException
    {
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(tableName);
        sb.append("WHERE CarID = ");
        sb.append(carID);
        sb.append(';');

        stmt.execute(sb.toString());


    }
}
