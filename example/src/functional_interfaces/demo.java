package functional_interfaces;

public class demo {
    public static void main(String[] args) {
        /**
         * 功能接口 简单样例
         */
        Converter<String, Integer> converter = (x) -> Integer.valueOf(x);
        Integer convert = converter.convert("121");
        System.out.println(convert);

        /**
         * 通过使用静态方法引用可以进一步简化上面的示例代码：
         */


        //Java 8允许您通过::关键字传递方法或构造函数的引用。示例显示了如何引用静态方法。
        Converter<Integer, String> cs = String::valueOf;
        System.out.println(cs.convert(1));
        //引用静态方法外,但我们也可以引用对象方法,我们创建一个 测试对象 ObTest  并声明一个方法 methodOne
        ObTest obTest = new ObTest();
        //methodOne 的参数 要和自定义接口方法参数一样  （毕竟是代理人）
        Converter<String, Integer> cn = obTest::methodOne;
        System.out.println(cn.convert("1122"));

        // :: 关键字怎么使用构造函数  我们定义一个不同构造函数的 测试类 Person 员工类  并创建一个员工创建工厂接口类 PersonFactory

        PersonFactory<Person> person = Person::new;
        System.out.println(person.create("罗纳尔多", "史密斯","sss").toString());
        /**
         * 上面的语句 我们不是手动实现工厂，而是通过构造函数引用将所有内容粘合在一起
         * 我们通过Person :: new创建对Person构造函数的引用。
         * Java编译器通过匹配PersonFactory.create的签名自动选择正确的构造函数。
         */


    }
}

/**
 * 接口 <F,T> F T 都是代表类型参数
 *
 * @param <F>
 * @param <T> 注意只要接口只包含一个抽象方法 这个接口就可以任意使用lambda 表达式
 *            为了确保接口符合要求你可以添加 @FunctionalInterface 注解   这个注解如果发现你这个接口要添加第二个抽象方法声明的时候会抛出编译器错误
 *            记住，如果省略@FunctionalInterface注释，代码也是有效的 也是会这样的 你可以放开  F converts(F from)  这个注释得到答案
 */
@FunctionalInterface
interface Converter<F, T> {
    /**
     * 返回 T 入参数 F
     *
     * @param from
     * @return
     */
    T convert(F from);

    /* F converts(F from);*/
}

class ObTest {
    public Integer methodOne(String x) {
        return Integer.valueOf(x);
    }
}

class Person {

    String surname;
    String name;
    String address;

    Person() {
    }

    Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    Person(String surname, String name, String address) {
        this.surname = surname;
        this.name = name;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

interface PersonFactory<P extends Person> {
   // P create(String surname, String name);
    P create(String surname, String name, String address);
}



