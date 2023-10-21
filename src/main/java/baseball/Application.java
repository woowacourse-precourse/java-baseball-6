package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    //  힌트를 출력하는 로직
    public static void numberBaseball(){

        //정답 생성
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        //사용자 입력값 받기
        String inputValue = readLine();

        //사용자가 잘못된 값을 입력한 경우 오류 던지기

        }



    public static void main(String[] args) {
        //입력은 camp.nextstep.edu.missionutils.Console의 readLine() 활용
        //랜덤값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberRange() 활용

        // 숫자 야구 진행 기능
        numberBaseball();

    }
}
