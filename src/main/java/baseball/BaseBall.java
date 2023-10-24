package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        Score score = new Score();
        while(score.getStrike() != 3) {
            player.clear();
            System.out.print("숫자를 입력해주세요 : ");
            String stringPlayer = Console.readLine();
            score.reset();

            if(validationNumber(stringPlayer)) {
                convertPlayer(stringPlayer, player);
                getResult(computer, player, score);
                showResult(score);
            }
            else{
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
            }

        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean validationNumber(String stringPlayer) {
        if(stringPlayer.length() != 3)
            return false;
        for(char c : stringPlayer.toCharArray()){
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }

    public void convertPlayer(String stringPlayer, List<Integer> player) {
        String[] tmp = stringPlayer.split("");
        player.add(Integer.parseInt(tmp[0]));
        player.add(Integer.parseInt(tmp[1]));
        player.add(Integer.parseInt(tmp[2]));
    }

    public void getResult(List<Integer> computer, List<Integer> player, Score score) {
        for(int i = 0; i < 3; i++) {
            if(player.get(i) == computer.get(i))
                score.setStrike(score.getStrike() + 1);
            else if(computer.contains(player.get(i)))
                score.setBall(score.getBall() + 1);
        }
    }

    public void showResult(Score score) {
        if(score.getBall() == 0 && score.getStrike() == 0)
            System.out.print("낫싱");
        else {
            if(score.getBall() > 0)
                System.out.print(score.getBall() + "볼 ");
            if(score.getStrike() > 0)
                System.out.print(score.getStrike() + "스트라이크 ");
        }
        System.out.print("\n");
    }

    public int restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String state = Console.readLine();
        if(state.equals("1") || state.equals("2"))
            return Integer.parseInt(state);
        else
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
    }
}