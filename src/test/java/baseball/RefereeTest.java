package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {
    final Referee referee = new Referee();
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 같은_수가_다른_자리에_있으면_볼이다() {
        referee.judge(List.of(1, 2, 3), List.of(2, 4, 5));
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("1볼");
    }

    @Test
    void 같은_수가_같은_자리에_있으면_스트라이크이다() {
        referee.judge(List.of(1, 2, 3), List.of(1, 4, 3));
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("2스트라이크");
    }

    @Test
    void 스트라이크와_볼이_함께_나올_수_있다() {
        referee.judge(List.of(1, 2, 3), List.of(1, 4, 2));
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 같은_수가_전혀_없으면_낫싱이다() {
        referee.judge(List.of(1, 2, 3), List.of(7, 8, 9));
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("낫싱");
    }

    @Test
    void 스트라이크가_3개일_경우_정답이다() {
        referee.judge(List.of(1, 2, 3), List.of(1, 2, 3));
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}