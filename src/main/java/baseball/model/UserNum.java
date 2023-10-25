package baseball.model;

import java.util.List;

public class UserNum {
    private List<Integer> userNum;

    public UserNum(List<Integer> num){
        this.userNum=num;
    }

    public List<Integer> getUserNumArray(){
        return this.userNum;
    }
}
