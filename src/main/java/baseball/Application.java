package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //사용자 입력 받기
        Game game = new Game();
    }
}

class RandomNumberGenerator{
    public static int generate() {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(100, 1000);
        } while (!isDistinct(randomNumber));
        return randomNumber;
    }

    //세 자리가 모두 다른 숫자인지 확인하는 함수
    public static boolean isDistinct(int randomNumber){
        int hundred = randomNumber / 100;
        int ten = (randomNumber / 10) % 10;
        int one = randomNumber % 10;
        return (hundred != ten) && (hundred != one) && (one != ten);
    }
}

class Game{
    int answer;
    int[] answerDigits;
    Game(){
        answer = RandomNumberGenerator.generate();
    }

    // 사용자가 제시한 숫자를 평가하는 함수
    public String evaluation(int inputNumber) {
        return "";
    }
}