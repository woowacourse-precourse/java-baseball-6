package baseball;

import java.util.List;
public class Application {
    public static void main(String[] args) {
        GetInput input = new GetInput();                //컴퓨터 정답, 플레이어 입력값 설정
        Again again = new Again();                      //재시작 설정
        Judge judge = new Judge();                      //비교 결과 출력

        boolean game = true;                            //게임 시작 유무

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(game) {
            List<Integer> computer = input.getComputerNum();        //컴퓨터 정답 설정

            String result = "";
            while (!result.equals("3스트라이크")) {
                List<Integer> player = input.getPlayerNum();        //플레이어 입력값 설정
                result = judge.getJudge(computer, player);          //비교 후 출력, 3스트라이크가 아니면 계속
            }

            game = again.getAgain();                                //3스트라이크라면 재시작 유무 설정
        }
    }
}
