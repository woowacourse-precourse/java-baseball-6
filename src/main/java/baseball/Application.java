package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	    	Scanner scanner = new Scanner(System.in);
    	        Random random = new Random();
    	        boolean playAgain = true;

    	        System.out.println("숫자 야구 게임을 시작합니다.");

    	        while (playAgain) {
    	            // 컴퓨터가 선택한 3자리 서로 다른 숫자 생성
    	            int[] computerNumbers = generateRandomNumbers();
    	            int attempts = 0;

    	            while (true) {
    	                System.out.print("서로 다른 3자리 숫자를 입력하세요: ");
    	                String input = scanner.next();

    	                if (!isValidInput(input)) {
    	                    System.err.println("유효하지 않은 입력입니다. 1부터 9까지의 서로 다른 3자리 숫자를 입력하세요.");
    	                    continue;
    	                }

    	                int[] userNumbers = convertToDigits(input);

    	                // 볼과 스트라이크 계산
    	                int strikes = 0;
    	                int balls = 0;

    	                for (int i = 0; i < 3; i++) {
    	                    if (userNumbers[i] == computerNumbers[i]) {
    	                        strikes++;
    	                    } else if (contains(computerNumbers, userNumbers[i])) {
    	                        balls++;
    	                    }
    	                }

    	                if (strikes == 3) {
    	                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    	                    break;
    	                }

    	                System.out.println(strikes + "스트라이크 " + balls + "볼");
    	                attempts++;
    	            }

    	            System.out.println("게임이 종료되었습니다. 시도한 횟수: " + attempts);

    	            System.out.print("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요: ");
    	            int choice = scanner.nextInt();
    	            if (choice != 1) {
    	                playAgain = false;
    	            }
    	        }

    	        System.out.println("게임 종료. 감사합니다!");
    	    }

    	    // 1부터 9까지 서로 다른 3자리 숫자 생성
    	    public static int[] generateRandomNumbers() {
    	        int[] numbers = new int[3];
    	        for (int i = 0; i < 3; i++) {
    	            numbers[i] = 1 + i;
    	        }
    	        // 숫자 섞기
    	        shuffleArray(numbers);
    	        return numbers;
    	    }

    	    // 배열의 순서 섞기
    	    public static void shuffleArray(int[] array) {
    	        Random random = new Random();
    	        for (int i = array.length - 1; i > 0; i--) {
    	            int index = random.nextInt(i + 1);
    	            int temp = array[index];
    	            array[index] = array[i];
    	            array[i] = temp;
    	        }
    	    }

    	    // 사용자 입력 유효성 검사
    	    public static boolean isValidInput(String input) {
    	        if (input.length() != 3) {
    	            return false;
    	        }

    	        for (char c : input.toCharArray()) {
    	            if (c < '1' || c > '9') {
    	                return false;
    	            }
    	        }

    	        for (int i = 0; i < 2; i++) {
    	            for (int j = i + 1; j < 3; j++) {
    	                if (input.charAt(i) == input.charAt(j)) {
    	                    return false;
    	                }
    	            }
    	        }

    	        return true;
    	    }

    	    // 입력 문자열을 숫자 배열로 변환
    	    public static int[] convertToDigits(String input) {
    	        int[] digits = new int[3];
    	        for (int i = 0; i < 3; i++) {
    	            digits[i] = Character.getNumericValue(input.charAt(i));
    	        }
    	        return digits;
    	    }

    	    // 배열에서 특정 숫자가 포함되어 있는지 확인
    	    public static boolean contains(int[] array, int number) {
    	        for (int value : array) {
    	            if (value == number) {
    	                return true;
    	            }
    	        }
    	        return false;
    	    }
    }

