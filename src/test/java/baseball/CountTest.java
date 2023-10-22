package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountTest {
    Count count = Count.provideCount("123");
    @Test
    void toString_테스트(){
        Assertions.assertEquals("123", count.toString());
    }

    @Test
    void count객체_만들어주는_메서드(){
        Count count2 = Count.provideCount("345");
        Assertions.assertEquals("345", count2.toString());
    }

    @Test
    void String_3자리숫자_확인(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            Count.provideCount("5677");
        });

    }

    @Test
    void String_중복_확인() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            Count.provideCount("111");
        });
    }
}
