package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.consts.MessagesConst.INPUT_USER_NUMBER;
import static baseball.consts.MessagesConst.INPUT_RESTART_NUMBER;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> playerInputNumber(){
        System.out.print(INPUT_USER_NUMBER);
        return Arrays.asList(
                Console.readLine()
                        .split("")
        );
    }

    public String askPlayerChoice(){
        System.out.println(INPUT_RESTART_NUMBER);
        return Console.readLine();
        //isValidChoice(choice);
    }
}
