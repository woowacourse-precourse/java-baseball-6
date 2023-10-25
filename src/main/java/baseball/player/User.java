package baseball.player;

import baseball.game.Validate;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> user = new ArrayList<>();

    public void init(){
        user.clear();
    }

    public void selectUserNumber(){
        String[] input = Console.readLine().split("");
        Validate.isLessThenFourLetter(input);

        for (String inputNum : input) {
            int num = Integer.parseInt(inputNum);
            Validate.isNumberValidate(num);
            Validate.isNumberDuplicate(user, num);
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
