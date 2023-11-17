package baseball;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.service.GameResultService;
import baseball.model.PlayerChoice;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {

    @DisplayName("1~9의 서로 다른 숫자 3개를 생성한다.")
    @Test
    void generateComputerNumber(){
        ComputerNumber computerNumber = ComputerNumber.create();
        assertThat(computerNumber.getNumbers().size()).isEqualTo(3);
    }


    @DisplayName("입력 받은 숫자가 1~9의 서로 다른 숫자 3개인 경우 정상 처리 된다.")
    @Test
    void validatePlayerNumber_o(){
        UserNumber userNumber = UserNumber.create("123");
        assertThat(userNumber.getNumbers().size()).isEqualTo(3);
    }

    @DisplayName("입력 받은 값에 0이 포함된 경우 예외가 발생한다.")
    @Test
    void validatePlayerNumber_ex1(){
        assertThatThrownBy(() -> UserNumber.create("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 1~9의 서로 다른 숫자 3개가 아니면 예외가 발생한다.")
    @Test
    void validatePlayerNumber_ex2(){
        assertThatThrownBy(() -> UserNumber.create("144"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //입력 받은 숫자와 컴퓨터 숫자 비교
    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 낫싱")
    @Test
    void generateResult1() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1,9)).thenReturn(1).thenReturn(2).thenReturn(3);
            //computerNumber 가 1,2,3이 되도록 mocking

            ComputerNumber computerNumber = ComputerNumber.create();  //1,2,3
            UserNumber userNumber = UserNumber.create("456");
            GameResultService gameResultService = new GameResultService(computerNumber, userNumber);
            assertThat(gameResultService.isNothing()).isTrue();
            assertThat(gameResultService.getBallCount()).isEqualTo(0);
            assertThat(gameResultService.getStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 숫자 1개가 같고 다른 자리에 있으면 - 1볼")
    @Test
    void generateResult2() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1,9)).thenReturn(1).thenReturn(2).thenReturn(3);
            //computerNumber 가 1,2,3이 되도록 mocking

            ComputerNumber computerNumber = ComputerNumber.create();  //1,2,3
            UserNumber userNumber = UserNumber.create("451");  //4,5,1
            GameResultService gameResultService = new GameResultService(computerNumber, userNumber);
            assertThat(gameResultService.isNothing()).isFalse();
            assertThat(gameResultService.getBallCount()).isEqualTo(1);
            assertThat(gameResultService.getStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 2볼")
    @Test
    void generateResult3() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1,9)).thenReturn(1).thenReturn(2).thenReturn(3);
            //computerNumber 가 1,2,3이 되도록 mocking

            ComputerNumber computerNumber = ComputerNumber.create();  //1,2,3
            UserNumber userNumber = UserNumber.create("351");  //3,5,1
            GameResultService gameResultService = new GameResultService(computerNumber, userNumber);
            assertThat(gameResultService.isNothing()).isFalse();
            assertThat(gameResultService.getBallCount()).isEqualTo(2);
            assertThat(gameResultService.getStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 3볼")
    @Test
    void generateResult4() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1,9)).thenReturn(1).thenReturn(2).thenReturn(3);
            //computerNumber 가 1,2,3이 되도록 mocking

            ComputerNumber computerNumber = ComputerNumber.create();  //1,2,3
            UserNumber userNumber = UserNumber.create("231");  //2,3,1
            GameResultService gameResultService = new GameResultService(computerNumber, userNumber);
            assertThat(gameResultService.isNothing()).isFalse();
            assertThat(gameResultService.getBallCount()).isEqualTo(3);
            assertThat(gameResultService.getStrikeCount()).isEqualTo(0);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 1스트라이크")
    @Test
    void generateResult5() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1,9)).thenReturn(1).thenReturn(2).thenReturn(3);
            //computerNumber 가 1,2,3이 되도록 mocking

            ComputerNumber computerNumber = ComputerNumber.create();  //1,2,3
            UserNumber userNumber = UserNumber.create("145");  //1,4,5
            GameResultService gameResultService = new GameResultService(computerNumber, userNumber);
            assertThat(gameResultService.isNothing()).isFalse();
            assertThat(gameResultService.getBallCount()).isEqualTo(0);
            assertThat(gameResultService.getStrikeCount()).isEqualTo(1);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 2스트라이크")
    @Test
    void generateResult6() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1,9)).thenReturn(1).thenReturn(2).thenReturn(3);
            //computerNumber 가 1,2,3이 되도록 mocking

            ComputerNumber computerNumber = ComputerNumber.create();  //1,2,3
            UserNumber userNumber = UserNumber.create("125");  //1,2,5
            GameResultService gameResultService = new GameResultService(computerNumber, userNumber);
            assertThat(gameResultService.isNothing()).isFalse();
            assertThat(gameResultService.getBallCount()).isEqualTo(0);
            assertThat(gameResultService.getStrikeCount()).isEqualTo(2);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 3스트라이크")
    @Test
    void generateResult7() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1,9)).thenReturn(1).thenReturn(2).thenReturn(3);
            //computerNumber 가 1,2,3이 되도록 mocking

            ComputerNumber computerNumber = ComputerNumber.create();  //1,2,3
            UserNumber userNumber = UserNumber.create("123");  //1,4,5
            GameResultService gameResultService = new GameResultService(computerNumber, userNumber);
            assertThat(gameResultService.isNothing()).isFalse();
            assertThat(gameResultService.getBallCount()).isEqualTo(0);
            assertThat(gameResultService.getStrikeCount()).isEqualTo(3);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 1볼 1스트라이크")
    @Test
    void generateResult8() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1,9)).thenReturn(1).thenReturn(2).thenReturn(3);
            //computerNumber 가 1,2,3이 되도록 mocking

            ComputerNumber computerNumber = ComputerNumber.create();  //1,2,3
            UserNumber userNumber = UserNumber.create("142");  //1,4,2
            GameResultService gameResultService = new GameResultService(computerNumber, userNumber);
            assertThat(gameResultService.isNothing()).isFalse();
            assertThat(gameResultService.getBallCount()).isEqualTo(1);
            assertThat(gameResultService.getStrikeCount()).isEqualTo(1);
        }
    }

    @DisplayName("입력 받은 숫자와 컴퓨터 숫자 비교 - 2볼 1스트라이크")
    @Test
    void generateResult9() {
        try (MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(1,9)).thenReturn(1).thenReturn(2).thenReturn(3);
            //computerNumber 가 1,2,3이 되도록 mocking

            ComputerNumber computerNumber = ComputerNumber.create();  //1,2,3
            UserNumber userNumber = UserNumber.create("132");  //1,3,2
            GameResultService gameResultService = new GameResultService(computerNumber, userNumber);
            assertThat(gameResultService.isNothing()).isFalse();
            assertThat(gameResultService.getBallCount()).isEqualTo(2);
            assertThat(gameResultService.getStrikeCount()).isEqualTo(1);
        }
    }

    @DisplayName("게임 종료 문구에 대한 입력값 검증 - 1 이나 2 가 아닌 문자를 넣으면 예외가 발생한다.")
    @Test
    void validateInput_ex1() {
        assertThatThrownBy(() -> new PlayerChoice("x"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 종료 문구에 대한 입력값 검증 - 1 이나 2 가 아닌 다른 숫자를 넣으면 예외가 발생한다.")
    @Test
    void validateInput_ex2() {
        assertThatThrownBy(() -> new PlayerChoice("5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
