package lambda_example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class demo {
    public static List<String> strings = Arrays.asList("muj", "ad", "a", "sinde");

    /**
     * 在没有lambda 的情况下我们处理字符串列表排序
     */
    public static void StringSortingOldProcessing() {
        System.out.println(strings);
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(strings);
        /**
         * Collections.sort接受字符串列表 strings 和比较器 Comparator 对指定列表 strings 进行排序
         * 如果某天开发 一直都在做排序相关的开发的化我们很多时间都会在创建匿名比较器上面 然后传输给sort 方法
         */
    }

    /**
     * java8 处理字符串列表 操作
     *
     * @param
     */
    public static void java8ProcessingStringList() {
        /**
         * java8 就不需要花很多时间在 创建匿名对象上，使用短语法  lambda 表达式
         */


        //语法1
        Collections.sort(strings, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println("java8 语法形式1" + strings);
        //语法2  对于只有一行的方法体 可以跳过{} 和 return 关键字
        Collections.sort(strings, (String x, String y) -> x.compareTo(y));
        System.out.println("java8 语法形式2" + strings);

        //语法3 List 中就有一个sort 方法 因此我们可以去掉 Collections.sort 这个操作
        strings.sort((q, w) -> w.compareTo(q));
        System.out.println("java8 语法形式3" + strings);


    }

    public static void main(String[] args) {
        StringSortingOldProcessing();
        System.out.println("java 实现排序");
        java8ProcessingStringList();
    }

}


