package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Print {
    private static final Print print = new Print();

    private Print() {
    }

    // 게임 시작
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 게임 중
    public String doGame() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    // 결과 출력
    public void resultGame(int[] result) {
        if (result[0] + result[1] == 0) System.out.println("낫싱");
        else if (result[0] == 0 && result[1] != 0) System.out.println(result[1] + "볼");
        else if (result[1] == 0 && result[0] != 0) System.out.println(result[0] + "스트라이크");
        else System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
    }

    // 정답 출력
    public int finishGame(List<Integer> list) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choiceNum = Integer.parseInt(Console.readLine());
        if (choiceNum == 1) list.clear();
        return choiceNum;
    }


    public static Print getPrint() {
        return print;
    }

}
