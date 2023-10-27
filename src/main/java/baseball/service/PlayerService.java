package baseball.service;

import baseball.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    public List<Integer> createPlayerList(String input) {
        Player player = new Player(convertList(input));
        return player.getPlayer();
    }

    private List<Integer> convertList(String input) {
        List<Integer> convertedList = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char inputChar = input.charAt(i);
            int inputInt = Character.getNumericValue(inputChar);
            convertedList.add(inputInt);
        }
        return new ArrayList<>(convertedList);
    }
}
