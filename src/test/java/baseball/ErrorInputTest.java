package baseball;

import baseball.service.InputErrorCheckService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class ErrorInputTest extends NsTest {

    private InputErrorCheckService inputErrorCheckService
            = new InputErrorCheckService();


    @Test
    void 같은_숫자_입력_테스트(){
        assertThat(inputErrorCheckService.sameNumCheck("122")).isEqualTo(false);
    }

    @Test
    void 숫자만_입력_테스트(){
        assertThat(inputErrorCheckService.IntegerCheck("31둘")).isEqualTo(false);
    }




    @Test
    void 게임_재시작_입력_에러(){
        assertThat(inputErrorCheckService.restartInputErrCheck("3")).isEqualTo(false);
    }

    @Test
    void 게임_재시작_입력_정상(){
        assertThat(inputErrorCheckService.restartInputErrCheck("1")).isEqualTo(true);
    }

    @Test
    void 인풋_길이_테스트_1(){
        assertThat(inputErrorCheckService.inputNumLengthCheck("123")).isEqualTo(true);
    }

    @Test
    void 인풋_길이_테스트_2(){
        assertThat(inputErrorCheckService.inputNumLengthCheck("1234")).isEqualTo(false);
    }

    @Test
    void 인풋_길이_테스트_3(){
        assertThat(inputErrorCheckService.inputNumLengthCheck("12")).isEqualTo(false);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
