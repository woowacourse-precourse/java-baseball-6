package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag = true; //게임이 종료되었을 때 재시작과 종료를 확인할 수 있는 flag
        while (flag) {
            flag = GameStarter.newGame();
        }
    }
}
