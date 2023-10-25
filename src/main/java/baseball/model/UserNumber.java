package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private List<Integer> userNumber;
    public UserNumber(List<Integer> userNumber){
        this.userNumber=userNumber;
    }
    public List<Integer> getUserNumber(){
        return userNumber;
    }
}
