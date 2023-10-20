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

            // 입력한 3자리 문자열(사실 숫자) 하나씩 순회하면서 myAnswer 배열에 추가해줌
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
            // todo

        }while(!RESULT);

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

