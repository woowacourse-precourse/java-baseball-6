package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        User user = new User();
        computer.setAnswerNum();
        user.inputNum();
    }
}
