package baseball.domain;


import game.Game;
import game.GameInputInterface;
import game.GameOutputInterface;
import game.GameRandom;
import java.util.regex.Pattern;

public class BaseballGame implements Game {
    private final BaseballNumber numbers;
    private final GameRandom random;
    private final GameInputInterface in;
    private final GameOutputInterface out;


    public BaseballGame(GameRandom random, GameInputInterface in, GameOutputInterface out) {
        this.random = random;
        this.numbers = new BaseballNumber(random.sampleDistinctNumbers(1, 9, 3));
        this.in = in;
        this.out = out;
    }

    public Game createNewGame() {
        return new BaseballGame(random, in, out);
    }

    public void sayHello() {
        out.print("숫자 야구 게임을 시작합니다.\n");
    }

    public void sayBi() {
        out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    public void run() {
        while (true) {
            out.print("숫자를 입력해주세요 :");
            String input = in.getInput();
            checkNumbers(input);
            BaseballNumber otherNumbers = BaseballNumber.ofString(input);
            out.print(numbers.getHintFrom(otherNumbers).toString());
            if (numbers.equals(otherNumbers)) {
                break;
            }
        }
        sayBi();
    }

    public boolean shouldRetry() {
        out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String input = in.getInput();
        checkInput(input);
        if ("2".equals(input)) {
            return false;
        }
        return true;
    }


    private static void checkNumbers(String s) {
        if (Pattern.matches("[0-9]{3}", s)) {
            return;
        }
        throw new IllegalArgumentException("0~9까지 숫자 3자리수가 아닙니다.");
    }

    private static void checkInput(String input) {
        if (Pattern.matches("[12]", input)) {
            return;
        }
        throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
    }
}

