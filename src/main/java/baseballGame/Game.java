package baseballGame;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

import static constant.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Game {
    List<Integer> answer = new ArrayList<>();

    public Game() {
        for (int i = 0; i < 3; i++) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (answer.contains(randomNumber));
            answer.add(randomNumber);
        }
    }

    public static void run(){
        Game game; // game 객체 생성
        do {
            RESULT = false;
            game = new Game();
            game.gameStart();
        }while(game.restart());
    }
    private void gameStart(){

        do {
            List<Integer> myAnswer = new ArrayList<>(); // 내가 유추한 정답
            System.out.print(INPUT_NUMBER);
            String inputString = Console.readLine();

            for (int i = 0; i < inputString.length(); i++) {
                if(inputString.charAt(i) < '0' || inputString.charAt(i) > '9'){
                    throw new IllegalArgumentException(WRONG_INPUT_TYPE);
                }
                char charAtIndex = inputString.charAt(i);
                int intAtIndex = Character.getNumericValue(charAtIndex);
                if (!myAnswer.contains(intAtIndex)) { // 중복 예외 처리
                    myAnswer.add(intAtIndex);
                }
            }
            int[] hintArr = new int[3];
            hint(myAnswer, hintArr);
            printScore(hintArr);
        }while(!RESULT);

    }

    private void printScore(int[] hintArr){
        if(hintArr[1] == 3){
            System.out.println(hintArr[1] + STRIKE);
//            System.out.println(STRIKE);
            System.out.println(GAME_FINISH);
            RESULT = true;
        }
        else if(hintArr[0] == 0 && hintArr[1] != 0){
            System.out.println(hintArr[1] + STRIKE);
        }
        else if(hintArr[1] == 0 && hintArr[0] != 0){
            System.out.println(hintArr[0] + BALL);
        }
        else if (hintArr[2] == 3) {
            System.out.println(NOTHING);
        }
        else {
            System.out.println(hintArr[0] + BALL + " " + hintArr[1] + STRIKE);
        }
    }
    private void hint(List<Integer> List, int[] hintArr){ // 볼, 스트라이크, 낫싱 횟수 배열에 넣어주는 함수
        if(List.size() != answer.size()){
            throw new IllegalArgumentException(WRONG_INPUT_LENGTH_ERROR);
        }
        for (int i = 0; i < List.size(); i++){
            if(List.get(i).equals(answer.get(i))){
                hintArr[1]++; // strike
//                System.out.println("hint[1] : " + hintArr[1]);
            }
            else if(answer.contains(List.get(i))){
                hintArr[0]++; // ball
//                System.out.println("hint[0] : " + hintArr[0]);
            }
            else{
                hintArr[2]++; // nothing
//                System.out.println("hint[2] : " + hintArr[2]);
            }
        }

    }

    private boolean restart() {
        System.out.println(GAME_RESTART);
        String restartString = Console.readLine();
        int restartNum = 0;
        // string을 정수로 바꿈.
        try {
            restartNum = Integer.parseInt(restartString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (restartNum == 1) {
            GAME_RESTART_BOOL = true;
        } else if (restartNum == 2) {
            GAME_RESTART_BOOL = false;
        } else {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR);
        }
        return GAME_RESTART_BOOL;
    }
}

