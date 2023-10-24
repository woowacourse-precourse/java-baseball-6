package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requireBaseBallNumber(){
        System.out.println(REQUIRE_BASEBALL_NUMBER);
        return Console.readLine();
    }




}
