package baseball.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.util.CalculationResult;
import baseball.util.GameChoiceInputValid;
import baseball.util.GameInputValid;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameModelTest {

    private GameModel gameModel;

    @BeforeEach
    public void setUp() {
        GameInputValid gameInputValid = new GameInputValid();
        GameChoiceInputValid gameChoiceInputValid = new GameChoiceInputValid();
        gameModel = new GameModel(gameInputValid, gameChoiceInputValid);
    }

    @DisplayName("사용자가 숫자를 입력한다.")
    @Test
    public void inputisNumeric() {
        //when
        String input = "123";

        //then
        assertDoesNotThrow(() -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    public void inputisNotNumeric() {
        //when
        String input = "abc";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 3자리 미만의 값을 입력할 경우 예외가 발생한다.")
    @Test
    public void inputLessThanRange() {
        //when
        String input = "12";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 3자리 초과의 값을 입력할 경우 예외가 발생한다.")
    @Test
    public void inputGreaterThanRange() {
        //when
        String input = "1234";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 0의 숫자값을 입력할 경우 예외가 발생한다.")
    @Test
    public void inputZeroValue() {
        //when
        String input = "012";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 Null(띄어쓰기)의 값을 입력할 경우 예외가 발생한다.")
    @Test
    public void inputNullPoint() {
        //when
        String input = "1 3";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("사용자가 중복된 숫자의 값을 입력할 경우 예외가 발생한다.")
    @Test
    public void inputDuplicateNumber() {
        //when
        String input = "112";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.validateUserInput(input);
        });
    }

    @DisplayName("입력값과 랜덤값을 비교하여 3개가 완전히 일치 경우 3스트라이크")
    @Test
    public void checkGameResultThreeStrike() {
        //given
        List<Integer> comNumberList = new ArrayList<>();
        comNumberList.add(1);
        comNumberList.add(2);
        comNumberList.add(3);

        List<Integer> userNumber = new ArrayList<>();
        userNumber.add(1);
        userNumber.add(2);
        userNumber.add(3);

        //when
        CalculationResult result = new CalculationResult();
        result.calStrikeAndBall(comNumberList, userNumber);

        //then
        assertEquals(3, result.getStrikeCnt());
        assertEquals(0, result.getBallCnt());
    }

    @DisplayName("입력값과 랜덤값을 비교하여 1개만 완전히 일치하고 2개는 위치가 틀린 경우 2볼 1스트라이크")
    @Test
    public void checkGameResultOneStrikeTwoBall() {
        //given
        List<Integer> comNumberList = new ArrayList<>();
        comNumberList.add(1);
        comNumberList.add(2);
        comNumberList.add(3);

        List<Integer> userNumber = new ArrayList<>();
        userNumber.add(1);
        userNumber.add(3);
        userNumber.add(2);

        //when
        CalculationResult result = new CalculationResult();
        result.calStrikeAndBall(comNumberList, userNumber);

        //then
        assertEquals(1, result.getStrikeCnt());
        assertEquals(2, result.getBallCnt());
    }

    @DisplayName("입력값과 랜덤값을 비교하여 같은 값이 없을 경우 0볼 0스트라이크")
    @Test
    public void checkGameResultNotting() {
        //given
        List<Integer> comNumberList = new ArrayList<>();
        comNumberList.add(1);
        comNumberList.add(2);
        comNumberList.add(3);

        List<Integer> userNumber = new ArrayList<>();
        userNumber.add(4);
        userNumber.add(5);
        userNumber.add(6);

        //when
        CalculationResult result = new CalculationResult();
        result.calStrikeAndBall(comNumberList, userNumber);

        //then
        assertEquals(0, result.getStrikeCnt());
        assertEquals(0, result.getBallCnt());
    }
}