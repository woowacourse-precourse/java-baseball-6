package baseball.baseTest;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import repository.InputRepository;
import repository.InputRepositoryImpl;

import java.io.ByteArrayInputStream;

import static constant.BaseConst.*;
import static org.assertj.core.api.Assertions.*;

public class InputRepositoryTest {

    private final InputRepository inputRepository = new InputRepositoryImpl();

    private void inputString(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @AfterEach
    void consoleClose() {
        Console.close();
    }

    @Test
    void getMyNumberTest() {
        inputString("123", "142");
        assertThat(inputRepository.getMyNumber()).isEqualTo("123");
        assertThat(inputRepository.getMyNumber()).isEqualTo("142");
    }

    @Test
    void getMyNumberExceptionTest() {
        inputString("223", "232", "111"); // 숫자 중복 테스트
        assertThatThrownBy(() -> inputRepository.getMyNumber()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getMyNumber()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getMyNumber()).isInstanceOf(IllegalArgumentException.class);
        Console.close();

        inputString("a12", "2345", "   ", null, "", " 123"); // 잘못된 값 테스트
        assertThatThrownBy(() -> inputRepository.getMyNumber()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getMyNumber()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getMyNumber()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getMyNumber()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getMyNumber()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getMyNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getRestartSelectTest() {
        inputString("1", "2");
        assertThat(inputRepository.getRestartSelect()).isEqualTo(RESTART);
        assertThat(inputRepository.getRestartSelect()).isEqualTo(EXIT);
    }

    @Test
    void getRestartSelectExceptionTest() {
        inputString("3", "0", "4"); // 잘못된 숫자
        assertThatThrownBy(() -> inputRepository.getRestartSelect()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getRestartSelect()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getRestartSelect()).isInstanceOf(IllegalArgumentException.class);
        Console.close();

        inputString("aasdf", " ", null, "", "ㄴㅇㄹㄷ", "1 23 4"); // 잘못된 값
        assertThatThrownBy(() -> inputRepository.getRestartSelect()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getRestartSelect()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getRestartSelect()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getRestartSelect()).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputRepository.getRestartSelect()).isInstanceOf(IllegalArgumentException.class);
    }
}
