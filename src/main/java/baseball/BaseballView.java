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

    public void printStrikeOrBall(int strike, int ball){
        // 스트라이크, 볼, 낫싱 개수 세기
        if (strike==0 && ball==0) {
            System.out.println("낫싱");
        } else if (ball==0) {
            System.out.println(strike+"스트라이크");
        } else if (strike==0) {
            System.out.println(ball+"볼");
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

}
