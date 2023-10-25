package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberGenerator {
    public static List<Integer> uniqueRandomNumbersGenerator(int numberOfRandom){
        return Randoms.pickUniqueNumbersInRange(1, 9,numberOfRandom);
    }


    public static List<Integer> getUniqueRandomNumberSequence(int LengthOfSequence){
        Set<Integer> set = new HashSet<>();
        while(set.size() != 3){
            set.add(Randoms.pickNumberInRange(1,9));
        }
        List<Integer> randomNumbers = new ArrayList<>(set);
        validateRandomNumbers(randomNumbers);
        return randomNumbers;
    }
    private static void validateRandomNumbers(List<Integer> randomNumbers){
        List<Integer> nonDuplicateNumbers = randomNumbers.stream().distinct().toList();
        if (nonDuplicateNumbers.size() != 3){
            System.out.println(randomNumbers);
            throw new IllegalArgumentException();
        }
        for (Integer nonDuplicateNumber : nonDuplicateNumbers) {
            if (nonDuplicateNumber < 1 || nonDuplicateNumber > 9){
                throw new IllegalArgumentException();
            }
        }
    }
}
