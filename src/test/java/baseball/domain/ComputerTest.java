package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.dto.CountResultDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void matchTest_결과는_2스트라이크() {
        // given
        List<Integer> list = new ArrayList<>(List.of(4, 5, 6));
        Number computerNumber = new Number(list);
        Computer computer = new Computer(computerNumber);

        String input = "458";
        Player player = new Player(NumberGenerator.createPlayerNumber(input));

        // when
        CountResultDto countResult = computer.match(player);
        int strikeCount = countResult.getStrikeCount();
        int ballCount = countResult.getBallCount();

        // then
        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void matchTest_결과는_1볼_1스트라이크() {
        // given
        List<Integer> list = new ArrayList<>(List.of(3, 5, 2));
        Number computerNumber = new Number(list);
        Computer computer = new Computer(computerNumber);

        String input = "327";
        Player player = new Player(NumberGenerator.createPlayerNumber(input));

        // when
        CountResultDto countResult = computer.match(player);
        int strikeCount = countResult.getStrikeCount();
        int ballCount = countResult.getBallCount();

        // then
        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(1);
    }
}