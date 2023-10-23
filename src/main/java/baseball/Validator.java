package baseball;

import static baseball.Application.userNumbers;

public class Validator {
    final String regex = "[0-9]+";
    public void check(String userInputNumber){
        if(userNumbers.isEmpty()) initUserNumbers();
        if(userInputNumber.matches(regex) && checkSize(userInputNumber) && checkNumber(userInputNumber)){
            makeUserInputNumber(userInputNumber);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    private boolean checkNumber(String userInputNumber) {
        for(int i=0; i<3; i++){
            if(userInputNumber.charAt(i)==0)    return false;
        }
        return true;
    }

    public boolean checkSize(String userInputNumber){
        return stoi(userInputNumber) >= 100 && stoi(userInputNumber) < 1000;
    }

    public void makeUserInputNumber(String userInputNumber) {
        String[] userInputNumbers = userInputNumber.split("");
        for (int i = 0; i < 3; i++) {
            userNumbers.set(i,stoi(userInputNumbers[i]));
        }
    }

    private Integer stoi(String userInputNumber) {
        return Integer.parseInt(userInputNumber);
    }

    private void initUserNumbers() {
        for(int i=0; i<3; i++){
            userNumbers.add(i);
        }
    }
}
