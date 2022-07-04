import com.huawei.pojo.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        People people = (People) context.getBean("people");
        People people2 = (People) context.getBean("people");
        System.out.println(people == people2);
        people.getCat().jiao();
        people.getDog().jiao();

    }
}
