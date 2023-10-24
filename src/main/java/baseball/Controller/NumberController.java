package baseball.Controller;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberController {
    static final int NUMOFDIGIT = 3;

    public static Integer[] createRandomNumber(){

        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < NUMOFDIGIT) {
            int randomNumbers = pickNumberInRange(1,9);
            uniqueNumbers.add(randomNumbers);
        }

        // Set return
        return uniqueNumbers.toArray(new Integer[0]);

    }
    public void checkLength(String userSay){
        if(userSay.length()!=NUMOFDIGIT) throw new IllegalArgumentException("3자리 숫자를 입력해주세요. 프로그램을 종료합니다.");

    }
    public Integer[] getUserNumber(String userInput) {
        Integer[] userNumbers = {0,0,0};
        int userInputInteger = Integer.parseInt(userInput);

        //유저의 답 추출. 자릿수별로 변수를 만든다.
        userNumbers[0] = userInputInteger / 100;
        userNumbers[1] = userInputInteger % 100 / 10;
        userNumbers[2] = userInputInteger % 10;

        return userNumbers;
    }
}
