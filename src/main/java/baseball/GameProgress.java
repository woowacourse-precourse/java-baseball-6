package baseball;

import java.util.List;

public class GameProgress {
    void startGameProgress() {
        boolean startAgain = true;

        while (startAgain) {
            ComputerNum computerNum = new ComputerNum();
            UserNum userNum = new UserNum();
            Judgement judgement = new Judgement();
            Compare compare = new Compare();
            WhetherRestart whetherRestart = new WhetherRestart();

            List<String> computerNumList = computerNum.genComputerNum(); // 컴퓨터 숫자 생성
            System.out.println(computerNumList);

            System.out.println("숫자 야구 게임을 시작합니다.");

            String result = "";

            while (!result.equals("3스트라이크")) {
                List<String> userNumList = userNum.getUserNum();
                result = judgement.judgement(computerNumList, userNumList); // 사용자 숫자 입력
                System.out.println(result); // 결과 출력
            }
            startAgain = whetherRestart.scanGameEndNumber();
        }
    }
}