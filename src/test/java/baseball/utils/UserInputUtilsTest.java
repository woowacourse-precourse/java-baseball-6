package baseball.utils;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UserInputUtilsTest {

    @Test
    void checkDuplication() {
        UserInputUtils.setSize(3);
        String user = "123";
        UserInputUtils.checkDuplication(user);
        System.out.println(user);
        user = "111";
        UserInputUtils.checkDuplication(user);
    }

    @Test
    void checkSize() {
        UserInputUtils.setSize(3);
        String user = "123";
        UserInputUtils.checkSize(user);
        System.out.println(user);
        user = "1234";
        UserInputUtils.checkSize(user);
    }
}