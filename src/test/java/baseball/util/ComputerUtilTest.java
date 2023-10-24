package baseball.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerUtilTest {

    @Test
    void 컴퓨터가_생성한_자료구조가_List일경우_참() {
        assertTrue(ComputerUtil.generateComputerNumber() instanceof List<Integer>);
    }
}