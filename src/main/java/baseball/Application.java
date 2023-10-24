package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 포함 관계
        Computer computer = Computer.getComputer();
        Print print = Print.getPrint();
        Input input = Input.getInput();
        GameResult gameResult = GameResult.getGameResult();

        List<Integer> randomNumList = new ArrayList<>();

        print.startGame();
        while (true) {
            randomNumList = computer.makeRandomList(randomNumList); // random 수 설정
            String inputValue = input.doGame(); // 초기 문구 및 사용자 값 받기 및 내부 예외 처리
            int[] resultArr = gameResult.countResult(inputValue, randomNumList); // strike, ball 개수

            print.resultGame(resultArr); // 1. 결과 출력
            if (resultArr[0] == 3 && input.finishGame(randomNumList) == 2) break; // 2. 예외처리 및 (재시작||종료)
        }
    } // main 끝
}
