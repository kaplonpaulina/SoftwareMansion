package AlgorithmicTask;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TaskTest {


    private Task task;

    private List<Integer> genericSeqA;
    private List<Integer> negativeAndZeroSeqA;
    private List<Integer> repetitiveSeqA;
    private List<Integer> emptySeqA;
    private List<Integer> genericSwqB;
    private List<Integer> negativeAndZeroSeqB;
    private List<Integer> allPrimeSeqB;
    private List<Integer> noPrimeSeqB;
    private List<Integer> emptySeqB;

    @Before
    public void setUp() throws Exception {
        task = new Task();

        genericSeqA = new ArrayList<>(Arrays.asList(2, 3, 9, 2, 5, 1, 3, 7, 10));
        negativeAndZeroSeqA = new ArrayList<>(Arrays.asList(-1, -5, -12, -6, 0));
        repetitiveSeqA = new ArrayList<>(Arrays.asList(3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3));
        emptySeqA = new ArrayList<>();
        genericSwqB = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 3, 10, 6, 6, 1, 7, 10, 10, 10));
        negativeAndZeroSeqB = new ArrayList<>(Arrays.asList(-1, -1, -1, -5, -5, -5, -5, -5, -7, -7));
        allPrimeSeqB = new ArrayList<>(Arrays.asList(3, 3, 3, 7, 7, 7, 7, 7, 7, 7, 5, 5, 5, 5, 5));
        noPrimeSeqB = new ArrayList<>(Arrays.asList(1, 4, 4, 4, 4, 6, 6, 6, 6, 6, 6));
        emptySeqB = new ArrayList<>();
    }

    @Test
    public void eratostenesSieve() {


        int upperLimit = 100;

        Set<Integer> primeNumbers = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
        Set<Integer> notPrimeNumbers = new HashSet<>();

        for (int iter = 0; iter <= upperLimit; iter++) {
            if (!primeNumbers.contains(iter)) {
                notPrimeNumbers.add(iter);
            }
        }

        boolean[] sieveResult = task.eratostenesSieve(upperLimit);

        primeNumbers.stream().forEach(a -> assertEquals(true, sieveResult[a]));
        notPrimeNumbers.stream().forEach(a -> assertEquals(false, sieveResult[a]));


    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNumberEratostenesSieve() {

        int upperLimit = -2;
        task.eratostenesSieve(upperLimit);

    }

    @Test
    public void genericSeqAGenericSeqBRemoveValuesWithPrimeNumberOfOccurencesTest() {

        List<Integer> result = new ArrayList<>(Arrays.asList(2, 9, 2, 5, 7, 10));
        assertEquals(result, task.removeValuesWithPrimeNumberOfOccurences(genericSeqA, genericSwqB));

    }

    @Test
    public void emptySeqAGenericSeqBRemoveValuesWithPrimeNumberOfOccurencesTest() {

        List<Integer> result = new ArrayList<>();
        assertEquals(result, task.removeValuesWithPrimeNumberOfOccurences(emptySeqA, genericSwqB));

    }

    @Test
    public void genericSeqAEmptySeqBRemoveValuesWithPrimeNumberOfOccurencesTest() {

        List<Integer> result = genericSeqA;
        assertEquals(result, task.removeValuesWithPrimeNumberOfOccurences(genericSeqA, emptySeqB));

    }

    @Test
    public void emptySeqAEmptySeqBRemoveValuesWithPrimeNumberOfOccurencesTest() {

        List<Integer> result = new ArrayList<>();
        assertEquals(result, task.removeValuesWithPrimeNumberOfOccurences(emptySeqA, emptySeqB));

    }

    @Test
    public void repetetiveSeqAAllPrimesSeqBRemoveValuesWithPrimeNumberOfOccurencesTest() {

        List<Integer> result = new ArrayList<>();
        assertEquals(result, task.removeValuesWithPrimeNumberOfOccurences(repetitiveSeqA, allPrimeSeqB));

    }

    @Test
    public void genericSeqANoPrimesSeqBRemoveValuesWithPrimeNumberOfOccurencesTest() {

        List<Integer> result = genericSeqA;
        assertEquals(result, task.removeValuesWithPrimeNumberOfOccurences(genericSeqA, noPrimeSeqB));

    }

    @Test
    public void genericSeqANegativeAndZeroSeqBRemoveValuesWithPrimeNumberOfOccurencesTest() {

        List<Integer> result = genericSeqA;
        assertEquals(result, task.removeValuesWithPrimeNumberOfOccurences(genericSeqA, negativeAndZeroSeqB));

    }

    @Test
    public void negativeAndZeroSeqANegativeAndZeroSeqBRemoveValuesWithPrimeNumberOfOccurencesTest() {

        List<Integer> result = new ArrayList<>(Arrays.asList(-12, -6, 0));
        assertEquals(result, task.removeValuesWithPrimeNumberOfOccurences(negativeAndZeroSeqA, negativeAndZeroSeqB));

    }


}