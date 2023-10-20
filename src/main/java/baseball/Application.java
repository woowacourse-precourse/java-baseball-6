package baseball;
import camp.nextstep.edu.missionutils.Console;
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
        computer.pickRandomNumber();
        System.out.println("숫자 야구를 시작합니다.");
        while (command == 1) {
            System.out.print("숫자를 입력해주세요: ");
            int[] playerNumber = player.inputPlayerNums();
            int[] result = getGameResult(playerNumber, computer.getComputerNums());
            System.out.println(changeResultToText(result));
            // 3스트라이크 라면 게임을 종료할지, 새로 시작할 지 결정 한다.
            if (result[1] == 3)
                command = selectRestartOrEndGame(computer);
        }
    }

    private static int selectRestartOrEndGame(Computer computer) {
        // 만약 player 가 새로 시작한다고 하면, computer 는 다시 새로운 숫자를 뽑아 내야 한다.
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int n = Integer.parseInt(Console.readLine());
        if (n == 1)
            computer.pickRandomNumber();
        return n;
    }

    private static String changeResultToText(int[] result) {
        StringBuffer buffer = new StringBuffer();
        if (result[0] == 0 && result[1] == 0) {
            buffer.append("낫싱");
        } else {
            if (result[0] != 0) {
                buffer.append(result[0] + "볼 ");
            }

            if (result[1] != 0) {
                buffer.append(result[1] + "스트라이크");
            }
        }
        return buffer.toString();
    }

    // 0번째 결과에는 볼 카운트, 1번째 결과에는 스트라이크 카운트를 저장한다.
    private static int[] getGameResult(int[] playerNum, int[] computerNum) {
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
    private static boolean isBall(int playerNum, int[] computerNum) {
        for (int i = 0; i < 3; i++) {
            if (playerNum == computerNum[i])
                return true;
        }
        return false;
    }
}
