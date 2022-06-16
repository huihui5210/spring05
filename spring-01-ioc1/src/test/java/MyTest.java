import dao.UserDAOIpml;
import dao.UserDAOMysqlImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.UserServiceIpml;

public class MyTest {
    public static void main(String[] args) {
//        UserService userService = new UserServiceIpml();
//        //不用改源码   使用动态注入
//        ((UserServiceIpml)userService).setUserDAO(new UserDAOMysqlImpl());
//        userService.getUser();
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceIpml userServiceIpml = (UserServiceIpml)context.getBean("userServiceIpml");
        userServiceIpml.getUser();
    }
}
