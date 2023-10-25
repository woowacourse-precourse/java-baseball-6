package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Bot {
    int[] botNumbers = {0, 0, 0};
    int[] userNumbers = {0, 0, 0};
    Bot(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    int[] generateRandomNumber(int[] botNumbers) {
        for(int i = 0; i < 3; i++){
            botNumbers[i] = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
            for(int j = 0; j < i; j++){
                if(botNumbers[j] == botNumbers[i]){
                    --i;
                    break;
                }
            }
        }
        return botNumbers;
    }
    int[] getAnswer(int[] userNumbers) {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        int tempNumber = Integer.parseInt(userInput);
        if(tempNumber < 100 || tempNumber > 999){
            throw new IllegalArgumentException("알맞은 값을 입력하세요!");
        }

            for(int i = 2; i >= 0; i--){
            userNumbers[i] = tempNumber % 10;
            tempNumber /= 10;
        }
        return userNumbers;
    }
     boolean checkAnswer(int[] botNumbers, int[] userNumbers) {
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++){
                if(botNumbers[i] == userNumbers[j] && i == j)
                    ++strike;
                else if(botNumbers[i] == userNumbers[j] && i != j)
                    ++ball;
            }
        }
        if(ball == 0 && strike == 0)
            System.out.println("낫싱");
        if(ball > 0)
            System.out.print(ball + "볼 ");
        if(strike > 0)
            System.out.println(strike + "스트라이크");
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return false;
        }
        else
            return true;
    }

}
