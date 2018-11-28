package lambda_example;

import java.util.function.IntSupplier;

/**
 * lambda 表达式
 */
public class lambda {
    /**
     * 表达式语法
     *      参数 -> 表达式
     *      参数 -> { 声明语法;}
     *
     *  特性：
     *      1.可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
     *      2.可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
     *      3.可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
     *      4.可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
     *
     *  接口描述：
     * 1.BiConsumer<T,U>           代表了一个接受两个输入参数的操作，并且不返回任何结果
     * 2.BiFunction<T,U,R>         代表了一个接受两个输入参数的方法，并且返回一个结果
     * 3.BinaryOperator<T>         代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果
     * 4.BiPredicate<T,U>          代表了一个两个参数的boolean值方法
     * 5.BooleanSupplier            代表了boolean值结果的提供方
     * 6.Consumer<T>                代表了接受一个输入参数并且无返回的操作
     * 7.DoubleBinaryOperator       代表了作用于两个double值操作符的操作，并且返回了一个double值的结果。
     * 8.DoubleConsumer             代表一个接受double值参数的操作，并且不返回结果。
     * 9.DoubleFunction<R>          代表接受一个double值参数的方法，并且返回结果
     * 10.DoublePredicate           代表一个拥有double值参数的boolean值方法
     * 11.DoubleSupplier            代表一个double值结构的提供方
     * 12.DoubleToIntFunction       接受一个double类型输入，返回一个int类型结果。
     * 13.DoubleToLongFunction      接受一个double类型输入，返回一个long类型结果
     * 14.DoubleUnaryOperator       接受一个参数同为类型double,返回值类型也为double 。
     * 15.Function<T,R>             接受一个输入参数，返回一个结果。
     * 16.IntBinaryOperator         接受两个参数同为类型int,返回值类型也为int 。
     * 17.IntConsumer               接受一个int类型的输入参数，无返回值 。
     * 18.IntFunction<R>            接受一个int类型输入参数，返回一个结果 。
     * 19.IntPredicate              接受一个int输入参数，返回一个布尔值的结果。
     * 20.IntSupplier               无参数，返回一个int类型结果。
     * 21.IntToDoubleFunction       接受一个int类型输入，返回一个double类型结果 。
     * 22.IntToLongFunction         接受一个int类型输入，返回一个long类型结果。
     * 23.IntUnaryOperator          接受一个参数同为类型int,返回值类型也为int 。
     * 24.LongBinaryOperator        接受两个参数同为类型long,返回值类型也为long。
     * 25.LongConsumer              接受一个long类型的输入参数，无返回值。
     * 26.LongFunction<R>           接受一个long类型输入参数，返回一个结果。
     * 27.LongPredicate             R接受一个long输入参数，返回一个布尔值类型结果。
     * 28.LongSupplier              无参数，返回一个结果long类型的值。
     * 29.LongToDoubleFunction      接受一个long类型输入，返回一个double类型结果。
     * 30.LongToIntFunction         接受一个long类型输入，返回一个int类型结果。
     * 31.LongUnaryOperator         接受一个参数同为类型long,返回值类型也为long。
     * 32.ObjDoubleConsumer<T>      接受一个object类型和一个double类型的输入参数，无返回值。
     * 33.ObjIntConsumer<T>         接受一个object类型和一个int类型的输入参数，无返回值。
     * 34.ObjLongConsumer<T>        接受一个object类型和一个long类型的输入参数，无返回值。
     * 35.Predicate<T>              接受一个输入参数，返回一个布尔值结果。
     * 36.Supplier<T>               无参数，返回一个结果。
     * 37.ToDoubleBiFunction<T,U>   接受两个输入参数，返回一个double类型结果
     * 38.ToDoubleFunction<T>       接受一个输入参数，返回一个double类型结果
     * 39.ToIntBiFunction<T,U>      接受两个输入参数，返回一个int类型结果。
     * 40.ToIntFunction<T>          接受一个输入参数，返回一个int类型结果。
     * 41.ToLongBiFunction<T,U>     接受两个输入参数，返回一个long类型结果。
     * 42.ToLongFunction<T>         接受一个输入参数，返回一个long类型结果。
     * 43.UnaryOperator<T>          接受一个参数为类型T,返回值类型也为T。
     */

    public static void simpleExample(){
        LambdaTest lambdaTest = new LambdaTest();
        int operate = lambdaTest.operate(5, 23, lambdaTest.addition);
        System.out.println(operate);

    }
    public static void main(String[] args){
        simpleExample();
    }
}
class LambdaTest{

    /**
     * 带类型声明
     */
    SuaRonOperation addition = (int a, int b) -> a + b;
    /**
     * 不用类型声明
     */
    SuaRonOperation subtraction = (a, b) -> a - b;

    /**
     * 大括号声语句
     */
    SuaRonOperation multiplication = (int a, int b) -> { return a * b; };

    /**
     * 大括号返回语句
     */
    SuaRonOperation division = (int a, int b) -> a / b;

    public int operate(int a, int b, SuaRonOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}

/**
 * 自定义接口
 */
interface SuaRonOperation {
    int operation(int a, int b);
}
