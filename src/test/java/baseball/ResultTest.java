package baseball;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ResultTest extends NsTest {

    @Test
    void 사용자와_컴퓨터_리스트_비교_3스트라이크(){

        Computer computer = new Computer();
        computer.generateComputerNumber();
        Result result = new Result(computer,new User(computer.getComputerList()));
        assert (result.resultToString().equals("3스트라이크"));
    }




    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
