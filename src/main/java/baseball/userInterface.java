package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class userInterface {
    final static String startPhrases="숫자 야구 게임을 시작합니다.";
    final static String inputPhrases="숫자를 입력해주세요 : ";
    final static String endPhrases="개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final static String restartChoicePhrases="게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.";
    final static String ballPhrases="볼";
    final static String strikePhrases="스트라이크";
    final static String nothingPhrases="낫싱";
    final static int endGameChoice=2;
    final static int restartChoice=1;
    public static List<Integer> userInputNumber;

    public static void startWrite(){
        System.out.println(startPhrases);
    }

    public static void inputWrite(){
        System.out.print(inputPhrases);
    }

    public static void endWrite(int listSize){
        System.out.println(listSize+endPhrases);
    }

    public static void choiceWrite(){
        System.out.println(String.format(restartChoicePhrases, restartChoice, endGameChoice));
    }

    public static void stringArrayToIntArray(String[] input){
        List<Integer> input_int = new ArrayList<>();
        for(String num:input){
            input_int.add(Integer.parseInt(num));
        }
        userInputNumber=input_int;
    }

    public static void userInput(){
        String[] input= Console.readLine().split("");
        if(inputExeption.isUnigueInput(input) && inputExeption.isDigitNumber(input)){
            stringArrayToIntArray(input);
        }
    }

    public static int choiceGame() {
        choiceWrite();
        String re_game=Console.readLine();
        inputExeption.isOneAndTwoNumber(re_game);
        return Integer.parseInt(re_game);
    }

    public static int checkUserGuess(int[] userGuess){
        int ball=userGuess[0];
        int strike=userGuess[1];

        if(strike==BaseballGame.listSize){
            System.out.println(strike+strikePhrases);
            endWrite(BaseballGame.listSize);
            return choiceGame();
        }
        if(strike==0 && ball==0){
            System.out.println(nothingPhrases);
        } else if(strike!=0 && ball!=0){
            System.out.println(ball+ballPhrases+" "+ strike+strikePhrases);
        }else if(strike==0 && ball!=0){
            System.out.println(ball+ballPhrases);
        }else{
            System.out.println(strike+strikePhrases);
        }
        return 0;
    }
}
