package app;

public class DemoLambdaExpression {
    public static void main(String[] args) {
        FuncInter1 add = (int x, int y) -> x + y;
        FuncInter1 multiply = (int x, int y) -> x * y;

        DemoLambdaExpression obj = new DemoLambdaExpression();

        System.out.println("Addition is " + obj.operate(6, 3, add));
        System.out.println("Multiplication is " + obj.operate(6, 3, multiply));


        FuncInter2 fobj = message -> System.out.println("Hello " + message);
        fobj.sayMessage("Geek");
    }

    private int operate(int a, int b, FuncInter1 fobj) {
        return fobj.operation(a, b);
    }

    interface FuncInter1 {
        int operation(int a, int b);
    }

    interface FuncInter2 {
        void sayMessage(String message);
    }
}
