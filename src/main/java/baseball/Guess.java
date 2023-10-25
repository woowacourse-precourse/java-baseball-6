package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Guess {
    private final int GUESS_SIZE = 3;
    private List<Integer> computerGuess = new ArrayList<>();
    private List<Integer> userGuess = new ArrayList<>();

    public void setComputerGuessByRandom() {
        computerGuess.clear();
        while (computerGuess.size() < GUESS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerGuess.contains(randomNumber)) {
                computerGuess.add(randomNumber);
            }
        }
    }

    private boolean checkUserInput(String userInput) {
        if (userInput.length() != GUESS_SIZE) {
            return false;
        }
        for (int i = 0; i < userInput.length(); ++i) {      //숫자만 입력했는지 체크
            char c = userInput.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        for (int i = 0; i < userInput.length() - 1; ++i) {      //중복되는 글자가 없는지 체크
            char c = userInput.charAt(i);
            if (userInput.substring(i + 1).contains(c + "")) {      //char을 charsequence로 바꾼다
                return false;
            }
        }
        return true;
    }

    public void setUserGuessByInput() throws IllegalArgumentException {
        String userInput = Console.readLine();
        if (!checkUserInput(userInput)) {
            throw new IllegalArgumentException();
        }
        userGuess.clear();
        for (int i = 0; i < userInput.length(); ++i) {
            char c = userInput.charAt(i);
            userGuess.add(c - '0');
        }
    }

    public int calculateBall() {
        int ballCount = 0;
        for (int i = 0; i < GUESS_SIZE; ++i) {
            if (computerGuess.contains(userGuess.get(i))) {
                ballCount++;
            }
        }
        return ballCount - calculateStrike();
    }

    public int calculateStrike() {
        int strikeCount = 0;
        for (int i = 0; i < GUESS_SIZE; ++i) {
            if (computerGuess.get(i).equals(userGuess.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
