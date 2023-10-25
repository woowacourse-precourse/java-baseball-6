package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountTest {
    Note count = Note.writeDown("123");
    @Test
    void toString_테스트(){
        Assertions.assertEquals("123", count.toString());
    }

    @Test
    void count객체_만들어주는_메서드(){
        Note count2 = Note.writeDown("345");
        Assertions.assertEquals("345", count2.toString());
    }

    @Test
    void String_3자리숫자_확인(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            Note.writeDown("5677");
        });

    }

    @Test
    void String_중복_확인() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            Note.writeDown("111");
        });
    }
}
