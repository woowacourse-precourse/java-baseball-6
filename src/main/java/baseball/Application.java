package baseball;

import java.security.PrivateKey;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game rightAnswer = new Game();
        Game.start(rightAnswer);

    }
}

class Game {
    static private String INSERT_BLOCK = "숫자를 입력해주세요 : ";
    static private String GAME_START_COMMENT ="숫자 야구 게임을 시작합니다.";
    int[] answer = new int[3];

    Game() {
        System.out.println(GAME_START_COMMENT);
        int numberCount =0;
        while (numberCount<3) {
            int randomNumber = pickNumberInRange(1, 9);

            if (Game.checkNum(randomNumber, answer)) {
                answer[numberCount] = randomNumber;
                numberCount++;
            }


        }
        for (int j = 0; j < 3; j++) {
            System.out.println(answer[j]);
        }

    }

    Game(String input) {
        for (int i = 0; i < answer.length; i++) {
            answer[i]= Integer.parseInt(input.charAt(i)+"");
        }
    }

    static void start(Game rightAnswer) {
        Game answer =Game.insert();
        Game.checkAnswer(answer,rightAnswer);

    }

    static Game insert() {

        System.out.print(INSERT_BLOCK);
        String input = readLine();

        return new Game(input);
    }
    static void checkAnswer(Game answer,Game rightAnswer){
        int ballCount=0;
        int strikeCount=0;
        String nothing="낫싱";
        String stringAnswer =Array.makeArrayToString(answer.answer);
        System.out.println(stringAnswer);
        String stringRightAnswer=Array.makeArrayToString(rightAnswer.answer);
        System.out.println(stringRightAnswer);
        for (int i = 0; i < stringRightAnswer.length(); i++) {
            for (int j = 0; j <stringAnswer.length(); j++) {
                if(stringRightAnswer.charAt(i)==stringAnswer.charAt(j)){
                    if(i==j) {
                        strikeCount++;
                    }
                    if (i!=j) {
                        ballCount++;
                    }

                }
            }
        }
        if(strikeCount>0 && ballCount>0){
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
            Game.start(rightAnswer);
        }
        if(strikeCount==0 && ballCount>0){
            System.out.println(ballCount+"볼");
            Game.start(rightAnswer);
        }
        if(strikeCount>0 && ballCount==0){
            System.out.println(strikeCount+"스트라이크");
            Game.start(rightAnswer);
        }
        if(strikeCount == 3){
            System.out.println(strikeCount+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            Game.newGameSelection();
        }
        if(strikeCount==0 && ballCount==0) {
            System.out.println(nothing);
            Game.start(rightAnswer);
        }

    }
    static void newGameSelection(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String selection = readLine();
    }
    static boolean checkNum(int a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] == a) {
                return false;
            }

        }
        return true;
    }
    static void checkRightInput(String a) {
        try{

                int value=Integer.parseInt(a);


        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

    }

    static boolean checkNoZero(String a){
        for (int i = 0; i <a.length() ; i++) {
            if(a.contains("0")){
                return false;
            }
        }
        return true;
    }
}

class Array{
    static String makeArrayToString(int[] a){
        String result = "";


        for (int i = 0; i <a.length ; i++) {
            result = result + a[i];
        }
        return result;
    }
}
