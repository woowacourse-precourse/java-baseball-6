package baseball.Player;

import baseball.Player.BaseballPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Batter implements BaseballPlayer {
    private List<Integer> choice;
    private static final List<Character> validInput = Arrays.asList('1','2','3','4','5','6','7','8','9');

    @Override
    public void makeChoice(){
        String input = readLine();

        if(!isValidChoice(input)){
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }

        choice = new ArrayList<>();
        for (char c : input.toCharArray()) {
            choice.add(Integer.parseInt(String.valueOf(c)));
        }
    }

    private boolean isValidChoice(String input){
        if (input.length()!=3) return false;

        List<String> checkedCharacters = new ArrayList<>();
        for (char c : input.toCharArray()){
            //올바른 입력 혹은 중복 탐지
            if (!validInput.contains(c) || checkedCharacters.contains(c)){
                return false;
            }
            checkedCharacters.add(String.valueOf(c));
        }
        return true;
    }

    public List<Integer> getChoice(){
        return this.choice;
    }
}
