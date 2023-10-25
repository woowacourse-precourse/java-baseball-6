package baseball.game;

import baseball.ball.Ball;
import baseball.ball.Result;
import baseball.input.InputFactory;

import java.io.IOException;
import java.util.List;


public class GameService {
    private static final GameService instance = new GameService();

    private static final Ball ball = Ball.getInstance();

    private int endPtr;
    private int num;

    private GameService() {

    }

    public static GameService getInstance() {
        return instance;
    }

    public void startGame() {
        endPtr = 1;
        while (endPtr == 1) {
            List<Integer> list = ball.updateTarget();
            list.forEach(n -> {
                System.out.printf(n + " ");
            });
            println("숫자 야구 게임을 시작합니다.");
            Result result = new Result(0, 0);
            while (!result.chkResult(result)) {
                print("숫자를 입력해주세요 : ");
                num = read();
                result = ball.checkNumber(num);
                println(result.toString());
            }
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            endPtr = read();
            if(endPtr != 1 && endPtr != 2) throw new IllegalArgumentException("잘못된 입력입니다!");
        }
    }

    private void print(String message) {
        System.out.printf(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void println() {
        System.out.println();
    }

    private int read() {
        try {
            return Integer.parseInt(InputFactory.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
