package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
public class BullsAndCowsComputer {
    List<Integer> secretNumber;
    String gameResult;
    boolean isCorrect = false;

    public void PlayGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.secretNumber = createSecretNumber();
        UsrInput usrInput = new UsrInput();

        while (!isCorrect){
            List<Integer> input = usrInput.getUsrInput();
            this.gameResult = checkUsrCorrect(secretNumber,input);
            if (Objects.equals(this.gameResult, "3스트라이크")){
                System.out.println(this.gameResult);
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                this.isCorrect = true;
            } else{
                System.out.println(this.gameResult);
            }
        }


    }

    public List<Integer> createSecretNumber() {
        List<Integer> secretNumber = new ArrayList<>();
        while (secretNumber.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!secretNumber.contains(randomNumber)) {
                secretNumber.add(randomNumber);
            }
        }

        return secretNumber;
    }

    public String checkUsrCorrect(List<Integer> computer , List<Integer> player) {
        int numOfMatch = countNumOfMatch(computer,player);
        int numOfStrike = countNumOfStrike(computer, player);
        int ball = numOfMatch - numOfStrike;

        if(numOfMatch == 0){
            return "낫싱";
        }else if(numOfStrike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return numOfStrike + "스트라이크";
        }
        return ball + "볼 " + numOfStrike + "스트라이크";
    }


    public int countNumOfMatch(List<Integer> computer , List<Integer> player){
        int count = 0;
        for (Integer integer : player) {
            if (computer.contains(integer)) {
                count += 1;
            }
        }

        return count;
    }

    public int countNumOfStrike(List<Integer> computer , List<Integer> player){
        int strike = 0;
        for(int i = 0; i < player.size(); i++){
            if(Objects.equals(computer.get(i), player.get(i))){
                strike += 1;
            }
        }
        return strike;
    }
}
