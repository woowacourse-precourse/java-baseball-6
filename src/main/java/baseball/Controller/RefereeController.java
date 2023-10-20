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

    private int[] getQueryDecoding(String queryString) throws IllegalArgumentException {
        int asciiZero = 48;
        int[] query = new int[3];


        // query의 입력 길이가 3이 아닌 경우의 예외
        if(queryString.length() != 3) {
            refereeView.displayException(referee.getExceptionMassage());
            throw new IllegalArgumentException();
        }
        
        for(int i = 0; i < queryString.length(); ++i) {
            query[i] = queryString.charAt(i) - asciiZero;
            // query의 입력 값이 1~9의 수가 아닌 경우의 예외
            if(query[i] < 1 || query[i] > 9) {
                refereeView.displayException(referee.getExceptionMassage());
                throw new IllegalArgumentException();
            }
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
