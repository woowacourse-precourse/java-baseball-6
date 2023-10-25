package baseball;

import java.util.List;

public class Game {
    private boolean exitFlag = false;
    private List<Integer> computer;
    private List<Integer> player;
    private RandomNumber randomNumber = new RandomNumber();
    private Input input = new Input();
    private GameLogic gameLogic = new GameLogic();

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = randomNumber.getComputerNumbers();
        while (!exitFlag) {
            System.out.print("숫자를 입력해주세요 : ");
            player = input.stringToList(ConsoleUtils.readLine());
            printHint(computer, player);
        }
    }

    private void setRestartOrExit() {
        String input = ConsoleUtils.inputRestartOrExit();
        if (input.equals("1")) {
            computer = randomNumber.getComputerNumbers();
            return;
        }
        exitFlag = true;
    }

    private void printHint(List<Integer> answer, List<Integer> input) {
        int strike = gameLogic.countStrike(answer, input);
        int ball = gameLogic.countBall(answer, input);

        System.out.println(gameLogic.makeHint(strike, ball));
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            setRestartOrExit();
        }
    }
}
