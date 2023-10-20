package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String computerNum = makeRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine().strip();
            checkInput(input);

            compare(input, computerNum);
        }
    }

    private static void compare(String input, String computerNum) {
        int strikeCnt = 0;
        int ballCnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<input.length(); i++) {
            for (int j=0; j<computerNum.length(); j++) {
                if (input.charAt(i) == computerNum.charAt(j)) {
                    if (i == j) {
                        strikeCnt++;
                    } else {
                        ballCnt++;
                    }
                }
            }
        }

        if (strikeCnt==3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            if (ballCnt==0 && strikeCnt==0) {
                sb.append("낫싱");
            } else {
                if (ballCnt!=0) {
                    sb.append(ballCnt + "볼 ");
                }

                if (strikeCnt!=0) {
                    sb.append(strikeCnt + "스트라이크");
                }
            }

            System.out.println(sb);
            System.out.println(computerNum);
        }
    }

    private static String makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return "" + computer.get(0) + computer.get(1) + computer.get(2);
    }

    private static void checkInput(String input) {
        //세 글자인지 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 글자가 아닙니다");
        }

        //1-9 사이 숫자인지 확인
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("1에서 9사이 숫자가 아닙니다");
        }
        
        //셋 다 다른 숫자인지 확인
        if (hasSameNumber(input.charAt(0), input.charAt(1), input.charAt(2))) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다");
        }
    }

    private static boolean hasSameNumber(char c1, char c2, char c3) {
        if (c1==c2) {
            return true;
        }

        if (c2==c3) {
            return true;
        }

        if (c3==c1) {
            return true;
        }

        return false;
    }
}
