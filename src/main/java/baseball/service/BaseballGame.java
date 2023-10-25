package baseball.service;

import baseball.console.Input;
import baseball.console.Output;
import baseball.entity.Computer;
import baseball.entity.User;

import java.util.HashSet;

public class BaseballGame {
    private final String startMessage = "숫자 야구 게임을 시작합니다.";
    private User user;
    private Computer computer;

    public BaseballGame() {
        System.out.println(startMessage);
        user = new User();
        computer = new Computer();
    }

    public void start() {
        computer.setAnswer();
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
        int strike = 0;
        int ball = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == answer.charAt(i)) {
                strike++;
            }
            set.add(answer.charAt(i));
        }
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != answer.charAt(i) && set.contains(number.charAt(i))) {
                ball++;
            }
        }
        if (ball == 0 && strike == 0) {
            Output.printNothingMessage();
        }
        else if (ball == 0) {
            Output.printStrikeMessage(strike);
        }
        else if (strike == 0) {
            Output.printBallMessage(ball);
        }
        else {
            Output.printBallAndStirkeMessage(ball, strike);
        }

        if (strike == 3) {
            return true;
        }
        return false;
    }
}

