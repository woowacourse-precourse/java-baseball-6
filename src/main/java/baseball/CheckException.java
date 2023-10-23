package baseball;
import java.util.ArrayList;
import java.util.List;

public class CheckException {
    CheckException(){}

    boolean isValidLength(String userInput,int wantLength){
        return userInput.length()==wantLength;
    }

    boolean isValidNumber(String userInput) {
        for (int i=0; i<userInput.length(); i++){
            if(userInput.charAt(i)<'1' || userInput.charAt(i)>'9') return false;
        }
        return true;
    }

    boolean hasDuplication(String userInput){
        List<Integer>numberCount = new ArrayList<>();
        for (int i=0; i<=9; i++){
            numberCount.add(0);
        }
        for (int i=0; i<userInput.length(); i++){
            int digit=Character.getNumericValue(userInput.charAt(i));
            numberCount.set(digit,numberCount.get(digit)+1);
        }

        for (int i=1; i<=9; i++) {
            if (numberCount.get(i) > 1) {
                return true;
            }
        }
        return false;
    }

    boolean error(String userInput){
        if(!isValidLength(userInput,3) || !isValidNumber(userInput)) return true;
        return hasDuplication(userInput);
    }
}
