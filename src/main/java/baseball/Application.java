package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다."); // 게임 시작 문구 출력
        int status = 1; // 게임 시작

        while(status == 1) {
            System.out.print("숫자를 입력해주세요 : ");

            try {
                int playerNum = Integer.parseInt(readLine());
                if (playerNum < 111 || playerNum > 999) {
                    throw new IllegalArgumentException();
                }
            }catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력값입니다.");
            }finally {
                status = 2;
            }

            String computerNum = String.valueOf(Randoms.pickNumberInRange(111, 1000));

            if(status == 2){
                break;
            }

        }


    }
}
