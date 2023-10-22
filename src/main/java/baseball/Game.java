package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * 게임. 답과 실행메서드(play())를 가지고 있다.
 */
public class Game {

    private String computerNum; // 컴퓨터가 선택한 숫자(답)

    /**
     * 게임 시작에 필요한 정보 세팅
     */
    private void init() {
        makeComputerNum(); // 컴퓨터의 숫자 결정
    }

    /**
     * 게임 실행
     */
    public void play() {
        init();

        System.out.println("숫자 야구 게임을 시작합니다.");

        // 사용자의 값 입력
        System.out.print("숫자를 입력해주세요 : ");
        System.out.println(Console.readLine());

    }

    /**
     * 컴퓨터의 숫자 결정(답 결정)
     * @return 컴퓨터의 값(답)
     */
    private void makeComputerNum() {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < GameDetail.NUM_COUNT) {
            String randomNum = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (sb.indexOf(randomNum) == -1) {
                sb.append(randomNum);
            }
        }
        computerNum = sb.toString();
    }

}
