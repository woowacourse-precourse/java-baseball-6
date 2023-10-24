package baseball.service;

import baseball.view.Message;
import baseball.utils.Random;
import baseball.utils.UserNumList;

import camp.nextstep.edu.missionutils.Console;

public class GameService {
    static int strike = 0;
    static int ball = 0;
    public static int[] GameSettings() {
        Message.printGameStart();
        int[] RandomNumber = Random.getRandom();
        return RandomNumber;
    }



    public static void Play(int[] RandomNumber) throws IllegalArgumentException{
        while (strike != 3) {
            int[] UserInputList = getUserNumber();
            strike = 0;
            ball = 0;
            getScore(UserInputList, RandomNumber);
            Message.printScores(strike, ball);
        }
        strike = 0;
        ball = 0;
    }


    private static int[] getUserNumber() throws IllegalArgumentException{
        Message.requestInputNum();
        String input = Console.readLine();
        return UserNumList.UserInputList(input);
    }


    // 점수 계산을 위한 함수
    private static void getScore(int[] UserInputList, int[] RandomNumber){
        for(int i = 0; i < 3 ; i++) {
            compute(UserInputList, RandomNumber, i);
        }
    }

    private static void compute(int[] UserInputList, int[] RandomNumber, int index) {
        int flag = -1;
        for (int i = 0 ; i < 3; i++) {
            if (RandomNumber[i] == UserInputList[index]) {
                flag = i;
                break;
            }
        }
        ballOrStrike(index, flag);
    }

    private static void ballOrStrike(int index, int flag){
        if (index == flag) {
            strike += 1;
        }
        if (index != flag && flag != -1) {
            ball += 1;
        }
    }

}
