package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class ProgramNumber {
    private String programNumber;

    //생성된 프로그램 숫자 반환
    public String getProgramNumber() {
        return programNumber;
    }

    //생성 시 바로 프로그램 숫자를 만들 수 있도록 한다.
    public ProgramNumber(int numberSize, int startNumber, int endNumber) {
        createProgramNumber(numberSize, startNumber, endNumber);
    }

    //1 ~ 9 범위 내의 랜덤한 숫자 하나 획득
    private String getOneNumber(int startNumber, int endNumber) {
        return Integer.toString(Randoms.pickNumberInRange(startNumber, endNumber));
    }

    //세자리 자연수 획득
    private void createProgramNumber(int numberSize, int startNumber, int endNumber) {
        //중복을 피하기 위해 HashSet 사용
        Set<String> programNumberSet = new LinkedHashSet<>(numberSize);
        while (programNumberSet.size() < numberSize) {
            programNumberSet.add(getOneNumber(startNumber, endNumber));
        }

        programNumber = String.join("", programNumberSet);
    }
}
