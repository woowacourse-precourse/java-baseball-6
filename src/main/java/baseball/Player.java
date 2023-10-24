package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    public List<Integer> playerNumber = new ArrayList<>();

    public Player(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] characterizedInput = input.toCharArray();
        Set<Character> numberSet = new HashSet<>();

        for (char number : characterizedInput) {
            if (number < '1' || number > '9' || !numberSet.add(number)) {
                throw new IllegalArgumentException();
            }
            playerNumber.add(number - '0');
        }
    }
}
