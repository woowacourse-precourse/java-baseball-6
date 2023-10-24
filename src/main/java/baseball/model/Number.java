package baseball.model;

import java.util.List;

public class Number {
    public List<Integer> computer_Number;
    public List<Integer> player_Number;
    public String player_Input;

    public List<Integer> getComputer_Number() {
        return computer_Number;
    }

    public void setComputer_Number(List<Integer> computer_Number) {
        this.computer_Number = computer_Number;
    }

    public String getPlayer_Input() {
        return player_Input;
    }

    public void setPlayer_Input(String input_String) {
        this.player_Input = input_String;
    }

    public void setPlayer_Number(List<Integer> player_Number) {
        this.player_Number = player_Number;
    }

    public List<Integer> getPlayer_Number() {
        return player_Number;
    }



}
