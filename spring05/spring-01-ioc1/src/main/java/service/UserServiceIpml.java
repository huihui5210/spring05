package service;

import dao.UserDAO;
import dao.UserDAOIpml;
import dao.UserDAOMysqlImpl;

public class UserServiceIpml implements UserService {
//    private UserDAO userDAO = new UserDAOIpml();
    private UserDAO userDAO ;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void getUser() {
        userDAO.getUser();
    }
}
