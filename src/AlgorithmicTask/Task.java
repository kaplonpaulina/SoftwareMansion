package AlgorithmicTask;

import java.util.*;
import java.util.stream.Collectors;

public class Task {


    public boolean[] eratostenesSieve(int upperLimit) {

        if (upperLimit < 0)
            throw new IllegalArgumentException("Negative size");

        boolean primeNumbers[] = new boolean[upperLimit + 1];

        for (int i = 2; i <= upperLimit; i++)
            primeNumbers[i] = true;

        for (int p = 2; p * p <= upperLimit; p++) {
            if (primeNumbers[p] == true) {
                for (int i = p * p; i <= upperLimit; i += p)
                    primeNumbers[i] = false;
            }
        }

        return primeNumbers;
    }


    public List<Integer> removeValuesWithPrimeNumberOfOccurences(List<Integer> sequenceA, List<Integer> sequenceB) {

        if (sequenceB.isEmpty()) {
            return sequenceA;
        }


        Map<Integer, Integer> mapValueToNumber = new HashMap<>();

        sequenceB.stream().forEach(number -> {
            if (mapValueToNumber.get(number) == null) {
                mapValueToNumber.put(number, 1);
            } else {
                mapValueToNumber.put(number, mapValueToNumber.get(number) + 1);
            }
        });


        Set<Integer> setNumbersOfOcurrence = new HashSet<>(mapValueToNumber.values());

        int maxValue = setNumbersOfOcurrence.stream().max(Integer::compare).get();

        boolean[] eratostenesSieve = eratostenesSieve(maxValue);

        Set<Integer> setPrimaryNumbersOfOcurrence = setNumbersOfOcurrence.stream().filter(a -> eratostenesSieve[a]).collect(Collectors.toSet());

        Set<Integer> setB = new HashSet<>(mapValueToNumber.keySet().stream().filter(a -> setPrimaryNumbersOfOcurrence.contains(mapValueToNumber.get(a))).collect(Collectors.toSet()));

        return sequenceA.stream().filter(a -> !setB.contains(a)).collect(Collectors.toList());

    }


}
