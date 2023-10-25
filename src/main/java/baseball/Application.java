package baseball;


import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        ComputerNum computerNum = new ComputerNum();
        InitGame initGame = new InitGame();
        Compare compare = new Compare();
        Retry retry = new Retry();

        Boolean restart = true;

        while (restart) {
            List<Integer> computerNums = computerNum.ComputerNumber();

            String ans = "";

            while (!ans.equals("3스트라이크")) {
                ans = compare.Classification(computerNums, initGame.userNum());
                System.out.println(ans);
            }
            restart = retry.retry();
        }
    }
}