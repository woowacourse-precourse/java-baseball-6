package baseball;


import static baseball.Referee.gameSwitch;
import static baseball.Referee.result;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 처음에 숫자를 맞히면 종료 가능, 두 번째 부터 무한루프..
        while(gameSwitch) {
            Computer computer = new Computer();
            System.out.println(computer.getComputerBall());


            BaseBallGameUI baseBallGameUI = new BaseBallGameUI();
            baseBallGameUI.startBaseballGame();
            baseBallGameUI.inputPlayerNum();
            String inputValue = readLine();
            int inputValueToInt = Integer.parseInt(inputValue);

            Player player = new Player(inputValueToInt);

            Referee referee = new Referee();
            referee.decideResult(computer.getComputerBall(), player.getPlayerBall());
            baseBallGameUI.printResult(result);
        }
    }
}
