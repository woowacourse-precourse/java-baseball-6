package baseball.Player;

import baseball.Player.BaseballPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Batter implements BaseballPlayer {
    private static List<Integer> choice;
    private static final List<Character> validCharacter = Arrays.asList('1','2','3','4','5','6','7','8','9');

    private static final String INVALID_INPUT = "올바른 입력이 아닙니다.";

    @Override
    public void makeChoice(){
        String input = readLine();

        if(!isValidChoice(input)){
            throw new IllegalArgumentException(INVALID_INPUT);
        }

        choice = new ArrayList<>();
        for (char c : input.toCharArray()) {
            choice.add(Integer.parseInt(String.valueOf(c)));
        }
    }

    private boolean isValidChoice(String input){
        if (input.length()!=3) return false;

        List<Character> checkedCharacters = new ArrayList<>();
        for (char c : input.toCharArray()){
            //올바른 입력 혹은 중복 탐지
            if (!validCharacter.contains(c) || checkedCharacters.contains(c)){
                return false;
            }
            checkedCharacters.add(c);
        }
        return true;
    }

    public Boolean decideToPlayMore(){
        String input = readLine();
        if(input.equals("1")){
            return true;
        }
        if(input.equals("2")){
            return false;
        }
        throw new IllegalArgumentException(INVALID_INPUT);
    }

    public List<Integer> getChoice(){
        return this.choice;
    }
}
