package baseball;

import java.util.List;

public class Game {
    int[] comArr, userArr;
    private int strikes = 0, balls = 0;
    private boolean flag = false;
    private void placeMatch(List<Integer> comList, List<Integer> userList, int strikes, int balls) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(comList.get(i))) {
                strikes++;
            } else if (comList.contains(userList.get(i))) {
                balls++;
            }
        }
        if (balls > 0 && strikes > 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else if (balls > 0) {
            System.out.println(balls + "볼");
        } else if (strikes > 0) {
            System.out.println(strikes + "스트라이크");
            if(strikes==3){
                flag = true;
            }
        } else if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }
    }
    public boolean getflag() {
        return flag;
    }
    public void play(List<Integer> comList, List<Integer> userList) {
        flag = false;
        int strikes = 0;
        int balls = 0;
        placeMatch(comList, userList, strikes, balls);
    }



}
