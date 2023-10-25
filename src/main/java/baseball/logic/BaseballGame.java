package baseball.logic;

import baseball.domain.Player;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private int strikeCount;
    private int ballCount;
    private Player player;
    public static String RESTART = "1";
    public static String EXIT = "2";
    public static String NOTHING = "낫싱";
    public static String BALL = "볼";
    public static String STRIKE = "스트라이크";
    public static int GAME_OVER_STRIKE = 3;
    public static int NUMBERS_LENGTH = 3;
    public static int NUMBERS_RANGE_START = 1;
    public static int NUMBERS_RANGE_END = 9;
    public static int COUNT_INIT_NUMBER = 0;



    public BaseballGame() {
        this.computerNumbers = new ArrayList<>();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public String play() {
        OutputView.printGameIntroduction();
        ExtractComputerRandomNumber();

        player = new Player();
        String playerAnswer;
        while (true) {
            player.guessNumbers();
            giveScore(player.getNumbers());
            printScores();
            if (isGameOver()) {
                OutputView.printGameOver();
                playerAnswer = player.replayOrExit();
                if (playerAnswer.equals(RESTART)) {
                    return RESTART;
                } else if (playerAnswer.equals(EXIT)) {
                    return EXIT;
                } else {
                    // 예외 출력
                }
            }
        }
    }

    private List<Integer> ExtractComputerRandomNumber() {
        while (computerNumbers.size() < NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(NUMBERS_RANGE_START, NUMBERS_RANGE_END);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private void giveScore(List<Integer> guessNumbers) {
        resetCount();
        for (int i = 0; i < 3; i++) {
            // 스트라이크 검사
            int guessNumber = guessNumbers.get(i);
            if (guessNumber == computerNumbers.get(i)) {
                strikeCount++;
            }
            // 볼 검사
            if (guessNumber == computerNumbers.get((i + 1) % 3)) {
                ballCount++;
            }
            if (guessNumber == computerNumbers.get((i + 2) % 3)) {
                ballCount++;
            }
        }
    }

    private void resetCount() {
        this.strikeCount = COUNT_INIT_NUMBER;
        this.ballCount = COUNT_INIT_NUMBER;
    }
    private void printScores() {
        OutputView.printScores(ballCount, strikeCount);
    }
    private boolean isGameOver() {
        if (strikeCount == GAME_OVER_STRIKE) {
            return true;
        }else {
            return false;
        }
    }
}
