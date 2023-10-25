package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballFunction {
    public List<Integer> genNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> getNum(){
        List<Integer> player = new ArrayList<>();
        int input;

        System.out.print("숫자를 입력해주세요 : ");

        try {
            input = Integer.parseInt(Console.readLine());
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        if (input>=1000){
            throw new IllegalArgumentException();
        }

        player.add(input/100);
        player.add((input%100)/10);
        player.add(input%10);

        return player;
    }

    public Score compare(List<Integer> computer, List<Integer> player){
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

    public void printScore(Score score){
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

    public boolean threeStrike(){

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int input = Integer.parseInt(Console.readLine());

        if (input == 1) return true;
        if (input == 2) return false;

        throw new IllegalArgumentException();

    }

}
