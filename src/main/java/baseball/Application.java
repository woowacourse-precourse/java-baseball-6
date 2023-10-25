package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int choice=1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            if (choice == 2) {
                System.out.println("게임을 완전히 종료합니다.");
                return;
            } else {
                startGame();
            }
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");

            choice = Integer.parseInt(Console.readLine());
        }
    }

    public static void startGame() {
        // 랜덤 숫자 생성.
        int uniqueRandomNumber = generateUniqueRandomNumber(1, 9, 3);
        System.out.println("상대방의 수: " + uniqueRandomNumber);
        int userNumber;
        String number;

        while (true) {
            do {
                System.out.print("숫자를 입력해 주세요 : ");
                number = Console.readLine();
                userNumber= Integer.parseInt(number);
            } while (!isValidInput(userNumber));


            int strikes = 0;
            int balls = 0;
            String computerNumber= String.valueOf(uniqueRandomNumber);

            for (int i = 0; i < 3; i++) {
                if (number.charAt(i) == computerNumber.charAt(i)) {
                    strikes++;
                } else if (computerNumber.contains(String.valueOf(number.charAt(i)))){
                    balls++;
                }
            }

            if (strikes == 3) {
                System.out.println("스트라이크 3! 게임 종료!");
                break;
            }
            if (balls > 0) {
                System.out.println(balls + "볼 ");
            }
            if (strikes > 0) {
                System.out.println(strikes + "스트라이크 ");
            }
            if (balls == 0 && strikes == 0) {
                System.out.println("낫싱");
            }
        }

    }

    public static int generateUniqueRandomNumber(int start, int end, int count) {
        int result = 0;
        Set<Integer> uniqueNumbers = new HashSet<>();

        //set을 이용해 중복 제거
        while (uniqueNumbers.size() < count) {
            int uniqueNumber = Randoms.pickNumberInRange(start, end);
            uniqueNumbers.add(uniqueNumber);
        }
        for (int number : uniqueNumbers) {
            result = result * 10 + number;
        }

        return result;
    }

    public static boolean isValidInput(int number) {
        String numberStr = Integer.toString(number);

        if (numberStr.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }

        if (numberStr.charAt(0) == numberStr.charAt(1) ||
                numberStr.charAt(1) == numberStr.charAt(2) ||
                numberStr.charAt(0) == numberStr.charAt(2)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        }

        return true;
    }

}
