package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    static List<Integer> computer = new ArrayList<>();

    static private void initailizeComputer() {
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    static private void inputCheck(String input) {
        // 포맷 체크
        if (!input.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

        //중복 체크
        if (input.charAt(0) == input.charAt(1)
                || input.charAt(0) == input.charAt(2)
                || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException("입력에 중복된 숫자가 존재합니다.");
        }
    }

    static public void play() {

        int gameFlag = 1;
        while (gameFlag == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            initailizeComputer();
            Judge judge = new Judge(computer);

            boolean correct = false;
            while (!correct) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputString = Console.readLine();
                inputCheck(inputString);
                correct = judge.makeJudgement(inputString);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameFlag = Integer.parseInt(Console.readLine());
        }
    }
}
