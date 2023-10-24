package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = getComputerNums();
        Scanner sc = new Scanner(System.in);
        outer: while (true) {
            String userNum = sc.nextLine();
            LinkedList<Integer> user = getUser(userNum);
            int strikes = 0;
            int balls = 0;

            strikes = findstrikes(computer, user, strikes);
            balls = findBall(computer, user, balls);
            if (strikes == 3) { //s =3
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int play = sc.nextInt();
                if(play ==1){
                    computer = getComputerNums();
                    sc.nextLine(); // 개행문자 비우기
                } else if (play == 2) {
                    sc.close();
                    break outer;
                }else {
                    throw new IllegalStateException("잘못 입력하였습니다");
                }

            } else {
                result(strikes, balls);
            }
        }

    } //main

    private static List<Integer> getComputerNums() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static LinkedList<Integer> getUser(String s_num) {
        LinkedList<Integer> myNum = new LinkedList<>();
        if (s_num.length() != 3 || !s_num.matches("[0-9]+")) { //길이 체크 및 숫자 인지
            throw new IllegalArgumentException("값을 제대로 입력해주세요");
        }
        String[] split = s_num.split("");
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(split[i]);
            if (num < 1 || num > 9 || myNum.contains(num)) {  //음수처리 및 서로 다른 문자인지
                throw new IllegalArgumentException("값을 제대로 입력해주세요");
            }
            myNum.add(num);
        }
        return myNum;
    }

    private static void result(int strikes, int balls) {
        if (balls > 0 && strikes > 0) { //둘다
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else if (balls > 0 && strikes == 0) {//ball만
            System.out.println(balls + "볼");
        } else if (balls == 0 && strikes > 0) {//strike만 있는 경우
            System.out.println(strikes + "스트라이크");
        } else {//아무거도 없어
            System.out.println("낫싱");
        }
    }

    private static int findBall(List<Integer> computer, List<Integer> user, int balls) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (user.get(i) == computer.get(j) && (i != j)) {
                    balls++;
                }
            }
        }
        return balls;
    }

    private static int findstrikes(List<Integer> computer, List<Integer> user, int strikes) {
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i) == computer.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }
}
