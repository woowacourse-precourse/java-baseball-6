package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BaseBallGameTest {

    @Test
    void isNotIntegerType(){
        BaseBallGame baseBallGame = new BaseBallGame();
        boolean isNotInteger = false;

        assertThat(baseBallGame.isNotIntegerType("123"))
                .isEqualTo(isNotInteger);
    }

    @Test
    void splitStringToDigits(){
        BaseBallGame baseBallGame = new BaseBallGame();
        List<Integer> integerList = baseBallGame.splitStringToDigits("123");

        ArrayList<Integer> digitList = new ArrayList<>(Arrays.asList(1,2,3));
        assertThat(digitList).isEqualTo(integerList);
    }

    @Test
    void isDuplicateNumber(){
        BaseBallGame baseBallGame = new BaseBallGame();
        boolean duplicateFlag = true;

        assertThat(baseBallGame.isDuplicateNumber("122"))
                .isEqualTo(duplicateFlag);
    }

    @Test
    void isNotCorrectButton(){
        BaseBallGame baseBallGame = new BaseBallGame();
        boolean buttonCheck = true;

        assertThat(baseBallGame.isNotCorrectButton("3"))
                .isEqualTo(buttonCheck);
    }
}