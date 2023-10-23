package baseball.domain;
import baseball.view.Input;

public class Player {
    private String number;
    private Input input;
    public Player(){
        this.number = "";
        input = new Input();
    }
    public String inputNumber(){
        return input.inputNumber();
    }
}
