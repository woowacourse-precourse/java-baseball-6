package baseball.controller;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.RandomUtils;
import baseball.view.ErrorView;
import baseball.view.PrintView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    User user;
    Game game;
    PrintView printView = new PrintView();

    // 게임 시작전 세팅하는 함수
    public void gameSet() {
        game = new Game(RandomUtils.getRandomNumbers());
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
        gameStart(game.getAnswer());
        printView.printGameEndMessage();

        gameRestart();
    }

    // 게임을 시작한다.
    public void gameStart(int[] answer) {
        printView.printGameStartMessage();
        while (game.getStrike()!=3) {
            game.initScore();
            printView.printUserInputMessage();
            user = new User(getInputNumber());
            analyzeInputNumber(answer, user.getInputNum());
        }
    }

    // 입력값을 받는다.
    public int[] getInputNumber() {
        ErrorView errorView = new ErrorView();
        int[] inputNum = new int[3];
        String input = Console.readLine();
        if (input.length() != 3) {
            errorView.inputNumberLengthError();
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                errorView.validateInputError();
            }
            inputNum[i] = Integer.parseInt(String.valueOf(c));
        }
        return inputNum;
    }

    // 입력받은 숫자와 정답을 비교한다.
    public void analyzeInputNumber(int[] answer, int[] inputNum) {

        for (int i = 0; i < answer.length; i++) {
            compareNumber(answer, inputNum, i);
        }

        printView.printScoreMessage(game.getStrike(), game.getBall());

    }


    // 정답과 숫자가 같은지 확인한다.
    public void compareNumber(int[] answer, int[] inputNum, int index) {
        for (int j = 0; j < inputNum.length; j++) {
            if (answer[index] == inputNum[j]) {
                getCount(index, j);
                break;
            }
        }
    }

    // 스트라이크와 볼의 갯수를 구한다.
    public void getCount(int index, int j) {
        if (index != j) {
            game.increaseBall();
        }
        if (index == j) {
            game.increaseStrike();
        }
    }

    // 게임 재시작 여부를 묻고 재시작 또는 종료 시킨다.
    public void gameRestart() {
        printView.printRestartMessage();
        int mode = Integer.parseInt(Console.readLine());
        if (mode == 1) {
            game.initScore();
            gameSet();
        }else if(mode == 2) {
            printView.printRestartEndMessage();
        }
    }
}
