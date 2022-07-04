# spring05
狂神
这个关于 spring的学习项目，内容包含：
# # 1.Spring
简介
    Spring：春天——>给软件行业带来了春天
    2002，首次推出了Spring框架的雏形：interface框架！

    Spring框架即以interface21框架为基础，经过重新设计，并不断丰富其内涵，于2004年3月24日，发布了1.0正式版

    Rod Johnson，Spring Framework创始人，著名作者。很难想象Rod Johnson的学历，真的让好多人大吃一惊，他是悉尼大学的博士，然而他的专业不是计算机，而是音乐学。

    spring理念：使现有的技术更**加容易使用，本身是一个大杂烩。

    SSH：Struct2 + Spring + Hibernate
    SSM: SpringMVC + Spring + Mybatis

去哪里下载

官网： https://spring.io/projects/spring-framework#overview

文档: https://docs.spring.io/spring-framework/docs/current/reference/html/

中文文档: https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference

官方下载： https://repo.spring.io/release/org/springframework/spring/
优点：

    Spring是一个开源的免费的框架（容器）！
    Spring是一个轻量级的、非入侵式的框架！
    控制反转（IOC），面向切面编程（AOP）！
    支持事务的处理，对框架整合的支持！

总结一句话：Spring就是一个轻量级的控制反转（IOC）和面向编程（AOP）的框架！
IOC理论推导

IOC（控制反转）：指的就是控制权的反转，用原来手动创建对象，转成java程序创建对象

控制：谁来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用spring后，对象是由spring来创建的

反转：程序本身不创建对象，而变成被动的接收对象

依赖注入：就是利用set方法来进行注入的。

IOC是一种编程思想，由主动编程变成了被动接收

ok，到了现在，我们彻底不用再去程序中进行改动了，要实现不同的操作，只需要在xml配置文件中进行修改，所谓的IOC，一句话搞定：对象是由Spring创建，管理，装配！
创建第一个Spring工程

​ 父工程下加入spring驱动

    <dependencies>
        <!--加入spring驱动-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.0.RELEASE</version>
        </dependency>
    </dependencies>

新建一个pojo包，在包下创建一个Hello实体类

    public class Hello {
        private String str;
        public String getStr() {
            return str;
        }
        public void setStr(String str) {
            this.str = str;
        }
        @Override
        public String toString() {
            return "Hello{" +
                    "str='" + str + '\'' +
                    '}';
        }
    }

创建spring容器映射文件，命名为beans.xml(官方的命名为applicationContext.xml)

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="hello" class="com.xsq.pojo.Hello">
        <!--使用Spring来创建对象，在Spring这些都称为Bean
            类型 变量名 = new 类型();
            Hello hello = new Hello();
            id = 变量名
            class = new 的对象
            properties  相当于给对象中的属性设置一个值
        -->
        <property name="str" value="Spring"/>
    </bean>
    </beans>

测试类：

    public class MyTest {
        public static void main(String[] args) {
            //获取spring的上下文对象
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            //我们的对象现在都在Spring中管理了，我们要使用，直接去里面取出来即可
            Hello hello = (Hello) context.getBean("hello");
            System.out.println(hello.toString());
        }
    }

测试结果：

    Hello{str='Spring'}

IOC创建对象的方式
使用无参构造创建对象（默认）

实体类：

    public class User {
        private String name;
        public User() {
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void show() {
            System.out.println("name = " + name);
        }
    }

beans.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="user" class="com.xsq.pojo.User">
        <property name="name" value="二哈"/>
    </bean>
    </beans>

测试类

    public class MyTest {
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            User user = (User) context.getBean("user");
            user.show();
        }
    }

测试结果：

    name = 二哈

使用有参构造创建对象

实体类:

    public class User {
        private String name;
        public User(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void show() {
            System.out.println("name = "+name);
        }
    }

1.下标赋值

beans.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="user" class="com.xsq.pojo.User">
        <constructor-arg index="0" value="盾山"/>
    </bean>
    </beans>

测试类：

    public class MyTest {
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            User user = (User) context.getBean("user");
            user.show();
        }
    }

测试结果：

    name = 盾山

2.类型赋值(不建议使用)

    <bean id="user" class="com.xsq.pojo.User">
        <constructor-arg type="java.lang.String" value="erha"/>
    </bean>

3.通过参数名来赋值

    <bean id="user" class="com.xsq.pojo.User">
        <constructor-arg name="name" value="erha"/>
    </bean>

总结：在配置文件加载的时候，容器中管理的对象就已经初始化了！
Spring配置
别名

    <!--别名-->
    <alias name="user" alias="user2"/>

Bean的配置

id:bean的唯一标识符，也就是相当于我们学的对象名
class:bean 对象所对应的全限定名：包名+类型
name:也是别名，而且同时name可以同时取多个别名

    <bean id="userT" class="com.xsq.pojo.UserT" name="t,t1">
        <property name="name" value="erha"/>
    </bean>

import

这个import，一般用于团队开发使用，他可以将多个配置文件，导入合并为一个

假设，现在项目中有多个人开发，这三个人负责不同类的开发，不同的类需要注册在不同的bean中，我们可以利用import将所有人的beans.xml合并为一个总的！

    张三
    李四
    王五
    applicationContext.xml
        <import resource="beans.xml"/>
        <import resource="bean1.xml"/>
        <import resource="bean2.xml"/>
        <import resource="bean3.xml"/>

使用的时候直接使用总配置就可以了
依赖注入
构造器注入

上面IOC创建对象已经讲过了
Set方式注入【重点】

搭建环境

实体类，生成对应的get和set以及tostring方法

    public class Student {
        private String name;
        private Address address;
        private String[] books;
        private List<String> hobbys;
        private Map<String, String> card;
        private Set<String> games;
        private String wife;
        private Properties info;
    public class Address {
        private String address;
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        @Override
        public String toString() {
            return "Address{" +
                    "address='" + address + '\'' +
                    '}';
        }
    }

beans.xml配置文件

    <bean id="student" class="com.xsq.pojo.Student">
        <property name="name" value="二哈"/>
    </bean>

测试类

    public class MyTest {
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            Student student = (Student) context.getBean("student");
            System.out.println(student.getName());
        }
    }

测试结果

    二哈

上面我们只给name注入相应的属性值，现在我们要给其他的属性也注入相应的值

让我们直接看beans.xml配置文件中

    <bean id="address" class="com.xsq.pojo.Address">
        <property name="address" value="北京"/>
    </bean>
    <bean id="student" class="com.xsq.pojo.Student">
        <!--第一种，普通的value注入-->
        <property name="name" value="二哈"/>
        <!--第二种，引用类型注入-->
        <property name="address" ref="address"/>
        <!--第三种，数组注入-->
        <property name="books">
            <array>
                <value>《红楼梦》</value>
                <value>《三国演义》</value>
                <value>《西游记》</value>
                <value>《水浒传》</value>
            </array>
        </property>
        <!--第四种，list注入-->
        <property name="hobbys">
            <list>
                <value>睡觉</value>
                <value>玩游戏</value>
            </list>
        </property>
        <!--第五种，Map注入-->
        <property name="card">
            <map>
                <entry key="身份证" value="165466465465"/>
                <entry key="银行卡" value="564545646564654"/>
            </map>
        </property>
        <!--第六种，set注入-->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>COC</value>
                <value>BOB</value>
            </set>
        </property>
        <!--第七种，空值注入-->
        <property name="wife">
            <null/>
        </property>
        <!--第八种，properties注入-->
        <property name="info">
            <props>
                <prop key="name">二哈</prop>
                <prop key="sex">男</prop>
                <prop key="id">2019</prop>
            </props>
        </property>
    </bean>

测试类中：

    public class MyTest {
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            Student student = (Student) context.getBean("student");
            System.out.println(student.toString());
        }
    }

测试结果

    Student{name='二哈', address=Address{address='北京'}, books=[《红楼梦》, 《三国演义》, 《西游记》, 《水浒传》], hobbys=[睡觉, 玩游戏], card={身份证=165466465465, 银行卡=564545646564654}, games=[LOL, COC, BOB], wife='null', info={name=二哈, sex=男, id=2019} }

拓展注入方式
p命名空间注入：

我们为了和之前几种注入方式的区分，我们可以重新再创建一个beans.xml，命名为userbeans.xml

p标签注入需要在约束条件中加入一条约束代码

    xmlns:p="http://www.springframework.org/schema/p"

我们的userbeans.xml文件中，我们在User对象当中注入属性name和age：

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:p="http://www.springframework.org/schema/p"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">
               <!--p命名注入，可以直接注入属性的值：properties-->
        <bean id="user" class="com.xsq.pojo.User" p:name="二哈" p:age="18"/>

测试类：

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user =  context.getBean("user",User.class);
        System.out.println(user);
    }

测试结果：

    User{name='二哈', age='18'}

c命名空间注入：

c标签注入的话是通过构造器注入，所以我们需要在实体类中加入有参及无参构造

    public class User {
        private String name;
        private String age;
        public User() {
        }
        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

c标签注入我们也需要和p标签一样在约束条件上加入相关的约束条件

    xmlns:c="http://www.springframework.org/schema/c"

userbeans.xml文件中也向User对象中注入相应的属性：

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:p="http://www.springframework.org/schema/p"
           xmlns:c="http://www.springframework.org/schema/c"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">
        <!--p命名注入，可以直接注入属性的值：properties-->
        <bean id="user" class="com.xsq.pojo.User" p:name="二哈" p:age="18"/>
        <!--c命名注入，通过构造器注入：construct-args-->
        <bean id="user2" class="com.xsq.pojo.User" c:name="盾山" c:age="19"/>
    </beans>

测试类：

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user =  context.getBean("user2",User.class);
        System.out.println(user);
    }

测试结果：

    User{name='盾山', age='19'}

拓展注入需要的注意点：

    需要在约束文件中添加约束条件

bean的作用域：

singleton：在spring IoC容器仅存在一个Bean实例，Bean以单例方式存在，bean作用域范围的默认值。
prototype：每次从容器中调用Bean时，都返回一个新的实例，即每次调用getBean()时，相当于执行newXxxBean()。
request：每次HTTP请求都会创建一个新的Bean，该作用域仅适用于web的Spring WebApplicationContext环境。
session：同一个HTTP Session共享一个Bean，不同Session使用不同的Bean。该作用域仅适用于web的Spring WebApplicationContext环境。
application：限定一个Bean的作用域为ServletContext的生命周期。该作用域仅适用于web的Spring WebApplicationContext环境。
单例模式（spring的默认机制）：

单例模式是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象

举个例子来理解吧，一个系统中可以存在多个打印任务，但是只能有一个正在工作的任务；一个系统只能有一个窗口管理器或文件系统；一个系统只能有一个计时工具或ID(序号)生成器。如在Windows中就只能打开一个任务管理器。如果不使用机制对窗口对象进行唯一化，将弹出多个窗口，如果这些窗口显示的内容完全一致，则是重复对象，浪费内存资源；如果这些窗口显示的内容不一致，则意味着在某一瞬间系统有多个状态，与实际不符，也会给用户带来误解，不知道哪一个才是真实的状态。因此有时确保系统中某个对象的唯一性即一个类只能有一个实例非常重要。

具体实现，直接在后面加上scope属性，选择singleton单例模式：

    <bean id="user2" class="com.xsq.pojo.User" c:name="盾山" c:age="19" scope="singleton"/>

测试类，为了更好的查看创建对象是否为单例，我们打印出其的hashcode码及判断其是否相等：

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user =  context.getBean("user2",User.class);
        User user2 =  context.getBean("user2",User.class);
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user==user2);
    }

测试结果，从测试的结果中可以看到，user和user2的hashcode码完全相等，且判断也为true：

    1858609436
    1858609436
    true

原型模式：

原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。

原型模式应该理解了上面的单例模式应该就很好理解了

来我们来看具体的实现，将scope属性的值设置为prototype原型模式：

    <bean id="user2" class="com.xsq.pojo.User" c:name="盾山" c:age="19" scope="prototype"/>

测试类中还是和是上面的单例模式的测试代码一致，输出对应的hashcode码，判断是否相等：

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user =  context.getBean("user2",User.class);
        User user2 =  context.getBean("user2",User.class);
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user==user2);
    }

测试结果，从测试结果中我们可以看出，原型模式创建的对象的hashcode码是不一致的，判断也为false：

    1858609436
    1920387277
    false

其余的request和session以及application这些都是只能在web开发中才能使用到的
Bean的自动装配

    自动装配是Spring满足bean依赖一种方式！
    Spring会在上下文中自动的寻找，并自动给bean装配属性

在Spring中有三种装配方式

1.xml中显示的配置

2.在java中显示配置

3.隐式的自动装配bean【重要】
搭建环境：

一个人拥有俩只猫

    public class Dog {
        public void shout(){
            System.out.println("汪汪~~~");
        }
    }
    public class Cat {
        public void shout(){
            System.out.println("瞄瞄~~~");
        }
    }
    public class People {
        private Dog dog;
        private Cat cat;
        private String name;

对应的set和get别忘了，以及tostring

beans.xml文件中，先按照传统方式注入属性：

    <bean id="cat" class="com.xsq.pojo.Cat"/>
    <bean id="dog" class="com.xsq.pojo.Dog"/>
    <bean id="people" class="com.xsq.pojo.People">
        <property name="dog" ref="dog"/>
        <property name="cat" ref="cat"/>
        <property name="name" value="盾山"/>
    </bean>

测试类：

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people", People.class);
        people.getCat().shout();
        people.getDog().shout();
    }

测试结果：

    瞄瞄~~~
    汪汪~~~

byname自动装配

beans.xml文件中，加入autowire属性，将值设置为byName

byName：会自动在容器上下文中查找，和自己对象set方法后面的值对应的beanid

    <bean id="cat" class="com.xsq.pojo.Cat"/>
    <bean id="dog" class="com.xsq.pojo.Dog"/>
    <bean id="people" class="com.xsq.pojo.People" autowire="byName">
        <property name="dog" ref="dog"/>
    </bean>

bytype自动装配

bytype自动装配和byname的差不多，将autowire的值设置为byType

byType：会自动在容器上下文中查找，和自己对象属性类型相同的bean，但是一种属性只能有一个对象，否则spring容器无法进行识别，这里装配方式的id是可以省略的

    <bean id="cat" class="com.xsq.pojo.Cat"/>
    <bean id="ashj" class="com.xsq.pojo.Dog"/>
    <bean id="people" class="com.xsq.pojo.People" autowire="byType">
       <property name="name" value="二哈"/>
    </bean>

小结：

    byname的使用，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致！
    bytype的使用，需要保证所以bean的class也就是对象唯一，并且bean需要和自动注入的属性的类型一致！

使用注解实现自动装配

    @Autowired：自动装配，先通过类型判断，再是名字，如果无法通过@Autowired唯一装配上属性，则需要通过@Qualifier(value=”xxx”)
    @Nullable：字段标记了这个注解，说明这个字段可以为null
    @Resource：也是自动装配，java自带的，先通过名字进行判断，再通过类型进行判断

jdk1.5支持的注解，spring2.5就开始支持了

使用注解实现自动装配需要在beans.xml文件中加入相关的约束条件

    xmlns:context="http://www.springframework.org/schema/context"

以及

    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd

最后还要开启注解自动装配

    <context:annotation-config/>

beans.xml中总览：

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
        <!--开启注解自动装配-->
        <context:annotation-config/>
        <bean id="cat" class="com.xsq.pojo.Cat"/>
        <bean id="dog" class="com.xsq.pojo.Dog"/>
        <bean id="people" class="com.xsq.pojo.People"/>
    </beans>

实体类中加入Autowired注解，在Autowired后面加入required属性，将值设置为true表示该值可以为null，如果为false表示不能为null

    public class People {
        @Autowired
        private Dog dog;
        @Autowired(required = false)
        private Cat cat;
        private String name;

（科普）字段中加入@Nullable 字段标记了这个注解，说明这个字段可以为null

如果Autowired的两个注解都解决不了，就可以在Autowired下面加上Qualifier，加以设置

首先我们先看我们的beans.xml文件，可以看到无论是通过name还是type都无法进行判断，因此我们需要通过Qualifier注解进行设置

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
        <!--开启注解自动装配-->
        <context:annotation-config/>
        <bean id="cat222" class="com.xsq.pojo.Cat"/>
        <bean id="cat221" class="com.xsq.pojo.Cat"/>
        <bean id="dog222" class="com.xsq.pojo.Dog"/>
        <bean id="people" class="com.xsq.pojo.People"/>
    </beans>

实体类中在Qualifier中设置对应的value值

    public class People {
        @Autowired
        private Dog dog;
        @Autowired
        @Qualifier(value = "cat221")
        private Cat cat;
        private String name;

@Resource注解

Resource注解的使用方式和Autowired差不多，可以通过name来指定beanid，并且Resource不是spring里的，存在java中的

    public class People {
        @Resource
        private Dog dog;
        @Resource(name = "cat221")
        private Cat cat;
        private String name;

小结：

@Resource和@Autowired的区别：

    都是用来自动装配的，都可以放在属性字段上
    @Autowired 通过byType的方式实现，若是通过该类型无法判断，也就是有多个相同的相同的属性的bean则会使用byname进行装配，若俩种都无法使用就报错【常用】
    @Resource默认通过byname的方式实现，如果找不到名字，则通过byType实现！如果两个都找不到的情况下，就报错！

使用注解开发
属性注入

使用注解开发就是注入对象和创建对象不再依赖beans.xml(applicationContext.xml)文件，直接在实体类上面加上对应的注解实现创建注入

@Component：这里的@Component相当于我们以前的<bean id="user" class="com.xsq.pojo.User"/>

@Value(“盾山”)：就相当于<property name="name" value="盾山"/>

    //等价于    <bean id="user" class="com.xsq.pojo.User"/>
    //@Component 组件
    @Component
    public class User {
        @Value("盾山")
        public String name ;
        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

当然就这样在实体类上加上注解肯定不行，我们还需要在beans.xml(applicationContext.xml)中开启注解扫描和指定要扫描的包，并且添加相应的约束条件

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
        <!--指定要扫描的包-->
        <context:component-scan base-package="com.xsq.pojo"/>
        <!--开启注解扫描-->
        <context:annotation-config/>
    </beans>

测试类：

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.toString());
    }

测试结果：

    User{name='盾山'}

衍生注解

@Component有几个衍生注解，我们在web开发中，会按照mvc三层架构分层！

    dao 【@Repository】
    service【@Service】
    controller【@Controller】

这四个注解功能都是一样的，都是代表将某个类注册到Spring中，装配Bean
自动装配

    @Autowired：自动装配，先通过类型判断，再是名字，如果无法通过@Autowired唯一装配上属性，则需要通过@Qualifier(value=”xxx”)
    @Nullable：字段标记了这个注解，说明这个字段可以为null
    @Resource：也是自动装配，java自带的，先通过名字进行判断，再通过类型进行判断

作用域

通过scope注解中value来定义作用域，详解可以看bean的作用域

    @Component
    @Scope(value = "singleton")
    public class User {
        @Value("盾山")
        public String name ;
        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

小结：

xml与注解：

    xml更加万能，适用于任何场合！维护简单方便
    注解不是自己类使用不了，维护相对复杂！

xml与注解最佳的实践：

    xml用来管理bean；
    注解只负责完成属性的注入；
    我们在使用的过程中，只需要注意一个问题：必须让注解生效，就需要开启注解的扫描支持
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
        <!--指定要扫描的包-->
        <context:component-scan base-package="com.xsq"/>
        <!--开启注解扫描-->
        <context:annotation-config/>
    </beans>

​
使用java方式配置spring（完全抛弃beans.xml配置文件）

搭建环境

首先先在pojo包下创建一个User实体类，在类上面加上Component注解，这里这个注解的意思，就是说明这个类被spring给接管了，注册到容器中

value注解注入值，这个就不需要多说了

    //这里这个注解的意思，就是说明这个类被spring给接管了，注册到容器中
    @Component
    public class User {
        public String name;
        public String getName() {
            return name;
        }
        @Value("二哈")//注入值
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

接着实体类创建完了，我们创建一个配置类，我们虽然没有了beans.xml配置文件，但是也需要一个类去注入对象

@Configuration：代表这是一个配置类，就和我们之前看的beans.xml

@Bean：注册一个bean，就相当于我们之前写的bean标签，这个方法的名字就相当于bean中的id属性，这个方法的返回值，就相当于bean标签中的class属性

    //这个也会Spring容器托管，注册到容器中，因为他本来就是一个@Component
    //@Configuration代表这是一个配置类，就和我们之前看的beans.xml
    @Configuration
    @ComponentScan("com.xsq.pojo")
    public class KuangConfig {
        //注册一个bean，就相当于我们之前写的bean标签
        //这个方法的名字就相当于bean中的id属性
        //这个方法的返回值，就相当于bean标签中的class属性
        @Bean
        public User getUser(){
            return new User();//就是返回要注入到bean的对象
        }
    }

环境都搭建好了，就是测试了，创建一个测试类：

这里因为我们用的是完全使用配置方式去做，所有需要用AnnotationConfig来获取容器，通过配置类的class对象加载

    public class MyTest {
        @Test
        public void test1(){
            //如果完全使用了配置方式去做，我们就只能通过AnnotationConfig 上下文来获取容器，通过配置类的class对象加载！
            ApplicationContext context = new AnnotationConfigApplicationContext(KuangConfig.class);
            User getUser = (User) context.getBean("getUser");
            System.out.println(getUser);
        }
    }

运行，查看测试结果：

    User{name='二哈'}

如果出现了下面的异常，查看你的配置类引入格式是否正确，不能加双引号，然后就是你的bean的id是否引入错误

    org.springframework.beans.factory.NoSuchBeanDefinitionException

代理模式
静态代理

代理模式：就好比我们现实中要租房，找中介代理，中介再找房东，

角色分析：

    抽象角色：一般使用接口或者抽象类来解决
    真实角色：被代理的角色
    代理角色：代理真实角色，代理真实角色后，我们一般会做一些附属操作
    客户：访问代理对象的人

代理步骤：

假如你要去租房，要去找中介，中介在帮你去找房东

接口：

    public interface Rent {
        public void rent();
    }

真实对象：

    //房东
    public class Host implements Rent{
        public void rent() {
            System.out.println("房东要出租房屋");
        }
    }

代理角色：

    //中介
    public class Proxy {
        private Host host;
        public Proxy(Host host) {
            this.host = host;
        }
        public Host getHost() {
            return host;
        }
        public void setHost(Host host) {
            this.host = host;
        }
        //看房
        public void LookHouse(){
            System.out.println("看房，感觉不错");
        }
        //收钱
        public void money(){
            System.out.println("交易达成，交中介费");
        }
        //租房
        public void rent(){
            host.rent();
        }
    }

客户：

    //me 客户
    public class Client {
        public static void main(String[] args) {
            //创建房东对象
            Host host = new Host();
            //创建中介对象
            Proxy proxy = new Proxy(host);
            //看房
            proxy.LookHouse();
            //ok，交中介费
            proxy.money();
            //通过中介的手租房
            proxy.rent();
        }
    }

代理模式的好处：

    可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
    公共也就是交给我们的代理角色！实现了业务的分工！
    公共业务发生扩展的时候，方便集中管理！

缺点：

    一个真实角色就会产生一个代理角色；代码量会翻倍-开发效率会变低

加深理解

首先我们先创建一个接口

    public interface UserService {
        public void add();
        public void delete();
        public void update();
        public void select();
    }

再创建一个实现类去实现该接口

    public class UserServiceImpl implements UserService{
        public void add() {
            System.out.println("增加了用户");
        }
        public void delete() {
            System.out.println("删除了用户");
        }
        public void update() {
            System.out.println("修改了用户");
        }
        public void select() {
            System.out.println("查询了用户");
        }
    }

测试

    public class Client {
        public static void main(String[] args) {
            UserServiceImpl userService = new UserServiceImpl();
            userService.add();
        }
    }

测试结果：

    增加了用户

此时，我们需要加入新功能，如果是以前我们直接就在UserServiceImpl中直接就加了，记住这是大忌，我们需要重新创一个代理对象，也就是一个新的代理类，在代理类中进行相关操作

    public class Proxy implements UserService {
        private UserServiceImpl userService;
        public void setUserService(UserServiceImpl userService) {
            this.userService = userService;
        }
        public void add() {
            this.log("add");
            userService.add();
        }
        public void delete() {
            this.log("delete");
            userService.delete();
        }
        public void update() {
            this.log("update");
            userService.update();
        }
        public void select() {
            this.log("select");
            userService.select();
        }
        //增加的查询日志
        public void log(String msg){
            System.out.println(msg+"方法已经执行了");
        }
    }

此时，我们的测试就变了：

    public class Client {
        public static void main(String[] args) {
            UserServiceImpl userService = new UserServiceImpl();
            Proxy proxy = new Proxy();
            proxy.setUserService(userService);
            proxy.add();
        }
    }

测试结果，可以看到我们新增的功能已经新增过去了，我们没有去改原先的代码，而是新增了一个代理类：

    add方法已经执行了
    增加了用户

动态代理

    动态代理和静态代理角色一样
    动态代理的代理类是动态生成的，不是我们手动写好的
    动态代理分为俩大类：基于接口的动态代理，基于类的动态代理
        基于接口—-JDK动态代理
        基于类：cglib
        java字节码实现：javassist

首先我们需要了解俩个类：Proxy：代理，InvocationHandler：调用处理程序

具体实现：

还是上面的房东类和租房接口

    public interface Rent {
        public void rent();
    }
    //房东
    public class Host implements Rent {
        public void rent() {
            System.out.println("房东要出租房屋");
        }
    }

接下来我们就是创建动态代理类（也就是中介）

    public class ProxyInvocationHandler implements InvocationHandler {
        //被代理的接口
        private Object target;
        public void setRent(Object target) {
            this.target = target;
        }
        //生成动态代理类
        public Object getProxy() {
            return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                    target.getClass().getInterfaces(), this);
        }
        //处理代理实例，并返回结果
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //动态代理的本质，就是使用反射机制实现！
            Object result = method.invoke(target, args);
            return result;
        }
    }

测试：

    public class Client {
        public static void main(String[] args) {
            //创建房东对象
            Host host = new Host();
            //创建动态代理对象，也就是中介
            ProxyInvocationHandler pih = new ProxyInvocationHandler();
            //放入需要代理的对象，也就是房东
            pih.setRent(host);
            Rent proxy = (Rent) pih.getProxy();
            proxy.rent();
        }
    }

如果我们是想要在多个旧的接口上面增加新的功能，如果是静态代理，就需要再新建多个新的接口，十分繁琐，动态代理就只需要改代理的对象

还是之前上面的静态代理的例子，在增删改查中加一个日志功能

    public interface UserService {
        public void add();
        public void delete();
        public void update();
        public void select();
    }
    public class UserServiceImpl implements UserService{
        public void add() {
            System.out.println("增加了用户");
        }
        public void delete() {
            System.out.println("删除了用户");
        }
        public void update() {
            System.out.println("修改了用户");
        }
        public void select() {
            System.out.println("查询了用户");
        }
    }

创建动态代理对象，并加入新增的日志功能

    public class ProxyInvocationHandler implements InvocationHandler {
        //被代理的接口
        private Object target;
        public void setRent(Object target) {
            this.target = target;
        }
        //生成动态代理类
        public Object getProxy() {
            return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                    target.getClass().getInterfaces(), this);
        }
        //处理代理实例，并返回结果
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //动态代理的本质，就是使用反射机制实现！
            this.log(method.getName());//使用反射method获取到执行方法的name
            Object result = method.invoke(target, args);
            return result;
        }
        public void log(String msg){
            System.out.println("执行了"+msg+"方法！");
        }
    }

测试：

    public class Client {
        public static void main(String[] args) {
            UserServiceImpl userService = new UserServiceImpl();
            ProxyInvocationHandler pih = new ProxyInvocationHandler();
            //设置要代理的对象
            pih.setRent(userService);
            //动态生成代理类
            UserService proxy = (UserService) pih.getProxy();
            proxy.update();
        }
    }

测试结果：可以看到日志已经成功加入进来了

    执行了update方法！
    修改了用户

动态代理的好处：

    可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
    公共也就是交给我们的代理角色！实现了业务的分工！
    公共业务发生扩展的时候，方便集中管理！
    一个动态代理类代理的是一个接口，一般就是对应的一类业务
    一个动态代理类可以代理多个类，只要实现了同一个接口即可！

AOP
什么是AOP

AOP（Aspect-OrientedProgramming，面向切面编程），可以说是OOP（Object-Oriented Programing，面向对象编程）的补充和完善。OOP引入封装、继承和多态性等概念来建立一种对象层次结构，用以模拟公共行为的一个集合。当我们需要为分散的对象引入公共行为的时候，OOP则显得无能为力。也就是说，OOP允许你定义从上到下的关系，但并不适合定义从左到右的关系。例如日志功能。日志代码往往水平地散布在所有对象层次中，而与它所散布到的对象的核心功能毫无关系。对于其他类型的代码，如安全性、异常处理和透明的持续性也是如此。这种散布在各处的无关的代码被称为横切（cross-cutting）代码，在OOP设计中，它导致了大量代码的重复，而不利于各个模块的重用。

​ 而AOP技术则恰恰相反，它利用一种称为“横切”的技术，剖解开封装的对象内部，并将那些影响了多个类的公共行为封装到一个可重用模块，并将其名为“Aspect”，即方面。所谓“方面”，简单地说，就是将那些与业务无关，却为业务模块所共同调用的逻辑或责任封装起来，便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可操作性和可维护性。AOP代表的是一个横向的关系，如果说“对象”是一个空心的圆柱体，其中封装的是对象的属性和行为；那么面向方面编程的方法，就仿佛一把利刃，将这些空心圆柱体剖开，以获得其内部的消息。而剖开的切面，也就是所谓的“方面”了。然后它又以巧夺天功的妙手将这些剖开的切面复原，不留痕迹。
AOP的常见术语

    Aspect(切面):通常是一个类，里面可以定义切入点和通知
    JointPoint(连接点):程序执行过程中明确的点，一般是方法的调用
    Advice(通知):AOP在特定的切入点上执行的增强处理，有before,after,afterReturning,afterThrowing,around
    Pointcut(切入点):就是带有通知的连接点，在程序中主要体现为书写切入点表达式
    AOP代理：AOP框架创建的对象，代理就是目标对象的加强。Spring中的AOP代理可以使JDK动态代理，也可以是CGLIB代理，前者基于接口，后者基于子类

使用spring来实现AOP
引入依赖：

    <dependencies>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.6</version>
        </dependency>
    </dependencies>

方式一：使用spring的API接口

创建UserService接口以及对应的实现类

    public interface UserService {
        public void add();
        public void delete();
        public void update();
        public void select();
    }
    public class UserServiceImpl implements UserService {
        public void add() {
            System.out.println("增加了用户");
        }
        public void delete() {
            System.out.println("删除了用户");
        }
        public void update() {
            System.out.println("修改了用户");
        }
        public void select() {
            System.out.println("查询了用户");
        }
    }

我们要在执行的操作前后加入日志

我们先创建一个log类，实现MethodBeforeAdvice接口，代表要在操作之前执行的

    public class log implements MethodBeforeAdvice {
        //method：要执行的目标对象的方法
        //args：参数
        //target：目标对象
        public void before(Method method, Object[] objects, Object target) throws Throwable {
            System.out.println(target.getClass().getName()+"的"+method.getName()+"被执行了");
        }
    }

再创建一个AfterLog类，实现AfterReturningAdvice，代表的是要在执行完操作之后执行

    public class AfterLog implements AfterReturningAdvice {
        //returnValue的返回值
        public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
            System.out.println("执行了"+method.getName()+"方法，返回结果为："+returnValue);
        }
    }

现在要增加的类操作我们都创建好了，我们现在需要使用applicationContext.xml文件进行配置注入

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:aop="http://www.springframework.org/schema/aop"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd">
        <!--配置bean-->
        <bean id="userService" class="com.xsq.service.UserServiceImpl"/>
        <bean id="log" class="com.xsq.log.log"/>
        <bean id="afterLog" class="com.xsq.log.AfterLog"/>
        <!--方式一：使用原生Spring API接口-->
        <!--配置aop:需要导入aop的约束-->
        <aop:config>
            <!--切入点：expression表达式,execution(要执行的位置：* * * * *)       (修饰词 返回值 类名 方法名 参数)-->
            <aop:pointcut id="pointcut" expression="execution(* com.xsq.service.UserServiceImpl.*(..))"/>
            <!--执行环绕增加！-->
            <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
            <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>
        </aop:config>
    </beans>

测试类：

    public class MyTest {
        @Test
        public void test1(){
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            //动态代理的是接口：注意点
            UserService userService = (UserService) context.getBean("userService");
            userService.select();
        }
    }

测试结果：

    com.xsq.service.UserServiceImpl的select被执行了
    查询了用户
    执行了select方法，返回结果为：null

方式二：自定义来实现AOP【主要是切面定义】

自定义一个类：

    public class DiyPointCut {
        public void before(){
            System.out.println("=========方法执行之前=======");
        }
        public void after(){
            System.out.println("=========方法执行之后=======");
        }
    }

在applicationContext.xml中配置注入：

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:aop="http://www.springframework.org/schema/aop"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd">
        <!--配置bean-->
        <bean id="userService" class="com.xsq.service.UserServiceImpl"/>
        <bean id="log" class="com.xsq.log.log"/>
        <bean id="afterLog" class="com.xsq.log.AfterLog"/>
        <!--方式二：自定义类-->
        <bean id="diy" class="com.xsq.diy.DiyPointCut"/>
        <aop:config>
            <!--自定义切面-->
            <aop:aspect ref="diy">
                <!--切入点-->
                <aop:pointcut id="point" expression="execution(* com.xsq.service.UserServiceImpl.*(..))"/>
                <!--通知-->
                <aop:before method="before" pointcut-ref="point"/>
                <aop:after method="after" pointcut-ref="point"/>
            </aop:aspect>
        </aop:config>
    </beans>

测试：

    public class MyTest {
        @Test
        public void test1(){
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            //动态代理的是接口：注意点
            UserService userService = (UserService) context.getBean("userService");
            userService.select();
        }
    }

测试结果：

    =========方法执行之前=======
    查询了用户
    =========方法执行之后=======

方式三：使用注解实现

首先我们要在applicationContext.xml文件中进行切面和切入点的配置

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:aop="http://www.springframework.org/schema/aop"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd">
        <!--配置bean-->
        <bean id="userService" class="com.xsq.service.UserServiceImpl"/>
        <!--方式三-->
        <bean id="annotationPointCut" class="com.xsq.diy.AnnotationPointCut"/>
        <!--开启注解支持-->
        <aop:aspectj-autoproxy/>
    </beans>

创建一个类

    @Aspect//标注这个类是一个切面
    public class AnnotationPointCut {
        @Before("execution(* com.xsq.service.UserServiceImpl.*(..))")
        public void before(){
            System.out.println("=====方法执行前======");
        }
        @After("execution(* com.xsq.service.UserServiceImpl.*(..))")
        public void after(){
            System.out.println("=====方法执行后======");
        }
        @Around("execution(* com.xsq.service.UserServiceImpl.*(..))")
        public void around(ProceedingJoinPoint jp) throws Throwable{
            System.out.println("环绕前");
            Object proceed = jp.proceed();  //执行之后
            System.out.println("环绕后");
        }
    }

测试：

    public class MyTest {
        @Test
        public void test1(){
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            //动态代理的是接口：注意点
            UserService userService = (UserService) context.getBean("userService");
            userService.select();
        }
    }

测试结果：

    环绕前
    =====方法执行前======
    查询了用户
    环绕后
    =====方法执行后======
