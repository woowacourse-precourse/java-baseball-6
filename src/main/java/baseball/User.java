package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> user = new ArrayList<>();

    public void init(){
        user.clear();
    }

    public void selectUserNumber(){ // TODO: 리팩토링(너무 많은 로직이 들어있음)
        String[] input = Console.readLine().split("");

        if(input.length >= 4){
            throw new IllegalArgumentException("입력 값은 3개 이하여야 합니다.");
        }

        for(int i=0; i<input.length; i++){
            int num = Integer.parseInt(input[i]);
            Validate.isNumberValidate(num);

            if(user.contains(num)){
                throw new IllegalArgumentException("입력 값은 서로 다른 값이여야 합니다.");
            }
            user.add(num);
        }
    }

    public void setUserObject(){
        init();
        selectUserNumber();
    }

    public int getUserNumber(int index){
        return user.get(index);
    }
}
