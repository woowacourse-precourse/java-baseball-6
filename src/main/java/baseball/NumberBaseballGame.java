package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    AnswerMaker answerMaker = new AnswerMaker();
    Message message = new Message();
    List<Integer> answer = new ArrayList<>();
    public void speaker(String message) {
        System.out.print(message);
    }

    public void play() {
        boolean gameStatus = true;
        while (gameStatus) {
            speaker(message.startMessage());
            answer = answerMaker.makeThreeDifferentNumberList(1, 9); // 정답 생성
            oneRound(); // 하나의 라운드가 끝나면 재시작 여부 묻기
            speaker(message.restartOrStopMessage());
            String startOrStop = userInput.getUserAnswer();
        }
    }

    public void oneRound() {
        boolean threeStrike = false;
        while (!threeStrike) {
            speaker(message.requestNumberMessage());
            List<Integer> userNumbers = userInput.inputToThreeNumbers();
            speaker(message.scoreMessage());
        }
    }
}
