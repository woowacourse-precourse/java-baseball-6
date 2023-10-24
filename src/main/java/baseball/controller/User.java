package baseball.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.view.Message;
import java.util.HashSet;

public class User {
    public String getUserNumber() {
        Message.inputMessage();
        String userNumber = readLine();
        checkUserNumber(userNumber);
        return userNumber;
    }

    public boolean inputReplay() {
        Message.replayMessage();
        String input = readLine();
        return checkInputReplay(input);
    }

    public boolean checkInputReplay(String input) {
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void checkUserNumber(String input) {
        HashSet<Character> numberBucket = new HashSet<>();
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            if (numberBucket.contains(input.charAt(i))) {
                throw new IllegalArgumentException();
            } else {
                numberBucket.add(input.charAt(i));
            }
        }
    }
}
