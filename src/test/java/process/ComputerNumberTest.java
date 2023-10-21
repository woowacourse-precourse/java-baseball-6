package process;

import domain.ComputerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberTest {

    final List<Integer> computer = new ArrayList<>();
    final ComputerNumber computerNumber = ComputerNumber.getInstance(computer);
    @Test
    @DisplayName("세자리 랜덤 수 생성 확인")
    public void makeRandomNumbers() throws Exception {
        // when
        List<Integer> randomNumber = computerNumber.getRandomNumber();

        // then
        for (int num : randomNumber
        ) {
            System.out.print(num);
        }
    }
}
