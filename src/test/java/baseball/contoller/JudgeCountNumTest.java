package baseball.contoller;

import baseball.controller.JudgeCountNum;
import baseball.model.TargetNum;
import baseball.model.UserNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JudgeCountNumTest {

    @Test
    void 카운트넘_판단_잘하는지(){

        // 123 123
        List<Integer> t=new ArrayList<>(List.of(1, 2, 3));
        TargetNum targetNum = new TargetNum(t);

        List<Integer> u1=new ArrayList<>(List.of(1, 2, 3));
        UserNum userNum = new UserNum(u1);

        JudgeCountNum judgeCountNum = new JudgeCountNum(userNum,targetNum);
        int strikeNum = judgeCountNum.getCountNum().getStrikeNum();
        int ballNum = judgeCountNum.getCountNum().getBallNum();

        Assertions.assertThat(strikeNum).isEqualTo(3);
        Assertions.assertThat(ballNum).isEqualTo(0);

        //123 245
        List<Integer> u2=new ArrayList<>(List.of(2, 4, 5));
        userNum = new UserNum(u2);

        judgeCountNum = new JudgeCountNum(userNum,targetNum);
        strikeNum = judgeCountNum.getCountNum().getStrikeNum();
        ballNum = judgeCountNum.getCountNum().getBallNum();

        Assertions.assertThat(strikeNum).isEqualTo(0);
        Assertions.assertThat(ballNum).isEqualTo(1);

        //123 456
        List<Integer> u3=new ArrayList<>(List.of(4, 5, 6));
        userNum = new UserNum(u3);

        judgeCountNum = new JudgeCountNum(userNum,targetNum);
        strikeNum = judgeCountNum.getCountNum().getStrikeNum();
        ballNum = judgeCountNum.getCountNum().getBallNum();

        Assertions.assertThat(strikeNum).isEqualTo(0);
        Assertions.assertThat(ballNum).isEqualTo(0);


    }

}
