package baseball.controller;

import baseball.view.TextInterface;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> answer = new ArrayList<>();
    List<Integer> userAnswer = new ArrayList<>();
    Boolean wantToStop = false;
    Boolean correct = false;
    TextInterface textInterface = new TextInterface();

    public void start() {
        textInterface.openning();
        while (!wantToStop) {
            initGame();
            while (!correct) {
                waitInput();
                calculate();
            }
        }
    }

    public void initGame() {
        int randomNumber;
        int length = 0;
        correct = false;

        answer.clear();
        userAnswer.clear();
        // 3개의 숫자를 만들어 list에 추가. 서로 다른 숫자여야함.
        while (length < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
                length++;
            }
        }
    }

    public void waitInput() {
        String userInputString;
        String[] userInputArray;
        int userInputInteger;

        //user의 입력을 기다림.
        userInputString = textInterface.readInput();
        if (userInputString.length() != 3) {
            throw new IllegalArgumentException();
        }

        //user로부터 받은 입력값을 ListArray에 integer로 변환해서 추가.
        userInputArray = userInputString.split("");
        for (int i = 0; i < userInputArray.length; i++) {
            userInputInteger = Integer.valueOf(userInputArray[i]);
            if (userAnswer.contains(userInputInteger)) {
                throw new IllegalArgumentException();
            }
            userAnswer.add(userInputInteger);
        }
    }

    public void calculate() {
        String select;
        int strike = 0;
        int ball = 0;

        if (answer.equals(userAnswer)) {
            correct = true;
            select = textInterface.correctAnswer();
            if (select.equals("1")) {
                wantToStop = false;
            } else if (select.equals("2")) {
                textInterface.endGame();
                wantToStop = true;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            for (int i = 0; i < answer.size(); i++) {
                int num = userAnswer.get(i);
                if (answer.contains(num)) {
                    if (answer.indexOf(num) == i) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }

            if (strike == 0 && ball == 0) {
                textInterface.nothing();
            } else if (strike != 0 && ball == 0) {
                textInterface.onlyStrike(strike);
            } else if (strike == 0 && ball != 0) {
                textInterface.onlyBall(ball);
            } else if (strike != 0 && ball != 0) {
                textInterface.ballAndStrike(ball, strike);
            }
            userAnswer.clear();
        }
    }
}
