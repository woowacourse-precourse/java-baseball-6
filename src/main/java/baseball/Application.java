package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    String playFlag;
    List<Integer> target = new ArrayList<>();
    String input;
    int strike;
    int ball;

    public void setPlayFlag() {
        this.playFlag = "1";
    }

    private void setTargetNumber() {
        while (this.target.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.target.contains(randomNumber)){
                this.target.add(randomNumber);
            }
        }
    }

    private void printTargetNumber() {
        System.out.println(this.target);
    }

    public void setHint() {
        this.ball = 0;
        this.strike = 0;
    }

    public void getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        this.input = Console.readLine();
    }

    public void checkInputValid() {
        if (this.input.length() != 3) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        try {
            Integer.parseInt(this.input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        if (this.input.contains("0")) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        char firstChar = this.input.charAt(0);
        char secondChar = this.input.charAt(1);
        char thirdChar = this.input.charAt(2);
        if (firstChar == secondChar || secondChar == thirdChar || thirdChar == firstChar) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    public void getHint() {
        Integer inputFirstDigit = Character.getNumericValue(this.input.charAt(0));
        Integer inputSecondDigit = Character.getNumericValue(this.input.charAt(1));
        Integer inputThirdDigit = Character.getNumericValue(this.input.charAt(2));
        Integer targetFirstDigit = target.get(0);
        Integer targetSecondDigit = target.get(1);
        Integer targetThirdDigit = target.get(2);

        if (inputFirstDigit.equals(targetFirstDigit)) {
            this.strike += 1;
        } else if (this.target.contains(inputFirstDigit)) {
            this.ball += 1;
        }

        if (inputSecondDigit.equals(targetSecondDigit)) {
            this.strike += 1;
        } else if (this.target.contains(inputSecondDigit)) {
            this.ball += 1;
        }

        if (inputThirdDigit.equals(targetThirdDigit)) {
            this.strike += 1;
        } else if (this.target.contains(inputThirdDigit)) {
            this.ball += 1;
        }

    }

    public void printHint() {
        if (this.ball == 0 && this.strike == 0) {
            System.out.println("낫싱");
        } else if (this.ball == 0) {
            System.out.println(String.format("%d스트라이크", this.strike));
        } else if (this.strike == 0) {
            System.out.println(String.format("%d볼", this.ball));
        } else {
            System.out.println(String.format("%d볼 %d스트라이크", this.ball, this.strike));
        }
    }

    public static String askRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public static void checkAskValid(String playFlag) {
        if (!playFlag.equals("1") && !playFlag.equals("2")) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    public static void main(String[] args) {
        String playFlag;
        playFlag = "1";
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (playFlag.equals("1")){

            Application application = new Application();

            application.setTargetNumber();

            //application.printTargetNumber();

            application.setHint();

            while (application.strike < 3) {
                application.setHint();

                application.getInputNumber();

                application.checkInputValid();

                application.getHint();

                application.printHint();
            }

            playFlag = askRestart();

            checkAskValid(playFlag);
        }
    }
}
