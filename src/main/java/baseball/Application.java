package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    // 1부터 9까지 서로 다른 수로 이루어진 3자리의 숫자를 맞추기
    // 같은 수 같은 자리 -> 스트라이크, 다른 자리 -> 볼
    // 같은 수 전혀 없으면 낫싱이란 힌트 얻음, 힌트로 상대방의 수 맞추면 승리
    // 사용자가 잘못된 값을 입력 하면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
    // 게임이 끝난 후 재시작/종료를 구분하는 1과 2중 하나의 수
    public static void main(String[] args) {
        //게임 시작 알리고 랜덤 숫자 생성(no.1)
        System.out.print("숫자 야구 게임을 시작합니다.");
        Baseball game = new Baseball();
        Baseball.init(game);
    }
}

class Baseball {
    static final int LIMIT_DIGIT = 3;

    Baseball() {
        String randomNum;

        while (num.length() < LIMIT_DIGIT) {
            randomNum = Integer.toString(pickNumberInRange(1, 9));
            if (!num.contains(randomNum)) {
                num += randomNum;
            }
        }
    }

    public static void init(Baseball answer) {
        
    }
}