package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validate {
    public static void validateContinueGame(String number) throws IllegalArgumentException {
        if (number.length() != 1)
            throw new IllegalArgumentException();
        if (!(number.equals("1") || number.equals("2")))
            throw new IllegalArgumentException();
    }

    public static void validateNumber(String number) throws IllegalArgumentException {
        if (number.length() != 3)
            throw new IllegalArgumentException();
        char num;
        Set<Character> distinctNumber = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            num = number.charAt(i);
            if ('1' > num || num > '9')
                throw new IllegalArgumentException();
            distinctNumber.add(num);
        }
        if (distinctNumber.size() < 3)
            throw new IllegalArgumentException();
    }
}
