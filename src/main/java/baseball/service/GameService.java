package baseball.service;

import baseball.domain.Score;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameService {

    ValidCheckService validCheckService = new ValidCheckService();

    //컴퓨터 숫자 생성
    public  List<Integer> generateRandomNumber(int length) {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public int sameCount(List<Integer> computer,List<Integer> player){
        int same = 0;
        for(int i = 0; i< player.size(); i++){
            if(computer.contains(player.get(i))){
                same ++;
            }
        }
        return same;
    }
    public int countStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.get(i).equals(player.get(i))){
                strike ++;
            }
        }
        return strike;
    }
    //same에서 strike를 뺀 값이 ball의 수가 된다.
    public int countBall(int same, int strike){
        int ball = same - strike;
        return ball;
    }
    public List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        validCheckService.isValidNumber(userInput);
        return validCheckService.stringToIntegerList(userInput);
    }

    public void countOnPlay(List<Integer> computer, List<Integer> user, Score score, int same) {
        int strike = countStrike(computer, user);
        int ball = countBall(same, strike);
        score.setScore(strike, ball);
    }






}
