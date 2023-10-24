package baseball.view;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static String setUserNumber(){
        System.out.print("숫자를 입력해주세요. : ");
        return Console.readLine();
    }

    public static List<String> UserNumbertoList(){
       String userNumber = setUserNumber();
        return List.of(userNumber.split(""));

    }
}
