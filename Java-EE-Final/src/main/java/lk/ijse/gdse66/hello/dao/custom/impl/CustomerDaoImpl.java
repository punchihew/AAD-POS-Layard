package lk.ijse.gdse66.hello.dao.custom.impl;



import lk.ijse.gdse66.hello.dao.SQLUtil;
import lk.ijse.gdse66.hello.dao.custom.CustomerDao;
import lk.ijse.gdse66.hello.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public ArrayList<Customer> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute(connection,"SELECT * FROM Customer");
        while (rst.next()) {
            Customer customer = new Customer(rst.getString(1), rst.getString(2), rst.getString(3),  rst.getInt(4));
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public boolean save(Connection connection, Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(connection, "INSERT INTO customer VALUES (?,?,?,?)", entity.getCusId(), entity.getCusName(), entity.getCusAddress(), entity.getCusSalary());

    }

    @Override
    public boolean update(Connection connection, Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(connection, "UPDATE customer SET customer_name=?, address=?, contact=? WHERE customer_ID=?",entity.getCusName() , entity.getCusAddress(), entity.getCusSalary(), entity.getCusId());
    }

    @Override
    public boolean delete(Connection connection, String Id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(connection, "DELETE FROM customer WHERE customer_ID=?", Id);
    }
}
