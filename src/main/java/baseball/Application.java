package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    private static void startGame() {
        Computer computer = new Computer();
        Player player = new Player();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            player.setPlayerNumber(Console.readLine());
            computer.printResult(player.getPlayerNumber());
        } while (!isClear());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean isClear() {
        return BaseballNumber.getStrike() == BaseballNumber.getAnswer();
    }
}
