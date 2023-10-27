package baseball.domain;

import baseball.util.JudgementConverter;
import baseball.util.RandomNumberGenerator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
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
    @Test
    @Order(1)
    @DisplayName("볼/스트라이크 판정 한계값 이탈 여부")
    public void Case_2_Not_Over_Valid() {
        Computer computer = new Computer();

        // given
        for (int i = 0; i < 100; i++) {
            List<Integer> numberList = new ArrayList<>();
            while (numberList.size() < 3) {
                int randomNumber = RandomNumberGenerator.generate();
                if (!numberList.contains(randomNumber)) {
                    numberList.add(randomNumber);
                }
            }
            Pitch pitch = new Pitch(numberList);
            assertThat(computer.countStrike(pitch.getPitches())).isGreaterThanOrEqualTo(0);
            assertThat(computer.countStrike(pitch.getPitches())).isLessThanOrEqualTo(3);
            assertThat(computer.countBall(pitch.getPitches())).isGreaterThanOrEqualTo(0);
            assertThat(computer.countBall(pitch.getPitches())).isLessThanOrEqualTo(3);

        }
    }

    @Test
    @Order(2)
    @DisplayName("Judgement 반환값 정확도 여부")
    public void Case_3_Judgement_Result_Covert() {
        // when
        Computer computer = new Computer();

        // given & then
        for (int i = 0; i < 100; i++) {
            List<Integer> numberList = new ArrayList<>();
            while (numberList.size() < 3) {
                int randomNumber = RandomNumberGenerator.generate();
                if (!numberList.contains(randomNumber)) {
                    numberList.add(randomNumber);
                }
            }
            Pitch pitch = new Pitch(numberList);
            Judgement judgement = new Judgement(
                    computer.countStrike(pitch.getPitches()),
                    computer.countBall(pitch.getPitches())
            );
            assertThat(JudgementConverter.of(judgement)).isNotIn("4볼", "-1볼", "0볼 0스트라이크", "0볼", "0스트라이크", "4스트라이크", "1볼 2스트라이크", "2볼 2스트라이크");
        }
    }

}
