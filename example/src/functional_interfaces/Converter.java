package functional_interfaces;
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