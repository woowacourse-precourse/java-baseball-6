package baseball;

import static baseball.constant.PrintMessage.ASK_RETRY_GAME_MESSAGE;
import static baseball.constant.PrintMessage.BALL;
import static baseball.constant.PrintMessage.GAME_START_MESSAGE;
import static baseball.constant.PrintMessage.INPUT_NUMBER_MESSAGE;
import static baseball.constant.PrintMessage.NO_MATCHING;
import static baseball.constant.PrintMessage.STRIKE;
import static baseball.constant.PrintMessage.SUCCESS_GAME_MESSAGE;

import baseball.dto.StrikeBallCnt;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        List<Integer> answerNumber = createAnswerNumber();

        String input;
        while (!isEnd){
            print(INPUT_NUMBER_MESSAGE);
            input = br.readLine();
            checkValidNumber(input);
            StrikeBallCnt result = getResult(input, answerNumber);
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

    private static StrikeBallCnt getResult(String input, List<Integer> answer) {
        int strikeCnt = 0;
        int ballCnt = 0;

        char[] chars = input.toCharArray();
        for (int i = 0; i < 3; i++) {
            if(chars[i] - '0' == answer.get(i)){
                strikeCnt += 1;
            }else if(answer.contains(chars[i] - '0')){
                ballCnt += 1;
            }
        }

        return new StrikeBallCnt(strikeCnt, ballCnt);

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

    private static void checkValidNumber(String input) {
        if(input.length() != 3){
            throw new IllegalArgumentException(NOT_VALID_NUMBER);
        }
        Integer.parseInt(input);
    }

    private static List<Integer> createAnswerNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

}
