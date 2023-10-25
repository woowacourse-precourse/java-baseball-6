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

    //userNum 초기화
    public void dataInit(){
        userNum.clear();
    }

    //입력받은 숫자를 userNum에 저장
    public void convertInput(String input){
        dataInit();

        for (int i = 0; i < 3; i++) {
            userNum.add(input.charAt(i) - '0');
        }

    }

    //userNum 반환
    public List<Integer> getUserNum(){
        return userNum;
    }

}
