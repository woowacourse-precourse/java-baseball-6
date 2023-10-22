package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class ProgramNumber {
    private String programNumber;

    //생성 시 바로 프로그램 숫자를 만들 수 있도록 한다.
    public ProgramNumber() {
        createProgramNumber();
    }

    //세자리 자연수 획득
    private void createProgramNumber() {
        Set<String> programNumberSet = generateUniqueNumbers();
        programNumber = String.join("", programNumberSet);
    }

    // 중복 없이 n개의 1 ~ 9 범위 내의 랜덤한 숫자 생성
    private Set<String> generateUniqueNumbers() {
        Set<String> numberSet = new LinkedHashSet<>(NumberStatus.NUMBER_SIZE);
        while (numberSet.size() < NumberStatus.NUMBER_SIZE) {
            numberSet.add(getRandomNumber());
        }
        return numberSet;
    }

    //1 ~ 9 범위 내의 랜덤한 숫자 하나 획득
    private String getRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(NumberStatus.START_NUMBER, NumberStatus.END_NUMBER));
    }

    //생성된 프로그램 숫자 반환
    public String getProgramNumber() {
        return programNumber;
    }
}
