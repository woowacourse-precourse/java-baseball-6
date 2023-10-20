package baseball.distinguishnumber;

import java.util.List;

public class distinguishNum implements Distinguish{

    @Override
    public String distinguish(List<Integer> answer, List<Integer> user){
        int strikeCount = 0;
        int ballCount = 0;

        for(int i = 0; i<user.size(); i++){
            if(checkStrike(answer.get(i), user.get(i))){
                strikeCount++;
                continue;
            }
            if(checkBall(answer, user.get(i))) {
                ballCount++;
            }
        }

        return makeString(strikeCount, ballCount);
    }

    private boolean checkStrike(int answer, int user){
        return answer == user;
    }

    private boolean checkBall(List<Integer> answer, int user){
        return answer.contains(user);
    }

    @Override
    public String makeString(int strike, int ball){
        if(strike == 0 && ball == 0) return "낫싱";
        else if(strike != 0 && ball == 0)return strike + "스트라이크";
        else if(strike == 0)return ball + "볼";
        return ball + "볼" + strike + "스트라이크 ";
    }
}
