package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputPlayerNumber() {
        System.out.print(INPUT_MESSAGE);
        String playerNumber = Console.readLine();
        return playerNumber;
    }
}
