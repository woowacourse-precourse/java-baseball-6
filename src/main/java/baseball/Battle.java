package baseball;

import java.util.List;

public class Battle {
    public static void startBaseball(List<Integer> userBalls, List<Integer> computerBalls){
        int result = Score.calculation(userBalls, computerBalls);

        while (true){
            if(result == 3){ // strike가 3이라면(게임 종료 결과에 적합하다면)
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                RerunOrNot.reGameStart();
                break;
            }
            List<Integer> newUserBalls = UserBalls.inputBalls(); // 게
            result = Score.calculation(newUserBalls, computerBalls);
        }
    }
}
