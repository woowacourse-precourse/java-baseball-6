package baseball.contoller;

import baseball.controller.JudgeCountNum;
import baseball.controller.JudgeCountNumImpl;
import baseball.model.CountNum;
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

        JudgeCountNum judgeCountNumImpl = new JudgeCountNumImpl();
        CountNum countNum = judgeCountNumImpl.getJudgeCountNum(userNum,targetNum);
        int strikeNum = countNum.getStrikeNum();
        int ballNum = countNum.getBallNum();

        Assertions.assertThat(strikeNum).isEqualTo(3);
        Assertions.assertThat(ballNum).isEqualTo(0);

        //123 245
        List<Integer> u2=new ArrayList<>(List.of(2, 4, 5));
        userNum = new UserNum(u2);

        countNum = judgeCountNumImpl.getJudgeCountNum(userNum,targetNum);
        strikeNum = countNum.getStrikeNum();
        ballNum = countNum.getBallNum();

        Assertions.assertThat(strikeNum).isEqualTo(0);
        Assertions.assertThat(ballNum).isEqualTo(1);

        //123 456
        List<Integer> u3=new ArrayList<>(List.of(4, 5, 6));
        userNum = new UserNum(u3);

        countNum = judgeCountNumImpl.getJudgeCountNum(userNum,targetNum);
        strikeNum = countNum.getStrikeNum();
        ballNum = countNum.getBallNum();

        Assertions.assertThat(strikeNum).isEqualTo(0);
        Assertions.assertThat(ballNum).isEqualTo(0);

        // 123 453
        List<Integer> u4=new ArrayList<>(List.of(4, 5, 3));
        userNum = new UserNum(u4);

        countNum = judgeCountNumImpl.getJudgeCountNum(userNum,targetNum);
        strikeNum = countNum.getStrikeNum();
        ballNum = countNum.getBallNum();

        Assertions.assertThat(strikeNum).isEqualTo(1);
        Assertions.assertThat(ballNum).isEqualTo(0);

        // 123 312
        List<Integer> u5=new ArrayList<>(List.of(3, 1, 2));
        userNum = new UserNum(u5);

        countNum = judgeCountNumImpl.getJudgeCountNum(userNum,targetNum);
        strikeNum = countNum.getStrikeNum();
        ballNum = countNum.getBallNum();

        Assertions.assertThat(strikeNum).isEqualTo(0);
        Assertions.assertThat(ballNum).isEqualTo(3);
    }

}
