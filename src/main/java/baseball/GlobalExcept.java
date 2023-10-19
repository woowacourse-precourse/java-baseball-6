package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GlobalExcept {
    public static void checkDuplication(List<Ball> balls){
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != balls.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
    public static void checkRange(Integer number) {
        if(number < 1 || number > 9) {
            throw new IllegalArgumentException("숫자는 1부터 9까지만 가능합니다.");
        }
    }

    public static void checkLength(String userInput) {
        if(userInput.length() != Game.MAX_BALL_SIZE){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }

    public static void checkAlphabetic(String userInput) {
        for(int i=0; i<Game.MAX_BALL_SIZE; i++){
            if(Character.isAlphabetic(userInput.charAt(i))){
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }
    }

    public static boolean checkRestart(String restartInput) {
        if(restartInput.equals("1")){
            return true;
        }
        else if(restartInput.equals("2")){
            return false;
        }
        else{
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
