package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        int strike = 0;

        // 3스트라이크가 될 때까지 반복
        while (strike<3) {

            // 게임 시작 문구 출력
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 컴퓨터가 1~9까지의 서로 다른 임의의 수 3개 선택
            String computer = "";
            for (int i=0;i<3;i++) {
                computer+= Integer.toString(Randoms.pickNumberInRange(1, 9));
            }

            // 플레이어에게 숫자 입력받기
            System.out.println("숫자를 입력해주세요 : ");
            String randomNum = Console.readLine();

            strike = 0;
            int ball = 0;

            // 컴퓨터가 임의로 뽑은 수 3개와 플레이어가 입력한 숫자 3개 비교
            for (int i=0; i<3; i++) {
                int index = 0;
                String number = Character.toString(computer.charAt(i));
                if (randomNum.contains(number)){
                    index = randomNum.indexOf(number);
                    if (i==index) {
                        strike+=1;
                    } else {
                        ball+=1;
                    }
                }
            }

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
}
