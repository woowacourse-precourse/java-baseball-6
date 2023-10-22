package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.CountState;
import baseball.Model.Referee;
import baseball.View.RefereeTerminalView;

public class RefereeController {
    private Referee referee;
    private RefereeTerminalView refereeView;

    public RefereeController(Referee referee, RefereeTerminalView refereeView) {
        this.referee = referee;
        this.refereeView = refereeView;
    }

    private void validationIsThreeLength(String queryString) throws IllegalArgumentException {
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

        validationIsThreeLength(queryString);
        for(int i = 0; i < queryString.length(); ++i) {
            query[i] = queryString.charAt(i) - asciiZero;
            validationIsNumber(query[i]);
        }

        return query;
    }

    private CountState getCountState(int[] query, Computer computer) {
        int[] answer = computer.getAnswer();
        boolean[] pickedMap = computer.getPickedMap();
        CountState countState = new CountState();

        for(int i = 0; i < 3; ++i) { 
            if(pickedMap[query[i]]) {
                if(query[i] == answer[i]) countState.countingStrike();
                else countState.countingBall();
            }
        }

        return countState;
    }

    public Boolean judge(String queryString, Computer computer) {
        StringBuilder sb = new StringBuilder();
        int[] query = getQueryDecoding(queryString);
        CountState countState = getCountState(query, computer);

        if(countState.getStrikeCount() == 0 && countState.getBallCount() == 0)
            sb.append("낫싱");
        if(countState.getBallCount() > 0)
            sb.append(countState.getBallCount()).append("볼 ");
        if(countState.getStrikeCount() > 0)
            sb.append(countState.getStrikeCount()).append("스트라이크 ");

        refereeView.displayJudge(sb.toString());
        return (countState.getStrikeCount() == 3);
    }
}
