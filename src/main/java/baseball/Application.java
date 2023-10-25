package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임 루프 시작
        while (true) {
            // 랜덤으로 서로 다른 3자리 숫자 생성
            int[] computerNumbers = generateRandomNumbers();

            // 게임 플레이
            boolean isGameEnd = playGame(computerNumbers);

            // 게임 종료 시 재시작 또는 종료 여부 확인
            if (isGameEnd) {
                if (!askForRestart()) {
                    break; // 게임 종료
                }
            }
        }
    }

    // 랜덤함수로 서로 다른 3자리 숫자 생성
    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            while (contains(numbers, randomNumber)) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            }
            numbers[i] = randomNumber;
        }
        return numbers;
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인
    private static boolean contains(int[] array, int number) {
        for (int element : array) {
            if (element == number) {
                return true;
            }
        }
        return false;
    }

    // 게임 시작
    private static boolean playGame(int[] computerNumbers) {
        int attempts = 0;

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            // 입력값을 숫자 배열로 변환
            int[] userNumbers = new int[3];
            for (int i = 0; i < 3; i++) {
                userNumbers[i] = input.charAt(i) - '0';
            }

            // 볼과 스트라이크 계산
            int balls = 0;
            int strikes = 0;
            for (int i = 0; i < 3; i++) {
                if (userNumbers[i] == computerNumbers[i]) {
                    strikes++;
                } else if (contains(computerNumbers, userNumbers[i])) {
                    balls++;
                }
            }

            if (strikes == 3) {
                System.out.println(strikes + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true; // 게임 종료
            } else if (balls == 0 && strikes == 0) {
                System.out.println("낫싱");
            } else if (balls > 0 && strikes == 0) {
                System.out.println(balls + "볼");
            } else if (strikes > 0 && balls == 0) {
                System.out.println(strikes + "스트라이크");
            } else {
                System.out.println(balls + "볼 " + strikes + "스트라이크");
            }

            attempts++;
        }
    }
    private static boolean askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        return choice == 1; // 1이면 재시작, 2이면 종료
    }
}
