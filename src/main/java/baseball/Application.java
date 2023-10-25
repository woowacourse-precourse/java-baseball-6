package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Application {

    public static String createRandomNumber() {
        StringBuilder computer = new StringBuilder();
        while (computer.length() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.toString().contains(randomNumber)) {
                computer.append(randomNumber);
            }
        }
        return computer.toString();
    }

    public static boolean checkDuplicateInput(String input) {
        Set<Character> buffers = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (buffers.contains(ch)) {
                return true;
            }
            buffers.add(ch);
        }
        return false;
    }

    public static int[] calculateScoreBoard(String currentNumber, String computer) {
        int[] scoreBoard = {0, 0};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentNumber.charAt(i) == computer.charAt(j)) {
                    if (i == j) {
                        scoreBoard[0]++;
                    } else {
                        scoreBoard[1]++;
                    }
                    break;
                }
            }
        }
        return scoreBoard;
    }

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isProgramRunning = true;

        do {
            String computer = createRandomNumber();
            boolean isGameRunning = true;
            do {
                System.out.print("숫자를 입력해주세요 : ");
                String currentNumber = camp.nextstep.edu.missionutils.Console.readLine();
                if ((currentNumber.length() != 3) || checkDuplicateInput(currentNumber)) {
                    throw new IllegalArgumentException();
                }

                // 해당 게임에서의 점수 계산 (scoreBoard[0] : 스트라이크, scoreBoard[1] : 볼)
                int[] scoreBoard = calculateScoreBoard(currentNumber, computer);

                if (scoreBoard[0] == 3) {
                    // 3 strike
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    isGameRunning = false;
                } else if (scoreBoard[0] == 0 && scoreBoard[1] == 0) {
                    // NOTHING
                    System.out.println("낫싱");
                } else {
                    if (scoreBoard[0] == 0) {
                        System.out.println(scoreBoard[1] + "볼");
                    } else if (scoreBoard[1] == 0) {
                        System.out.println(scoreBoard[0] + "스트라이크");
                    } else {
                        System.out.println(scoreBoard[1] + "볼 " + scoreBoard[0] + "스트라이크");
                    }
                }
            } while (isGameRunning);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String gameover = camp.nextstep.edu.missionutils.Console.readLine();
            if (Objects.equals(gameover, "2")) {
                isProgramRunning = false;
            } else if (!Objects.equals(gameover, "1")) {
                throw new IllegalArgumentException();
            }
        } while (isProgramRunning);
    }
}
