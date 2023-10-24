package baseball;

import baseball.controller.GameStart;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> computerRandomBalls = new ArrayList<>();
    public static List<Integer> userRandomBalls = new ArrayList<>();
    public static void main(String[] args) {
        GameStart.Start();
    }
}
