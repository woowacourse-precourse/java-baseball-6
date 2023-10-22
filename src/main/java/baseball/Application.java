package baseball;

// 기능 목록(숫자야구)
// #1. 사용자가 숫자를 입력한다.
//    - 이때 서로 다른 숫자이어야 하며 3자리 자릿수만 가능하다.
//    - 새로운 게임을 다시 할땐 1 또는 2만 입력되어야 한다.
//    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨후 종료시킨다
// #2. 컴퓨터의 수를 받는다.
//    - 서로 다른 숫자(1~9)를 3번 받는다.
//    - 새로운 게임이 시작되면 새로 번호를 부여받는다.
// #3. 판단(심판)
//    - 같은 자리, 같은 숫자 = 스트라이크
//    - 다른 자리, 같은 숫자 = 볼
//    - (다른 자리, 다른 숫자)*3 = 낫싱


public class Application {
    public static void main(String[] args) {
        do {
            Controller controller = new Controller();
            controller.run();
        } while (playAgain());

    }

    public static boolean playAgain() {
        Controller controller = new Controller();

        if (controller.askRetryInput() == 1) {
            return true;
        }
        return false;
    }
}
