package baseball;

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
        int strikeCount, ballCount; //(스트라이크, 볼 횟수)

      randomNumber = generateRandomNumber();
    }
    public static int generateRandomNumber() {
       int tempRandomNum = Randoms.pickNumberInRange(100, 999);

        while(tempRandomNum / 100 == (tempRandomNum / 10) % 10 || (tempRandomNum / 10) % 10 == tempRandomNum % 10 || tempRandomNum % 10 == tempRandomNum / 100) {
            tempRandomNum = Randoms.pickNumberInRange(100, 999);
        }
        return tempRandomNum;
    }
}
