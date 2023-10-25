package baseball.controller;

import baseball.model.BaseballGameModel;
import baseball.view.BaseballGameView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameControllerTest {

    BaseballGameModel baseballGameModel;
    BaseballGameView baseballGameView;

    BaseballGameController baseballGameController = new BaseballGameController(baseballGameModel, baseballGameView);

    @BeforeEach
    public void setUp() {
        // 객체 초기화
        baseballGameModel = new BaseballGameModel();
        BaseballGameView baseballGameView = new BaseballGameView();

    }

    @AfterEach
    public void tearDown() {
        // 객체 정리
        baseballGameModel = null;
        baseballGameView = null;
        baseballGameController = null;
    }

    @Test
    void processInputErrorTest() {
        assertThrows(IllegalArgumentException.class,
                () -> baseballGameController.processInput("1234", 3));
        assertThrows(IllegalArgumentException.class,
                () -> baseballGameController.processInput("안12", 3));
        assertThrows(IllegalArgumentException.class,
                () -> baseballGameController.processInput("122", 3));
    }

    @Test
    void processInputTest() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        assertThat(integers).isEqualTo(baseballGameController.processInput("123", 3));
    }

    @Test
    void allStrike() {
        // given

        List<Integer> userInput = new ArrayList<>();
        List<Integer> computerNumbers = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        userInput.add(1);
        userInput.add(2);
        userInput.add(3);

        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);

        // when
        HashMap<String, Integer> computeResult = baseballGameController.computeResult(userInput, computerNumbers);

        // then
        hashMap.put("strike", 3);
        hashMap.put("ball", 0);
        assertThat(hashMap).isEqualTo(computeResult);
    }

    @Test
    void oneStrikeOneBall() {
        // given

        List<Integer> userInput = new ArrayList<>();
        List<Integer> computerNumbers = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        userInput.add(2);
        userInput.add(2);
        userInput.add(3);

        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(2);

        // when
        HashMap<String, Integer> computeResult = baseballGameController.computeResult(userInput, computerNumbers);

        // then
        hashMap.put("strike", 1);
        hashMap.put("ball", 1);
        assertThat(hashMap).isEqualTo(computeResult);
    }

    @Test
    void noStrikeNoBall() {
        // given

        List<Integer> userInput = new ArrayList<>();
        List<Integer> computerNumbers = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        userInput.add(1);
        userInput.add(2);
        userInput.add(3);

        computerNumbers.add(5);
        computerNumbers.add(6);
        computerNumbers.add(4);

        // when
        HashMap<String, Integer> computeResult = baseballGameController.computeResult(userInput, computerNumbers);

        // then
        hashMap.put("strike", 0);
        hashMap.put("ball", 0);
        assertThat(hashMap).isEqualTo(computeResult);
    }

    @Test
    void AllBall() {
        // given

        List<Integer> userInput = new ArrayList<>();
        List<Integer> computerNumbers = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        userInput.add(1);
        userInput.add(2);
        userInput.add(3);

        computerNumbers.add(3);
        computerNumbers.add(1);
        computerNumbers.add(2);

        // when
        HashMap<String, Integer> computeResult = baseballGameController.computeResult(userInput, computerNumbers);

        // then
        hashMap.put("strike", 0);
        hashMap.put("ball", 3);
        assertThat(computeResult).isEqualTo(hashMap);
    }



}