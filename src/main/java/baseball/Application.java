package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            int[] userNum = new int[3];
            int[] answerNum = new int[3];
            int[] result;

            generateAnswer(answerNum);

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true){
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                validateInput(input, userNum);

                result = compareNum(userNum, answerNum);
                int strikes = result[0];
                int balls = result[1];

                if (strikes == 3) {
                    System.out.println("3스트라이크! 게임 종료");
                    if (!askForRestart()) {
                        break;
                    }else{
                        generateAnswer(answerNum);
                        continue;
                    }
                }

                if (strikes == 0 && balls == 0) {
                    System.out.println("낫싱");
                } else {
                    if (balls > 0) {
                        System.out.printf("%d볼 ", balls);
                    }
                    if (strikes > 0) {
                        System.out.printf("%d스트라이크", strikes);
                    }
                }
            }
        }catch(IllegalArgumentException e){
            // 그냥 프로그램 종료
        }finally{
            Console.close();
        }

    }

    private static boolean askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return switch (input) {
            case "1" -> true;
            case "2" -> false;
            default -> throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
        };
    }

    private static int[] compareNum(int[] userNum, int[] answerNum) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < userNum.length; i++) {
            if (userNum[i]==answerNum[i]) {
                strikes++;
            } else {
                int finalI = i;
                if (Arrays.stream(answerNum).anyMatch(n -> n == userNum[finalI])) {
                    balls++;
                }
            }
        }
        return new int[]{strikes, balls};
    }

    private static void generateAnswer(int[] answerNum) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        int idx = 0;
        for (Integer num : uniqueNumbers) {
            answerNum[idx++] = num;
        }
    }

    private static void validateInput(String input, int[] userNum) throws IllegalArgumentException {
        validateInputLength(input);
        makeUserNum(input, userNum);
        validateUserNumDuplicates(userNum);
    }

    private static void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
    }

    private static void makeUserNum(String input, int[] userNum) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
            userNum[i] = Character.getNumericValue(c);
        }
    }

    private static void validateUserNumDuplicates(int[] userNum) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : userNum) {
            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다.");
            }
        }
    }
}
