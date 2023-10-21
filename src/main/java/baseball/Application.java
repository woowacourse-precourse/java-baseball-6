package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int ball = 0, strike = 0; // 점수를 저장할 변수
    // 컴퓨터와 유저의 숫자 리스트 선언
    private static final List<Integer> computer = new ArrayList<>(); // 컴퓨터 숫자 리스트 변수
    private static List<Integer> user = new ArrayList<>(); // 유저 숫자 리스트 변수

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 숫자 야구 게임 시작 메시지 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame(); // 게임 시작
    }

    // 점수를 측정하여 갱신하는 메소드
    private static void getScore() {
        // 새로운 입력이므로 ball과 strike 초기화
        ball = 0;
        strike = 0;
        for (int idx = 0; idx < user.size(); idx++) {
            if (user.get(idx) == computer.get(idx)) {
                strike++;
            } else if (computer.contains(user.get(idx))) {
                ball++;
            }
        }
    }

    // 유저 입력을 받아오는 메소드
    private static List<Integer> inputUser() {
        List<Integer> tempList = new ArrayList<>();
        String userNum = Console.readLine();
        for (char c : userNum.toCharArray()) {
            int number = Character.getNumericValue(c);
            tempList.add(number);
        }
//        System.out.println("tempList: " + tempList);
        return tempList;
    }

    // 유저의 숫자 리스트를 초기화하는 메소드
    private static void clearUser() {
        user.clear();
    }

    // 컴퓨터의 숫자 리스트를 초기화하는 메소드
    private static void clearComputer() {
        computer.clear();
    }

    // 점수를 출력하는 메소드
    private static void printScore() {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if ((ball == 0) && (strike == 0)) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    private static void playGame() {
        boolean restart = false;
        clearComputer(); // 컴퓨터 번호 초기화
        clearUser(); // 유저 번호 초기화
        // 컴퓨터 3가지 숫자 랜덤 저장
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while (true) {
//            System.out.println("Computer: " + computer);
            System.out.print("숫자를 입력해주세요 : ");
            try {
                user = inputUser();
            } catch (Exception e) { // 입력 에러 발생 시 exception throw
                throw new IllegalArgumentException();
            }
            if (user.size() != 3) {
                throw new IllegalArgumentException();
            }

            getScore(); // 점수 갱신
            printScore(); // 점수 출력
            clearUser(); // 유저가 입력한 번호 초기화

            if (strike == 3) { // 정답 !
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                List<Integer> temp = inputUser();
                if (temp.size() != 1) {
                    throw new IllegalArgumentException();
                }
                if (temp.get(0) == 1) { //
                    restart = true; // 재시작 플래그 세팅
                    break;
                } else {
                    break;
                }
            }
        }
        // 재시작
        if (restart) {
            playGame();
        }
    }
}
