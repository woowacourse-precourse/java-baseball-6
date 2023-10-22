package baseball;

import baseball.computer.NumberBaseballGameComputerPlayer;

public class Application {

    public static void main(String[] args) {
        NumberBaseballGameComputerPlayer computerPlayer = new NumberBaseballGameComputerPlayer();

        NumberBaseballGame game = new NumberBaseballGame(computerPlayer);

        System.out.println("숫자 야구 게임을 시작합니다.");
        game.run();
    }
}
