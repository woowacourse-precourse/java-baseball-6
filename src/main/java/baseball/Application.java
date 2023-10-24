package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.ArrayList;

public class Application {
    static final int START = 1;
    static final int END = 2;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean onLoop = true;
        int flag = START;
        while(onLoop) {
            switch (flag) {
            case START:
                flag = playGame();
                // fall through
                break;
            case END:
                onLoop = false;
                break;
            default:
                throw new IllegalArgumentException();
            }
        }
    }

    private static int playGame() throws IllegalArgumentException {
        List<Integer> computer = generateComputer();
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = readLine();
            checkedException(inputNumber);

            int[] strikeAndBall = calculateStrikeBall(computer,inputNumber);
            int strike = strikeAndBall[0];
            int ball = strikeAndBall[1];
            String result = printStrikeBall(strike,ball);
            System.out.println(result);

            if (result.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return Integer.parseInt(readLine());
            }
        }
    }
    public static List generateComputer() {
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static int[] calculateStrikeBall(List<Integer> computer, String inputNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computer.size(); i++){
            int comparableNumber = Character.getNumericValue(inputNumber.charAt(i));
            if (computer.get(i) == comparableNumber){
                strike++;
            } else if (computer.contains(comparableNumber)){
                ball++;
            }
        }
        int[] strikeAndBall= {strike, ball};
        return strikeAndBall;
    }
    private static String printStrikeBall(int strike, int ball) {
        String result = "";
        if (strike==0 && ball==0){
            result = "낫싱";
        } else if (strike==0){
            result = ball + "볼";
        } else if (ball==0){
            result  = strike + "스트라이크";
        } else {
            result = ball+"볼 "+strike+"스트라이크";
        }
        return result;
    }
    private static void checkedException(String inputNumber) {
        String numberRegex = "^[1-9]+$";
        if (inputNumber.length()!= 3){
            throw new IllegalArgumentException();
        }else if (!inputNumber.matches(numberRegex)){
            throw new IllegalArgumentException();
        }

        String tmp = "";
        for (char c : inputNumber.toCharArray()) {
            String comparableNumber = String.valueOf(c);
            if (!tmp.contains(comparableNumber)) {
                tmp += comparableNumber;
            }else if (tmp.contains(comparableNumber)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
