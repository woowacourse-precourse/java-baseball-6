package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        int inputNumber; //(사용자 입력 숫자)
        int randomNumber; //(랜덤하게 추출된 세자리 숫자)
        int strikeCount = 0; //(스트라이크 횟수)
        int inputRestart = 1; //(게임 재시작 입력 숫자)

      System.out.println("숫자 야구 게임을 시작합니다.");
      while (inputRestart == 1) {
          randomNumber = generateRandomNumber();
          while (strikeCount != 3) {
              System.out.println("숫자를 입력해주세요 :");
              inputNumber = Integer.parseInt(Console.readLine());
              strikeCount = generateGameGuess(inputNumber, randomNumber);
          }
          System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
          System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
          inputRestart = Integer.parseInt(Console.readLine());
      }
    }
    public static int generateRandomNumber() {
        int firRandom = Randoms.pickNumberInRange(1, 9);
        int secRandom = Randoms.pickNumberInRange(1, 9);
        while (firRandom == secRandom){
            secRandom = Randoms.pickNumberInRange(1, 9);
        }
        int thiRandom = Randoms.pickNumberInRange(1, 9);
        while (thiRandom == secRandom || thiRandom == firRandom){
            thiRandom = Randoms.pickNumberInRange(1, 9);
        }

        return firRandom + secRandom*10 + thiRandom*100;
    }

    public static int generateGameGuess(int inputNumber, int randomNumber) {
        int strikeCount = 0; int ballCount = 0;
        int[] inputArray = {inputNumber / 100, (inputNumber / 10) % 10, inputNumber % 10};
        int[] randomArray = {randomNumber / 100, (randomNumber / 10) % 10, randomNumber % 10};
        for(int i = 0; i < 3; i++){ //향상된 for문 사용 시 해당 배열의 내부 값을 제시함, 인덱싱으로 사용 부적합
            if(inputArray[i] == randomArray[i]) {strikeCount++;}
            else if (ballCounter(randomArray, inputArray[i])) {ballCount++;}
        }
        if(strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        else if(strikeCount == 0 && ballCount > 0){
            System.out.printf("%d볼\n", ballCount);
        }
        else if(strikeCount > 0 && ballCount == 0){
            System.out.printf("%d스트라이크\n", strikeCount);
        }
        else {
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
        }
        return strikeCount;
    }
    public static boolean ballCounter(int[] randomArray, int inputValue) {
        for (int i : randomArray) {//randomArray배열의 값을 인덱싱으로 하기에 향상된 for문 사용 적합
            if (i == inputValue) {
                return true;
            }
        }
        return false;
    }
}
