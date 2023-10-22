package baseball.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectUtilTest {

    @Test
    void isSame_sameObject() {
        // 두 개의 같은 객체를 생성
        Object object1 = new Object();
        Object object2 = object1;

        // isSame 메소드가 true를 반환해야 함
        assertTrue(ObjectUtil.isSame(object1, object2));
    }

    @Test
    void isSame_differentObject() {
        // 두 개의 다른 객체를 생성
        Object object1 = new Object();
        Object object2 = new Object();

        // isSame 메소드가 false를 반환해야 함
        assertFalse(ObjectUtil.isSame(object1, object2));
    }

    @Test
    void isSame_differentInteger_sameValue() {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);

        assertTrue(ObjectUtil.isSame(integer1, integer2));
    }

    @Test
    void isSame_differentInteger_differentValue() {
        Integer integer1 = 1;
        Integer integer2 = 2;

        assertFalse(ObjectUtil.isSame(integer1, integer2));
    }

    @Test
    void isSame_differentInt_differentValue() {
        int int1 = 1;
        int int2 = 2;

        assertFalse(ObjectUtil.isSame(int1, int2));
    }

    @Test
    void isSame_differentInt_sameValue() {
        int int1 = 1;
        int int2 = 1;

        assertTrue(ObjectUtil.isSame(int1, int2));
    }

}
