import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] arr = {1, 2, 3 ,4};
        list.add(arr[0]);

        boolean res = list.contains(arr[0]);

        Set<Integer> set = new HashSet<>();


        System.out.println("res = " + res);
    }
}