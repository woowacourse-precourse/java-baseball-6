package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

//숫자를 랜덤으로 생성해서 게임 진행을 해주는 친구
public class GameManager {
    private Player player;
    private Computer computer;

    public void startGame() {
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> inputNumbers = player.getNumbers();
            if (!isValid(inputNumbers)) {
                return (new IllegalArgumentException);
            }
            int[] result = judge(inputNumbers);
            System.out.println(result[0] + "스트라이크 " + result[1] + "볼");
            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        if (input.equals("1")) {
            startGame();
        } else {
            System.out.println("게임을 종료합니다.");
        }
    }
    private int[] judge(List<Integer> numbers) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (numbers.get(i) == computer.getNumbers().get(i)) {
                result[0]++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (numbers.get(i) == computer.getNumbers().get(j)) {
                        result[1]++;
                        break;
                    }
                }
            }
        }
        return result;
    }


}
