package baseball;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int strike;
    private int ball;
    private List<Integer> computer_number = new ArrayList<>();

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}