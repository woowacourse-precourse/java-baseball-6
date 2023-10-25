package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}