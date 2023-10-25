package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int[] computerNumbers = generateComputerNumbers();
        System.out.println(Arrays.toString(computerNumbers));
        System.out.println(isValid("124"));
        System.out.println(Arrays.toString(parseInput("123")));
        System.out.println(countStrikes(computerNumbers, parseInput("912")));
        System.out.println(countBalls(computerNumbers, parseInput("841"), 1));
        printResult(1,2);
    }

    // 컴퓨터 랜덤 숫자 3개 생성
    private static int[] generateComputerNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int number;
            do {
                number = Randoms.pickNumberInRange(1, 9);
            } while (contains(numbers, number));
            numbers[i] = number;
        }
        return numbers;
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인
    private static boolean contains(int[] array, int number) {
        for (int value : array) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }

    // 게임 진행
    private static void playGame(int[] computerNumbers) {

        // 숫자 입력받기
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (isValid(input)) {
            int[] userNumbers = parseInput(input);
            int strikes = countStrikes(computerNumbers, userNumbers);
            int balls = countBalls(computerNumbers, userNumbers, strikes);

            printResult(strikes, balls);

        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    // 사용자가 입력한 값 유효성 확인
    private static boolean isValid(String input) {
        // 3자리 수이며, 1~9까지의 숫자만 포함
        if (!input.matches("^[1-9]{3}$")) {
            return false;
        }

        // 중복된 숫자가 없는지 확인
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 문자열 입력 값 -> 정수 배열로 변환
    private static int[] parseInput(String input) {
        int[] numbers = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }

    // 스트라이크 수 계산
    private static int countStrikes(int[] computerNumbers, int[] userNumbers) {
        int count = 0;
        for (int i = 0; i < computerNumbers.length; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                count++;
            }
        }
        return count;
    }

    // 볼 수 계산
    private static int countBalls(int[] computerNumbers, int[] userNumbers, int strikes) {
        int count = 0;
        for (int userNumber : userNumbers) {
            if (contains(computerNumbers, userNumber)) {
                count++;
            }
        }
        return count - strikes;
    }


    // 결과 출력
    private static void printResult(int strikes, int balls){
        if (strikes == 3){
            System.out.printf("%d스트라이크\n", strikes);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if(strikes == 0 && balls == 0){
            System.out.println("낫싱");
            return;
        }
        if(balls == 0){
            System.out.printf("%d스트라이크\n", strikes);
            return;
        }
        if (strikes == 0) {
            System.out.printf("%d볼\n", balls);
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", strikes, balls);
    }
}
