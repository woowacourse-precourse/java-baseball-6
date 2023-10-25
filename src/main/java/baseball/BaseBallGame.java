package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private final Result result;
    private final Computer computer;
    private final Player player;

    public BaseBallGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.computer = new Computer();
        this.player = new Player();
        this.result = new Result();
    }

    public void play() {
        while (player.state != State.END) {
            if (player.state == State.START) {
                computer.makeProblem();
            }
            player.guess();
            result.showResult(player, computer);
            if (player.state == State.PAUSE) {
                resetGame();
            }
        }

    }

    private void resetGame() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        player.setPlayerState(Validator.validateUserinputRestart(input));
    }

}

