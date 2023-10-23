package baseball;

import java.util.List;

public class Battle {
    // 사용자의 값과 컴퓨터의 값 비교
    // 스트라이크/볼/낫싱 값 계산
    // 맞출때까지 진행(while true 이용)
    // 맞춘 이후에 재시작할지, 종료할지

    public static void startBaseball(List<Integer> userBalls, List<Integer> computerBalls){
        Score.calculation(userBalls, computerBalls);
        while (true){
            List<Integer> newUserBalls = UserBalls.inputBalls();
            int result = Score.calculation(newUserBalls, computerBalls);
            if(result == 3){ // strike가 3이라면(게임 종료 결과에 적합하다면)
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                RerunOrNot.reGameStart();
            }
        }
    }
}
