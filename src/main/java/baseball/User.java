package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private List<Integer> userInput;

    User(){}

    public List<Integer> getUserInput() {
        return this.userInput;
    }

    public void input(){
        try {
            userInput = new ArrayList<>();
            String input = Console.readLine();
            if(input.length() != 3){
                throw  new Exception();
            }
            int num = Integer.parseInt(input);
            digit(num);
            hasDuplicate(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void digit(int num){
        userInput.add(0, num/100);
        userInput.add(1, (num%100)/10);
        userInput.add(2, (num%100)%10);
    }

    public void hasDuplicate(List<Integer> userInput) throws Exception{
        Set<Integer> set = new HashSet<>(userInput);
        if(set.size() != userInput.size()){
            throw new Exception();
        }
        if(userInput.size() != 3){
            throw new Exception();
        }
    }
}
