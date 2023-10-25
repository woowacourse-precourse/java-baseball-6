package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        BaseballGame rightAnswer = new BaseballGame();
        BaseballGame.startBaseballGame(rightAnswer);
    }
}

class BaseballGame{
    int[] randomNumberArr = new int[3];
    BaseballGame() {

        int pickRandomNumber;
        int idx = 0;

        while(idx < 3) {
            pickRandomNumber = pickNumberInRange(1, 9);

            if(checkDuplicationInt(randomNumberArr, pickRandomNumber)) {
                randomNumberArr[idx] = pickRandomNumber;
                idx += 1;
            }
        }
    }

    static boolean checkDuplicationInt(int[] arr, int number) {
        for(int num : arr) {
            if(num == number) {
                return false;
            }
        }
        return true;
    }

    static boolean checkDuplicationChar(char[] arr, char ch) {
        int duplicateNum=0;
        for(char c : arr) {
            if(c == ch) {
                duplicateNum+=1;
            }
        }

        if(duplicateNum==1){
            return true;
        }else{
            return false;
        }
    }

    static void startBaseballGame(BaseballGame correctAnswer){
        //System.out.println(correctAnswer.randomNumberArr[0] +"a"+ correctAnswer.randomNumberArr[1]+"a"+correctAnswer.randomNumberArr[2] );
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = readLine();

        if(BaseballGame.checkInputNumber(inputNumber) == false){
            throw new IllegalArgumentException();
        }

        int strike=0, ball=0;
        strike = calculateStrike(inputNumber, correctAnswer);
        ball = calculateBall(inputNumber, correctAnswer);

        printResult(strike, ball);

        if (strike != 3) {
            BaseballGame.startBaseballGame(correctAnswer);
            return;
        }

        if (BaseballGame.continueBaseballGame()) {
            correctAnswer = new BaseballGame();
            BaseballGame.startBaseballGame(correctAnswer);
        }
    }

    static boolean continueBaseballGame() {
        int inputNum;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String newGameAnswer = readLine();

        try {
            inputNum = Integer.parseInt(newGameAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if(inputNum == 1){
            return true;
        }else if(inputNum == 2){
            return false;
        }else{
            throw new IllegalArgumentException();
        }
    }

    static boolean checkInputNumber(String inputNumber){
        for (char ch: inputNumber.toCharArray()) {
            if (Character.isDigit(ch) == false) {
                return false;
            }
        }

        if(inputNumber.length() != 3){
            return false;
        }

        return true;
    }

    static int calculateStrike(String inputNumber, BaseballGame correctAnswer){
        int strike=0, number, idx=0;
        for (char ch: inputNumber.toCharArray()) {
            number=Character.getNumericValue(ch);

            if(number == correctAnswer.randomNumberArr[idx]){
                strike+=1;
            }
            idx+=1;
        }
        return strike;
    }

    static int calculateBall(String inputNumber, BaseballGame correctAnswer){
        int ball=0, number, idx=0;
        for (char ch: inputNumber.toCharArray()) {
            number=Character.getNumericValue(ch);

            if((number != correctAnswer.randomNumberArr[idx]) && checkDuplicationInt(correctAnswer.randomNumberArr, number)==false){
                ball+=1;
            }
            idx+=1;
        }
        return ball;
    }

    static void printResult(int strike, int ball) {
        if(strike!=0 && ball!=0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }else if(strike!=0){
            System.out.println(strike + "스트라이크");
        }else if(ball!=0){
            System.out.println(ball + "볼");
        }else{
            System.out.println("낫싱");
        }
    }
}

