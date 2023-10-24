package baseball.umpire;

import baseball.AppConfig;
import baseball.game.CheckingBoard;
import baseball.game.Score;
import baseball.game.umpire.Umpire;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static baseball.AppConfig.DIGIT_NUM;

public class UmpireTest {
    Umpire umpire;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        umpire = appConfig.umpire();
    }

    @Test
    void umpireStrikeCheck() {
        //given
        String ball = "123";
        String batt = "153";
        int compareCount = 0;
        int strikeCount = 0;
        CheckingBoard checkingBoard = new CheckingBoard();

        for (int i = 0; i < DIGIT_NUM; i++) {
            if (ball.charAt(i) == batt.charAt(i)) {
                compareCount++;
            }
        }
        //when
        checkingBoard = umpire.checkStrike(ball, batt, checkingBoard);
        //then
        Boolean[] strikeCheckingBoard = checkingBoard.getStrikeCheckingBoard();
        for (int i = 0; i < DIGIT_NUM; i++) {
            if (strikeCheckingBoard[i] == true) {
                strikeCount++;
            }
        }
        Assertions.assertThat(strikeCount).isEqualTo(compareCount);
    }

    @Test
    void umpireBallCheck() {
        //given
        String ball = "011";
        String bat = "110";
        int compareCount = 0;
        int ballCount = 0;

        CheckingBoard checkingBoard = new CheckingBoard();

        Boolean[] compareCheckingBoard = new Boolean[DIGIT_NUM];
        Arrays.fill(compareCheckingBoard, false);

        checkingBoard = umpire.checkStrike(ball, bat, checkingBoard);

        Boolean[] strikeCheckingBoard = checkingBoard.getStrikeCheckingBoard();

        for (int i = 0; i < DIGIT_NUM; i++) {
            if (strikeCheckingBoard[i] == true) {
                continue;
            }
            for (int j = 0; j < DIGIT_NUM; j++) {
                if (strikeCheckingBoard[j] == true) {
                    continue;
                }
                if (compareCheckingBoard[j] == true) {
                    continue;
                }
                if (ball.charAt(i) == bat.charAt(j)) {
                    compareCheckingBoard[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < DIGIT_NUM; i++) {
            if (compareCheckingBoard[i] == true) {
                compareCount++;
            }
        }

        //when
        checkingBoard = umpire.checkBall(ball, bat, checkingBoard);

        //then
        Boolean[] ballCheckingBoard = checkingBoard.getBallCheckingBoard();
        for (int i = 0; i < DIGIT_NUM; i++) {
            if (ballCheckingBoard[i] == true) {
                ballCount++;
            }
        }
        Assertions.assertThat(ballCount).isEqualTo(compareCount);
    }

    @Test
    void umpireJudgeCheck() {
        //given
        String ball = "111";
        String bat = "111";

        int compareStrike = 3;
        int compareBall = 0;
        boolean compareHomerun = true;
        boolean compareNothing = false;

        Score score = new Score();

        Score compareScore = new Score();
        compareScore.setAll(compareStrike, compareBall, compareHomerun, compareNothing);

        CheckingBoard checkingBoard = new CheckingBoard();

        checkingBoard = umpire.checkStrike(ball, bat, checkingBoard);
        checkingBoard = umpire.checkBall(ball, bat, checkingBoard);

        //when
        score = umpire.judge(checkingBoard, score);

        //then
        Assertions.assertThat(score).usingRecursiveComparison().isEqualTo(compareScore);
    }
}
