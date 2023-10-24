package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static boolean inputExpt(String num, int numLength) { // 입력값 예외 처리
        if (num.length() != 3) {
            return true; // 입력 받은 값의 길이가 3이 아닐 경우
        }

        for (int i = 0; i < numLength; i++) { // 입력 받은 값이 숫자가 아닐 경우
            char c = num.charAt(i);
            if (c < '1' || c > '9') {
                return true;
            }
        }

        for (int i = 0; i < numLength - 1; i++) { // 서로 다른 숫자가 아닐 경우
            for (int j = i + 1; j < numLength; j++) {
                if (num.charAt(i) == num.charAt(j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int[] processBaseball(String num, java.util.List<Integer> randNum, int numLength) {
        int[] result = {0, 0}; // 볼, 스트라이크

        for (int i = 0; i < numLength; i++) {
            int userNum = Character.getNumericValue(num.charAt(i));

            if (userNum == randNum.get(i)) { // 스트라이크 개수
                result[1]++;
                continue;
            }

            for (int j = 0; j < numLength; j++) { // 볼 개수
                if (userNum == randNum.get(j)) {
                    result[0]++;
                }
            }
        }

        return result;
    }

    public static boolean exitGame(int[] result, int numLength) {
        if (result[1] == numLength) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            String process = String.format("%d 볼 %d 스트라이크", result[0], result[1]);
            System.out.println(process);
        }
        return false;
    }

    public static <List> void main(String[] args) {
        int numLength = 3; // 입력 값의 길이
        String exit = "0";

        System.out.println("숫자 야구 게임을 시작합니다.");

        java.util.List<Integer> randNum = Randoms.pickUniqueNumbersInRange(1, 9, numLength);

        while (!exit.equals("2")) {
            if (exit.equals("1")) {
                randNum = Randoms.pickUniqueNumbersInRange(1, 9, numLength);
                exit = "0";
            }

            System.out.print("숫자를 입력해주세요 : ");
            String num = Console.readLine();

            if (inputExpt(num, numLength)) {
                throw new IllegalArgumentException("입력 오류 발생!");
            }

            int[] result = processBaseball(num, randNum, numLength); // 볼 스트라이크

            if (exitGame(result, numLength)) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                exit = Console.readLine();
            }
        }
    }
}
