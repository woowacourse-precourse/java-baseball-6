package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /* 구현 순서
         * 1. (컴퓨터): random한 숫자 3개를 추출 - pickNumberInRange() 이용
         * 2. (사람) : String 입력 - Console.readLine() 사용
         * 3. 조건 문을 통해서 출력값 나타내기 - System.out.println()
         * 4. 예외 처리하기 - IllegalArgumentException
         *
         * 5. 시작 문구   : while 사용
         * 6. 재시작/종료  : 1(새로 시작) 2 (종료) * System.exit()를 호출하지 않는다. -> break, continue 사용
         *
         * 7. println 에러 확인 : 2볼 0스트라이크 -> 2볼
         *
         * 기능 분리
         * 1. 랜덤 숫자 만드는 걸 Computer class가 수행
         * 2. if (resultArr[0] == 3 && print.finishGame(randomNumList) == 2) break; // 2. 정답 시, 조건 이중 for문 해결
         * */

        // 포함 관계
        Computer computer = Computer.getComputer();
        Print print = Print.getPrint();
        GameResult gameResult = GameResult.getGameResult();

        List<Integer> randomNumList = new ArrayList<>();

        print.startGame();

        while (true) {
            randomNumList = computer.makeRandomList(randomNumList); // random 수 설정
            String inputValue = print.doGame(); // 초기 문구 및 사용자 값 받기
            if (inputValue.length() > 3) throw new IllegalArgumentException(); // 예외 처리
            int[] resultArr = gameResult.countResult(inputValue, randomNumList); // strike, ball 개수

            print.resultGame(resultArr); // 1. 결과 출력
            if (resultArr[0] == 3 && print.finishGame(randomNumList) == 2) break; // 2. 정답출력 및 (재시작||종료)
        }
    } // main 끝
}
