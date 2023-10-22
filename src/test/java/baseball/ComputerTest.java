package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    void generateRandomNumber_3자리수_조건에_맞는지확인(){

        Assertions.assertDoesNotThrow(()->{
            Computer computer = new Computer();
        });
        Assertions.assertDoesNotThrow(()->{
            Computer computer = new Computer();
        });
        Assertions.assertDoesNotThrow(()->{
            Computer computer = new Computer();
        });
    }
//    @Test
//    void Count가_볼_스트라이크_낫싱_인지확인(){
//        Computer computer = new Computer(Count.provideCount("143"));
//        Count count = Count.provideCount("135");
//        Assertions.assertEquals(Computer.judgeGameResult(count), "1볼 1스트라이크" );
//    }
//    @Test
//    void 볼_확인(){
//        Computer computer = new Computer(Count.provideCount("123"));
//        Count count = Count.provideCount("451");
//        Assertions.assertEquals(Computer.isBall(count), "1볼");
//    }
//
//    @Test
//    void 스트라이크_확인(){
//        Computer computer = new Computer(Count.provideCount("123"));
//        Count count = Count.provideCount("123");
//        Assertions.assertEquals(Computer.isStrike(count), "3스트라이크");
//    }
//
//
//    @Test
//    void 낫싱_확인(){
//        Computer computer = new Computer(Count.provideCount("123"));
//        Count count = Count.provideCount("456");
//        Assertions.assertEquals(Computer.isNothing(count),"낫싱");
//    }
}
