package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;

public class BaseballService {

    public List<Integer> generateAnswer() {
       return GenerateRandomNum.generate();
    }

    public List<Integer> userPlayInput() {
        String input = Console.readLine();
        List<Integer> userInput = new ArrayList<>();
        return stringToList(input);
    }

    public int userRestartInput() {
        return Integer.parseInt(Console.readLine());
    }

    public boolean getResult(List<Integer> player, List<Integer> answer) {
        Score score = getScore(player, answer);
        if(score.getStrike() == 3) {
            System.out.println(score.getStrike() + "스트라이크");
            return true;
        } else if (score.getStrike() == 0 && score.getBall() == 0){
            System.out.println(NoticeType.NOTHING.getMessage());
        } else {
            System.out.println(score.getBall() + "볼 " + score.getStrike() + "스트라이크");
        }

        return false;
    }

    public Score getScore(List<Integer> player, List<Integer> answer) {

        int strikes = 0, balls = 0;

        for(int i=0;i<player.size();i++) {
            if(isStrike(player, answer, i)) {
                strikes++;
            }
            if(isBall(player, answer, i)) {
                balls++;
            }
        }
        return new Score(strikes, balls);
    }

    public boolean isRestart(int num) {
        if(num == 1) {
            return true;
        }
        return false;
    }

    public boolean isStrike(List<Integer> player, List<Integer> answer, int index) {
        return Objects.equals(player.get(index), answer.get(index));
    }

    public boolean isBall(List<Integer> player, List<Integer> answer, int index) {
        return answer.contains(player.get(index)) && !isStrike(player, answer, index);
    }

    public List<Integer> stringToList(String str) {
        List<Integer> list = new ArrayList<>();
        for(String s : str.split("")) {
            list.add(Integer.parseInt(s));
        }

        return list;
    }
}
