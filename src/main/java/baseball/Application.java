package baseball;


import Service.BallServiceImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        BallServiceImpl ballService = BallServiceImpl.getInstance(); //ballService 클래스 객체 생성
        boolean flag = false; //게임을 계속할건지 체크하는 flag, true이면 게임 그만둠
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!flag) {
            System.out.print("숫자를 입력해 주세요 : ");
            String ballCount = Console.readLine(); //사용자가 숫자 입력

            if (ballService.startGame(ballCount)) { //숫자 3개를 모두 맞췄을 경우
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String isExit = Console.readLine(); //1이나 2를 입력
                if (isExit.equals("2")) { //종료할 경우
                    flag = true;
                } else { //다시 시작할 경우
                    ballService.generateRandomNumber();
                }
            }
        }
    }
}
