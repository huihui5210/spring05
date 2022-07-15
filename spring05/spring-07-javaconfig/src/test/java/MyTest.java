import com.huawei.cater.Config.CaterConfig;
import com.huawei.cater.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
       ApplicationContext context = new AnnotationConfigApplicationContext(CaterConfig.class);
        User user = (User) context.getBean("getUser");
        System.out.println(user.name);
    }
}
