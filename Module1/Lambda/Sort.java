package Lambda;


import java.util.*;

public class Sort {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(
                Arrays.asList(50, 10, 40, 20, 30)
        );

        Collections.sort(list, (a, b) -> a - b);

        System.out.println(list);
    }
}
