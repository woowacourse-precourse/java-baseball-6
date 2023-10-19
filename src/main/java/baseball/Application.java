package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

// Number-Baseball Game
public class Application {

    public static void main(String[] args) {

        // start game
        System.out.println("숫자 야구 게임을 시작합니다.");

        // setting for new game
        boolean correct = false;
        String inputStr = "";
        String answerStr = makeRandomThreeNumber();

        // game
        while (true) {

            // 1. Get three number
            inputStr = getUserInput();

            // 2. Get round's result & Print result
            correct = calculateRoundResult(answerStr, inputStr);

            // 3. If correct, Ask if play continuous
            if (correct) {

                askNextGame();

                int cont = Integer.parseInt(Console.readLine());
                if (cont == 1) {            // if 1, set the new game
                    correct = false;
                    answerStr = makeRandomThreeNumber();
                } else if (cont == 2) {     // if 2, break the loop
                    break;
                } else {                    // else, IllegalArgumentException
                    throw new IllegalArgumentException("잘못 입력했습니다.");
                }

            }
        }

    }

    private static String getUserInput(){

        String userInput = "";

        System.out.print("숫자를 입력해주세요 : ");

        // get user input : three different number
        try {
            int inputInt = Integer.parseInt(Console.readLine());
            userInput = Integer.toString(inputInt);
        } catch (IllegalArgumentException e){
            System.out.println(e + " 입력 오류가 발생했습니다. 종료합니다.");
        }
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력 오류가 발생했습니다.");
        }

        return userInput;
    }

    private static boolean calculateRoundResult(String answerStr, String inputStr){
        boolean correct = false;

        // function for Strike-Ball-Nothing
        String roundResult = judgeScore(answerStr, inputStr);
        if (inputStr.equals(answerStr)) {
            correct = true;
        }

        // print result
        System.out.println(roundResult);

        return correct;
    }

    private static String judgeScore(String answerStr, String inputStr){
        int strike = 0;
        int ball = 0;

        for (int i=0; i<answerStr.length(); i++) {
            // strike > ball > nothing
            String answerChar = answerStr.substring(i, i+1);
            String inputChar = inputStr.substring(i, i+1);

            // judge whether strike
            if (answerChar.equals(inputChar)) {
                strike += 1;
            } else if (inputStr.contains(answerChar)) {
                ball += 1;
            }
        }

        if (strike == 0 && ball == 0){
            return "낫싱";
        } else if (strike == 0) {
            return ball+"볼";
        } else if (ball == 0) {
            return strike+"스트라이크";
        } else {
            return ball+"볼 "+strike+"스트라이크";
        }
    }

    private static void askNextGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static String makeRandomThreeNumber(){

        // make the all Three Random Number Different
        String threeNums = "";
        while (threeNums.length() != 3) {
            String tmp = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!threeNums.contains(tmp)) {
                threeNums += tmp;
            }
        }
        return threeNums;
    }

}
