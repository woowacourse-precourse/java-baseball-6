package baseball.service;

import baseball.domain.Number;
import baseball.domain.Score;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;



public class GameService {

    private final Number number = new Number();
    private final ValidCheckService validCheckService = new ValidCheckService();

    private final List<Integer> computerNumber = new ArrayList<>();

    private final InputView inputView = new InputView();

    //컴퓨터 숫자 생성
    public  List<Integer> generateRandomNumber(int length) {
        computerNumber.clear();
        while (computerNumber.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(number.MIN_NUM, number.MAX_NUM);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public int sameCount(List<Integer> computer, List<Integer> user){
        int same = 0;
        for (Integer integer : user) {
            if (computer.contains(integer)) {
                same++;
            }
        }
        return same;
    }
    public int countStrike(List<Integer> computer, List<Integer> user){
        int strike = 0;
        int i = 0;
        while (i < user.size()) {
            if(computer.get(i).equals(user.get(i))){
                strike ++;
            }
            i++;
        }
        return strike;
    }
    //same에서 strike를 뺀 값이 ball의 수가 된다.
    public int countBall(int same, int strike){
//        int ball = same - strike;
        return same - strike;
    }

    public List<Integer> getValidUserNumber() {
        String userInput = inputView.inputUserNumber();
        validCheckService.isValidStringNumber(userInput);
        return validCheckService.stringToIntegerList(userInput);
    }



    public Score countOnPlay(List<Integer> computer, List<Integer> user) {
        Score score = new Score();
        int same = sameCount(computer,user);
        int strike = countStrike(computer, user);
        int ball = countBall(same, strike);
        score.setScore(strike, ball);
        return score;
    }

}
