package baseball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    void 난수생성중복검사(){
        Computer computer = new Computer();
        for(int i = 0; i < 100; i++) {
            int[] numbers = computer.initiate();
            boolean[] duplicateCheck = new boolean[10];
            for(int j = 0; j < 3; j++){
                Assertions.assertFalse(duplicateCheck[numbers[j]]);
                duplicateCheck[numbers[j]] = true;
            }
        }
    }

    @Test
    void 판정테스트(){
        Computer computer = new Computer();
        computer.randomNumbers = new int[] {1, 2, 3};
        int[] result1 = computer.judge(new int[] {1, 2, 3});
        int[] result2 = computer.judge(new int[] {2, 3, 1});
        int[] result3 = computer.judge(new int[] {4, 1, 9});
        int[] result4 = computer.judge(new int[] {1, 9, 2});
        int[] result5 = computer.judge(new int[] {1, 3, 2});

        Assertions.assertEquals(result1[1], 3);
        Assertions.assertEquals(result2[0], 3);
        Assertions.assertEquals(result3[0], 1);
        Assertions.assertTrue(result4[0] == 1 && result4[1] == 1);
        Assertions.assertTrue(result5[0] == 2 && result5[1] == 1);
    }
}
