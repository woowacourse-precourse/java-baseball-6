package baseball;

import baseball.model.ComputerNumber;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import baseball.util.Validator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> //1초 내 코드 실행 여부
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤_생성(){
        ComputerNumber setNumber = new ComputerNumber();
        setNumber.generateNumber();

        assertThat(setNumber.generateNumber().size()).isEqualTo(3);
    }
    @Test
    void 사용자_입력_길이_테스트() {
        Validator inputLengthValidation = new Validator();

        String correctInput = "123";
        String longInput = "1234";
        String shortInput = "12";

        // then 올바르게 작성, 길게 작성, 짧게 작성
        assertThatCode(() ->
                inputLengthValidation.lengthValidation(correctInput))
                .doesNotThrowAnyException();

        assertThatThrownBy(() ->
                inputLengthValidation.lengthValidation(longInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OutputView.MessageConst.ASK_LENGTH_MSG);

        assertThatThrownBy(() ->
                inputLengthValidation.lengthValidation(shortInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OutputView.MessageConst.ASK_LENGTH_MSG);
    }

    @Test
    void 사용자_입력_중복_테스트() {
        // given
        Validator inputSameValidation = new Validator();
        List<Integer> correctInput = new ArrayList<>();
        List<Integer> wrongInput = new ArrayList<>();

        // when
        correctInput.add(1);
        correctInput.add(2);
        correctInput.add(3);

        wrongInput.add(1);
        wrongInput.add(1);
        wrongInput.add(1);

        // then
        assertThatCode(() ->
                inputSameValidation.sameInputValidation(correctInput))
                .doesNotThrowAnyException();

        assertThatThrownBy(() ->
                inputSameValidation.sameInputValidation(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OutputView.MessageConst.ASK_SAME_MSG);
    }
    @Test
    void 사용자_자연수_입력_테스트() {
        // given
        Validator inputNumberValidation = new Validator();
        List<Integer> correctInput = new ArrayList<>();
        List<Integer> wrongInput = new ArrayList<>();

        // when (올바른 작성, 잘못된 작성)
        correctInput.add(1);
        correctInput.add(2);
        correctInput.add(3);

        wrongInput.add(0);
        wrongInput.add(1);
        wrongInput.add(2);

        // then
        assertThatCode(() ->
                inputNumberValidation.numberValidation(correctInput))
                .doesNotThrowAnyException();

        assertThatThrownBy(() ->
                inputNumberValidation.numberValidation(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OutputView.MessageConst.ASK_NATURAL_MSG);
    }

    @Test
    void 종료_여부_입력값_테스트()  {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.restartValidation(3))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
