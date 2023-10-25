package baseball.model;

import java.util.List;

public class UserNumberDto {
    private List<Integer> userNumber;
    public UserNumberDto(){};
    public List<Integer> getUserNumber(){
        return this.userNumber;
    }
    public void setUserNumber(List<Integer> userNumber){
        this.userNumber = userNumber;
    }
}
