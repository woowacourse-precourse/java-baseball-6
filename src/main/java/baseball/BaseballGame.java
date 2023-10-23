package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private final Answer answer;
    private Boolean keepGame;

    public BaseballGame() {
        answer = new Answer();
        keepGame = true;
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        answer.generate();
        gameLoop();
    }

    public void gameLoop() {
        while (keepGame) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerInput = Console.readLine();
            List<Integer> playerInputList = stringToList(playerInput);
            InputChecker.checkValidNumber(playerInputList);

            processRound(playerInputList);
        }
    }

    private List<Integer> stringToList(String string) {
        List<Integer> list = new ArrayList<>();
        string.chars().forEach(c -> list.add(Character.getNumericValue(c)));

        return list;
    }

    private void processRound(List<Integer> playerInputList) {
        int strike;
        int ball;

        List<Integer> list = answer.calculateStrikeAndBall(playerInputList);

        strike = list.get(0);
        ball = list.get(1);

        printResult(strike, ball);
    }

    private void printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.printf("%d스트라이크\n", strike);
            endGame();
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String playerInput = Console.readLine();

        if (playerInput.equals("1")) {
            answer.generate();
            keepGame = true;
        } else if (playerInput.equals("2")) {
            keepGame = false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
