package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startGame() {
        System.out.println(START_MESSAGE);
    }

    public String inputPlayerNumber() {
        System.out.println(INPUT_MESSAGE);
        String playerNumber = Console.readLine();
        return playerNumber;
    }
}
