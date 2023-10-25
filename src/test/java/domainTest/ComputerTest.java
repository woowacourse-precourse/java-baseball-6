package domainTest;

import baseball.domain.Computer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class ComputerTest {
    @DisplayName("컴퓨터가 생성되었을 때 3자리의 숫자가 제대로 랜덤으로 저장되는지 확인한다.")
    @RepeatedTest(10)
    void makeRandomNumberTest(){
        //given
        Computer computer = new Computer();

        //then
        Assertions.assertEquals(3,computer.getNumber().size());
        Assertions.assertTrue(computer.getNumber().stream().allMatch(num -> num>=1 && num<=9));
    }
}
