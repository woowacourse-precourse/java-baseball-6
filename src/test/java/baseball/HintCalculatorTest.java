package baseball;

import baseball.controller.HintCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HintCalculatorTest {

    @DisplayName("userList와 computerList가 하나도 겹치지 않을 때 낫싱 출력")
    @Test
    void printNothingHint(){
        List<Integer> userList = List.of(1, 2, 3);
        List<Integer> computerList = List.of(4, 5, 6);
        HintCalculator hintCalculator = new HintCalculator(userList, computerList);
        String hintString = hintCalculator.getHintString();
        String expectedHintString = "낫싱";
        assertThat(hintString).isEqualTo(expectedHintString);
    }

    @DisplayName("볼 개수가 0이고 스트라이크 개수가 0이 아닐 때 스트라이크만 출력")
    @Test
    void printOnlyStrikeCount(){
        List<Integer> userList = List.of(1, 2, 3);
        List<Integer> computerList = List.of(1, 4, 5);
        HintCalculator hintCalculator = new HintCalculator(userList, computerList);
        String hintString = hintCalculator.getHintString();
        String expectedHintString = "1스트라이크";
        assertThat(hintString).isEqualTo(expectedHintString);
    }

    @DisplayName("스트라이크 개수가 0이고 볼 개수가 0이 아닐 때 볼만 출력")
    @Test
    void printOnlyBallCount(){
        List<Integer> userList = List.of(1, 2, 3);
        List<Integer> computerList = List.of(3, 1, 2);
        HintCalculator hintCalculator = new HintCalculator(userList, computerList);
        String hintString = hintCalculator.getHintString();
        String expectedHintString = "3볼";
        assertThat(hintString).isEqualTo(expectedHintString);
    }

    @DisplayName("스트라이크, 볼 개수 모두 0이 아닐 때")
    @Test
    void printBothStrikeAndBallCount(){
        List<Integer> userList = List.of(1, 2, 3);
        List<Integer> computerList = List.of(3, 2, 4);
        HintCalculator hintCalculator = new HintCalculator(userList, computerList);
        String hintString = hintCalculator.getHintString();
        String expectedHintString = "1볼 1스트라이크";
        assertThat(hintString).isEqualTo(expectedHintString);
    }

    @DisplayName("userNumber와 computerNumber가 일치할 때 3스트라이크 출력")
    @Test
    void prinThreeStrikeCount(){
        List<Integer> userList = List.of(1, 2, 3);
        List<Integer> computerList = List.of(1, 2, 3);
        HintCalculator hintCalculator = new HintCalculator(userList, computerList);
        String hintString = hintCalculator.getHintString();
        String expectedHintString = "3스트라이크";
        assertThat(hintString).isEqualTo(expectedHintString);
    }

}
