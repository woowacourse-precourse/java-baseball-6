package baseball.number;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private List<Integer> userInput;

    public UserInput(String str){
        validateLength(str);
        List<Integer> userInput = stringToList(str);
        validateNum(userInput);
        this.userInput = userInput;
    }

    private void validateLength(String str) {
        // validation1. 숫자 길이가 3
        if(str.length()!=3){
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
    }

    private static List<Integer> stringToList(String str){
        //string -> List<Integer>로 바꿔서 저장
        Integer input = Integer.parseInt(str);
        List<Integer> userInput = new ArrayList<>();
        userInput.add(input/100);
        userInput.add(input/10%10);
        userInput.add(input%10);
        return userInput;
    }

    //입력값 유효성 검사
    private List<Integer> validateNum(List<Integer> userInput){

        // validation2. 0이 포함되면 안됨
        if(userInput.contains(0)){
            throw new IllegalArgumentException("숫자에 0이 포함될 수 없습니다.");
        }

        // validation3. 3개의 수 중에서 겹치는게 없다.
        if(userInput.get(0).equals(userInput.get(1)) || userInput.get(1).equals(userInput.get(2)) ||
                userInput.get(0).equals(userInput.get(2))){
            throw new IllegalArgumentException("3자리 수 중에서 중복되는 수가 존재합니다.");
        }
        return userInput;
    }

    public int get(int i){
        return (int)userInput.get(i);
    }

}
