package baseball;

import java.util.List;

import static baseball.Referee.gameSwitch;
import static baseball.Referee.setGameSwitch;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class BaseBallGameUI {
    Referee referee = new Referee();
    Computer computer = new Computer();

    public void startBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputPlayerNum() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(List<Integer> result) {
        if(result.get(0) == 0 && result.get(1) != 0) {
            System.out.println(result.get(1) + "스트라이크");
            if(result.get(1) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                restartGame();
            }
        }
        if(result.get(1) == 0 && result.get(0) != 0) {
            System.out.println(result.get(0) + "볼");
        }
        if(result.get(0) != 0 && result.get(1) != 0) {
            System.out.println(result.get(0) + "볼 " + result.get(1) + "스트라이크");
        }
        if(result.get(0) == 0 && result.get(1) == 0) {
            System.out.println("낫싱");
        }
    }

    public Boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputValue = readLine();
        int inputValueToInt = Integer.parseInt(inputValue);

        if(inputValueToInt == 2) {
            setGameSwitch(false);
        }
        if(inputValueToInt == 1) {
            Computer computer = new Computer();
            System.out.println(computer.getComputerBall());
        }
        return gameSwitch;
    }

    public void startGame() {
        System.out.println(computer.getComputerBall());

        startBaseballGame();
        while(gameSwitch) {
            inputPlayerNum();
            String inputValue = readLine();
            int inputValueToInt = Integer.parseInt(inputValue);
            Player player = new Player(inputValueToInt);
            printResult(referee.decideResult(computer.getComputerBall(), player.getPlayerBall()));
            System.out.println(referee.decideResult(computer.getComputerBall(), player.getPlayerBall()));
        }
    }
}
