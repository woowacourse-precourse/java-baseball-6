package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNum {
    private List<Integer> userNum=new ArrayList<>();

    public UserNum(List<Integer> num){
        this.userNum=num;
    }

    public void setUserNum(List<Integer> num){
        this.userNum=num;
    }

    public List<Integer> getUserNumArray(){
        return this.userNum;
    }
}
