package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Game {

    public void play() {
        List<Integer> computerNum = setComputerNum();
        List<Integer> inputNum = new ArrayList<>();
        while (!inputNum.equals(computerNum)) {
            inputNum = setInput();
        }
        replay();
    }

    /**
     * 게임 재시작, 종료 여부
     */
    private void replay() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int game = Integer.parseInt(Console.readLine());
        if (game == 1) {
            play();
        } else if (game == 2) {
            System.out.println("--게임 종료--");
        }
    }

    /**
     * 컴퓨터 수 설정
     *
     * @return 컴퓨터 수
     */
    private List<Integer> setComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        System.out.print(computerNum.get(0));
        System.out.print(computerNum.get(1));
        System.out.println(computerNum.get(2));
        return computerNum;
    }

    /**
     * 공백 없이 입력받기
     *
     * @return 입력 수
     */
    private List<Integer> setInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String[] input = Console.readLine().split("");
        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            inputNum.add(Integer.parseInt(input[i]));
        }
        return inputNum;
    }
}

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        game.play();
        Console.close();
    }
}
