package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
         * */

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) computer.add(randomNumber);
        }
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // random 수 설정
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) computer.add(randomNumber);
            }

            // 초기 문구
            System.out.print("숫자를 입력해주세요 : ");
            String inputValue = Console.readLine();

            // 예외 처리
            if (inputValue.length() > 3) throw new IllegalArgumentException();

            // 스트라이크, 볼 개수 count
            int strikeCnt = 0;
            int bollCnt = 0;
            char[] chars = inputValue.toCharArray();
            for (int i = 0; i < computer.size(); i++) {
                if (computer.get(i) == chars[i] - '0') strikeCnt++;
                else if (computer.contains(chars[i] - '0')) bollCnt++;
            }

            // 출력 - 0개인 경우 세지 않는다.
            if (strikeCnt + bollCnt == 0) System.out.println("낫싱");
            else if (strikeCnt == 0 && bollCnt != 0) System.out.println(bollCnt + "볼");
            else if (bollCnt == 0 && strikeCnt != 0) {
                System.out.println(strikeCnt + "스트라이크");
                if (strikeCnt == 3) {
                    // 게임 재시작 or 종료
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String choiceNum = Console.readLine();
                    if (choiceNum.equals("1")) {
                        computer.clear(); // list 비우기
                        continue;
                    }
                    if (choiceNum.equals("2")) break;
                }
            } else System.out.println(bollCnt + "볼 " + strikeCnt + "스트라이크");
        }
    } // main 끝
}
