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
        computer.computerNumbers = new int[] {1, 2, 3};
        int[] result1 = computer.getJudgeResult(new int[] {1, 2, 3});
        int[] result2 = computer.getJudgeResult(new int[] {2, 3, 1});
        int[] result3 = computer.getJudgeResult(new int[] {4, 1, 9});
        int[] result4 = computer.getJudgeResult(new int[] {1, 9, 2});
        int[] result5 = computer.getJudgeResult(new int[] {1, 3, 2});

        Assertions.assertThat(result1[1]).isEqualTo(3);
        Assertions.assertThat(result2[0]).isEqualTo(3);
        Assertions.assertThat(result3[0]).isEqualTo(1);
        Assertions.assertThat(result4[0] == 1 && result4[1] == 1).isTrue();
        Assertions.assertThat(result5[0] == 2 && result5[1] == 1).isTrue();
    }
}
