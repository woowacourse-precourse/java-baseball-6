package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int N = 3;
    private String answer = "";

    public Computer() {
        generateAnswer();
    }

    //N자리 정답 생성
    private void generateAnswer() {
        for (int i = 0; i < N; i++) {
            addDigit();
        }
    }

    //answer에 겹치지 않는 수 한 자리를 추가
    public void addDigit() {
        boolean isDuplicated[] = new boolean[10];
        int randomNumber;

        for (int i = 0; i < answer.length(); i++) {
            //숫자가 중복되는 것을 막기 위해
            //i번째 자리에 있는 숫자가 이미 존재한다는 것을 표시
            char c = answer.charAt(i);
            isDuplicated[Character.getNumericValue(c)] = true;
        }

        do {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        } while (isDuplicated[randomNumber]);

        this.answer = answer.concat(String.valueOf(randomNumber));
    }

    public String getAnswer() {
        return answer;
    }
}
