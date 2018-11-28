package new_features_default;

/**
 * defalt 测试demo
 * default 详细解释资料 http://www.importnew.com/10764.html
 */
public class demo {
}
/**
 * Java 8使我们能够通过使用default关键字向接口添加非抽象方法实现。
 * 此功能也称为虚拟扩展方法。
 */
interface Formula{
    /**
     * 抽象方法 calculate
     * @param a
     * @return
     */
    double calculate(int a);

    /**
     * default关键字 定义的非抽象方法可以直接使用
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        /**
         * calculate 是抽象方法 需要实现calculate 才能调用(正常操作需要写个类 实现Formula 方法，这边方便简单用匿名内部类实现这个操作)
         */
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100+20);
            }
        };
        System.out.println("调用抽象方法calculate"+formula1.calculate(100));
        /**
         * 可以直接使用 抽象类中的方法为什么要用 default 查看解释 ： http://www.importnew.com/10764.html
         */
        System.out.println("调用抽象类的default方法"+formula1.sqrt(88));
    }
}
