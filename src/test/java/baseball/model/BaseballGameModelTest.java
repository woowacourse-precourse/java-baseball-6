package baseball.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameModelTest {

    private BaseballGameModel baseballGameModel;

    @BeforeEach
    public void setUp() {
        // 객체 초기화
        baseballGameModel = new BaseballGameModel();
    }

    @AfterEach
    public void tearDown() {
        // 객체 정리
        baseballGameModel = null;
    }

    @Test
    void length() {
        baseballGameModel.generateRandomNumbers();
        List<Integer> computerNumbers = baseballGameModel.getComputerNumbers();
        assertThat(computerNumbers.size()).isEqualTo(3);
    }

    @Test
    void clear() {
        baseballGameModel.generateRandomNumbers();
        List<Integer> computerNumbers = baseballGameModel.getComputerNumbers();
        baseballGameModel.clearComputerNumbers();
        assertThat(computerNumbers.size()).isEqualTo(0);
    }
}