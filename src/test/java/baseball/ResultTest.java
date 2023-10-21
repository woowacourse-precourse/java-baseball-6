package baseball;

import baseball.model.Result;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest extends NsTest {

    @Test
    void 사용자와_컴퓨터_리스트_비교_3스트라이크(){
        List<Integer> inputList = List.of(1,2,3);
        List<Integer> computer = List.of(1,2,3);
        Result result = new Result(computer,inputList);

        assert (result.resultToString().equals("3스트라이크"));
    }

    @Test
    void 사용자와_컴퓨터_리스트_비교_3볼(){
        List<Integer> inputList = List.of(1,2,3);
        List<Integer> computer = List.of(3,1,2);
        Result result = new Result(computer,inputList);

        assert (result.resultToString().equals("3볼"));
    }

    @Test
    void 사용자와_컴퓨터_리스트_비교_낫싱(){
        List<Integer> inputList = List.of(1,2,3);
        List<Integer> computer = List.of(4,5,6);
        Result result = new Result(computer,inputList);

        assert (result.resultToString().equals("낫싱"));
    }

    @Test
    void 사용자와_컴퓨터_리스트_비교_2볼_1스트라이크(){
        List<Integer> inputList = List.of(1,2,3);
        List<Integer> computer = List.of(1,3,2);
        Result result = new Result(computer,inputList);

        assert (result.resultToString().equals("2볼 1스트라이크"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
