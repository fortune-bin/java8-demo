package lambda_scopes;

/**
 * lambda 作用域 小样
 * 从lambda表达式访问外部作用域变量与匿名对象非常相似。 我们可以从本地外部作用域以及实例字段和静态变量访问最终变量。
 */

public class demo {
    static int outerStaticNum;
   static int outerNum;
    public static void main(String [] args){
        localVariable();
    }
    /**
     * 访问局部变量 样例（example）
     */
    public static void localVariable(){
        //我们可以从lambda表达式的外部范围读取最终的局部变量：
        final  int x = 1;
        Converter<Integer,String> converter = (y)->String.valueOf(y+x);
        System.out.println(converter.convert(10));

        //但与匿名对象不同，变量num不必声明为final。这样的代码也有效代码也有效
        int num = 1;
        Converter<Integer,String> cn = (h)->String.valueOf(h+num);
        System.out.println(cn.convert(9));
        //但是，对于要编译的代码，外部局部变量必须是隐式最终的也就是确定这个局部变量不会改变了。以下代码无法编译：同时也禁止在lambda 表达式改变值
        /*
        int nm = 1;
        Converter<Integer,String> cns = (h)->String.valueOf(h+nm);
        System.out.println(cns.convert(9));
        nm= 4;
        */
    }


    /**
     * 访问字段和静态变量:
     * 与局部变量相比，我们对lambda表达式中的实例字段和静态变量都有读写访问权限。从匿名对象中可以很好地了解此行为。
     */

    public static void fieldsAndStaticVariables(){
        Converter<Integer, String> stringConverter1 = (x)->{
            outerNum = 22;
            return String.valueOf(x);
        };
        stringConverter1.convert(23);
        System.out.println(outerNum);
    }
}


