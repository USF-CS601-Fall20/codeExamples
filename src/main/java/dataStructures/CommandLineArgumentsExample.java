package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class CommandLineArgumentsExample {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Not enough arguments");
            return;
        }
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int sum = x + y;
        System.out.println(sum);




    }
}
