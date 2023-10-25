package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
  public static void main(String[] args) {
        while (true) {
            playGame();
            if (!askForRestart()) {
                break;
            }
        }
        System.out.println("게임을 종료합니다.");
    }

    public static void playGame() {
        Randoms randoms = new Randoms();
        int[] computerNumbers = generateComputerNumbers(randoms);

        System.out.println("숫자 야구 게임을 시작합니다.");

        int tries = 0;
        while (true) {
            int[] userNumbers = getUserNumbers();

            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (userNumbers[i] == computerNumbers[i]) {
                    strikes++;
                } else if (contains(computerNumbers, userNumbers[i])) {
                    balls++;
                }
            }

            System.out.println("결과: " + getResult(strikes, balls));

            if (strikes == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            tries++;
        }

        System.out.println("게임 종료 (시도 횟수: " + tries + ")");
    }

    public static int[] generateComputerNumbers(Randoms randoms) {
        int[] computerNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            computerNumbers[i] = randoms.pickNumberInRange(1, 9);
        }
        return computerNumbers;
    }

    public static int[] getUserNumbers() {
        int[] userNumbers = new int[3];

        for (int i = 0; i < 3; i++) {
            userNumbers[i] = Integer.parseInt(Console.readLine("숫자를 입력해주세요: "));
            if (userNumbers[i] < 1 || userNumbers[i] > 9) {
                System.out.println("잘못된 입력입니다. 1부터 9까지의 서로 다른 숫자를 입력해주세요.");
                return getUserNumbers();
            }
        }

        return userNumbers;
    }

    public static String getResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else {
            String result = "";
            if (balls > 0) {
                result += balls + "볼";
                if (strikes > 0) {
                    result += " ";
                }
            }
            if (strikes > 0) {
                result += strikes + "스트라이크";
            }
            return result;
        }
    }

    public static boolean askForRestart() {
        String choice = Console.readLine("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요: ");
        if ("1".equals(choice)) {
            return true;
        } else if ("2".equals(choice)) {
            return false;
        } else {
            System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
            return askForRestart();
        }
    }

    public static boolean contains(int[] array, int target) {
        for (int number : array) {
            if (number == target) {
                return true;
            }
        }
        return false;

    }

}
