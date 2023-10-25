package baseball;

import baseball.controller.BaseBallController;
import baseball.service.BaseBallService;
import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Application {
    static private final BaseBallController controller = new BaseBallController();

    public static void main(String[] args) {
        controller.doBaseBall();
    }
}