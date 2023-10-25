package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class UserInput {
    static final String INPUT_MESSAGE = "숫자를 입력해 주세요.";
    public static List<Integer> playerNumber(){
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        List<Integer> playerNum = new ArrayList<>();

        for(String number: input.split("")){
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }
}
