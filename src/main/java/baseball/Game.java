package baseball;

import java.util.List;

public class Game {

    public void play() {

        GameCounter counter = new GameCounter();
        Judgement judgement = new Judgement();
        RandomNumberGenerator computerNumberGenerator = new RandomNumberGenerator();
        UserNumberReader userNumberReader = new UserNumberReader(new UserNumberValidator());

        List<Integer> computerNumbers = computerNumberGenerator.createNumbers();

        String result = "";
        while (!result.equals("3스트라이크")) {
            List<Integer> userNumbers = userNumberReader.read();
            int total = counter.countTotal(computerNumbers, userNumbers);
            int strike = counter.countStrike(computerNumbers, userNumbers);
            result = judgement.judge(total, strike);
            System.out.println(result);
        }
    }

}
