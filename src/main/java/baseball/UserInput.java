package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class UserInput {
    String userString = Console.readLine();

    public List<Character> userInputToList() {

        HashSet<Character> checkContainSameThings = new HashSet<>();
        List<Character> extractDigit = new ArrayList<>();

        for (int i = 0; i < userString.length(); i++) {

            if (!checkContainSameThings.add(userString.charAt(i))) {
                throw new IllegalArgumentException();
            }

            if (userString.charAt(i) >= '1' && userString.charAt(i) <= '9')
                extractDigit.add(userString.charAt(i));

            if (!Pattern.matches("[1-9]{3}",userString))
                throw new IllegalArgumentException();
        }
        return extractDigit;
    }

    public List<Integer> changeCharToIntInList () {

        List<Integer> changeCharToInt = new ArrayList<>();

        for (Character chr : userInputToList()) {
            int num = Character.getNumericValue(chr);
            changeCharToInt.add(num);
        }

        return changeCharToInt;
    }
}

