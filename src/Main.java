import AlgorithmicTask.Task;
import CleanCode.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        System.out.println("Exercise 1.");

        Task task = new Task();

        List<Integer> a = new ArrayList<>(Arrays.asList(-1, -5, -12, -6, 0));
        List<Integer> b = new ArrayList<>(Arrays.asList(-1, -1, -1, -5, -5, -5, -5, -5, -7, -7));

        System.out.println("Seg A: \n" + a);
        System.out.println("Seq B: \n" + b);
        System.out.println("Result:");
        System.out.println(task.removeValuesWithPrimeNumberOfOccurences(a, b));


        System.out.println("\n\nExercise 2.");

        Session session = new Session();

        List<String> d = new ArrayList<>(Arrays.asList("2017-03-10 08:13:11", "2017-03-10 19:01:27", "2017-03-11 07:35:55", "2019-05-03 16:15:11", "2019-05-04 08:01:41", "2019-05-05 17:19:08"));

        System.out.println("Log: \n" + d);
        System.out.println("Result:");

        System.out.println(session.askOpinion(d));

    }


}
