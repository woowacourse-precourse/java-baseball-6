package baseball;

public class BaseballGame {
    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            Computer computer = new Computer();
            User user = new User();
            while (!computer.checkNum(user.getUserNum())) {
                user.inputNum();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } while (User.chooseRestart());
    }
}
