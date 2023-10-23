package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        //예외 처리 3자리가 아닌경우
        if (input.length() != 3) {
            System.out.println("3자리 숫자를 입력해주세요.");
        }

        int[] numbers = new int[3];

        // 문자열의 각 문자를 int로 변환하여 배열에 저장
        for (int i = 0; i < 3; i++) {
            // 문자를 숫자로 변환하고 배열에 저장
            numbers[i] = Integer.parseInt(input.substring(i, i + 1));
        }
        System.out.println("Numbers : " + numbers[0] + numbers[1] + numbers[2]);

        //비교할 랜덤한 숫자 3개를 저장할 배열
        int[] randomNumbers = new int[3];

        //generateRandomNumbers를 활용한 랜덤한 숫자 3개를 저장
        for (int i = 0; i < 3; i++) {
            randomNumbers[i] = generateRandomNumbers().get(i);
        }
        System.out.println("Random Numbers: " + randomNumbers[0] + randomNumbers[1] + randomNumbers[2]);

        //게임을 진행하는 과정에서 사용자 입력값과 랜덤값을 비교한다




    }
}
