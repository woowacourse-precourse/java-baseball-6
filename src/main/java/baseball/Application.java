package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static Baseball_Machine baseballMachine = new Baseball_Machine();

    public static void main(String[] args) {
        baseballMachine.play();
    }
}