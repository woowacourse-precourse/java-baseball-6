package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        StartGame();
    }
    private static void StartGame() {
        boolean playing = true;

        while(playing) {
            System.out.print("숫자를 입력주세요 : ");
            String num = readLine();
            precondition(num);
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            playing = playGame(num, computer);
        }
    }
    private static void precondition(final String num) {
        try {
            int parseNum = Integer.parseInt(num);
            if (num.length() != 3) {
                throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
            }
            char[] duplicate = num.toCharArray();
            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (duplicate[i] == duplicate[j]) {
                        throw new IllegalArgumentException("입력한 숫자에 중복이 있습니다.");
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if (duplicate[i] < '1' || duplicate[i] > '9') {
                    throw new IllegalArgumentException("1~9까지의 숫자를 입력해주세요.");
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    private static boolean playGame(String user, List<Integer> computer) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int userDigit = user.charAt(i) - '0';
            int computerDigit = computer.get(i);

            if (userDigit == computerDigit) {
                strikes++;
            } else if (computer.contains(userDigit)) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }

        if (strikes != 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
        }

        if (balls != 0 && strikes == 0) {
            System.out.println(balls + "볼");
        }

        if (strikes != 0 && balls != 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크 ");
        }

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String option = readLine();
            if ("2".equals(option)) {
                return false; // 게임 종료
            }
        }
        return true; // 게임 계속
    }
}
