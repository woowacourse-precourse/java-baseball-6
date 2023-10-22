package baseball;

import java.util.List;

public class GameProgress {
    void startGameProgress() {
        ComputerNum computerNum = new ComputerNum();
        Judgement judgement = new Judgement();

        List<String> computerNumList = computerNum.genComputerNum(); // 컴퓨터 숫자 생성
        System.out.println(computerNumList);

        System.out.println("숫자 야구 게임을 시작합니다.");

        String result = "";

        while (!result.equals("3스트라이크")) {
            UserNum userNum = new UserNum();
            List<String> userNumList = userNum.getUserNum(); // 사용자 숫자 입력

            result = judgement.judgement(computerNumList, userNumList);
            System.out.println(result); // 결과 출력
        }

    }
}
