package baseball;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GamePlay {
    private final GameControl gameControl;
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> input = new ArrayList<>();
    
    public GamePlay(GameControl gameControl) {
        this.gameControl = gameControl;
    }

    public void start() {
        this.printFirstMessage();
        this.setAnswer();
    }

    public void process() {
        this.printProcessMessage();
        while(!this.inputAnswer(Console.readLine()).equals("3스트라이크")){
            continue;
        }
        this.isAnswer();
    }
    
    private void printFirstMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    
    private void printProcessMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    private void setAnswer() {
        this.computer.clear();
        while(this.computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.computer.contains(randomNumber)) {
                this.computer.add(randomNumber);
            }
        }
    }

    private String inputAnswer(String str) {
        String result;
        InputDto.validateNumber(str);
        this.input = InputDto.convertToNumberList(str);
        result = checkAnswer(this.input);
        System.out.println(result);
        return result;
    }

    private String checkAnswer(List<Integer> list) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i ++) {
            if (list.get(i).equals(this.computer.get(i))) {
                strikeCount++;
            } else if (this.computer.contains(list.get(i))) {
                ballCount++;
            }
        }
        if(strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        if(strikeCount == 3) {
            return "3스트라이크";
        }

        StringBuilder result = new StringBuilder();
        if( ballCount > 0) {
            result.append(ballCount).append("볼 ");
        }
        if(strikeCount > 0) {
            result.append(strikeCount).append("스트라이크");
        }
        return result.toString().trim();
    }

    private void isAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        gameControl.changeContinue();
    }
}
