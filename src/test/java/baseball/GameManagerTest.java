package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("GameManager 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameManagerTest {

    @Test
    void 사용자의_올바른_입력을_받는다() {
        GameManager gameManager = new GameManager();

        String input1 = "123";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);

        List<Integer> userInputList1 = gameManager.getUserTrialInput();
        camp.nextstep.edu.missionutils.Console.close();

        assertEquals(List.of(1, 2, 3), userInputList1);

        String input2 = "618";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        List<Integer> userInputList2 = gameManager.getUserTrialInput();
        camp.nextstep.edu.missionutils.Console.close();

        assertEquals(List.of(6, 1, 8), userInputList2);
    }

    @Test
    void 사용자의_올바른_재시작_입력을_받는다() {
        GameManager gameManager = new GameManager();

        String input1 = "1";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);

        int userInputNumber1 = gameManager.getUserRestartInput();
        camp.nextstep.edu.missionutils.Console.close();

        assertEquals(1, userInputNumber1);

        String input2 = "2";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        int userInputNumber2 = gameManager.getUserRestartInput();
        camp.nextstep.edu.missionutils.Console.close();

        assertEquals(2, userInputNumber2);
    }
}
