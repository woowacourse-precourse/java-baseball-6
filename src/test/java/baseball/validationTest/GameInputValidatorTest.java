package baseball.validationTest;

import baseball.validation.GameInputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameInputValidatorTest {
    @Test
    public void lengthTest(){
        GameInputValidator gameInputValidator = new GameInputValidator();
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->{
            gameInputValidator.checkInputLengthValidity("1234");
        });
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->{
            gameInputValidator.checkInputLengthValidity("13");
        });
    }

    @Test
    public void RangeTest(){
        GameInputValidator gameInputValidator = new GameInputValidator();
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->{
            gameInputValidator.checkInputRangeValidity("0123");
        });
    }

    @Test
    public void uniquenessTest(){
        GameInputValidator gameInputValidator = new GameInputValidator();
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->{
            gameInputValidator.checkInputUniquenessValidity("333");
        });
    }

    @Test
    public void numericTest(){
        GameInputValidator gameInputValidator = new GameInputValidator();
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->{
            gameInputValidator.checkInputIsNumeric("rdf");
        });
    }
}
