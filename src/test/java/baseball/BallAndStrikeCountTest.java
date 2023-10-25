package baseball;

import baseball.domain.BallAndStrikeCount;
import baseball.domain.GameManager;
import baseball.domain.Numbers;
import baseball.resource.GameMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BallAndStrikeCountTest {

    private static ByteArrayOutputStream outputMessage = new ByteArrayOutputStream();
    private List<Integer> systemList = new ArrayList<>();
    private List<Integer> playerList = new ArrayList<>();

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    void 낫싱_출력() {
        for (int i = 1; i < 4; i++) {
            systemList.add(i);
        }

        for (int i = 4; i < 7; i++) {
            playerList.add(i);
        }

        Numbers systemNumbers = new Numbers(systemList);
        Numbers playerNumbers = new Numbers(playerList);

        GameManager manager = new GameManager();
        manager.ballAndStrikeComparison(systemNumbers, playerNumbers);

        Assertions.assertEquals(GameMessage.NOTHING_MESSAGE, outputMessage.toString().trim());
    }

    @Test
    void 볼_스트라이크_같이_출력() {
        for (int i = 1; i < 4; i++) {
            systemList.add(i);
        }

        for (int i = 3; i > 0; i--) {
            playerList.add(i);
        }

        Numbers systemNumbers = new Numbers(systemList);
        Numbers playerNumbers = new Numbers(playerList);

        GameManager manager = new GameManager();
        manager.ballAndStrikeComparison(systemNumbers, playerNumbers);

        Assertions.assertEquals("2볼 1스트라이크", outputMessage.toString().trim());
    }

    @Test
    void 볼만_출력() {
        for (int i = 1; i < 4; i++) {
            systemList.add(i);
        }

        for (int i = 3; i < 8; i+=2) {
            playerList.add(i);
        }

        Numbers systemNumbers = new Numbers(systemList);
        Numbers playerNumbers = new Numbers(playerList);

        GameManager manager = new GameManager();
        manager.ballAndStrikeComparison(systemNumbers, playerNumbers);

        Assertions.assertEquals("1볼", outputMessage.toString().trim());
    }

    @Test
    void 스트라이크만_출력() {
        for (int i = 1; i < 4; i++) {
            systemList.add(i);
        }

        for (int i = 7; i > 2; i-=2) {
            playerList.add(i);
        }

        Numbers systemNumbers = new Numbers(systemList);
        Numbers playerNumbers = new Numbers(playerList);

        GameManager manager = new GameManager();
        manager.ballAndStrikeComparison(systemNumbers, playerNumbers);

        Assertions.assertEquals("1스트라이크", outputMessage.toString().trim());
    }


    @Test
    void 정해진_스트라이크_갯수가_맞다면_true() {
        for (int i = 1; i < 4; i++) {
            systemList.add(i);
        }

        for (int i = 1; i < 4; i++) {
            playerList.add(i);
        }

        Numbers systemNumbers = new Numbers(systemList);
        Numbers playerNumbers = new Numbers(playerList);

        GameManager manager = new GameManager();
        BallAndStrikeCount ballAndStrikeCount = manager.ballAndStrikeComparison(systemNumbers, playerNumbers);

        Assertions.assertTrue(ballAndStrikeCount.threeStrike());
    }

    @Test
    void 정해진_스트라이크_갯수가_아니라면_false() {
        for (int i = 1; i < 4; i++) {
            systemList.add(i);
        }

        for (int i = 7; i > 2; i-=2) {
            playerList.add(i);
        }

        Numbers systemNumbers = new Numbers(systemList);
        Numbers playerNumbers = new Numbers(playerList);

        GameManager manager = new GameManager();
        BallAndStrikeCount ballAndStrikeCount = manager.ballAndStrikeComparison(systemNumbers, playerNumbers);

        Assertions.assertFalse(ballAndStrikeCount.threeStrike());
    }
}
