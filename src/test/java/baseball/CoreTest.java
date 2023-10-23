package baseball;

import baseball.core.GenerateNumberList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CoreTest {

    @Test
    void 컴퓨터_랜덤_숫자_생성_옳바른_개수만큼_생성하는지_테스트(){
        //given
        int generate_cnt = 3;
        //when
        List<Integer> computer = generateNumberListMethodCall(generate_cnt);

        //then
        assertThat(computer.size()).isEqualTo(3);
    }

    private List<Integer> generateNumberListMethodCall(int generate_cnt){
        return GenerateNumberList.generateRandomNumberToComputer(generate_cnt);
    }
    @Test
    void test(){
    }
}
