package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class BaseballGame {
    private int strike;
    private int ball;
    ComputerNumber computerNumber = new ComputerNumber();
    InputNumber inputNumber = new InputNumber();
    private String computerNum = computerNumber.getComputerNumber();
    public BaseballGame() {}
    public void start(){

        while (true) {
            String inputNum = inputNumber.input();
            for (int i = 0; i < 3; i++) {
                if(computerNum.charAt(i) == inputNum.charAt(i)) {
                    strike++;
                } else if(computerNum.indexOf(inputNum.charAt(i)) >= 0) {
                    ball++;
                }
            }
            boolean control = compare();
            if(control) {
                if (nextGame()) refresh();
                else break;
            }
        }
    }

    private void refresh() {
        computerNumber.setNumber();
        computerNum = computerNumber.getComputerNumber();
        strike=0;
        ball=0;
    }

    public boolean compare(){
        if(strike==3){
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else {
            if(strike>0&&ball>0) {
                System.out.println(ball + "볼" + " " + strike + "스트라이크");
            } else if(strike>0) {
                System.out.println(strike + "스트라이크");
            } else if (ball>0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println("낫싱");
            }
        }
        strike=0;
        ball=0;
        return false;
    }
    private boolean nextGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String oneTwo = readLine();
        if(oneTwo.equals("1")) {
            return true;
        } else if(oneTwo.equals("2")) {
            return false;
        }
        else{
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
