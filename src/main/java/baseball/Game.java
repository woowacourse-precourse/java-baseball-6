package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Computer computer;
    private final Player player;
    private GameStatus status;
    private GamePrinter printer;

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
        this.status = GameStatus.PROGRESS;
        this.printer = GamePrinter.getGamePrinter();
    }

    public void gameStart() {
        // command 가 1이면 여전히 게임을 수행, 2이면 게임을 종료
        computer.pickRandomNumber();
        printer.printStartGame();
        while (status == GameStatus.PROGRESS) {
            printer.printEnterNumber();
            player.inputPlayerNums();
            int[] result = getGameResult(player.getPlayerNumber(), computer.getComputerNums());
            printer.printResult(result);
            // 3스트라이크 라면 게임을 종료할지, 새로 시작할 지 결정 한다.
            if (result[1] == 3) {
                status = selectRestartOrEndGame(computer);
            }
        }
    }

    private GameStatus selectRestartOrEndGame(Computer computer) {
        // 만약 player 가 새로 시작한다고 하면, computer 는 다시 새로운 숫자를 뽑아 내야 한다.
        printer.printEndGame();
        int progress = Integer.parseInt(Console.readLine());
        // 진행 상태로 유지 한다면, computer 에게 번호를 뽑으라고 명령
        if (progress == GameStatus.PROGRESS.getProgress()) {
            computer.pickRandomNumber();
        }
        return GameStatus.getStatus(progress);
    }

    // 0번째 결과에는 볼 카운트, 1번째 결과에는 스트라이크 카운트를 저장한다.
    private int[] getGameResult(final int[] playerNum, final int[] computerNum) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            // 같은 자리에 있따면 스트라이크
            if (playerNum[i] == computerNum[i]) {
                result[1]++;
            } else if (isBall(playerNum[i], computerNum)) {
                result[0]++;
            }
        }
        return result;
    }

    // 해당 playerNum가 computerNums에 존재 한다면 볼 이다.
    private boolean isBall(final int playerNum, final int[] computerNum) {
        for (int i = 0; i < 3; i++) {
            if (playerNum == computerNum[i]) {
                return true;
            }
        }
        return false;
    }
}
