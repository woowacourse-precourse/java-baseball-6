package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터가 숫자 3개를 고른다.
        List<Integer> computer = chooseNumByComputer();

        while (true) {
            // 유저가 숫자 3개를 고른다.
            List<Integer> user = chooseNumByUser();

            // TODO 게임 종료 판단 기능 추가 시 삭제
            break;
        }
    }

    private static List<Integer> chooseNumByComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> chooseNumByUser() {
        System.out.println("숫자를 입력해주세요 : ");

        String userInput;
        userInput = scanner.next();

        List<Integer> num = new ArrayList<>();
        // 유저의 입력을 숫자 리스트로 변환
        for (int i = 0; i < userInput.length(); i++) {
            num.add(userInput.charAt(i) - '0');
        }
        return num;
    }
}
