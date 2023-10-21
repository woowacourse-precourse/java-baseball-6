package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import baseball.view.Output;
import baseball.controller.GamePlay;


public class Application {
    public static void main(String[] args) {
        Output.printGameStart();
        boolean isEnd = false;
        while(!isEnd) {
            GamePlay.playing();
        }

    }


    //유틸
    public static String printResult (int[] checkNumbers) {
        String result = "";
        if(checkNumbers[0] != 0 && checkNumbers[1] != 0) {
            result = checkNumbers[1]+"볼 " + checkNumbers[0]+"스트라이크\n";
        } else if (checkNumbers[0] != 0 && checkNumbers[1] == 0) {
            result = checkNumbers[0]+"볼\n";
        } else if (checkNumbers[0] == 0 && checkNumbers[1] != 0) {
            result = checkNumbers[1]+"스트라이크\n";
        } else {
            result = "낫싱\n";
        }
        return result;
    }
}