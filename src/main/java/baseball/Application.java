package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
        //Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
        //사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

        // 디버깅을 이용한 테스트도 여기에서 진행한다.
        Controller controller = new Controller();
        controller.start();

    }
}
