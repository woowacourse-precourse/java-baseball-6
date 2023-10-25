package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private List<Integer> userInput;

    User(){}

    public List<Integer> getUserInput() {
        return this.userInput;
    }

    public void setUserInput(List<Integer> userInput){
        this.userInput = userInput;
    }

    public void input(){
        try {
            int num = Integer.parseInt(Console.readLine());
            digit(num);
            hasDuplicate(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void digit(int num){
        this.userInput.add(num/100);
        this.userInput.add((num%100)/10);
        this.userInput.add((num%100)%10);
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
