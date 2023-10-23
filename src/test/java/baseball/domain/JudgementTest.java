package baseball.domain;

import baseball.util.JudgementConverter;
import org.junit.jupiter.api.*;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("판정(Judgement) 도메인 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JudgementTest {

    @Test
    @Order(0)
    @DisplayName("올바른 판정 판정 여부")
    public void Case_1_Correct_Judgement() {
        // when
        Computer computer = new Computer();
        computer.setNumberList(List.of(1, 7, 8));

        // given
        List<Pitch> pitches = List.of(
                new Pitch(List.of(2, 5, 6)),
                new Pitch(List.of(2, 1, 6)),
                new Pitch(List.of(2, 1, 7)),
                new Pitch(List.of(8, 1, 7)),
                new Pitch(List.of(1, 5, 6)),
                new Pitch(List.of(1, 7, 6)),
                new Pitch(List.of(1, 7, 8)),
                new Pitch(List.of(1, 4, 7)),
                new Pitch(List.of(8, 7, 1))
        );

        // then
        for (Pitch pitch : pitches) {
            assertSimpleTest(
                    () -> {
                        Judgement judgement = new Judgement(
                                computer.countBall(pitch.getPitches()),
                                computer.countStrike(pitch.getPitches())
                        );
                        assertThat(JudgementConverter.of(judgement)).isIn("낫싱", "1볼", "2볼", "3볼", "1스트라이크", "2스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크");
                    }
            );
        }
    }
}
