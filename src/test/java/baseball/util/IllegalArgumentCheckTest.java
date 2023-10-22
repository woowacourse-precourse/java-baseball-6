package baseball.util;

import baseball.AppConfig;
import baseball.game.util.IllegalArgumentCheck;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IllegalArgumentCheckTest {

    IllegalArgumentCheck illegalArgumentCheck;

    @BeforeEach
    public void BeforeEach(){
        illegalArgumentCheck = new IllegalArgumentCheck();
    }

    @Test
    void wrongLengthCheck(){
        //given
        String inputData = "5674";
        //when
        Assertions.assertThatThrownBy(() -> illegalArgumentCheck.checkArgumentLength(inputData))
                .isInstanceOf(IllegalArgumentException.class);
        //then
        //Exception
    }

    @Test
    void wrongCharCheck(){
        //given
        String inputData = "12t";
        //when
        Assertions.assertThatThrownBy(() -> illegalArgumentCheck.checkArgumentWrongChar(inputData))
                .isInstanceOf(IllegalArgumentException.class);
        //then
        //Exception
    }

    @Test
    void passCheck(){
        //given
        String inputData = "777";
        //when
        illegalArgumentCheck.checkArgument(inputData);
        //then
        //pass
    }
}
