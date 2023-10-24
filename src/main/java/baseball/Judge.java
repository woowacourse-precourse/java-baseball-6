package baseball;

import java.util.List;

public class Judge {
    public String getJudge(List<Integer> computer, List<Integer> player) {
        String result = "";

        Compare compare = new Compare();                                    //볼, 스트라이크 갯수
        int getStrike = compare.compareStrike(computer, player);
        int getBall = compare.compareBall(computer, player) - getStrike;


        if(getBall == 0 && getStrike == 0) {                                //아웃
            result = "낫싱";
            System.out.println(result);
            return result;
        }
        if(getStrike == 3) {                                                //3스트라이크
            result = "3스트라이크";
            System.out.println(result);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return result;
        }
        if(getBall > 0)
            result += getBall + "볼";
        if(getStrike > 0 && getBall > 0)
            result += " ";
        if(getStrike > 0)
            result += getStrike + "스트라이크";

        System.out.println(result);
        return result;
    }
}
