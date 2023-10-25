package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.GamePrinter.*;
import static baseball.GameState.*;

public class Play {
    private static final Play instance = new Play();
    private Play() {}
    public static Play getInstance() {
        return instance;
    }

    public int run(int[] comNums, int[] userNums) {
        int status = 0;
        int strike = 0;
        int ball = 0;

        int strikeCount = checkStrikeCount(comNums, userNums, strike);
        int ballCount = checkBallCount(comNums, userNums, ball);

        if (strikeCount == END_POINT.getValue()) {
            printStrikeCount(strikeCount);
            status = changeGameStatus();
        } else if (strikeCount != 0 && ballCount != 0) {
            printStrikeAndBallCount(strikeCount, ballCount);
        } else if (strikeCount != 0) {
            printStrikeCount(strikeCount);
        } else if (ballCount != 0) {
            printBallCount(ballCount);
        } else {
            printNothing();
        }

        return status;
    }

    public int changeGameStatus() {
        int gameState;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String str = Console.readLine();
        if (str.length() > 1 || str.equals(" ")) {
            throw new IllegalArgumentException();
        } else {
            int d = str.charAt(0) - '0';
            if (0 >= d || d > 2) {
                throw new IllegalArgumentException();
            } else {
                gameState = Integer.parseInt(str);
            }
        }
        return gameState;
    }

    public int checkGameStatus(int status) {
        if (status == GAME_OVER.getValue()) {
            return GAME_OVER.getValue();
        } else if (status == CONTINUE.getValue()) {
            return CONTINUE.getValue();
        }
        return STATE_LESS.getValue();
    }

    private int checkStrikeCount(int[] comNums, int[] userNums, int count) {
        for (int i = 0; i < comNums.length; i++) {
            if (comNums[i] == userNums[i]) {
                count += 1;
            }
        }
        return count;
    }

    private int checkBallCount(int[] comNums, int[] userNums, int count) {
        for (int i = 0; i < comNums.length; i++) {
            for (int j = 0; j < comNums.length; j++) {
                if (i != j && comNums[i] == userNums[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
