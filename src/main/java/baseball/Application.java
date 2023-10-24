package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            Computer computer = new Computer();
            User user = new User();
            computer.setAnswerNum();
            while (!computer.checkNum(user.getUserNum())) {
                user.inputNum();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } while (User.chooseRestart());
    }
}
