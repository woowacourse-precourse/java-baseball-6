package baseball.domain;

import baseball.view.Input;
import camp.nextstep.edu.missionutils.Console;

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
