package Game;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Game.BaseballGame.MAX_LENGTH;

public class ScanManager {

    public boolean isContinue(){
        int res = Integer.parseInt(Console.readLine());
        if(res == 1){
            return true;
        }
        else if(res == 2){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getDigitAsList(){
        String input = Console.readLine();
        if(varify(input)){
            return toList(input);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public boolean varify(String str){
        if(isCorrectLength(str) && isDigit(str) && isNotDuplicated(str)){
            return true;
        }
        return false;
    }

    public boolean isCorrectLength(String str){
        return str.length() == MAX_LENGTH;
    }

    public boolean isDigit(String str){
        for (int i = 0; i < MAX_LENGTH; i++){
            if( str.charAt(i) < '1' || str.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    public boolean isNotDuplicated(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> toList(String str){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < MAX_LENGTH; i++){
            list.add(str.charAt(i) - '0');
        }
        return list;
    }
}
