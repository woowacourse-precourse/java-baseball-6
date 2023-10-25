package baseball.domain;

import baseball.util.ValidationUtil;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.common.Constants.BALL_CNT;
import static baseball.common.GameMessage.*;

public class Game {
    private boolean isGameOver = false;

    public Game(Balls randomBalls) {
        Result result = beforeGame();
        playGame(randomBalls, result);
        afterGame();
    }

    private Result beforeGame() {
        System.out.println(GAME_START_MESSAGE);
        return new Result();
    }

    private void playGame(Balls randomBalls, Result result) {
        while (!result.isGameOver()) {
            System.out.print(NUMBER_INPUT_MESSAGE);
            String input = Console.readLine();

            ValidationUtil.isValidInput(input);

            List<Integer> userNums = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                userNums.add(Integer.parseInt(String.valueOf(input.charAt(i))));
            }

            result = randomBalls.play(userNums);
            System.out.println(result);
        }
    }

    private void afterGame() {
        System.out.print(BALL_CNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println(RESTART_SELECT_MESSAGE);

        String input = Console.readLine();
        if (input.equals("2")) {
            gameOver();
            return;
        }
        if (!input.equals("1")) {
            throw new IllegalArgumentException("1, 2 중 하나를 입력해야 합니다.");
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    private void gameOver() {
        isGameOver = true;
    }
}
