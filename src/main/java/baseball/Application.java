package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> pickNumbers = new ArrayList<>();
        int[] num = new int[3];
        int countStrike = 0, countBall = 0;
        boolean isCorrect = false, isContinue = false;

        // TODO: 랜덤값 생성하기 - 3개의 다른 수
        generateRandomNumbers(pickNumbers);

        // TODO: 문구 출력
        printStartState();

        // TODO : 반복문 내에서
        while (true){
            countBall = 0;
            countStrike = 0;

            // TODO: 입력
            getUserNumbers(num);

            // TODO: 프로그램 구현
            for (int i = 0; i < 3; i++) {
                // 개수
                if (pickNumbers.contains(num[i])) {
                    countBall += 1;
                }
                // 위치
                if (pickNumbers.get(i) == num[i]) {
                    countBall -= 1;
                    countStrike += 1;
                }
            }

            // TODO: 출력
            isCorrect = getResult(countBall, countStrike);

            if (isCorrect) {
                printEndState();
                pickNumbers.clear();
                isContinue = getUserContinue();

                if (isContinue) {
                    generateRandomNumbers(pickNumbers);
                } else {
                    break;
                }
            }

        }
    }

    private static void generateRandomNumbers(List<Integer> numbers) {
        while (numbers.size() < 3){
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(pickNumber)){
                numbers.add(pickNumber);
            }
        }
    }

    private static void printEndState() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static boolean getResult(int countBall, int countStrike) {
        if (countBall != 0)
            System.out.print(countBall +"볼 ");
        if (countStrike != 0)
            System.out.println(countStrike +"스트라이크");
        else System.out.println();

        if (countBall == 0 && countStrike == 0)
            System.out.println("낫싱");
        if (countStrike == 3) return true;
        else return false;
    }

    private static void getUserNumbers(int[] num) {
        System.out.print("숫자를 입력해주세요 : ");
        String snum = Console.readLine();
        for (int i = 0 ; i < 3 ; i++) {
            num[i] = snum.charAt(i)-'0';
        }
    }

    private static boolean getUserContinue() {
        int val = Console.readLine().charAt(0)-'0';
        boolean result = false;
        switch (val) {
            case 1:
                result = true;
                break;
            case 2:
                result = false;
                break;
        }
        return result;
    }

    private static void printStartState() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
