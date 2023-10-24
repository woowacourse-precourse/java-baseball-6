package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String setPlayerNumber(){//PlayerNumber(Model)
        System.out.println("숫자를 입력하세요: ");
        return Console.readLine();
    }

    public static String setReplayNumber(){//ReplayNumber(Model)
        System.out.println("Replay를 원하면 1을 입력, Finish를 원하면 2입력하세요.");
        return Console.readLine();
    }
}
