package baseball.model;


import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultTest {
    @DisplayName("두 숫자를 비교하여 결과를 출력한다 - 낫싱")
    @Test
    void create() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(4, 5, 6));
            RoundResult roundResult = RoundResult.create(computerNumber, userNumber);
            assertThat(roundResult.isNothing()).isTrue();
            assertThat(roundResult.provideBallCount()).isEqualTo(0);
            assertThat(roundResult.provideStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 숫자 1개가 같고 다른 자리에 있으면 - 1볼")
    @Test
    void generateResult2() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(4, 5, 1));
            RoundResult roundResult = RoundResult.create(computerNumber, userNumber);
            assertThat(roundResult.isNothing()).isFalse();
            assertThat(roundResult.provideBallCount()).isEqualTo(1);
            assertThat(roundResult.provideStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 2볼")
    @Test
    void generateResult3() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(3, 5, 1));
            RoundResult roundResult = RoundResult.create(computerNumber, userNumber);
            assertThat(roundResult.isNothing()).isFalse();
            assertThat(roundResult.provideBallCount()).isEqualTo(2);
            assertThat(roundResult.provideStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 3볼")
    @Test
    void generateResult4() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(2, 3, 1));
            RoundResult roundResult = RoundResult.create(computerNumber, userNumber);
            assertThat(roundResult.isNothing()).isFalse();
            assertThat(roundResult.provideBallCount()).isEqualTo(3);
            assertThat(roundResult.provideStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 1스트라이크")
    @Test
    void generateResult5() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 4, 5));
            RoundResult roundResult = RoundResult.create(computerNumber, userNumber);
            assertThat(roundResult.isNothing()).isFalse();
            assertThat(roundResult.provideBallCount()).isEqualTo(0);
            assertThat(roundResult.provideStrikeCount()).isEqualTo(1);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 2스트라이크")
    @Test
    void generateResult6() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 2, 5));
            RoundResult roundResult = RoundResult.create(computerNumber, userNumber);
            assertThat(roundResult.isNothing()).isFalse();
            assertThat(roundResult.provideBallCount()).isEqualTo(0);
            assertThat(roundResult.provideStrikeCount()).isEqualTo(2);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 3스트라이크")
    @Test
    void generateResult7() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 4, 5));
            RoundResult roundResult = RoundResult.create(computerNumber, userNumber);
            assertThat(roundResult.isNothing()).isFalse();
            assertThat(roundResult.provideBallCount()).isEqualTo(0);
            assertThat(roundResult.provideStrikeCount()).isEqualTo(1);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 1볼 1스트라이크")
    @Test
    void generateResult8() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 4, 2));
            RoundResult roundResult = RoundResult.create(computerNumber, userNumber);
            assertThat(roundResult.isNothing()).isFalse();
            assertThat(roundResult.provideBallCount()).isEqualTo(1);
            assertThat(roundResult.provideStrikeCount()).isEqualTo(1);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 2볼 1스트라이크")
    @Test
    void generateResult9() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1).thenReturn(2).thenReturn(3);

            ComputerNumber computerNumber = ComputerNumber.create();
            UserNumber userNumber = UserNumber.from(List.of(1, 3, 2));
            RoundResult roundResult = RoundResult.create(computerNumber, userNumber);
            assertThat(roundResult.isNothing()).isFalse();
            assertThat(roundResult.provideBallCount()).isEqualTo(2);
            assertThat(roundResult.provideStrikeCount()).isEqualTo(1);
        }
    }
}