package balls;

import Validation.Validation;
import converter.Converter;
import java.util.List;

public class Balls {
    List<Integer> balls;
    Validation validation= new Validation();
    Converter converter= new Converter();
    public Balls(List<Integer> balls){
        this.balls = balls;
    }
    public Balls(String input){
        validation.userGameStartValidation(input);
        this.balls= converter.stringToIntList(input);
    }
}
