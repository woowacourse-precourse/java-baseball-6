package baseball.Controller;

import java.util.ArrayList;

public class PlayerInputController {

    Validator validator = new Validator();

    public ArrayList<Integer> handlePlayerInput(String playerFirstInput){
        validator.validatePlayerInput(playerFirstInput);
        String[] numbers = playerFirstInput.replace(" ", "").split("");
        ArrayList<Integer> playerInput = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            playerInput.add(Integer.valueOf(numbers[i]));
        }
        return playerInput;
    }
}
