package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GamePlay {
    private Compare compare;

    public void run() {
        this.compare = new Compare(0, 0);
        printStartMsg();    // 게임 시작 문구 출력
        do {
            start();
        } while (restart());
    }

    public void start() {
        Computer computer = new Computer();
        Player player = new Player();
        List<Integer> comNum = computer.getNumbers();// 컴퓨터 랜덤 수 생성
//        List<Integer> comNum = List.of(1, 2, 3);    // 테스트용
        do {
            List<Integer> userInput = player.getUserInput();  // 사용자 입력 받아서 진행
            compare.compareNum(comNum, userInput);
            System.out.println(compare.getResultMsg()); // 결과 메세지 출력
        } while (!compare.isEnd());
    }

    private void printStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private String getUserInput() { // 재시작용 유저 입력
        return Console.readLine();
    }

    private Boolean restart() {
        int input;
        do {
            printRestartMsg();
            input = Integer.parseInt(getUserInput());
            if (invalidInput(input)) {
                printRestartKeyError(); // 에러 메세지 출력
            }
        } while (invalidInput(input));
        return (input == 1);
    }

    private boolean invalidInput(int input) {
        return (input != 1 && input != 2);
    }

    private void printRestartMsg() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void printRestartKeyError() {
        System.out.println("1, 2만 입력 가능합니다. 다시 입력해주세요.");
    }
}
