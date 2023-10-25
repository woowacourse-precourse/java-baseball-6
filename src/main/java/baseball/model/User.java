package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> userNum; //사용자가 입력한 수를 저장할 배열

    //생성자
    private User(){
        userNum = new ArrayList<>();
    }

    //생성자
    public static User create(){
        return new User();
    }

}
