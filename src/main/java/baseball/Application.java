package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        
    	while (true) {
            int[] target = generateRandomNumber();
            int[] guess;

            System.out.println("숫자 야구 게임을 시작합니다.");

            do {
                System.out.print("숫자를 입력해주세요 (세 자리 숫자): ");
                guess = getUserInput();

                int[] result = compare(target, guess);

            } while (!isWin(guess, target));

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());
            if (choice == 2) {
                break;
            }
        }

        System.out.println("게임을 종료합니다.");
    }

    public static int[] generateRandomNumber() {
        int[] number = new int[3];

        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            number[i] = randomNumber;
        }

        return number;
    }

    public static int[] getUserInput() {
        int[] number = new int[3];
        while (true) {
        	String input = Console.readLine();
            try {
                int inputValue = Integer.parseInt(input);
                number = parseNumber(inputValue);
                if (number.length != 3) {
                    System.out.println("세 자리 숫자를 입력하세요.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }
        return number;
    }

    public static int[] parseNumber(int input) {
        int[] number = new int[3];
        for (int i = 2; i >= 0; i--) {
            number[i] = input % 10;
            input /= 10;
        }
        return number;
    }

    public static int[] compare(int[] target, int[] guess) {
        int[] result = {0, 0}; // [볼, 스트라이크]

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (guess[i] == target[j]) {
                    if (i == j) {
                        result[1]++; // 스트라이크
                    } else {
                        result[0]++; // 볼
                    }
                }
            }
        }

        // 볼, 스트라이크, 낫싱 처리
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "스트라이크");
        } else if (result[1] == 0) {
            System.out.println(result[0] + "볼");
        } else {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }
        return result;
    }

    public static boolean isWin(int[] guess, int[] target) {
        for (int i = 0; i < 3; i++) {
            if (guess[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
x
