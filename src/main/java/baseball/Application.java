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

            generateAnswer(answerNum);

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true){
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                validateInput(input, userNum);
            }
        }catch(IllegalArgumentException e){
            // 그냥 프로그램 종료
        }finally {
            Console.close();
        }
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
