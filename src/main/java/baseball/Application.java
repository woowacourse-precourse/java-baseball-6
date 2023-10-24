package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        List<Integer> computer = new ArrayList<>(); // 컴퓨터가 만들어내는 숫자

        int restart = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restart != 2) {
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            int strike = 0;
            int ball = 0;
            System.out.print("숫자를 입력해주세요 : ");
            userInput = readLine();
            if (userInput.length() != 3) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if (computer.get(0).equals(Character.getNumericValue(userInput.charAt(0)))) { //첫번째 자리 일치
                strike++;
                if (computer.get(1).equals(Character.getNumericValue(userInput.charAt(2)))) {
                    ball++;
                }
                if (computer.get(2).equals(Character.getNumericValue(userInput.charAt(1)))) {
                    ball++;
                }
            } else if (!computer.get(0).equals(Character.getNumericValue(userInput.charAt(0)))) { //첫번째 자리는 일치X, 볼 확인
                if (computer.get(1).equals(Character.getNumericValue(userInput.charAt(2)))) {
                    ball++;
                }
                if (computer.get(2).equals(Character.getNumericValue(userInput.charAt(1)))) {
                    ball++;
                }
            }
            if (computer.get(1).equals(Character.getNumericValue(userInput.charAt(1)))) { //두번째 자리 일치
                strike++;
                if (computer.get(0).equals(Character.getNumericValue(userInput.charAt(2)))) {
                    ball++;
                }
                if (computer.get(2).equals(Character.getNumericValue(userInput.charAt(0)))) {
                    ball++;
                }
            } else if (!computer.get(1).equals(Character.getNumericValue(userInput.charAt(1)))) { //두번 째 자리는 일치X, 볼 확인
                if (computer.get(0).equals(Character.getNumericValue(userInput.charAt(2)))) {
                    ball++;
                }
                if (computer.get(2).equals(Character.getNumericValue(userInput.charAt(0)))) {
                    ball++;
                }
            }
            if (computer.get(2).equals(Character.getNumericValue(userInput.charAt(2)))) { //세번째 자리 일치
                strike++;
                if (computer.get(1).equals(Character.getNumericValue(userInput.charAt(0)))) {
                    ball++;
                }
                if (computer.get(0).equals(Character.getNumericValue(userInput.charAt(1)))) {
                    ball++;
                }
            } else if (!computer.get(2).equals(Character.getNumericValue(userInput.charAt(2)))) { //세번째 자리는 일치 X, 볼 확인
                if (computer.get(1).equals(Character.getNumericValue(userInput.charAt(0)))) {
                    ball++;
                }
                if (computer.get(0).equals(Character.getNumericValue(userInput.charAt(1)))) {
                    ball++;
                }
            }
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike != 0 && ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            }
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart = Integer.parseInt(readLine()); //재시작, 종료 구분하는 1과2 중 하나의 수
                if (restart == 1) { //재시작 시 숫자 초기화
                    computer.clear();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                } else if (restart == 2) {
                    break;
                } else if (restart != 1 && restart != 2) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
        }
    }
}
