package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballFunction {
    public static List<Integer> genNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    public static List<Integer> getNum(){
        List<Integer> player = new ArrayList<>();
        int input = Integer.parseInt(Console.readLine());
        if (input>=1000){
            throw new IllegalArgumentException();
        }
        player.add(input/100);
        player.add((input%100)/10);
        player.add(input%10);

        return player;
    }

    public static Score compare(List<Integer> computer, List<Integer> player){
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            boolean isStrike = computer.get(i).equals(player.get(i));
            boolean isBall = !isStrike & computer.contains(player.get(i));

            if (isStrike) strike++;
            if(isBall) ball++;
        }
        return new Score(strike, ball);
    }

    public static void printScore(Score score){
        boolean isNotiong = score.strike == 0 & score.ball == 0;
        if (isNotiong){
            System.out.println("낫싱");
            return;
        }if (score.ball != 0 & score.strike != 0){
            System.out.println(score.ball+"볼 "+score.strike+"스트라이크");
            return;
        }if (score.strike == 0){
            System.out.println(score.ball+"볼");
            return;
        }if (score.ball == 0){
            System.out.println(score.strike+"스트라이크");
            return;
        }
    }
    public static void main(String[] args) {
        printScore(compare(genNum(),getNum()));
    }
}
