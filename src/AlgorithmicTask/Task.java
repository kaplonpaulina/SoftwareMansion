package AlgorithmicTask;

import java.util.*;
import java.util.stream.Collectors;

public class Task {


    public static boolean[] eratostenesSieve(int m){

        boolean primeNumbers[] = new boolean[m+1];

        for(int i=2;i<m;i++)
            primeNumbers[i] = true;

        for(int p = 2; p*p <=m; p++)
        {
            if(primeNumbers[p] == true)
            {
                for(int i = p*p; i <= m; i += p)
                    primeNumbers[i] = false;
            }
        }

        return primeNumbers;
    }



    public static List<Integer> removeValuesWithPrimeNumberOfOccurences(List<Integer> sequenceA, List<Integer> sequenceB) {


        Map<Integer, Integer> mapValueToNumber = new HashMap<>();

        sequenceB.stream().forEach(number -> {
            if (mapValueToNumber.get(number) == null) {
                mapValueToNumber.put(number, 1);
            } else {
                mapValueToNumber.put(number, mapValueToNumber.get(number) + 1);
            }
        });//b


        Set<Integer> setNumbersOfOcurrence = new HashSet<>(mapValueToNumber.values());//b

        int maxValue = setNumbersOfOcurrence.stream().max(Integer::compare).get();//b

        boolean[] eratostenesSieve = eratostenesSieve(maxValue);//max(b) log(log(max(b)))

        setNumbersOfOcurrence = setNumbersOfOcurrence.stream().filter(a -> eratostenesSieve[a]).collect(Collectors.toSet());//a

        Set<Integer> finalSetNumbersOfOcurrence = setNumbersOfOcurrence;

        Set<Integer> setB = new HashSet<>(mapValueToNumber.keySet().stream().filter(a -> finalSetNumbersOfOcurrence.contains(mapValueToNumber.get(a))).collect(Collectors.toSet()));//b

        return sequenceA.stream().filter(a -> !setB.contains(a)).collect(Collectors.toList());//a

    }



}
