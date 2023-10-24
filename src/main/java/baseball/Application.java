package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int maxSize = 3;
    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < maxSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
    public static int getStrikes(int[] numbers, int[] randomNumbers) {
        int strikes = 0;
        for (int i = 0; i < maxSize; i++){
            if (numbers[i] == randomNumbers[i]){
                strikes++;
            }
        }
        return strikes;
    }

    public static int getBalls(int[] numbers, int[] randomNumbers){
        int balls = 0;
        for (int i =0; i<maxSize; i++){
            for (int j =0; j<maxSize; j++){
                if (i != j && numbers[i] == randomNumbers[j]){
                    balls++;
                }
            }
        }
        return balls;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        //예외 처리 3자리가 아닌경우
        if (input.length() != maxSize) {
            System.out.println("3자리 숫자를 입력해주세요.");
        }

        int[] numbers = new int[maxSize]; // 플레이어의 추측

        // 문자열의 각 문자를 int로 변환하여 배열에 저장
        for (int i = 0; i < maxSize; i++) {
            // 문자를 숫자로 변환하고 배열에 저장
            numbers[i] = Integer.parseInt(input.substring(i, i + 1));
        }
        System.out.println("Numbers : " + numbers[0] + numbers[1] + numbers[2]);

        //비교할 랜덤한 숫자 3개를 저장할 배열
        int[] randomNumbers = new int[maxSize]; // 컴퓨터가 낸 답

        //generateRandomNumbers를 활용한 랜덤한 숫자 3개를 저장
        for (int i = 0; i < maxSize; i++) {
            randomNumbers[i] = generateRandomNumbers().get(i);
        }

        //게임을 진행하는 과정에서 사용자 입력값과 랜덤값을 비교한다
        int strikes = getStrikes(numbers, randomNumbers);
        int balls = getBalls(numbers, randomNumbers);

        printResult(strikes, balls);

    }

    public static void printResult(int strikes, int balls){
        if (strikes == 0 && balls == 0){
            System.out.println("낫싱");
        } else if (balls == 0) {
            System.out.println(strikes + "스트라이크");
        } else if (strikes == 0) {
            System.out.println(balls + "볼");
        } else {
            System.out.println(balls + " 볼 " + strikes + " 스트라이크");
        }
    }
}
