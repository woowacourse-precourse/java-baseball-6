package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final InputService inputService;
    private final RandomService randomService;
    private final CompareService compareService;
    private final List<Integer> computer = new ArrayList<>();
    private List<Integer> inputValueList;

    public GameService() {
        this.inputService = new InputService();
        this.randomService = new RandomService();
        this.compareService = new CompareService();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomService.random(computer);

        while(true) {
            compareService.init();
            inputValueList = inputService.input();
            String result = compareService.run(inputValueList, computer);
            System.out.println(result);

            if (isGameOver(result) == 0) return;
        }
    }

    // 결과값으로 게임 종료를 판단하는 로직
    private int isGameOver(String result) {
        if(result.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            // 다시 시작
            if(input.equals("1")) {
                computer.clear();
                randomService.random(computer);
            }
            // 종료
            else return 0;
        }
        return 1;
    }
}
