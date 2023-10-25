package baseball;

import java.util.ArrayList;

// 게임 진행 요원
public class GameMaster {

    public boolean playGame() {
        Computer computer = new Computer();
        ArrayList<Integer> answer = computer.getAnswer();

        // 숫자 3개를 모두 맞출때 까지 반복
        while (!matchNums(answer)) {
        }

        return true; // 답을 맞추면 게임종료
    }

    private boolean matchNums(ArrayList<Integer> answer) {
        System.out.print("숫자를 입력해주세요 : ");
        Player player = new Player();
        ArrayList<Integer> nums = player.getNums();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.size(); i++) {
            int cNum = answer.get(i);
            int pNum = nums.get(i);

            if (cNum == pNum)
                strike++;// i번째 값이 서로 같다면
            else if (answer.contains(pNum))
                ball++; // answer리스트에 pNum값이 존재한다면
        }
        return printResult(strike, ball);
    }

    private boolean printResult(int strike, int ball) {
        String output = "";

        if (ball > 0)
            output += ball + "볼 ";
        if (strike > 0)
            output += strike + "스트라이크";
        if (strike == 0 && ball == 0)
            output += "낫싱";

        System.out.println(output.trim());
        return (strike == 3);
    }

}
