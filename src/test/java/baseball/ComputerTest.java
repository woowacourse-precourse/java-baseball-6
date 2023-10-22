package baseball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    void 난수생성중복검사(){
        Computer computer = new Computer();
        for(int i = 0; i < 100; i++) {
            int[] numbers = computer.initComputerNumbers();
            boolean[] duplicateCheck = new boolean[10];
            for(int j = 0; j < 3; j++){
                Assertions.assertThat(duplicateCheck[numbers[j]]).isEqualTo(false);
                duplicateCheck[numbers[j]] = true;
            }
        }
    }

    @Test
    void 판정테스트(){
        Computer computer = new Computer();
        int[] computerNumbers = computer.initComputerNumbers();
        Judgement result1 = computer.getJudgeResult(computerNumbers);
        Judgement result2 = computer.getJudgeResult(new int[] {computerNumbers[1], computerNumbers[2], computerNumbers[0]});
        Judgement result3 = computer.getJudgeResult(new int[] {0, computerNumbers[0], 0});
        Judgement result4 = computer.getJudgeResult(new int[] {computerNumbers[0], computerNumbers[2], 0});
        Judgement result5 = computer.getJudgeResult(new int[] {computerNumbers[0], computerNumbers[2], computerNumbers[1]});

        Assertions.assertThat(result1.strikeCount).isEqualTo(3);
        Assertions.assertThat(result2.ballCount).isEqualTo(3);
        Assertions.assertThat(result3.ballCount).isEqualTo(1);
        Assertions.assertThat(result4.strikeCount == 1 && result4.ballCount == 1).isTrue();
        Assertions.assertThat(result5.ballCount == 2 && result5.strikeCount == 1).isTrue();
    }

}
