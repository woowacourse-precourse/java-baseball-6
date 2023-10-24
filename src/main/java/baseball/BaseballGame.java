package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {
    ComputerNumber computerNumber = new ComputerNumber();
    PlayerNumber playerNumber = new PlayerNumber();
    Compare compare = new Compare();
    Exception exception = new Exception();



    public void GameStart() {

        System.out.print("숫자 야구 게임을 시작합니다.\n");
        List<Integer> computer = computerNumber.getComputer();

        GamePlay(computer);
    }

    public void GamePlay(List<Integer> computer) {
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> player = playerNumber.getPlayer();
        String CountResult = compare.CountResult(player, computer);
        System.out.println(CountResult);

        if (CountResult.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            GameReplay();
            return;
        }

        GamePlay(computer);
    }

    public void GameReplay() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String ReplayValue = Console.readLine();
        exception.Exception_ReplayNumber(ReplayValue);

        if (ReplayValue.equals("1")) {
            GameStart();
        } else if (ReplayValue.equals("2")) {
            return;
        }
    }
}