package baseball;

public class Check {
    Computer computer;
    User user;

    public void resultCheck() {
        int strike = 0;
        int ball = 0;
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
}
