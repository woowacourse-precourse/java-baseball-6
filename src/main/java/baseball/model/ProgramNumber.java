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
    public ProgramNumber() {
        createProgramNumber();
    }

    //1 ~ 9 범위 내의 랜덤한 숫자 하나 획득
    private String getOneNumber() {
        return Integer.toString(Randoms.pickNumberInRange(1, 9));
    }

    //세자리 자연수 획득
    private void createProgramNumber() {
        //중복을 피하기 위해 HashSet 사용
        Set<String> programNumberSet = new LinkedHashSet<>(3);
        while (programNumberSet.size() < 3) {
            programNumberSet.add(getOneNumber());
        }

        programNumber = String.join("", programNumberSet);
    }
}
