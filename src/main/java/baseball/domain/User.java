package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    //getMyinputlist
    public List<Integer> getMyinputList() {
        return myinputlist;
    }

    public void setMyinputList(List<Integer> myinputlist) {

        this.myinputlist = myinputlist;
    }

    List<Integer> myinputlist = new ArrayList<Integer>(); //myinputlist이라는 List 생성
}
