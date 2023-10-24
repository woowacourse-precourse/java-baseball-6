package baseball.controller;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import baseball.model.BallCount;
import baseball.view.OutputView;
public class Game {
    private static boolean exitFlag = false;
    static OutputView OV = new OutputView();
    private static List<Integer> computer = new ArrayList<>();
    private List<Integer> player = new ArrayList<>();
    static InputView number = new InputView();

    public void gameStart() {
        System.out.println(OV.START_SENTENCE);
        computer = number.setRandomNumbers();
        while (!exitFlag) {
            player = number.getInputNumber();
            OV.printHint(computer, player);
        }
    }

    public static void setRestartOrExit() {
        String input = OV.inputRestartOrExit();
        if(input.equals(OV.RESTART)) {
            computer = number.setRandomNumbers();
            return;
        }
        exitFlag = true;
    }



}
