package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int strike;
    private int ball;
    private List<Integer> computer_number = new ArrayList<>();

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        createComputerNumber();
    }

    private void createComputerNumber() { //컴퓨터가 3개의 숫자를 랜덤으로 생성
        while (computer_number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_number.contains(randomNumber)) { //중복되지 않는 숫자인 경우에만 리스트에 추가
                computer_number.add(randomNumber);
            }
        }
    }

    public void calculateStrikeAndBall(List<Integer> input_number) { //스트라이크와 볼의 개수를 계산
        this.strike = 0;
        this.ball = 0;

        for(int i=0; i<input_number.size(); i++) {
            if(computer_number.get(i) == input_number.get(i)) this.strike++;
            else if(computer_number.contains(input_number.get(i))) this.ball++;
        }
    }

    public boolean getResult(List<Integer> gamer_number) { //게임의 결과를 출력
        calculateStrikeAndBall(gamer_number);
        if(this.strike == 3) { //3개의 숫자를 모두 맞힌 경우
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if(this.strike == 0 && this.ball == 0) { //하나도 없는 경우
            System.out.println("낫싱");
            return false;
        } else if(this.strike > 0 && this.ball == 0) { //스트라이크만 있는 경우
            System.out.println(this.strike + "스트라이크");
            return false;
        } else if(this.strike == 0 && this.ball > 0) { //볼만 있는 경우
            System.out.println(this.ball + "볼");
            return false;
        } else { //볼과 스트라이크가 모두 있는 경우
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
            return false;
        }
    }
}