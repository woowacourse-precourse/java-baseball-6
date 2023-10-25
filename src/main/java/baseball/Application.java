package baseball;

import baseball.controller.PlayBaseballController;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        PlayBaseballController playBaseballController = new PlayBaseballController();
        playBaseballController.play();
    }
}