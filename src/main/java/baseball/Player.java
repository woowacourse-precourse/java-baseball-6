package baseball;

import game.Computer;

public class Player {

    private Computer computer;
    private String playerBall;

    public void start() {
        System.out.print("숫자 야구 게임을 시작합니다.\n");
        do {
            reset();
            play();
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (finish());
    }

    private void reset() {
        computer = new Computer();
    }

    private void play() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerBall = Input.readNumber();
        } while (!computer.catchBall(playerBall));
    }

    private boolean finish() {
        String option = Input.readOption();
        return !option.equals("2");
    }

}
