import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TimeConv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = new String[]{"A", "B", "C"};

        List<String> list1 = Arrays.asList(array);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        List<String> list3 = new ArrayList<>();

        System.out.println(list1.equals(list2));
    }
}
