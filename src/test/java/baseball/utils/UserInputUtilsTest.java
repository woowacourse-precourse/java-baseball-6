package baseball.utils;

import org.junit.jupiter.api.Test;

class UserInputUtilsTest {

    @Test
    void checkDuplication() {
        UserInputUtils.setSize(3);
        String user = "123";
        UserInputUtils.checkDuplication(user);
        System.out.println(user);
    }

    @Test
    void checkSize() {
        UserInputUtils.setSize(3);
        String user = "123";
        UserInputUtils.checkSize(user);
        System.out.println(user);
    }
}