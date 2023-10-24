package baseball.view;

import baseball.utility.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static Input input = new Input();

    private Input() {
    }

    public static Input getInput() {
        return input;
    }

    public String inputFromUser(){
        return Console.readLine();
    }

}
