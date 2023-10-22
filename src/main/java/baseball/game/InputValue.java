package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.constvalue.ConstValue.*;

public class InputValue {
    private String userNumbers;
    private String gameRestart;

    public InputValue(){
        this.userNumbers="";
        this.gameRestart="";
    }

    public List<Integer> getUserNumbers(){

        setUserNumbers();

        if (!checkUserNumbers()){
            throw new IllegalArgumentException("[ERROR] 숫자가 잘못된 형식입니다.");
        }

        List<Integer> numbers = new ArrayList<>();

        for (char ch : userNumbers.toCharArray()){
            numbers.add(Character.getNumericValue(ch));
        }

        return numbers;
    }

    public boolean isGameRestart(){

        setGameRestart();

        if (!checkGameRestart()){
            throw new IllegalArgumentException("[ERROR] 숫자가 잘못된 형식입니다.");
        }

        boolean userInput = true;

        if (gameRestart.equals(STOP)){
            userInput = false;
        }

        return userInput;
    }

    public void setUserNumbers() {
        this.userNumbers = Console.readLine();
    }

    public void setGameRestart() {
        this.gameRestart = Console.readLine();
    }

    public boolean checkUserNumbers () {
        if (this.userNumbers == null) {
            return false;
        }
        // user_input 길이를 확인 (3자리)
        if(this.userNumbers.length()!=3){
            return false;
        }
        // user_input이 모두 숫자 인지 확인
        for (char ch : this.userNumbers.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkGameRestart () {
        if (this.gameRestart == null) {
            return false;
        }
        // user_input 길이를 확인 (1자리)
        if(this.gameRestart.length()!=RESTART_LENGTH){
            return false;
        }
        // "1" or "2" 인지 확인
        if (!gameRestart.equals(RESTART) && !gameRestart.equals(STOP)){
            return false;
        }

        return true;
    }
}
