package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static int[] getRandomComputerNumber(){
        return new int[]{
            Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9),
                    Randoms.pickNumberInRange(1, 9)
        };
    }
    public static int[] getUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        int[] userNumbers = new int[3];
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
        }
        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) > '0' && userInput.charAt(i) <= '9') {
                continue;
            } else {
                throw new IllegalArgumentException("모두 숫자를 입력해주세요.");
            }
        }

        for (int i = 0; i < 3; i++) {
            userNumbers[i] = userInput.charAt(i)-'0';
        }

        return userNumbers;
    }
    public static void printResult(int[] cnt){
        if (cnt[0] == 0 && cnt[1] == 0) {
            System.out.println("낫싱");
        } else if (cnt[0] == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println(
                    String.valueOf(cnt[1]) + "볼 "
                            + String.valueOf(cnt[0]) + "스트라이크"
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
        if (cnt[0]==3){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int execInput = 1;
        while (execInput == 1){
            int[] computerNumbers = getRandomComputerNumber();

            while(true) {
                int[] userNumbers = getUserNumber();

                int[] cnt = calcGameResult(computerNumbers,userNumbers);

                printResult(cnt);

                if (isGameEnd(cnt)){
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            execInput = Integer.parseInt(Console.readLine());

            if (!(execInput == 1 || execInput == 2)){
                throw new IllegalArgumentException("1 또는 2 중에서 입력해주세요.");
            }

        }
    }
}
