package baseball;

import baseball.feature.Confirm;
import baseball.feature.RandomNumberMaker;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 임의의 서로 다른 컴퓨터 숫자 3개 생성
        RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
        List<Integer> computerNums = randomNumberMaker.maker();

        // 문자열 리스트로 변환
        List<Integer> userNumbers;
        String result = "";
        // 볼, 스트라이크, 낫싱 판별
        Confirm baseballConfirm = new Confirm(computerNums);


        while (!result.equals("3스트라이크")) {
            // 입력, 문자열 리스트로 변환
            System.out.print("숫자를 입력해주세요 : ");
            userNumbers = makeUserNumber(Console.readLine());
            baseballConfirm.takeNumbers(userNumbers);
            result = baseballConfirm.referee();
            System.out.println(result);

        }
        if (result.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }


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
