package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Answer {
    private int numberLength;
    private String answer;
    public Answer (int numberLength) {
        this.numberLength = numberLength;
        this.answer = setRandomNumber();
    }
    /* 랜덤 정수 배출 */
    private String setRandomNumber () {
        StringBuilder settingAnswer = new StringBuilder();
        while (settingAnswer.length() < this.numberLength) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
            String digitToString = String.valueOf(randomDigit);
            appendDigit(settingAnswer, digitToString);
        }
        return settingAnswer.toString();
    }
    /* 중복 검증 후 StringBuilder에 숫자 추가 */
    private void appendDigit (StringBuilder settingAnswer, String randomDigit) {
        String checkAnswer = settingAnswer.toString();
        if (!checkAnswer.contains(randomDigit))
            settingAnswer.append(randomDigit);
    }
    /* 사용자 입력 값을 받아, [스트라이크, 볼, 아웃]을 정수형 배열로 반환 */
    public int[] getStatusArray (String userAnswer) {
        if (this.answer.equals(userAnswer))
            return new int[]{numberLength, 0, 0};
        int[] result = new int[3];
        VisitedChecker visitedChecker = new VisitedChecker(numberLength);
        for (int i = 0; i < numberLength; i++)
            result[0] += compareStrike(userAnswer.charAt(i), this.answer.charAt(i), i, visitedChecker);
        for (int i = 0; i < numberLength; i++)
            result[1] += compareBall(userAnswer.charAt(i), visitedChecker);
        result[2] = numberLength - result[0] - result[1];
        return result;
    }
    /* 스트라이크 확인 */
    private int compareStrike (char a, char b, int index, VisitedChecker visitedChecker) {
        if (a != b)
            return 0;
        visitedChecker.checkVisited(index);
        return 1;
    }
    /* 볼 확인 */
    private int compareBall (char c, VisitedChecker visitedChecker) {
        for (int i = 0; i < numberLength; i++) {
            if (visitedChecker.isVisitedForAnswer(i) || c != this.answer.charAt(i))
                continue;
            visitedChecker.checkVisitedForAnswer(i);
            return 1;
        }
        return 0;
    }
}
