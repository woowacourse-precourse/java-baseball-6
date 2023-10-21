package baseball.vo;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumbers = new ArrayList<>();
    public void setUserNumbers(List<Integer>userNumbers){
        this.userNumbers=userNumbers;
    }
    public List<Integer> getUserNumbers(){
        return userNumbers;
    }

    public int getNumber(int index){
        return userNumbers.get(index);
    }
}
