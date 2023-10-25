package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answerNumbers = new ArrayList<>();
    private boolean running;
    private boolean gameOver;
    private int ball;
    private int strike;

    Computer() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void startGame(Player player) {
        generateRandomNumbers();
        running = true;
        gameOver = false;
        while (running) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> guessingNumbers = player.guessNumbers();
            countScore(guessingNumbers);
            printScore();
            if (gameOver) {
                this.askForRestart(player);
            }
        }
    }

    private void generateRandomNumbers() {
        if (answerNumbers.size() != 0) {
            answerNumbers.clear();
        }
        while (answerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumbers.contains(randomNumber)) {
                answerNumbers.add(randomNumber);
            }
        }
    }

    private void countScore(List<Integer> guessNumbers) {
        ball = 0;
        strike = 0;
        for (int i = 0; i < answerNumbers.size(); i++) {
            int answerNumberAtIndex = answerNumbers.get(i);
            int guessNumberAtIndex = guessNumbers.get(i);
            if (answerNumberAtIndex == guessNumberAtIndex) {
                strike++;
            }
            if (answerNumberAtIndex != guessNumberAtIndex
                    && answerNumbers.contains(guessNumberAtIndex)) {
                ball++;
            }
        }
    }

    private void printScore() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0 && strike == 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }
        if (ball == 0 && strike != 0 && strike != 3) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return;
        }
        if (strike == 3) {
            System.out.printf("%d스트라이크\n", strike);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameOver = true;
            running = false;
            return;
        }
    }

    private void askForRestart(Player player) throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
        try {
            String userInput = Console.readLine();
            int restartOption = Integer.parseInt(userInput);
            if (restartOption != 1 && restartOption != 2) {
                throw new IllegalArgumentException("재시작 옵션에 1이나 2가 아닌 숫자를 입력");
            }
            if (restartOption == 1) {
                this.startGame(player);
            }
            if (restartOption == 2) {
                return;
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Integer로 변환할 수 없는 문자열을 입력");
        }
    }
}