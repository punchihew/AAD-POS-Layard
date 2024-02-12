package lk.ijse.gdse66.hello.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T> extends SuperDAO {
    public ArrayList<T> getAll(Connection connection) throws SQLException, ClassNotFoundException;

    public boolean save(Connection connection,T entity) throws SQLException, ClassNotFoundException;

    public boolean update(Connection connection,T entity) throws SQLException, ClassNotFoundException;

    public boolean delete(Connection connection ,String Id) throws SQLException, ClassNotFoundException;
}
