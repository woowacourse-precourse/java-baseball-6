package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Game {
    private UserGame usergame = new UserGame(); //UserGame 클래스 객체 생성
    private ComputerGame computergame = new ComputerGame(); // ComputerGame 클래스 객체 생성
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

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
        if (!isExceptionExam(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input) == 1;
    }

    // countStrike + Strike -> 1 스트라이크 , countBall + Ball -> 1 볼
    // 컴퓨터 값과 입력한 값을 비교하여 같을 경우에 따라
    public void gameResult(UserGame user, ComputerGame comgame) { // 컴퓨터와 입력숫자 비교해서 판단하는 메서드
        StringBuilder sb = new StringBuilder();
        //1. 입력한 사용자의 숫자중 컴퓨터가 가지고 있는 숫자가 있는가 -> 볼
        // 메모리 동일 비교
        if (user.equals(comgame)) {
            sb.append(countBall()).append(BALL); // 볼 앞에 숫자도 만들어야 댐 BallCount
            if (usergame.inputUserNum().equals(computergame.randomNumber())) {
                sb.append(countStrike()).append(STRIKE);
            }
        }
        sb.append(NOTHING);
        //2. 입력한 사용자의 숫자중 컴퓨터가 가지고 있다면 위치가 동일한가 -> 스트라이크
    }

    public int countStrike() { // 스트라이크 세는 갯수
        int count = 0;
        // 음.. 카운터 어케 늘리지..
        // gameResult에서 비교하고 같을 때 가져오는데...
        return count;
    }

    public int countBall() {
        int count = 0;
        return count;
    }

    public boolean isResultException(String input) { // 0과 1이 아닌 숫자 시 예외
        String pattern = "^[1-2]$";
        return Pattern.matches(pattern, input);
    }

    public boolean isExceptionExam(String input) { // 예외처리
        if (!isResultException(input)) {
            return false;
        }
        return true;
    }
}
