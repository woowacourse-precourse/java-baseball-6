package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final int INPUT_SIZE = 3;

    private Computer computer;
    private Player player;
    private Referee referee;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        initialize();

        Result result = null;

        do {
            askAnswer();
            result = referee.umpire(player.getAnswer());
            printResult(result);
        } while (!result.isOut(INPUT_SIZE));

        System.out.println(INPUT_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void initialize() {
        computer = new Computer(INPUT_SIZE);
        player = new Player(INPUT_SIZE);
        referee = new Referee(computer.getTarget());
    }

    private void askAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        player.infer();
    }

    private void printResult(Result result) {
        StringBuilder stringBuilder = new StringBuilder();

        int balls = result.getBalls();
        int strikes = result.getStrikes();

        if (balls > 0) {
            stringBuilder.append(balls).append("볼");
        }

        if (balls > 0 && strikes > 0) {
            stringBuilder.append(" ");
        }

        if (strikes > 0) {
            stringBuilder.append(strikes).append("스트라이크");
        }

        if (balls == 0 && strikes == 0) {
            stringBuilder.append("낫싱");
        }

        System.out.println(stringBuilder);
    }

    public boolean proceed() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return player.playNextRound();
    }

    public void end() {
        Console.close();
    }
}
