package baseball;

import baseball.model.ComputerNumber;
import baseball.model.PlayAgainDecision;
import baseball.model.UserNumber;
import baseball.service.GameManager;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest {

    @DisplayName("1~9의 서로 다른 숫자 3개를 생성한다.")
    @Test
    void generateComputerNumber() {
        ComputerNumber computerNumber = ComputerNumber.create();
        assertThat(computerNumber.getNumbers().size()).isEqualTo(3);
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 낫싱")
    @Test
    void generateResult1() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(4, 5, 6));
            GameManager gameManager = GameManager.of(computerNumber, userNumber);
            assertThat(gameManager.isNothing()).isTrue();
            assertThat(gameManager.getBallCount()).isEqualTo(0);
            assertThat(gameManager.getStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 숫자 1개가 같고 다른 자리에 있으면 - 1볼")
    @Test
    void generateResult2() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(4, 5, 1));
            GameManager gameManager = GameManager.of(computerNumber, userNumber);
            assertThat(gameManager.isNothing()).isFalse();
            assertThat(gameManager.getBallCount()).isEqualTo(1);
            assertThat(gameManager.getStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 2볼")
    @Test
    void generateResult3() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(3, 5, 1));
            GameManager gameManager = GameManager.of(computerNumber, userNumber);
            assertThat(gameManager.isNothing()).isFalse();
            assertThat(gameManager.getBallCount()).isEqualTo(2);
            assertThat(gameManager.getStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 3볼")
    @Test
    void generateResult4() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(2, 3, 1));
            GameManager gameManager = GameManager.of(computerNumber, userNumber);
            assertThat(gameManager.isNothing()).isFalse();
            assertThat(gameManager.getBallCount()).isEqualTo(3);
            assertThat(gameManager.getStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 1스트라이크")
    @Test
    void generateResult5() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 4, 5));
            GameManager gameManager = GameManager.of(computerNumber, userNumber);
            assertThat(gameManager.isNothing()).isFalse();
            assertThat(gameManager.getBallCount()).isEqualTo(0);
            assertThat(gameManager.getStrikeCount()).isEqualTo(1);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 2스트라이크")
    @Test
    void generateResult6() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 2, 5));
            GameManager gameManager = GameManager.of(computerNumber, userNumber);
            assertThat(gameManager.isNothing()).isFalse();
            assertThat(gameManager.getBallCount()).isEqualTo(0);
            assertThat(gameManager.getStrikeCount()).isEqualTo(2);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 3스트라이크")
    @Test
    void generateResult7() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 4, 5));
            GameManager gameManager = GameManager.of(computerNumber, userNumber);
            assertThat(gameManager.isNothing()).isFalse();
            assertThat(gameManager.getBallCount()).isEqualTo(0);
            assertThat(gameManager.getStrikeCount()).isEqualTo(3);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 1볼 1스트라이크")
    @Test
    void generateResult8() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 4, 2));
            GameManager gameManager = GameManager.of(computerNumber, userNumber);
            assertThat(gameManager.isNothing()).isFalse();
            assertThat(gameManager.getBallCount()).isEqualTo(1);
            assertThat(gameManager.getStrikeCount()).isEqualTo(1);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 2볼 1스트라이크")
    @Test
    void generateResult9() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 3, 2));
            GameManager gameManager = GameManager.of(computerNumber, userNumber);
            assertThat(gameManager.isNothing()).isFalse();
            assertThat(gameManager.getBallCount()).isEqualTo(2);
            assertThat(gameManager.getStrikeCount()).isEqualTo(1);
        }
    }

    @ParameterizedTest(name = "[{index}] {0} 을 넣으면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 3, 5, 100})
    void validateInput_ex(int element) {
        assertThatThrownBy(() -> PlayAgainDecision.of(element))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
