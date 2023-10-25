package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> userNumbers = new ArrayList<>();

    public User(String inputUserNumbers){
        if (!userNumbers.isEmpty()){
            userNumbers.clear();
        }
        generateUserNumbers(inputUserNumbers);
    }

    public void generateUserNumbers(String inputUserNumbers){

        for (int i =0; i < inputUserNumbers.length(); i++){
            int number = inputUserNumbers.charAt(i)-'0';
            userNumbers.add(number);
        }
    }

    public List<Integer> getUserNumbers(){
        return userNumbers;
    }
}
