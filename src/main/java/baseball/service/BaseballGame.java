package baseball.service;

import baseball.console.Input;
import baseball.console.Output;
import baseball.entity.Computer;
import baseball.entity.User;

import java.util.HashSet;

public class BaseballGame {
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private User user;
    private Computer computer;

    public BaseballGame() {
        System.out.println(START_MESSAGE);
        user = new User();
        computer = new Computer();
    }

    public void start() {
        computer.generateRandomAnswer();
        user.setNumber(Input.get());
        while (!isCorrect()) {
            user.setNumber(Input.get());
        }
        Output.printAnswerMessage();
        String restart = Input.restart();
        if (restart.equals("1")) {
            start();
        }
    }

    private boolean isCorrect() {
        String number = user.getNumber();
        String answer = computer.getAnswer();
        int strike = countStrike(number, answer);
        int ball = countBall(number, answer);
        Output.print(ball, strike);

        if (strike == 3) {
            return true;
        }
        return false;
    }

    public static int countBall(String number, String answer) {
        HashSet<Character> set = new HashSet<>();
        for (char c : answer.toCharArray()) {
            set.add(c);
        }
        int ballCount = 0;
        for (int index = 0; index < 3; index++) {
            if (number.charAt(index) != answer.charAt(index) && set.contains(number.charAt(index))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public static int countStrike(String number, String answer) {
        if (number.equals(answer)) {
            return 3;
        }

        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (number.charAt(index) == answer.charAt(index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}

