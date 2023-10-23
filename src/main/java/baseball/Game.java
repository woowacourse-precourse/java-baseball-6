package baseball;

import java.util.Arrays;
import java.util.List;

public class Game {
    int[] comArr, userArr;
    private int strikes = 0, balls = 0;

    boolean endFlag=false; //3스트라이트시 재시작 여부 묻기 //여기 없어도 될듯?
    private boolean syncronize(int[] comArr,int[] userArr){ //낫싱?
        for (int userElem : userArr) {
            if (Arrays.stream(comArr).anyMatch(x -> x == userElem)) {
                return true;
            }
        }
        return false;
    }
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
        } else if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }
    }

    public int getStrikes() {
        return strikes;
    }

    //게임 결과
    public void play(List<Integer> comList, List<Integer> userList) {
        int strikes = 0;
        int balls = 0;
        placeMatch(comList, userList, strikes, balls);
    }

}
