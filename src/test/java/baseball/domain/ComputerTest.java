package baseball.domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Computer 도메인 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComputerTest {

    @Test
    @Order(0)
    @DisplayName("랜덤 숫자 생성기 정상 작동 여부")
    public void Case_1_No_Duplicate_Random_Number() {
        // when
        List<Computer> targetComputers = new ArrayList<>();

        // given
        for (int i = 0; i < 100; i++) {
            targetComputers.add(new Computer());
        }

        // then
        for (Computer computer : targetComputers) {
            assertTrue(() -> {
                long uniqueCount = computer.numberList.stream()
                        .distinct()
                        .count();
                return uniqueCount == 3;
            });
        }
    }

}
