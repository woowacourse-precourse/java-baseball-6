package baseball;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        Player player = new Player();
        gameStart(computer, player);
    }

    private static void gameStart(Computer computer, Player player) {
        // command 가 1이면 여전히 게임을 수행, 2이면 게임을 종료
        int command = 1;
        int[] computerNum = computer.pickRandomNumber();
        System.out.println("숫자 야구를 시작합니다.");
        while (command == 1) {
            System.out.print("숫자를 입력해주세요: ");
            int[] playerNumber = player.inputPlayerNums();
            int[] result = getGameResult(playerNumber, computerNum);
            System.out.println(Arrays.toString(result));
        }
    }

    // 0번째 결과에는 볼 카운트, 1번째 결과에는 스트라이크 카운트를 저장한다.
    private static int[] getGameResult(int[] playerNum, int[] computerNum) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            // 같은 자리에 있따면 스트라이크
            if (playerNum[i] == computerNum[i])
                result[1]++;
            else if (isBall(playerNum[i], computerNum)) {
                result[0]++;
            }
        }
        return result;
    }

    private static boolean isBall(int playerNum, int[] computerNum) {
        for (int i = 0; i < 3; i++) {
            if (playerNum == computerNum[i])
                return true;
        }
        return false;
    }
}
