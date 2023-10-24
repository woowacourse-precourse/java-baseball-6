package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<Integer> answers;
    static List<Integer> userGuess;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean moreGame = true;

        while (moreGame) {
            answers = prepareAnswer();
            String s = "";

            while (!s.equals("3스트라이크")) {
                userGuess = getNumbers();
                s = getScoreMessage(answers, userGuess);
                System.out.println(s);
            }

            moreGame = isGameOver();
        }
        System.out.println("게임 종료");

    }

    /**
     * 사용자의 입력을 받고 이를 숫자로 변환해 리스트에 저장하는 메소드
     *
     * @return 3개의 중복되지 않는 정수를 갖는 리스트
     * @throws IllegalArgumentException
     */
    protected static List<Integer> getNumbers() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> userGuess = new ArrayList<>();
        final byte[] inputToBytes = input.getBytes();
        if (inputToBytes.length != 3) {
            throw new IllegalArgumentException("input length should exactly be three.");
        }
        for (byte b : inputToBytes) {
            if (b > '9' || b < '1') {
                throw new IllegalArgumentException("numbers should be in range 1 to 9.");
            }
            int number = b - '0';
            if (userGuess.contains(number)) {
                throw new IllegalArgumentException("numbers cannot be duplicated.");
            } else {
                userGuess.add(number);
            }
        }
        return userGuess;
    }

    /**
     * 3개의 중복없는 무작위 수를 가진 리스트를 생성하는 메소드
     *
     * @return 중복이 없는 3개의 숫자를 가진 리스트
     */
    protected static List<Integer> prepareAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


    /**
     * 정답과 비교해 힌트를 계산하는 메소드
     *
     * @param computer  : 컴퓨터가 가진 정답
     * @param userGuess : 유저가 입력한 숫자
     * @return 볼과 스트라이크 개수를 나타내는 정수 배열
     */
    private static int[] compareWithAnswer(final List<Integer> computer, final List<Integer> userGuess) {
        int[] score = new int[2];

        for (int i = 0; i < 3; i++) {
            int computerNumber = computer.get(i);
            int userNumber = userGuess.get(i);

            if (computerNumber == userNumber) {
                score[1]++;
            } else if (computer.contains(userNumber)) {
                score[0]++;
            }
        }
        return score;
    }

    /**
     * compareWithAnswer에서 받은 힌트 정보를 문자열로 바꿔 출력하는 메소드
     *
     * @param computer  유저가 입력한 수들과 비교할 정답 리스트
     * @param userGuess 유저가 입력한 수들의 리스트
     * @return 힌트를 나타내는 문자열을 반환함
     */
    protected static String getScoreMessage(final List<Integer> computer, final List<Integer> userGuess) {
        int[] score = compareWithAnswer(computer, userGuess);
        StringBuilder sb = new StringBuilder();
        if (score[0] > 0) sb.append(score[0]).append("볼 ");
        if (score[1] > 0) sb.append(score[1]).append("스트라이크 ");
        if (sb.isEmpty()) sb.append("낫싱");
        return sb.toString().trim();
    }

    /**
     * 사용자에게 입력을 받아 1 또는 2를 받은 경우 각각 true(시작), false(종료)를 반환하고
     * 입력값이 잘못된 경우 IllegalArgumentException을 반환하는 메소드
     *
     * @return boolean
     * @throws IllegalArgumentException
     */
    protected static boolean isGameOver() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userChoiceString = Console.readLine();

        if (userChoiceString.length() != 1) {
            throw new IllegalArgumentException("your choice should exactly be one digit.");
        }

        if (userChoiceString.charAt(0) > '2' || userChoiceString.charAt(0) < '1') {
            throw new IllegalArgumentException("your choice should be in range 1 to 2.");
        }

        return Integer.parseInt(userChoiceString) == 1;
    }
}
