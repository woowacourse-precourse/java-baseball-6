package baseball.global;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerSingletonTest {

    @Test
    @DisplayName("같은 객체를 반환하는지 체크")
    void testSameInstanceReturned() {
        ComputerSingleton computerSingleton = ComputerSingleton.getInstance();
        ComputerSingleton computerSingleton2 = ComputerSingleton.getInstance();
        assertEquals(computerSingleton, computerSingleton2);
    }

    @Test
    @DisplayName("중복된 숫자를 생성하지 않는지 체크")
    void testNoDuplicatesGenerated() {
        ComputerSingleton computerSingleton = ComputerSingleton.getInstance();
        List<Integer> computerNumbers = computerSingleton.getComputerNumbers();

        boolean hasDuplicates = computerNumbers.stream()
            .distinct()
            .count() != computerNumbers.size();

        assertTrue(!hasDuplicates);
    }
}