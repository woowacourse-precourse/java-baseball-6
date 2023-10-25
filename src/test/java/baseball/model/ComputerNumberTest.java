package baseball.model;

import baseball.ComputerNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumberTest {
    @Test
    void 컴퓨터_유저_비교(){
        ComputerNumber computerNumber = new ComputerNumber(new simple());

        List<Integer> user = Arrays.asList(1,2,3);

        assertThat(computerNumber.getComputerNumber()).isEqualTo(user);
    }


    private static class simple implements ComputerNumberGenerator {
        @Override
        public List<Integer> generateComputerNumber() {
            return Arrays.asList(1,2,3);
        }
    }
}
