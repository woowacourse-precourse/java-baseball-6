package baseball;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
public class NewGame {
    List<Integer> Answer;
    String gameResult;
    boolean run2 = false;
    public void newGamePlay() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.Answer = createAnswer();
        Validation userInput = new Validation();

        while (!run2){
            List<Integer> input = userInput.getUserInput();
            this.gameResult = checkAnswer(Answer, input);
            if (Objects.equals(this.gameResult, "3스트라이크")){
                System.out.println(this.gameResult);
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                this.run2 = true;
            }
            else{
                System.out.println(this.gameResult);
            }
        }
    }

    public List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    public String checkAnswer(List<Integer> computer, List<Integer> user){
        int ballCount = countBall(computer, user);
        int strikeCount = countStrike(computer, user);
        int ball = ballCount - strikeCount;

        if(ballCount == 0){
            return "낫싱";
        }else if(strikeCount == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strikeCount + "스트라이크";
        }
        return ball + "볼 " + strikeCount + "스트라이크";
    }

    public int countBall(List<Integer> computer, List<Integer> user){
        int cntb = 0;
        for (Integer num : user) {
            if(computer.contains(num)) {
                cntb += 1;
            }
        }
        return cntb;
    }

    public int countStrike(List<Integer> computer, List<Integer> user){
        int cnts = 0;
        for(int i = 0; i <user.size(); i++){
            if(Objects.equals(computer.get(i), user.get(i))){
                cnts += 1;
            }
        }
        return cnts;
    }
}

