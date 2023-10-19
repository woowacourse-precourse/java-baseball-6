package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /* 구현 순서
         * 1. (컴퓨터): random한 숫자 3개를 추출 - pickNumberInRange() 이용
         * 2. (사람) : String 입력 - Console.readLine() 사용
         * 3. 조건 문을 통해서 출력값 나타내기 - System.out.println()
         * 4. 예외 처리하기 - IllegalArgumentException
         * */
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3); // random값 추출
        System.out.println("randomNumber = " + randomNumber);
        System.out.print("입력 : ");
        String inputValue = Console.readLine();
        if (inputValue.length() > 4) throw new IllegalArgumentException();
        int strikeCnt = 0;
        int bollCnt = 0;
        char[] chars = inputValue.toCharArray();
        for (int i = 0; i < randomNumber.size(); i++) {
            if (randomNumber.get(i) == chars[i] - '0') {
                strikeCnt++;
                continue;
            }
            if (randomNumber.contains(chars[i] - '0')) bollCnt++;
        }
        if(strikeCnt + bollCnt == 0) System.out.println("낫싱");
        if(strikeCnt == 3) System.out.println("3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println( bollCnt + "볼 " + strikeCnt + "스트라이크");
    }
}
