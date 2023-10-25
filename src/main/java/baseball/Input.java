package baseball;
import java.util.ArrayList;
import java.util.List;

public class Input {
    final private String userInput;
    Input(String userInput){
        this.userInput=userInput;
    }

    boolean isValidLength(){
        return userInput.length()==3;
    }

    boolean isValidNumber() {
        for (int i=0; i<userInput.length(); i++){
            if(userInput.charAt(i)<'1' || userInput.charAt(i)>'9') return false;
        }
        return true;
    }

    boolean hasDuplication(){
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

    boolean error(){
        if(!isValidLength() || !isValidNumber()) return true;
        return hasDuplication();
    }

   void checkException()throws IllegalArgumentException{
        if(error()) throw new IllegalArgumentException();
    }

}
