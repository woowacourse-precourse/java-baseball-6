package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class PlayGame {

    private static final int PLAY_BALL_LENGTH = 3;
    private static final int BALL_NUMBER_RANGE_START = 1;
    private static final int BALL_NUMBER_RANGE_END = 9;
    private static final String RESTART = "1";
    private static final String NOT_RESTART = "2";

    public void start() {
        String restartCheck = RESTART;

        while (restartCheck.equals(RESTART)) {
            game();
            System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n", RESTART, NOT_RESTART);
            try {
                restartCheck = Console.readLine();
            } catch (Exception e) {
                throw new IllegalArgumentException(RESTART + " 혹은 " + NOT_RESTART + "의 숫자만 입력 가능 합니다.");
            }
            if (!restartCheck.equals("1") && !restartCheck.equals("2")) {
                throw new IllegalArgumentException(RESTART + " 혹은" + NOT_RESTART + "의 숫자만 입력 가능 합니다.");
            }
        }
    }

    private void game() {
        List<Integer> computerRandomBalls = makeRandomBalls();
        boolean allStrike = false;

        while (!allStrike) {
            int strike = 0;
            int ball = 0;

            List<Integer> playerBalls = inputPlayerBalls();

            for (int i = 0; i < PLAY_BALL_LENGTH; i++) {
                if (computerRandomBalls.get(i).equals(playerBalls.get(i))) {
                    strike += 1;
                } else if (playerBalls.contains(computerRandomBalls.get(i))) {
                    ball += 1;
                }
            }

            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else {
                System.out.printf("%d볼 %d스트라이크%n", ball, strike);
            }

            if (strike == PLAY_BALL_LENGTH) {
                allStrike = true;
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<Integer> makeRandomBalls() {
        List<Integer> randomBalls = new ArrayList<>();

        while (randomBalls.size() < PLAY_BALL_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(BALL_NUMBER_RANGE_START, BALL_NUMBER_RANGE_END);
            if (!randomBalls.contains(randomNumber)) {
                randomBalls.add(randomNumber);
            }
        }
        return randomBalls;
    }

    private List<Integer> inputPlayerBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerBalls = new ArrayList<>();

        String[] input = Console.readLine().split("");
        if (input.length != PLAY_BALL_LENGTH) {
            throw new IllegalArgumentException(PLAY_BALL_LENGTH + "개의 숫자를 입력해야 합니다.");
        }
        for (String inputLetter : input) {
            Integer playerBall;
            try {
                playerBall = Integer.parseInt(inputLetter);
            } catch (Exception e) {
                throw new IllegalArgumentException(PLAY_BALL_LENGTH + "개의 숫자를 입력해야 합니다.");

            }
            if (!playerBalls.contains(playerBall)) {
                playerBalls.add(playerBall);
            } else {
                throw new IllegalArgumentException(PLAY_BALL_LENGTH + "개의 숫자를 입력해야 합니다.");

            }
        }

        return playerBalls;
    }
}
