package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Game {
    private UserGame usergame = new UserGame(); //UserGame 클래스 객체 생성
    private ComputerGame computergame = new ComputerGame(); // ComputerGame 클래스 객체 생성

    // 내 생각 : 1. 객체 생성한 걸로 다른 변수로 새로 만들어주기
    public void start() { // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            computergame.randomNumber();
            usergame.inputUserNum();
        } while (canRestart());
    }
    public boolean canRestart() { // 게임을 종료할건지 재시작할건지?
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine(); // input => 1 혹은 2만 가능
        if(!isExceptionExam(input)){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input) == 1;
    }
    // countStrike + Strike -> 1 스트라이크 , countBall + Ball -> 1 볼
    // 컴퓨터 값과 입력한 값을 비교하여 같을 경우에 따라

    public boolean isResultException(String input){ // 0과 1이 아닌 숫자 시 예외
        String pattern = "^[1-2]$";
        return Pattern.matches(pattern, input);
    }
    public boolean isExceptionExam(String input){ // 예외처리
        if(!isResultException(input)){
            return false;
        }
        return true;
    }
}
