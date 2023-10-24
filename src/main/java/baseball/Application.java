package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Constants.*;

public class Application {


    public static int[] getRandomComputerNumber(){
        int[] numbers = new int[3];

        // 같은 수가 나올 경우 다시 랜덤돌리기
        do {
            numbers = new int[]{
                    Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9)
            };
        }
        while (isDuplication(numbers));

        return numbers;
    }

    public static boolean isDuplication(int[] numbers){
        return numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[2] == numbers[0];
    }

    public static int[] getUserNumber(){
        int[] numbers = new int[3];

        do {
            System.out.print(ENTER_NUMBERS);
            String userInput = Console.readLine();

            if (userInput.length() != 3)
                throw new IllegalArgumentException(ONLY_THREE_NUMBERS);

            for (int i = 0; i < 3; i++) {
                if (!(userInput.charAt(i) > '0' || userInput.charAt(i) <= '9'))
                    throw new IllegalArgumentException(ONLY_NUMBER_ALLOWED);
            }

            for (int i = 0; i < 3; i++) {
                numbers[i] = userInput.charAt(i) - '0';
            }

        }while (isDuplication(numbers));

        return numbers;
    }

    public static void printResult(int[] cnt){
        if (cnt[0] == 0 && cnt[1] == 0) {
            System.out.println(NOTHING);
        } else if (cnt[0] == 3) {
            System.out.println("3"+ STRIKE);
            System.out.println(WIN_AND_END);
        } else {
            System.out.println(
                    String.valueOf(cnt[1]) + BALL +" "
                            + String.valueOf(cnt[0]) + STRIKE
            );
        }
    }

    public static int[] calcGameResult(int[] computer, int[] user){
        int[] cnt = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (user[i] == computer[j]) {
                    if (i == j) {
                        cnt[0] += 1;
                    } else {
                        cnt[1] += 1;
                    }
                }
            }
        }
        return cnt;
    }

    public static boolean isGameEnd(int[] cnt){
        return cnt[0] == 3;
    }

    public static void main(String[] args) {
        System.out.println(START_GAME);
        int execInput = 1;
        while (execInput == 1){
            int[] computerNumbers = getRandomComputerNumber();

            while(true) {
                // 사용자 숫자 입력받기
                int[] userNumbers = getUserNumber();

                // 사용자숫자와 컴퓨터 숫자 매칭된 결과 얻기
                int[] cnt = calcGameResult(computerNumbers,userNumbers);

                // 계산된 결과 출력
                printResult(cnt);

                // 만약 게임이 끝났다면 다시 입력받지 않고 게임 재시작문구 출력
                if (isGameEnd(cnt)){
                    break;
                }
            }

            System.out.println(RESTART_GAME_OR_NOT);
            execInput = Integer.parseInt(Console.readLine());

            if (!(execInput == 1 || execInput == 2)){
                throw new IllegalArgumentException(CHOICE_ONE_OR_TWO);
            }

        }
    }
}
