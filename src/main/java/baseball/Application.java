package baseball;

import baseball.feature.RandomNumberMaker;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        // 임의의 서로 다른 컴퓨터 숫자 3개 생성
        RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
        List<Integer> computerNums = randomNumberMaker.maker();

        // 입력
        String userInput = Console.readLine();
        // 문자열 리스트로 변환
        List<Integer> userNumbers = makeUserNumber(userInput);
        System.out.println(userNumbers);

    }

    // 문자열을 int형 리스트로 변경하는 함수
    public static List<Integer> makeUserNumber(String userInput) {
        // 문자열의 각요소를 담을 리스트 생성
        List<Integer> UserNumbers = new ArrayList<>();
        // 문자열을 char 형 리스트로 만들고  char형 인자들을 int형으로 바꿈
        for (char numChar : userInput.toCharArray()) {
            UserNumbers.add(Character.getNumericValue(numChar));
        }
        return UserNumbers;
    }
}
