package baseball;

import java.util.List;

public class Decision {

    public int countStrike(List<Integer> userNum, List<Integer> answer) {
        int strikeCount = 0;

        for(int i=0; i<3; i++) {
            if(userNum.get(i).equals(answer.get(i))) strikeCount++;
        }
        return strikeCount;
    }

    public int countBall(List<Integer> userNum, List<Integer> answer) {
        int ballCount = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if((i!=j) & (answer.get(i).equals(userNum.get(j)))) ballCount++;
            }
        }
        return ballCount;
    }

    public void referee(int strikeCount, int ballCount) {
        if((strikeCount > 0) & (ballCount > 0)) System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        else if((strikeCount > 0) & (ballCount < 1)) System.out.println(strikeCount + "스트라이크");
        else if ((ballCount > 0) & (strikeCount < 1)) System.out.println(ballCount + "볼");
        else System.out.println("낫싱");
    }

}
