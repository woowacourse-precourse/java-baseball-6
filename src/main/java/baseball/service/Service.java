package baseball.service;

import baseball.entity.Score;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Service {

    public List<Integer> makeNumber(){

        return IntStream.range(0,3)
                .mapToObj(i->Randoms.pickNumberInRange(1, 9))
                .toList();
    }

    public List<Integer> readNumber(){
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 문자열의 길이는 3이어야 합니다.");
        }

        return input.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public void checkStrike(List<Integer> computer, List<Integer> user, Score score){
        int strike = score.getStrike();
        strike = (int) IntStream.range(0,3)
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();
        score.setStrike(strike);
    }

    public void checkBall(List<Integer> computer, List<Integer> user, Score score){
        int ball = score.getStrike();
        ball = (int) IntStream.range(0, 3)
                .filter(i -> !computer.get(i).equals(user.get(i)) && computer.contains(user.get(i)))
                .count();
        score.setBall(ball);
    }

    public boolean countScore(List<Integer> computer, List<Integer> user, Score score, boolean quit){
        checkStrike(computer, user, score);
        checkBall(computer, user, score);

        int strike = score.getStrike();
        int ball = score.getBall();

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike == 3) {
            System.out.println("3스트라이크");
            quit = true;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball > 0 && strike > 0 ){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return quit;

    }

}
