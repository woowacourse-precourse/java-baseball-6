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
}
