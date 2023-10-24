package baseball.data;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Data {
    private final int digit = 3;
    private List<Integer> answer;
    private List<Integer> user;
    private boolean tof = true;
    private String result;
    private int strike = 0;
    private int ball = 0;

    public boolean getTof() {
        return tof;
    }

    public int getDigit(){
        return this.digit;
    }
    public void setTof(boolean tof) {
        this.tof = tof;
    }

    public List<Integer> getUser(String user) {
        this.user.clear();
        for(char num : user.toCharArray()){
            int userNum = num - '0';
            this.user.add(userNum);
        }
        return this.user;
    }

    public Data() {
        this.answer = new ArrayList<>();
        this.user = new ArrayList<>();
        while(this.answer.size() < digit){
            int num = Randoms.pickNumberInRange(1, 9);
            if(!this.answer.contains(num)){
                this.answer.add(num);
            }
        }
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public void resetAnswer() {
        this.answer.clear();
        while(this.answer.size() < digit){
            int num = Randoms.pickNumberInRange(1, 9);
            if(!this.answer.contains(num)){
                this.answer.add(num);
            }
        }
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike() {
        this.strike++;
    }

    public int getBall() {
        return ball++;
    }

    public void setBall() {
        this.ball++;
    }

    public void clear(){
        this.ball = 0;
        this.strike = 0;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult(){
        return this.result;
    }
}
