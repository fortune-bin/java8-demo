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









