package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    static Console cs;
    static List<Integer> randomNumber;

    public static void main (String[] args) {
        boolean gameInProgress = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            createRandomNumber();
            boolean isCorrectAnswer = false;

            do {
                List<Integer> userNumber = getUserNumber();
                if(checkAnswer(userNumber)) {
                    isCorrectAnswer = true;
                }
                else giveHint(userNumber);
            } while(!isCorrectAnswer);

            System.out.println("게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int num = getUserInput();
            if (num==1) gameInProgress = true;
            else gameInProgress = false;

        } while(gameInProgress);
    }

    public static void createRandomNumber() {
        randomNumber = new ArrayList<>();

        while(randomNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (randomNumber.contains(number)) continue;
            randomNumber.add(number);
        }
    }

    public static boolean checkAnswer(List<Integer> trial) {
        for (int i = 0; i < trial.size(); i++) {
            if (!Objects.equals(randomNumber.get(i), trial.get(i))) {
                return false;
            }
        }
        System.out.println("3스트라이크");
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        return true;
    }

    public static void giveHint(List<Integer> trial) {
        StringBuilder hint = new StringBuilder();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < randomNumber.size(); i++) {
            if (Objects.equals(randomNumber.get(i), trial.get(i))) strike++;
            else {
                for (int j = 0; j < trial.size(); j++) {
                    if (Objects.equals(randomNumber.get(i), trial.get(j))) {
                        ball++;
                        break;
                    }
                }
            }
        }

        if (strike==0 && ball==0) System.out.print("낫싱");
        if (ball > 0) hint.append(ball+"볼 ");
        if (strike > 0) hint.append(strike+"스트라이크");

        System.out.println(hint);
    }

    public static List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userTrial = Integer.toString(getUserInput());
        List<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < userTrial.length(); i++) {
            userNumber.add(Character.getNumericValue(userTrial.charAt(i)));
        }
        return userNumber;
    }

    public static int getUserInput() {
        String userNumber = Console.readLine();
        checkInput(userNumber);
        return Integer.valueOf(userNumber);
    }

    public static void checkInput(String userNumber) {
        if (userNumber.length() != 3 && userNumber.length() != 1) {
            throw new IllegalArgumentException();
        }
    }
}
