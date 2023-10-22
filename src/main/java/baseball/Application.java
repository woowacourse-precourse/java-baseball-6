package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터가 1~9까지의 서로 다른 임의의 수 3개 선택
        String computer = "";
        for (int i=0;i<3;i++) {
            computer+= Integer.toString(Randoms.pickNumberInRange(1, 9));
        }

    }
}
