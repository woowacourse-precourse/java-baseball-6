package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int[] generateRandomAnswer() {
        int[] answer;

        answer = new int[3];
        do {
            for (int i = 0; i < 2; i++) {
                answer[i] = Randoms.pickNumberInRange(1, 9);
            }
        } while(!duplicateNumber(answer));
        return answer;
    }

    private static boolean duplicateNumber(int[] number) {
        return ((number[0] == number[1])
                || (number[1] == number[2])
                || (number[2] == number[0]));
    }
}
