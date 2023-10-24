package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Answer;
import baseball.model.GameScore;
import baseball.util.NumberGenerator;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RandTest {

    @Test
    void 난수_생성_여부_확인() {
        NumberGenerator generator = new NumberGenerator();
        Answer answer = generator.createAnswer();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Integer> mockInput = new ArrayList<>(){{
            add(3);
            add(1);
            add(2);
        }};

        GameScore gameScore = answer.calcScore(mockInput);
        gameScore.printResult();
        assertThat(outputStream.toString()).isNotNull();
    }
}
