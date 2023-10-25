package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        CreateRandomNum randomNum = new CreateRandomNum();
        InputUserNum input = new InputUserNum();
        Referee referee = new Referee();
        Replay replay = new Replay();

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            // 랜덤 컴퓨터 숫자 생성
            List<Integer> computerNum = randomNum.create();

            String result = "";
            while (!result.equals("3스트라이크")) {
                // 사용자 숫자 입력
                List<Integer> userNum = input.userNum();

                // 입력에 따른 결과 판단
                result = referee.Judgement(computerNum, userNum);
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } while (replay.replay());

    }
}