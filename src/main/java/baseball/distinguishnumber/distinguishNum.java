package baseball.distinguishnumber;

import baseball.data.Data;

import java.util.List;

public class distinguishNum implements Distinguish{

    private Data data;

    public distinguishNum(Data data) {
        this.data = data;
    }

    @Override
    public void distinguish(List<Integer> answer, List<Integer> user){

        for(int i = 0; i<user.size(); i++){
            if(checkStrike(answer.get(i), user.get(i))){
                data.setStrike();
                continue;
            }
            if(checkBall(answer, user.get(i))) {
                data.setBall();
            }
        }
    }

    private boolean checkStrike(int answer, int user){
        return answer == user;
    }

    private boolean checkBall(List<Integer> answer, int user){
        return answer.contains(user);
    }
}
