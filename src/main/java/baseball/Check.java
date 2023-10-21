package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Check {
    Computer computer;
    User user;
    int strike;
    int ball;

    public void resultCheck() {
        strike = 0;
        ball = 0;
        for(int i=0;i<3;i++) {
            int idx = user.user.indexOf(computer.computer.get(i));
            if(idx==i) {
                strike+=1;
            }
            else if(idx!=-1) {
                ball+=1;
            }
        }
        String result = "";
        if(ball!=0) {
            result+=ball+"볼 ";
        }
        if(strike!=0) {
            result+=strike+"스트라이크";
        }
        else if(ball==0) {
            result+="낫싱";
        }
        System.out.println(result);
    }
    
    public boolean endingCheck() {
        if(strike==3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public boolean replayCheck() {
        String choice = Console.readLine();
        if(choice.equals("1")) {
            return true;
        }
        else if(choice.equals("2")) {
            return false;
        }
        else {
            return false;
        }
    }
}
