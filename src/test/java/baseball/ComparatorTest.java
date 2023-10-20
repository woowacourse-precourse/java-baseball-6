package baseball;

import baseball.Controller.Comparator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ComparatorTest {
    Comparator comparator = new Comparator();

    ArrayList<Integer> computerNumber = new ArrayList<>();
    ArrayList<Integer> playerInput = new ArrayList<>();
    @Test
    void 낫싱_정상판독_테스트(){
        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(3);

        playerInput.add(4);
        playerInput.add(5);
        playerInput.add(6);
        Assertions.assertThat(comparator.isNothing(computerNumber, playerInput)).isEqualTo(true);
    }

    @Test
    void 게임종료계산_정상판독_테스트(){
        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(3);

        playerInput.add(1);
        playerInput.add(2);
        playerInput.add(3);
        Assertions.assertThat(comparator.isEndGame(computerNumber, playerInput)).isEqualTo(true);
    }

    @Test
    void 볼계산_정상판독_테스트(){
        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(3);

        playerInput.add(3);
        playerInput.add(1);
        playerInput.add(5);
        Assertions.assertThat(comparator.countBalls(computerNumber, playerInput)).isEqualTo(2);
    }

    @Test
    void 스트라이크계산_정상판독_테스트(){
        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(3);

        playerInput.add(1);
        playerInput.add(2);
        playerInput.add(5);
        Assertions.assertThat(comparator.countStrikes(computerNumber, playerInput)).isEqualTo(2);
    }

}
