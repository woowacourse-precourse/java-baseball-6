package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner sc = new Scanner(System.in);
        int playing = 1;

        while (playing == 1) {
            //랜덤 숫자 생성
            List<Integer> computer = getRandomNumber();

            //사용자 숫자 입력(맞을 때까지 반복)
            int ans = 0;

            while (ans == 0) {
                //잘못 입력 시 (IllegalArgumentException 발생)

                List<Integer> user = getUserNumber(sc);

                //숫자 비교
                //총 개수 확인
                int cnt = 0;

                cnt = totalCntCheck(computer, user, cnt);

                //스트라이크 개수 확인
                int strike = 0;

                strike = strikeCheck(computer, user, strike);

                //볼 개수 확인
                int ball = cnt - strike;

                //최종 출력
                ans = printAns(ans, cnt, strike, ball);
            }
            //게임 재시작 여부 확인
            playing = checkPlayAgain(sc);
        }
    }


    //클래스 정의 부분
    private static List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserNumber(Scanner sc) {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> user = new ArrayList<>();

        String input = sc.next();

        for (String num : input.split("")) {
            user.add(Integer.parseInt(num));
        }

        if (user.size() != 3 || user.size() != user.stream().distinct().count()) {
            throw new IllegalArgumentException("입력된 숫자를 확인해주세요.");
        }
        return user;
    }

    private static int totalCntCheck(List<Integer> computer, List<Integer> user, int cnt) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i))) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private static int strikeCheck(List<Integer> computer, List<Integer> user, int strike) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    private static int printAns(int ans, int cnt, int strike, int ball) {
        int playing;
        if (cnt == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            ans = 1;
            playing = 0;
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return ans;
    }

    private static int checkPlayAgain(Scanner sc) {
        int playing;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playAgain = sc.next();

        if (playAgain.equals("1")) {
            playing = 1;
        } else if (playAgain.equals("2")) {
            playing = 0;
        } else {
            throw new IllegalArgumentException();
        }
        return playing;
    }
}
