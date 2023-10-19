package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class UserNum {

    public List<Integer> buildUserNum(String input){
        List<Integer> userNum = new ArrayList<>();
        for (char character : input.toCharArray()) {
            userNum.add(character - '0');
        }
        return userNum;
    }

}
