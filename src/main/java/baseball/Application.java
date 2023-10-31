package baseball;

import static baseball.constant.PrintMessage.ASK_RETRY_GAME_MESSAGE;
import static baseball.constant.PrintMessage.BALL;
import static baseball.constant.PrintMessage.GAME_START_MESSAGE;
import static baseball.constant.PrintMessage.INPUT_NUMBER_MESSAGE;
import static baseball.constant.PrintMessage.NO_MATCHING;
import static baseball.constant.PrintMessage.STRIKE;
import static baseball.constant.PrintMessage.SUCCESS_GAME_MESSAGE;

import baseball.domain.BaseBallGame;
import baseball.dto.StrikeBallCnt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    static BufferedReader br;
    static boolean isEnd;
    static final String NOT_VALID_NUMBER = "3자리의 숫자만 입력 가능합니다.";

    public static void main(String[] args){
        br = new BufferedReader(new InputStreamReader(System.in));
        isEnd = false;
        println(GAME_START_MESSAGE);

        try {
            baseballGame();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    private static void baseballGame() throws IOException {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.createAnswerNumber();

        String input;
        while (!isEnd){
            print(INPUT_NUMBER_MESSAGE);
            input = br.readLine();
            if(!baseBallGame.isValidNumber(input)){
                throw new IllegalArgumentException(NOT_VALID_NUMBER);
            }
            StrikeBallCnt result = baseBallGame.getResult(input);
            printResult(result);
        }

        if(isRetry()){
            isEnd = false;
            baseballGame();
        }

    }

    private static boolean isRetry() throws IOException {
        println(ASK_RETRY_GAME_MESSAGE);
        return br.readLine().equals("1");
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void printResult(StrikeBallCnt strikeBallCnt) {
        int strikeCnt = strikeBallCnt.getStrikeCnt();
        int ballCnt = strikeBallCnt.getBallCnt();

        if (ballCnt > 0){
            print(ballCnt + BALL + " ");
        }
        if (strikeCnt > 0){
            println(strikeCnt + STRIKE);
        }

        if(strikeCnt == 0 && ballCnt == 0){
            println(NO_MATCHING);
        }
        if(strikeCnt == 3){
            isEnd = true;
            println(SUCCESS_GAME_MESSAGE);
        }

    }

}
