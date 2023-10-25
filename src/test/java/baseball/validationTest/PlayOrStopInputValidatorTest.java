package baseball.validationTest;

import baseball.validation.PlayOrStopInputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayOrStopInputValidatorTest {

   /* @Test
    public void lengthTest(){
        PlayOrStopInputValidator playOrStopInputValidator = new PlayOrStopInputValidator();
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->{
            playOrStopInputValidator.checkInputLengthValidity("12");
        });

    }

    @Test
    public void oneOrTwoTest(){
        PlayOrStopInputValidator playOrStopInputValidator = new PlayOrStopInputValidator();
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->{
            playOrStopInputValidator.checkInputOneOrTwo("3");
        });
    }

    @Test
    public void numericTest(){
        PlayOrStopInputValidator playOrStopInputValidator = new PlayOrStopInputValidator();
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->{
            playOrStopInputValidator.checkInputIsNumeric("a");
        });
    }*/
}
