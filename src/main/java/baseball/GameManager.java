package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    /**
     * becomes true when user wants to stop playing the game, otherwise it's always false.
     */
    private boolean gameEndFlag;
    /**
     * becomes true when user gets the right answer, becomes false everytime the game restarts.
     */
    private boolean answerMatchFlag;

    /**
     * initializes {@code gameEndFlag}, {@code answerMatchFlag} to false when constructed
     */
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

    /**
     * Print the number of balls and strikes. If there is no balls or strikes, print "낫싱"
     *
     * @param ball   the number of balls
     * @param strike the number of strikes.
     */
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

    /**
     * Gets user input about game end. If input is "1" set {@code answerMatchFlag} to false and plays the game again. If
     * input is "2" set {@code gameEndFlag} to true, which ends the game.
     *
     * @throws IllegalArgumentException if the user input is not "1" or "2"
     */
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
