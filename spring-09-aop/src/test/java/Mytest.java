import com.huawei.cater.service.UserService;
import com.huawei.cater.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annoapplication.xml");
        //动态代理的是接口：注意点
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
