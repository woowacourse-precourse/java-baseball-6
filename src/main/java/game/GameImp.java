package game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameImp implements Game{
    private List<Integer> comnum ;
    private List<Integer> usernum;
    private Integer ball = 0;
    private Integer strike = 0;
    public void start() {
        strike =0;
        ball = 0;
        comnum = new ArrayList<>();
        while(comnum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!comnum.contains(randomNumber)) {
                comnum.add(randomNumber);
            }

        }
        return ;
    }
    @Override
    public boolean gameInput(String num) throws IllegalArgumentException {
        usernum = new ArrayList<>();
        Integer numInt = -1;
        if(num.length() != 3) {
            throw new IllegalArgumentException();
        }

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(i == j)
                    continue;
                if(num.charAt(i) == num.charAt(j)) {
                    throw new IllegalArgumentException();
                }
                if(num.charAt(i) == '0') {
                    throw new IllegalArgumentException();
                }
            }
        }

        try{
            numInt = Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        for(int i=0;i<3;i++) {
            usernum.add(num.charAt(i)-'0');
        }
        return true;
    }
    @Override
    public String gameoutput() {
        String ans = "";

        strike = 0;
        for(int i=0;i<3;i++) {
            if(comnum.get(i) == usernum.get(i)) {
                strike++;
                usernum.set(i, 0);
            }
        }
        ball = 0;
        for(int i=0;i<3;i++) {
            if(usernum.get(i) == 0)
                continue;
            if(comnum.contains(usernum.get(i)))
                ball++;
        }
        if(ball != 0)
            ans += (ball + "볼");
        if(ball != 0 && strike != 0)
            ans += " ";
        if(strike != 0)
            ans += (strike + "스트라이크");
        if(ans == "")
            ans = "낫싱";
        return ans;
    }

    @Override
    public boolean getStatus() {
        if(strike == 3)
            return true;
        return false;
    }

    @Override
    public boolean restart(String reinput) throws IllegalArgumentException{
        if(reinput.equals("1") && reinput.equals("2")){
            throw new IllegalArgumentException();
        }
        if(reinput.equals("1"))
            return true;
        return false;
    }
}
