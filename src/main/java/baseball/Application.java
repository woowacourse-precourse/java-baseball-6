package baseball;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class Computer {
    List<Integer>  numbers;

    // 생성자는 리턴 자료형을 정의하지 않는다
    Computer() {
        this.numbers = new ArrayList<>();
        setRandomNumbers(this.numbers);
    }

    // 종료조건 반환
    boolean userWin(String userInput){
        List<Integer>score = calculateScore(userInput);
        if (score.get(0) == 3)
            return true; // 게임 승리!
        printGameScore((score));
        return false;
    }
    private void printGameScore(List<Integer> score) {
        int strike = score.get(0);
        int ball = score.get(1);
        String printFormat = "";
        if (ball + strike == 0) {
            System.out.println("낫싱");
            return ;
        }
        if (ball != 0) {
            printFormat += String.format("%d볼", ball);
            if (strike != 0)
                printFormat += " ";
        }
        if (strike != 0)
            printFormat += String.format("%d스트라이크", strike);
        System.out.println(printFormat);
    }

    private void setRandomNumbers(List<Integer> list) {
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
        // 아래는 테스트용. 이후 삭제
        System.out.print("컴퓨터의 숫자 :");
        for (int item : list)
                System.out.print(item);
        System.out.println("");
    }

    // 입력 숫자가 컴퓨터 숫자와 얼마나 일치하는지 판단.
    private List<Integer> calculateScore(String userInput) {
        int strike = 0, ball = 0, userNum;
        for (int i = 0; i < 3; ++i) {
            char c = userInput.charAt(i);
            userNum = Character.getNumericValue(c);
            //this 없어도된대
            if (userNum == this.numbers.get(i))
                strike++;
            else if (this.numbers.contains(userNum))
                ball++;
        }
        List<Integer> score = new ArrayList<>();
        score.add(strike);
        score.add(ball);
        return score;
    }


}

class Game {
    Computer cp;
    Game() {
        // 새 게임이 시작되면, 메시지를 출력하고 새로운 컴퓨터를 생성
        System.out.println("숫자 야구 게임을 시작합니다.");
        cp = new Computer();
    }

    // 플레이 지속 시 true, 아닐 시 false 반환
    boolean playGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            // 잘못된 입력, 게임 종료
            if (!isValidInput(input)) {
                throw new IllegalArgumentException("정상값을 입력해 주세요.");
            }
            if (cp.userWin(input)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break ;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameEnd = Console.readLine();
        // 여기서도 유효한 값인지 확인해야 할듯.
        return isGameEnd(gameEnd);
    }

    // 사용자가 입력한 input이 유효한지 확인하고, 게임 종료 여부를 해석해 반환한다.
    boolean isGameEnd(String input) {
        if (input.length() != 1 || !input.matches("[0-9]+"))
            throw new IllegalArgumentException("정상값을 입력해 주세요.");
        if (input.charAt(0) == '1')
            return true;
        else if (input.charAt(0) == '2')
            return false;
        throw new IllegalArgumentException("1 혹은 2로 값을 입력해 주세요.");
    }

    // 3개의 '숫자'를 받았는지, 그 중 중복이 있는지를 판단
    boolean isValidInput(String input) {
        if (input.length() != 3 || !input.matches("[0-9]+"))
            return false;
        char c1 = input.charAt(0);
        char c2 = input.charAt(1);
        char c3 = input.charAt(2);
        return (c1 != c2) && (c2 != c3) && (c3 != c1);
    }
}

public class Application {

    public static void main(String[] args) {
        boolean continueGame = true;
        // TODO: 프로그램 구현
        while (continueGame) {
            try {
                Game gameMaster = new Game();
                continueGame = gameMaster.playGame();
            } catch (IllegalArgumentException e) {
                System.out.println("[오류 발생] : " + e.getMessage());
                break ;
            }
        }
    }
}
