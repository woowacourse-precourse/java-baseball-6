package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int maxSize = 3;
    //비교할 랜덤한 숫자 3개를 저장할 리스트
    public static List<Integer> randomNumbers = generateRandomNumbers(); // 컴퓨터가 낸 답
    public static boolean playGame() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        //예외 처리 3자리가 아닌경우
        if (input.length() != maxSize) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        List<Integer> numbers = new ArrayList<>(maxSize); // 플레이어의 추측

        // 문자열의 각 문자를 int로 변환하여 어레이리스트에 저장
        for (int i = 0; i < maxSize; i++) {
            // 문자를 숫자로 변환하고 어레이리스트에 저장
            numbers.add(Integer.parseInt(input.substring(i, i + 1)));
        }

        //게임을 진행하는 과정에서 사용자 입력값과 랜덤값을 비교한다
        int strikes = getStrikes(numbers, randomNumbers);
        int balls = getBalls(numbers, randomNumbers);

        printResult(strikes, balls);
        if (strikes == maxSize) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }
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
    public static int getStrikes(List<Integer> numbers, List<Integer> randomNumbers) {
        int strikes = 0;
        for (int i = 0; i < maxSize; i++){
            if (numbers.get(i).equals(randomNumbers.get(i))){
                strikes++;
            }
        }
        return strikes;
    }

    public static int getBalls(List<Integer> numbers, List<Integer> randomNumbers){
        int balls = 0;
        for (int i =0; i<maxSize; i++){
            for (int j =0; j<maxSize; j++){
                if (i != j && numbers.get(i).equals(randomNumbers.get(i))){
                    balls++;
                }
            }
        }
        return balls;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isContinue = true;
        while(isContinue){
            isContinue = playGame();

            if(!isContinue){
                System.out.println("게임을 다시 시작하시겠습니까? (1: Yes, 2: No)");
                String checkStart = Console.readLine();
                if ("2".equals(checkStart)){
                    System.out.println("게임 종료");
                    break;
                }
                isContinue = true;
            }
        }
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
