package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

    public void printBaseballStart() {
        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String inputRandomNum() {
        // 플레이어에게 숫자 입력받기
        System.out.println("숫자를 입력해주세요 : ");
        String randomNum = Console.readLine();
        return randomNum;
    }

}
