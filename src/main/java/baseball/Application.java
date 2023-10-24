package baseball;
import baseball.computer.Computer;
import baseball.controller.Controller;
import baseball.user.User;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Controller controller = new Controller();

        String gameRestart = "1"; //변수설정
        String result = ""; // 변수 설정

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(!gameRestart.equals("2")){
            Computer computer = controller.makeComputerNumber(); // 컴퓨터 수 생성

            while(!result.equals("3스트라이크")){
                User user = controller.makeUserNumber(); // user 수 생성
                result = controller.equals(computer.getComputer(), user.getUser());
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameRestart = Console.readLine();
            if(!gameRestart.equals("1") && !gameRestart.equals("2")){
                throw new IllegalArgumentException("1이나 2를 입력해주세요");
            }
            result = ""; // rseult 초기화
        }

    }
}