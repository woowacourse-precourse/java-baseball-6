package baseball.global;

import static baseball.Application.userRandomBalls;

public class Validator {
    final String regex = "[0-9]+";
    public void check(String input){
        if(userRandomBalls.isEmpty()) initUserRandomBalls();
        if(checkBlank(input) && checkSize(input) && input.matches(regex) && checkZero(input)){
            successInput(input);
        }
        else    throw new IllegalArgumentException();
    }

    public void checkUserChoice(String input){
        if (checkBlank(input) && !input.matches(regex) || input.length() != 1 || !checkZero(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkBlank(String userInputNumber){
        if (userInputNumber == null || userInputNumber.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean checkZero(String userInputNumber) {
        String[] tmp = userInputNumber.split("");
        for(int i=0; i<userInputNumber.length(); i++){
            if(stoi(tmp[i])==0)    return false;
        }
        return true;
    }

    private boolean checkSize(String userInputNumber){
        return stoi(userInputNumber) >= 100 && stoi(userInputNumber) < 1000;
    }

    private void successInput(String userInputNumber) {
        String[] userInputNumbers = userInputNumber.split("");
        for (int i = 0; i < userInputNumber.length(); i++) {
            userRandomBalls.set(i,stoi(userInputNumbers[i]));
        }
    }

    private Integer stoi(String userInputNumber) {
        return Integer.parseInt(userInputNumber);
    }

    private void initUserRandomBalls() {
        for(int i=0; i<3; i++){
            userRandomBalls.add(i);
        }
    }
}
