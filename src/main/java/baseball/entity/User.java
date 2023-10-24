package baseball.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private List<Integer> number;

    public User(){
        number = new ArrayList<>();
    }

    public List<Integer> getNumber() {
        return number;
    }

    /*
            a. 숫자인가?
            b. 3자리 수인가?
            c. 서로 다른 수로 구성되어 있는가?
    */
    public void setNumber(String userInput) {
        System.out.println(userInput);

        Set<Integer> checkuserInput = new HashSet<>();
        List<Integer> setting = new ArrayList<>();
        char[] userInputList = userInput.toCharArray();
//
//
        if(userInputList.length != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }
        for (char digit : userInputList) {
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("숫자를 입력하세요.");
            }else {
                int tmp = digit - '0';
                if(tmp < 1 || tmp > 9) throw new IllegalArgumentException("0 ~ 9사이의 숫자를 입력하세요");
                checkuserInput.add(tmp);
                setting.add(tmp);
            }
        }
        if(checkuserInput.size() != 3) throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        number = setting;
    }
}
