package validation;

import Validation.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class validationTest {
    Validation validation= new Validation();
    @Test
    public void 사용자입력이_공백인_경우() {
        String input = "";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                validation.inputLengthIsZero(input));
    }
    @Test
    public void 사용자입력이_3보다_작은경우(){
        String input="12";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                validation.inputLengthIsUnder(input));
    }
    @Test
    public void 사용자입력이_3보다_큰_경우(){
        String input="1234";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                validation.inputLengthIsOver(input));
    }
    @Test
    public void 사용자입력이_숫자가_아닌경우(){
        String input="asdf";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                validation.inputIsNotNumber(input));
    }
    @Test
    public void 사용자입력이_중복된_경우(){
        String input="113";
       Assertions.assertThrows(IllegalArgumentException.class, ()->
               validation.duplicateNumber(input));
    }

}
