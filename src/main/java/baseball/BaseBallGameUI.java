package baseball;

import java.util.List;

import static baseball.Referee.gameSwitch;
import static baseball.Referee.setGameSwitch;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class BaseBallGameUI {
    public void startMessage() {
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
                try{
                    restartGame();
                } catch (IllegalArgumentException e) {
                    setGameSwitch(false);
                }
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

    public void restartGame() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputValue = readLine();
        if(inputValue == null || !inputValue.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
        int inputValueToInt = Integer.parseInt(inputValue);

        if(inputValueToInt != 2 && inputValueToInt != 1) {
            throw new IllegalArgumentException();
        }

        if(inputValueToInt == 2) {
            setGameSwitch(false);
        }
        if(inputValueToInt == 1) {
            startGame();
        }
    }

    public void startGame() throws IllegalArgumentException {
        Referee referee = new Referee();
        Computer computer = new Computer();
        System.out.println(computer.getComputerBall());

        while(gameSwitch) {
            inputPlayerNum();
            String inputValue = readLine();
            if(inputValue == null || !inputValue.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
            int inputValueToInt = Integer.parseInt(inputValue);
            try {
                Player player = new Player(inputValueToInt);
                printResult(referee.decideResult(computer.getComputerBall(), player.getPlayerBall()));
            } catch (IllegalArgumentException e) {
                setGameSwitch(false);
            }
        }
    }
}
