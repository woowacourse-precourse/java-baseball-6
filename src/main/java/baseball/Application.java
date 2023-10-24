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
            System.out.println("낫싱\n");
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
            //if (!isValidInput(input))
                // 잘못된 입력, 게임 종료
            if (cp.userWin(input)) {
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break ;
            }
        }
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endGame = Console.readLine();
        // 여기서도 유효한 값인지 확인해야 할듯.
        //if (endGame)
        return true;
    }
    boolean isValidInput(String input) {
        return input.length() == 3 && input.matches("[0-9]+");
    }
}

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            Game gameMaster = new Game();
            if (!gameMaster.playGame())
                break ;
        }

    }
}
