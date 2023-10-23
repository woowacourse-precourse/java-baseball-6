package baseball;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;




public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computerNumber = new Init().getComputerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            CheckException checkException = new CheckException();

            try {
                if (checkException.error(userInput)) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                break;
            }

            Output output = new Output();
            output.setScore(computerNumber,userInput);
            output.printOutput();

            boolean error = false;
            if (output.userWin()) {
               output.printGameEnd();
                String continueOrEnd = Console.readLine();
                if (continueOrEnd.length() != 1) error = true;

                for (int i = 0; i < continueOrEnd.length(); i++) {
                    if (continueOrEnd.charAt(i) != '1' && continueOrEnd.charAt(i) != '2') {
                        error = true;
                        break;
                    }
                }


                try {
                    if (error) throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    break;
                }

                if (continueOrEnd.charAt(0) == '1') {
                    computerNumber.clear();
                    while (computerNumber.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computerNumber.contains(randomNumber)) {
                            computerNumber.add(randomNumber);
                        }
                    }
                } else if (continueOrEnd.charAt(0) == '2') {
                    break;
                }
            }
        }

    }
}
