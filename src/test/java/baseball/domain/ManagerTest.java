package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagerTest {

    @Test
    void getResultTest () throws Exception {
        //given
        String input = "1";

        //when
        Manager manager = new Manager(input);

        //then
        assertThat(manager.getResult()).isEqualTo("재시작");
    }
}
