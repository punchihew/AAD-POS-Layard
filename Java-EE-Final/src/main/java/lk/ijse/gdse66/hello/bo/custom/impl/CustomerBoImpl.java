package lk.ijse.gdse66.hello.bo.custom.impl;

import lk.ijse.gdse66.hello.bo.custom.CustomerBo;
import lk.ijse.gdse66.hello.dao.DAOFactory;
import lk.ijse.gdse66.hello.dao.custom.CustomerDao;
import lk.ijse.gdse66.hello.dto.CustomerDTO;
import lk.ijse.gdse66.hello.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDAO = (CustomerDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers= new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll(connection);
        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getCusId(),c.getCusName(),c.getCusAddress(),c.getCusSalary()));
        }
        return allCustomers;
    }

    @Override
    public boolean saveCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(connection,new Customer(customerDTO.getCusId(),customerDTO.getCusName(),customerDTO.getCusAddress(),customerDTO.getCusSalary()));
    }

    @Override
    public boolean updateCustomer(Connection connection, CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(connection,new Customer(customerDTO.getCusId(),customerDTO.getCusName(),customerDTO.getCusAddress(),customerDTO.getCusSalary()));
    }

    @Override
    public boolean deleteCustomer(Connection connection, String customerID) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(connection,customerID);
    }
}
