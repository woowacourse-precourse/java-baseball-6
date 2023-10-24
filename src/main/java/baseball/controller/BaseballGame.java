package baseball.controller;

import static baseball.util.Constants.MAX_NUM;
import static baseball.util.Constants.MIN_NUM;
import static baseball.util.Constants.NUMBER_SIZE;

import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class BaseballGame {
    Message output = new Message();
    private static final int ASCII_ZERO = 48;

    private static final int ASCII_NINE = 57;

    private final ArrayList<Character> numbers;

    public BaseballGame() {
        this.numbers = new ArrayList<>(NUMBER_SIZE);
    }

    public void gameStart() {
        output.printStart();

        do {
            setNumbers();
            playGame();
        } while (isRestart());
    }

    private void playGame() {
        int ballCount = 0;
        int strikeCount = 0;

        while (strikeCount != 3) {
            output.printInput();
            String userInput = Console.readLine();

            if (userInput.length() != NUMBER_SIZE) {
                throw new IllegalArgumentException("숫자 3자리를 입력을 해야합니다.");
            }

            for (int i = 0; i < userInput.length(); ++i) {
                checkNumberCharacter(userInput.charAt(i));
            }

            ballCount = getBallCount(userInput);
            strikeCount = getStrikeCount(userInput);

            if (ballCount > 0 && strikeCount > 0) {
                System.out.printf("%d볼 %d스트라이크%s", ballCount, strikeCount, System.lineSeparator());
                continue;
            }

            if (ballCount > 0) {
                System.out.printf("%d볼%s", ballCount, System.lineSeparator());
                continue;
            }

            if (strikeCount > 0) {
                System.out.printf("%d스트라이크%s", strikeCount, System.lineSeparator());
                continue;
            }

            System.out.printf("낫싱%s", System.lineSeparator());
        }

        output.printEnd();
    }

    private boolean isRestart() {
        output.printRetry();
        String userInput = Console.readLine();

        if (userInput.length() != 1) {
            throw new IllegalArgumentException("숫자 1자리를 입력을 해야합니다.");
        }
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("1과 2 두 개의 숫자를 입력해야 합니다.");
        }

        if (userInput.equals("1")) {
            return true;
        }
        return false;
    }

    private int getBallCount(String presentNumber) {
        int ballCount = 0;

        for (int i = 0; i < presentNumber.length(); ++i) {
            char value = presentNumber.charAt(i);

            if (isBall(value, i)) {
                ++ballCount;
            }
        }

        return ballCount;
    }

    private int getStrikeCount(String presentNumber) {
        int strikeCount = 0;

        for (int i = 0; i < presentNumber.length(); ++i) {
            char value = presentNumber.charAt(i);

            if (value == this.numbers.get(i).charValue()) {
                ++strikeCount;
            }
        }

        return strikeCount;
    }

    private boolean isBall(char value, int index) {
        return this.numbers.contains(Character.valueOf(value))
                && this.numbers.indexOf(Character.valueOf(value)) != index;
    }

    private void checkNumberCharacter(char value) {
        if (value < ASCII_ZERO || value > ASCII_NINE) {
            throw new IllegalArgumentException("숫자 문자가 아닙니다.");
        }
    }

    private void setNumbers() {
        this.numbers.clear();
        while (numbers.size() < NUMBER_SIZE) {
            int value = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);

            Character character = Character.valueOf((char) (value + ASCII_ZERO));

            if (!this.numbers.contains(character)) {
                this.numbers.add(character);
            }
        }
    }
}
