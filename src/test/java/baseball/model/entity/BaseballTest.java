package baseball.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import baseball.exception.BaseballException.ListSizeException;
import org.junit.jupiter.api.Test;

class BaseballTest {
    @Test
    public void 입력_받은_숫자가_3개_이하인_경우_예외() {
        assertThrows(ListSizeException.class, () -> {
            new Baseball("12");
        });
    }

    @Test
    public void 입력_받은_숫자가_3개_이상인_경우_예외() {
        assertThrows(ListSizeException.class, () -> {
            new Baseball("1234");
        });
    }

    @Test
    public void 입력_받은_숫자에_중복된_숫자가_있을_경우_예외() {
        assertThrows(ListSizeException.class, () -> {
            new Baseball("112");
        });
    }

    @Test
    public void 스트라이크_셋() {
        //given
        Baseball computerNumber = new Baseball("123");

        //when
        String input = "123";
        Baseball inputBaseball = new Baseball(input);

        //then
        assertEquals(3, computerNumber.countStrike(inputBaseball));
        assertEquals(0, computerNumber.countBall(inputBaseball));
    }
    
    @Test
    public void 볼_하나_스트라이크_하나() {
        //given
        Baseball computerNumber = new Baseball("123");

        //when
        String input = "135";
        Baseball inputBaseball = new Baseball(input);

        //then
        assertEquals(1, computerNumber.countStrike(inputBaseball));
        assertEquals(1, computerNumber.countBall(inputBaseball));
    }
    
    @Test
    public void 볼_둘_스트라이크_하나() {
        //given
        Baseball computerNumber = new Baseball("123");

        //when
        String input = "321";
        Baseball inputBaseball = new Baseball(input);

        //then
        assertEquals(1, computerNumber.countStrike(inputBaseball));
        assertEquals(2, computerNumber.countBall(inputBaseball));
    }

    @Test
    public void 낫싱() {
        //given
        Baseball computerNumber = new Baseball("123");

        //when
        String input = "456";
        Baseball inputBaseball = new Baseball(input);

        //then
        assertEquals(0, computerNumber.countStrike(inputBaseball));
        assertEquals(0, computerNumber.countBall(inputBaseball));
    }
}