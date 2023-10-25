package baseball.view;

public class View {
    // 시작문구를 출력하는 기능
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 사용자의 숫자입력을 알리는 기능
    public void printUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    // 정답을 맞췄을 때 재시작의 여부를 묻는 기능
    public void printGameRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    // 힌트를 출력하는 기능
    public void printStrikeBall(int strike_count, int ball_count) {
        if (strike_count == 0 && ball_count != 0) { // 볼만 있는 경우
            System.out.println(ball_count + "볼");
        }

        if (strike_count != 0 && ball_count == 0) { // 스트라이크만 있는 경우
            System.out.println(strike_count + "스트라이크");
        }

        if (strike_count == 0 && ball_count == 0) { // 하나도 없는 경우
            System.out.println("낫싱");
        }

        if (strike_count != 0 && ball_count != 0) {
            System.out.println(ball_count + "볼 " + strike_count + "스트라이크"); // 스트라이크 볼 둘다 있는 경우
        }
    }
}
