package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.Referee;
import baseball.View.RefereeTerminalOutputView;

public class RefereeController {
    private Referee referee;
    private RefereeTerminalOutputView refereeView;

    public RefereeController(Referee referee, RefereeTerminalOutputView refereeView) {
        this.referee = referee;
        this.refereeView = refereeView;
    }

    private int[] getQueryDecoding(String queryString) {
        int asciiZero = 48;
        int[] query = new int[3];

        try{
            // query의 입력 길이가 3이 아닌 경우의 예외
            if(queryString.length() != 3)
                throw new IllegalArgumentException();
            
            for(int i = 0; i < queryString.length(); ++i) {
                query[i] = queryString.charAt(i) - asciiZero;
                // query의 입력 값이 1~9의 수가 아닌 경우의 예외
                if(query[i] < 1 || query[i] > 9)
                    throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e){
            System.out.println(referee.getExceptionMassage());
        }

        return query;
    }

    public void judge(String queryString, Computer computer) {
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

        if(strikeCount == 0 && ballCount == 0)
            refereeView.displayJudge("낫싱");
        if(ballCount > 0)
            sb.append(ballCount).append("볼 ");
        if(strikeCount > 0)
            sb.append(strikeCount).append("스트라이크 ");

        refereeView.displayJudge(sb.toString());
    }
}
