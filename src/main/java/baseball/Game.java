package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Game {
    private List<Integer> computer;
    private List<Integer> user;
    private int maxTries;

    public Game() {
        computer = new ArrayList<>();
        user = new ArrayList<>();
        maxTries = 3; // 최대 시도 횟수
    }

    void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    void makeComNum() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            uniqueNumbers.add(randomNumber);
        }

        computer.clear();
        computer.addAll(uniqueNumbers);
    }

    void getUserNum() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (input.length() != 3) {
                System.out.println("세 자리 숫자를 입력해야 합니다.");
            } else {
                try {
                    int number = Integer.parseInt(input);
                    user.clear();
                    user.add(number / 100);
                    user.add((number / 10) % 10);
                    user.add(number % 10);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("올바른 숫자 형식이 아닙니다. 다시 시도해주세요.");
                }
            }
        }
    }

    public int countStrikes(List<Integer> resultNum, List<Integer> tryNum) {
        int countStrike = 0;
        for (int i = 0; i < resultNum.size(); i++) {
            if (resultNum.get(i).equals(tryNum.get(i))) {
                countStrike++;
            }
        }
        return countStrike;
    }

    public int countBalls(List<Integer> resultNum, List<Integer> tryNum) {
        int countBall = 0;
        for (int num : tryNum) {
            if (resultNum.contains(num) && !resultNum.get(tryNum.indexOf(num)).equals(num)) {
                countBall++;
            }
        }
        return countBall;
    }

    void play() {
        startMessage();

        while (true) {
            user.clear();
            computer.clear();
            makeComNum();
            int tries = 0;

            while (true) {
                getUserNum();
                int numStrikes = countStrikes(computer, user);
                int numBalls = countBalls(computer, user);
                tries++;

                if (numStrikes == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    String result = getResultString(numStrikes, numBalls);
                    System.out.println(result);
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();

            if (!choice.equals("1")) {
                System.out.println("게임 종료");
                break;
            }
        }
    }

    private String getResultString(int numStrikes, int numBalls) {
        if (numStrikes > 0 && numBalls > 0) {
            return numStrikes + "스트라이크 " + numBalls + "볼";
        } else if (numStrikes > 0) {
            return numStrikes + "스트라이크";
        } else if (numBalls > 0) {
            return numBalls + "볼";
        } else {
            return "낫싱";
        }
    }

    void run() {
        play();
    }
}