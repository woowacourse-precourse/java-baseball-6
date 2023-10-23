package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computerRandomBalls = new ArrayList<>();
    static List<Integer> userRandomBalls = new ArrayList<>();
    public static void main(String[] args) {
        GameStart.Start();
    }
}
