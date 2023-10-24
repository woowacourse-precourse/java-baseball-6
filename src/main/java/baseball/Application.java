package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        baseballGame();
    }

    public static void baseballGame() {

        System.out.print("숫자 야구 게임을 시작합니다.\n");

        ComputerNumber computerNumber = new ComputerNumber();
        List<Integer>computer = computerNumber.getComputer();
        PlayerNumber playerNumber = new PlayerNumber();
        Compare compare = new Compare();
        GameEnd gameEnd = new GameEnd();

        String result = "";
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> player = playerNumber.getPlayer();
            result = compare.TotalCount(player,computer);
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        gameEnd.AskReplay();
    }
}
