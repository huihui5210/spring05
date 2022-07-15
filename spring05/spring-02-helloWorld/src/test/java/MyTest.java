import com.huawei.pojo.Hello;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // xml的方式
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello =(Hello) context.getBean("hello");
        System.out.println(hello.getStr());
        hello.show();
    }
}
