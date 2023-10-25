package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.player.Player;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import static baseball.domain.game.GameInfo.ENTER_NUMBER;

public class GamePlay {

    private static int strikeCount;
    private static int ballCount;
    private static boolean isThreeStrike;

    public static void runFullGame() {
        try {
            do {
                resetScores();
                runOneRound();
                System.out.println(GameInfo.END_OR_RESTART.getInfo());
            } while (isGameStartAgain());
        } catch (IllegalArgumentException e) {
            throw e;
        } finally {
            Console.close();
        }
    }

    public static void runOneRound() {
        System.out.println(GameInfo.GAME_START.getInfo());
        List<Integer> computerNum = createComputerNum();
        try {
            do {
                resetScores();
                int[] playerNum = getPlayerNum();
                calculateScores(computerNum, playerNum);
                noticeScores();
            } while (!isThreeStrike);

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void resetScores() {
        strikeCount = 0;
        ballCount = 0;
        isThreeStrike = false;
        return;
    }

    public static boolean isGameStartAgain() {
        String numInput = Console.readLine();
        int numSelection = Integer.parseInt(numInput);
        if (numSelection != 1 && numSelection != 2) {
            throw new IllegalArgumentException("1 또는 2 숫자를 입력해야 합니다.");
        }
        return (numSelection == 1) ? true: false;
    }

    private static void calculateScores(List<Integer> computerNum, int[] playerNum) {
        for (int p=0; p<3; p++) {
            int playerDigit = playerNum[p];
            for (int c=0; c<3; c++) {
                int comDigit = computerNum.get(c);
                if (playerDigit == comDigit && p==c) {
                    strikeCount += 1;
                } else if (playerDigit == comDigit) {
                    ballCount += 1;
                }
            }
        }
    }

    private static void noticeScores() {
        if (ballCount==0 && strikeCount==0) {
            System.out.println(GameInfo.NOTHING.getInfo());
            return;
        } else if (ballCount==0) {
            System.out.println(strikeCount + GameInfo.STRIKE.getInfo());
            if (strikeCount == 3) {
                isThreeStrike = true;
                System.out.println(GameInfo.GAME_OVER.getInfo());
                return;
            }
            return;
        } else if (strikeCount==0) {
            System.out.println(ballCount + GameInfo.BALL.getInfo());
            return;
        } else if(ballCount !=0 && strikeCount !=0){
            System.out.println(ballCount + GameInfo.BALL.getInfo() + " " + strikeCount + GameInfo.STRIKE.getInfo());
            return;
        }
    }

    private static List<Integer> createComputerNum() {
        Computer computer = new Computer();
        computer.setComputerNum();
        List<Integer> computerNum = computer.getComputerNum();
        return computerNum;
    }

    private static int[] getPlayerNum() {
        System.out.print(ENTER_NUMBER.getInfo());
        String inputNum = Console.readLine();

        if (inputNum.length() !=3 ) {
            throw new IllegalArgumentException();
        }

        Player player = new Player();
        player.setPlayerNums(inputNum);
        int[] playerNum = player.getPlayerNums(inputNum);

        if (playerNum[0]==playerNum[1] || playerNum[1]==playerNum[2] || playerNum[2]==playerNum[0]) {
            throw new IllegalArgumentException("각 자리의 숫자는 모두 달라야 합니다.");
        }
        return playerNum;
    }

}
