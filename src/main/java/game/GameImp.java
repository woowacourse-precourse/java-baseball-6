package game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class GameImp implements Game{
    private static List<Integer> comnum ;
    private static List<Integer> usernum;
    private Integer ball = 0;
    private Integer strike = 0;
    private static final String strBall = "볼";
    private static final String strNothing = "낫싱";
    private static final String strStrike = "스트라이크";
    private static final String restart = "1";
    private static final String finish = "2";
    private static final int size = 3;
    private static final int zero = 0;
    private static final int strikeOut = size;
    private static final char charZero = '0';

    public void start() {
        strike =zero;
        ball = zero;
        comnum = new ArrayList<>();
        usernum = new ArrayList<>();
        while(comnum.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!comnum.contains(randomNumber)) {
                comnum.add(randomNumber);
            }
        }
    }
    @Override
    public boolean gameInput(String num) throws IllegalArgumentException {
        usernum = new ArrayList<>();
        if(num.length() != size) {
            throw new IllegalArgumentException();
        }
        for(int i=zero;i<size;i++) {
            for(int j=zero;j<size;j++) {
                if(i == j)
                    continue;
                if(num.charAt(i) == num.charAt(j)) {
                    throw new IllegalArgumentException();
                }
                if(num.charAt(i) == charZero) {
                    throw new IllegalArgumentException();
                }
            }
        }
        try{
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        for(int i=zero;i<size;i++) {
            usernum.add(num.charAt(i)-charZero);
        }
        return true;
    }
    @Override
    public String gameoutput() {
        String ans = "";
        strike = zero;
        for(int i=zero;i<size;i++) {
            Integer nownum = comnum.get(i);
            if(nownum.equals(usernum.get(i))) {
                strike++;
                usernum.set(i, zero);
            }
        }
        ball = zero;
        for(int i=zero;i<size;i++) {
            if(usernum.get(i) == zero)
                continue;
            if(comnum.contains(usernum.get(i)))
                ball++;
        }
        if(ball != zero)
            ans += (ball + strBall);
        if(ball != zero && strike != zero)
            ans += " ";
        if(strike != zero)
            ans += (strike + strStrike);
        if(ans.isEmpty())
            ans = strNothing;
        return ans;
    }
    @Override
    public boolean getStatus() {

        if(strike.equals(strikeOut))
            return true;
        return false;
    }
    @Override
    public boolean restart(String reinput) throws IllegalArgumentException{
        if(!reinput.equals(restart) && !reinput.equals(finish)){
            throw new IllegalArgumentException();
        }
        if(reinput.equals(restart))
            return true;
        return false;
    }
}
