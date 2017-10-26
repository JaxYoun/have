package com.youn.have.javaNewFeature.lambda;

public class LambdaTest {

    public static final String hi = "hello\t";
    public static String constan = "yangjx";
    /**
     * 参数类型声明
     * 对于独句函数，可以不用大括号，默认返回独句
     */
    static MathOperation addition = (int a, int b) -> a + b;
    /**
     * 数类无型声明
     * 对于独句函数，可以不用大括号，默认返回独句
     */
    static MathOperation subtraction = (a, b) -> a - b;
    /**
     * 当函数体使用大括号时，必须return
     */
    static MathOperation multiplication = (a, b) -> {
        return a * b;
    };
    /**
     * 数类无型声明
     * 对于独句函数，可以不用大括号，默认返回独句
     */
    static MathOperation division = (int a, int b) -> a / b;
    /**
     * 单个参数可以不用小括号
     */
    static GreetingService greetService1 = message -> System.out.println(hi + message);
    /**
     * 单个参数也可以用小括号
     */
    static GreetingService greetService2 = (message) -> System.out.println(hi + message);

//-------------------------------------------------------------------------
    /**
     * 变量作用域
     * lambda 表达式只能引用 final 或 final 局部变量，这就是说不能在 lambda 内部修改定义在域外的变量，否则会编译错误。
     * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
     * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
     * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
     * 可选的返回关键字：如果主体只有一个表达式，且以之作为返回值，此时可以省略return，编译器会自动返回该表达式；
     *                 如果大括号中有多个语句，又需要返回，则要用return指定返回值。
     */

    /**
     * 运算函数
     *
     * @param a
     * @param b
     * @param mathOperation
     * @return
     */
    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {
        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 - 5 = " + operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + operate(10, 5, division));

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

        greetService2.sayMessage(constan);
    }

    /**
     * 数学运算接口
     */
    @FunctionalInterface
    interface MathOperation {
        int operation(int a, int b);
    }

    /**
     * 消息服务接口
     */
    @FunctionalInterface
    interface GreetingService {
        void sayMessage(String message);
    }

}


