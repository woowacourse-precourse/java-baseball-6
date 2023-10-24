package baseball;


import static baseball.Application.*;
import static baseball.Constants.*;

public class Game {

    public void play(){
        Computer computer = new Computer();
        User user = new User();

        while(true) {

            // 사용자 숫자 입력
            user.inputNumbers();

            // 사용자숫자와 컴퓨터 숫자 매칭된 결과 얻기
            int[] cnt = calcGameResult(computer.getNumbers(),user.getNumbers());

            // 계산된 결과 출력
            printResult(cnt);

            // 만약 게임이 끝났다면 다시 입력받지 않고 게임 재시작문구 출력
            if (isGameEnd(cnt)){
                break;
            }
        }
    }

    public int[] calcGameResult(int[] computer, int[] user){
        int[] cnt = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (user[i] == computer[j]) {
                    if (i == j) {
                        cnt[0] += 1;
                    } else {
                        cnt[1] += 1;
                    }
                }
            }
        }
        return cnt;
    }

    private void printResult(int[] cnt){
        if (cnt[0] == 0 && cnt[1] == 0) {
            System.out.println(NOTHING);
        } else if (cnt[0] == 3) {
            System.out.println("3"+ STRIKE);
            System.out.println(WIN_AND_END);
        } else {
            System.out.println(
                    String.valueOf(cnt[1]) + BALL +" "
                            + String.valueOf(cnt[0]) + STRIKE
            );
        }
    }

    private boolean isGameEnd(int[] cnt){
        return cnt[0] == 3;
    }

}
