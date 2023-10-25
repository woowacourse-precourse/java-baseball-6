package baseball;

import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void main(String[] args) {
        // 3개의 서로 다른 숫자 생성

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
                int[] computerNumbers = generateRandomNumbers();
            while (true) {
                System.out.print("숫자를 입력하세요: ");
                String input = Console.readLine();

                if (!isValidInput(input)) throw new IllegalArgumentException();

                int[] userNumbers = parseInput(input);
                int[] result = playGame(computerNumbers, userNumbers);

                if (result[0] == 3) {
                    System.out.println(result[0] + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.");
                    break;
                } else if (result[2] == 3) {
                    System.out.println("낫싱");
                } else {
                    String message = "";
                    if (result[1] > 0) {
                        message += result[1] + "볼 ";
                    }
                    if (result[0] > 0) {
                        message += result[0] + "스트라이크";
                    }
                    System.out.println(message);
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int key = Integer.parseInt(Console.readLine());
            if(key == 2 || key == 1){
                if (key == 2) break;
            }
            else throw new IllegalArgumentException();
            }
            System.out.println("게임을 종료합니다.");

    }

    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Randoms.pickNumberInRange(1,9);
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
        return numbers;
    }

    private static boolean isValidInput(String input) {
        if (!input.matches("[1-9]{3}")) {
            return false;
        }
        int[] numbers = parseInput(input);
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] parseInput(String input) {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }
        return numbers;
    }

    private static int[] playGame(int[] computerNumbers, int[] userNumbers) {
        int strikes = 0;
        int balls = 0;
        int nothings = 0;

        for (int i = 0; i < 3; i++) {
            final int userNum = userNumbers[i];
            if (computerNumbers[i] == userNum) {
                strikes++;
            } else if (Arrays.stream(computerNumbers).anyMatch(num -> num == userNum)) {
                balls++;
            } else {
                nothings++;
            }
        }

        return new int[] { strikes, balls, nothings };
    }
}

