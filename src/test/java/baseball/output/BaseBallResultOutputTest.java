package baseball.output;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.PrintOutputTest;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseBallResultOutputTest extends PrintOutputTest {
    @Test
    void 모든_BaseBallResultOutputRule_출력() {
        final BaseBallResultOutput baseBallResultOutput = new BaseBallResultOutput(List.of(
                () -> System.out.println("첫번째 출력"),
                () -> System.out.println("두번째 출력")
        ));

        baseBallResultOutput.printAllRules();

        assertThat(output())
                .contains("첫번째 출력")
                .contains("두번째 출력");
    }
}
