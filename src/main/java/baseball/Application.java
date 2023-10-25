package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        while (gameStart()) {

        }
    }

    public static boolean gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 컴퓨터의 랜덤 수 얻기
        List<Integer> computerList = new ArrayList<>();
        pickAnswerNumbers(computerList);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            // user 입력
            User user = new User(Console.readLine());
            // 잘못된 입력에 대한 판단 & List형식으로 반환
            user.checkUserInputError();

            // 몇 개 맞추었는지 판단
            GameResult gameResult = new GameResult();
            gameResult.showResult(computerList, user.getUserList());

            int strike = gameResult.getStrike();
            int ball = gameResult.getBall();
            // 3스트라이크 여부 판단
            if (gameResult.getBall() == 0 && gameResult.getStrike() == 3) {
                // 3스트라이크
                int isMoreGame = gameResult.showResultStrike();
                if (isMoreGame == 1) {
                    return true;
                } else if (isMoreGame == 2) {
                    return false;
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                // 3스트라이크 아님
                gameResult.showResultNormal();
            }
        }
    }

    // 낫싱 또는 볼/ 스트라이크 모두 1개 이상

    // 사용자가 맞추어야할 3개 숫자를 뽑습니다.
    public static void pickAnswerNumbers(List<Integer> computerList) {
        while (computerList.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerList.contains(num)) {
                computerList.add(num);
            }
        }
    }


}
