package baseball;

import baseball.controller.ComputerController;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerControllerTest extends NsTest {
    ComputerController computerController = new ComputerController();

    @Test
    void 컴퓨터_입력_숫자_비교_올스트라이크(){
        List<Integer> baseball = Arrays.asList(3,4,5);
        List<Integer> computerInput = Arrays.asList(3,4,5);
        String hintMessage = "3스트라이크";

        computerController.compareNumbers(baseball,computerInput);
        assertThat(output()).isEqualTo(hintMessage);
    }

    @Test
    void 컴퓨터_입력_숫자_비교_올볼(){
        List<Integer> baseball = Arrays.asList(3,4,5);
        List<Integer> computerInput = Arrays.asList(4,5,3);
        String hintMessage = "3볼";

        computerController.compareNumbers(baseball,computerInput);
        assertThat(output()).isEqualTo(hintMessage);
    }

    @Test
    void 컴퓨터_입력_숫자_비교_1볼_1스트라이크(){
        List<Integer> baseball = Arrays.asList(3,4,5);
        List<Integer> computerInput = Arrays.asList(9,3,5);
        String hintMessage = "1볼 1스트라이크";

        computerController.compareNumbers(baseball,computerInput);
        assertThat(output()).isEqualTo(hintMessage);
    }

    @Test
    void 낫싱(){
        List<Integer> baseball = Arrays.asList(3,4,5);
        List<Integer> computerInput = Arrays.asList(7,8,9);
        String hintMessage = "낫싱";

        computerController.compareNumbers(baseball,computerInput);
        assertThat(output()).isEqualTo(hintMessage);
    }

    @Test
    void 사용자_입력_스트라이크판단(){
        List<Integer> baseball = Arrays.asList(3,4,5);
        List<Integer> computerInput = Arrays.asList(3,4,5);

        computerController.compareNumbers(baseball,computerInput);
        assertThat(computerController.isThreeStrike()).isTrue();
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
