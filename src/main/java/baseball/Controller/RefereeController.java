package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.Referee;
import baseball.View.RefereeTerminalView;

public class RefereeController {
    private Referee referee;
    private RefereeTerminalView refereeView;

    public RefereeController(Referee referee, RefereeTerminalView refereeView) {
        this.referee = referee;
        this.refereeView = refereeView;
    }

    private void validationisThreeLength(String queryString) throws IllegalArgumentException {
        if(queryString.length() != 3) {
            refereeView.displayException(referee.getExceptionMassage());
            throw new IllegalArgumentException();
        }
    }

    private void validationIsNumber(int n) throws IllegalArgumentException {
        if(n < 1 || n > 9) {
            refereeView.displayException(referee.getExceptionMassage());
            throw new IllegalArgumentException();
        }
    }

    private int[] getQueryDecoding(String queryString) {
        int asciiZero = 48;
        int[] query = new int[3];

        validationisThreeLength(queryString);
        for(int i = 0; i < queryString.length(); ++i) {
            query[i] = queryString.charAt(i) - asciiZero;
            validationIsNumber(query[i]);
        }

        return query;
    }

    public Boolean judge(String queryString, Computer computer) {
        int strikeCount = 0;
        int ballCount = 0;
        int[] query = getQueryDecoding(queryString);
        int[] answer = computer.getAnswer();
        boolean[] pickedMap = computer.getPickedMap();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; ++i) { 
            if(pickedMap[query[i]]) {
                if(query[i] == answer[i]) ++strikeCount;
                else ++ballCount;
            }
        }

        if(strikeCount == 0 && ballCount == 0) {
            refereeView.displayJudge("낫싱");
            return false;
        }
        if(ballCount > 0)
            sb.append(ballCount).append("볼 ");
        if(strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크 ");
            // 3스트라이크에 대한 종료 flag
            if(strikeCount == 3) {
                refereeView.displayJudge(sb.toString());
                return true;
            }
        }

        refereeView.displayJudge(sb.toString());
        return false;
    }
}
