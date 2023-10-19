package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean isRetry = true;
        do {
            // Init
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            boolean isRight = false;
            do {
                // Input
                System.out.println("숫자를 입력해주세요 : ");
                String inputStr = Console.readLine();
                List<Integer> input = getIntFromStr(inputStr);

                // Logic
                Score score = compare(computer, input);

                // Print
                if (score.isSame()) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    isRight = true;
                } else if (score.isDiff()) {
                    System.out.println("낫싱");
                } else {
                    if (score.getStrikeCnt() == 0) {
                        System.out.println(score.getBallCnt() + "볼");
                    } else if (score.getBallCnt() == 0) {
                        System.out.println(score.getStrikeCnt() + "스트라이크");
                    } else {
                        System.out.println(score.getBallCnt() + "볼 " + score.getStrikeCnt() + "스트라이크");
                    }
                }
            } while (!isRight);

            // 게임 한 번 종료 후 다시 물어보기
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if (input.equals("1"))
                isRetry = true;
            else
                isRetry = false;
        } while (isRetry);


    }

    private static Score compare(List<Integer> computer, List<Integer> input) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i) == input.get(j)) {
                    if (i == j)
                        strikeCnt++;
                    else
                        ballCnt++;
                }
            }
        }

        Score score = new Score(strikeCnt, ballCnt);
        return score;
    }

    private static List<Integer> getIntFromStr(String inputStr) throws IllegalArgumentException {
        if (inputStr.length() != 3)
            throw new IllegalArgumentException();

        List<Integer> ret = new ArrayList<>(3);

        for (int i = 0; i < inputStr.length(); i++) {
            Integer tmp = inputStr.charAt(i) - '0';
            if (!(tmp <= 9 && 1 <= tmp))
                throw new IllegalArgumentException();

            ret.add(tmp);
        }

        return ret;
    }
}