import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static AlgorithmicTask.Task.removeValuesWithPrimeNumberOfOccurences;
import static CleanCode.Session.askOpinion;

public class Main {

    public static void main(String[] args) {


        List<Integer> a = new ArrayList<>(Arrays.asList(2, 3, 9, 2, 5, 1, 3, 7, 10));
        List<Integer> b = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 3, 10, 6, 6, 1, 7, 10, 10, 10));
        System.out.println(removeValuesWithPrimeNumberOfOccurences(a, b));

       // List<String> d = new ArrayList<>(Arrays.asList("2017-03-10 08:13:11", "2017-03-10 19:01:27", "2017-03-11 07:35:55", "2019-05-03 16:15:11", "2019-05-04 08:01:41", "2019-05-05 17:19:08"));

       // System.out.println(askOpinion(d));

    }


}
