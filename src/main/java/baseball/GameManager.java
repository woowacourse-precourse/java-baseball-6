package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private boolean gameEndFlag;
    private boolean answerMatchFlag;

    public GameManager() {
        gameEndFlag = false;
        answerMatchFlag = false;
    }

    public boolean isGameEnd() {
        return gameEndFlag;
    }

    public boolean isAnswerMatch() {
        return answerMatchFlag;
    }

    public void printGuessResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼");
        }
        if (strike > 0) {
            if (ball > 0) {
                System.out.print(" ");
            }
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if (strike == 3) {
            System.out.print("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            answerMatchFlag = true;
        }
        System.out.println();
    }

    public void gameEnd() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (userInput.equals("1")) {
            answerMatchFlag = false;
            return;
        }
        if (userInput.equals("2")) {
            gameEndFlag = true;
            return;
        }
        throw new IllegalArgumentException();
    }
}
