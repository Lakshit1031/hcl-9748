public class java1 {
    public static void main(String[] args) {
        System.out.println("This is the first class.");

        Second obj = new Second();
        obj.show();
    }
}

class Second {
    public void show() {
        System.out.println("This is the second class.");
    }
}