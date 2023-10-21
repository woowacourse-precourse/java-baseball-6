package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        int inputNumber; //(사용자 입력 숫자)
        int inputFirstNum; //(사용자 입력 수 중 100의 자리 수)
        int inputSecondNum; //(사용자 입력 수 중 10의 자리 수)
        int inputThirdNum; //(사용자 입력 수 중 1의 자리 수)
        int randomNumber; //(랜덤하게 추출된 세자리 숫자)
        int randomFirstNumber; //(100의 자리로 인식할 랜덤한 숫자)
        int randomSecondNumber; //(10의 자리로 인식할 랜덤한 숫자)
        int randomThirdNumber; //(1의 자리로 인식할 랜덤한 숫자)
        int strikeCount = 0; //(스트라이크 횟수)
        int ballCount = 0; //(볼 횟수)

      randomNumber = generateRandomNumber();
      System.out.println("숫자 야구 게임을 시작합니다.");

      while(strikeCount != 3){
      System.out.print("숫자를 입력해주세요 :");
      inputNumber = Integer.parseInt(Console.readLine());
      strikeCount = generateGameGuess(inputNumber, randomNumber);
      }
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static int generateRandomNumber() {
       int tempRandomNum = Randoms.pickNumberInRange(100, 999);

        while(tempRandomNum / 100 == (tempRandomNum / 10) % 10 || (tempRandomNum / 10) % 10 == tempRandomNum % 10 || tempRandomNum % 10 == tempRandomNum / 100) {
            tempRandomNum = Randoms.pickNumberInRange(100, 999);
        }
        return tempRandomNum;
    }

    public static int generateGameGuess(int inputNumber, int randomNumber) {
        int strikeCount = 0; int ballCount = 0;
        int[] inputArray = {inputNumber / 100, (inputNumber / 10) % 10, inputNumber % 10};
        int[] randomArray = {randomNumber / 100, (randomNumber / 10) % 10, randomNumber % 10};
        for(int i : randomArray){
            if(inputArray[i] == randomArray[i]) {strikeCount++;}
            else if (ballCounter(randomArray, inputArray[i])) {ballCount++;}
        }
        if(strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        else if(strikeCount == 0 && ballCount > 0){
            System.out.printf("%d볼", ballCount);
        }
        else if(strikeCount > 0 && ballCount == 0){
            System.out.printf("%d스트라이크", strikeCount);
        }
        else {
            System.out.printf("%d볼 %d스트라이크", ballCount, strikeCount);
        }
        return strikeCount;
    }
    public static boolean ballCounter(int[] randomArray, int inputValue) {
        for (int i : randomArray) {
            if (i == inputValue) {
                return true;
            }
        }
        return false;
    }
}
