package baseball.unit.service.output;

import baseball.dto.Result;
import baseball.service.output.Output;
import baseball.service.output.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewUnitTest {
    private Output outPutView;

    @BeforeEach
    void init() {
        outPutView = new OutputView();
    }

    @Test
    void oneBallCase() {
        //given
        Result result = new Result(1, 0);
        //when
        outPutView.execute(result);
        //then
        /*
         * 결과는 콘솔로 확인
         * */
    }

    @Test
    void twoBallCase() {
        //given
        Result result = new Result(2, 0);
        //when
        outPutView.execute(result);
        //then
        /*
         * 결과는 콘솔로 확인
         * */
    }

    @Test
    void oneBallOneStrikeCase() {
        //given
        Result result = new Result(1, 1);
        //when
        outPutView.execute(result);
        //then
        /*
         * 결과는 콘솔로 확인
         * */
    }

    @Test
    void oneBallTwoStrikeCase() {
        //given
        Result result = new Result(1, 2);
        //when
        outPutView.execute(result);
        //then
        /*
         * 결과는 콘솔로 확인
         * */
    }

    @Test
    void TwoStrikeCase() {
        //given
        Result result = new Result(0, 2);
        //when
        outPutView.execute(result);
        //then
        /*
         * 결과는 콘솔로 확인
         * */
    }

    @Test
    void ThreeStrikeCase() {
        //given
        Result result = new Result(0, 3);
        //when
        outPutView.execute(result);
        //then
        /*
         * 결과는 콘솔로 확인
         * */
    }

    @Test
    void nothingCase() {
        //given
        Result result = new Result(0, 0);
        //when
        outPutView.execute(result);
        //then
        /*
         * 결과는 콘솔로 확인
         * */
    }

}
