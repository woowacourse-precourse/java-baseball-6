package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        
        GameLauncher game = new GameLauncher();
        game.start();
    }
}

class GameLauncher {
    private int init = 1;
    private List<Integer> computerNum;
    private int[] ballStrikeCounts;

    GameLauncher() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    void start() {
        run();
    }

    void run() {
        while (init == 1) {
            makeRandomNum();
            playBaseball();
        }
    }

    void makeRandomNum() {
        computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNum)) {
                computerNum.add(randomNum);
            }
        }
    }

    void playBaseball() {
        do {
            ballStrikeCounts = new int[]{0, 0};
            System.out.print("숫자를 입력해주세요 : ");
            int userNum = input();
            if (userNum < 99) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
            countBallStrike(userNum);
            print();
        } while (ballStrikeCounts[1] != 3);

        init = input();
        if (init > 99) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    void countBallStrike(int userNum) {
        int[] hundreds = new int[3];
        hundreds[0] = userNum/100;
        hundreds[1] = (userNum/10)%10;
        hundreds[2] = userNum%10;

        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.get(i) == hundreds[i]) {
                ballStrikeCounts[1]++;
            } else if (computerNum.contains(hundreds[i])) {
                ballStrikeCounts[0]++;
            }
        }
    }

    void print() {
        if (ballStrikeCounts[0] == 0 && ballStrikeCounts[1] == 0) {
            System.out.println("낫싱");
            return;
        }

        for (int i = 0; i < ballStrikeCounts.length; i++) {
            if (ballStrikeCounts[i] != 0) {
                if (i == 0) {
                    System.out.printf("%d볼 ", ballStrikeCounts[0]);
                } else {
                    System.out.printf("%d스트라이크", ballStrikeCounts[1]);
                }
            }
        }
        System.out.println();

        if (ballStrikeCounts[1] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    int input() throws IllegalArgumentException {
        try {
            String s = Console.readLine();
            int n = Integer.parseInt(s);
            if (checkNumber(n)) {
                return n;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    boolean checkNumber(int n) {
        if (n == 1 || n == 2) {
            return true;
        } else if ((n < 100) || (n > 1000)) {
            return false;
        } else if (((n/10)%10 == 0) || (n%10 == 0)) {
            return false;
        } else if ((n/100 == (n/10)%10) || ((n/10)%10 == n%10) || (n/100 == n%10)) {
            return false;
        }
        return true;
    }
}
