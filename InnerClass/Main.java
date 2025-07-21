package InnerClass;
class Outer {
    private String msg = "Hello from Outer!";

    class Inner {
        void showMsg() {
            System.out.println(msg);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.showMsg(); // Output: Hello from Outer!
    }
}
