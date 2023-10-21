package baseball;


public class Application {
    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            System.out.println(computer.createAnswerNumber());
            user.userNumber();

            /*System.out.println("낫싱");
            System.out.print("볼");
            System.out.print("스트라이크");
            System.out.println("3개의 숫자를 다 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");*/

        }
    }
}
