
package Lambda;

@FunctionalInterface
interface EvenOddCheck {
    void check(int n);
}

public class EvenOdd {
    public static void main(String[] args) {

        EvenOddCheck obj = (n) -> {
            if (n % 2 == 0) {
                System.out.println(n + " is Even");
            } else {
                System.out.println(n + " is Odd");
            }
        };

        obj.check(10);
        obj.check(7);
    }
}


