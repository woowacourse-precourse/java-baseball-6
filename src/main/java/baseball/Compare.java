package baseball;
/*
    클래스 명 : Compare
    설명      : 컴퓨터의 수와 사용자의 수를 비교
    작성자	  : 김준태
	날짜	  : 2023. 10. 23.
 */
import java.util.List;
public class Compare {
    private ComputerNumber computerNumber = new ComputerNumber();
    private UserInput userInput = new UserInput();

    public void CompareNumbers() {
        List<Integer> computerNumbers = computerNumber.randomNumber();
        int strikes, balls;
        while (true) {
            //사용자가 입력하는 수와 컴퓨터의 수가 일치할 때까지 반복
            strikes = 0;
            balls = 0;
            List<Integer> userNumbers = userInput.validatedUserInput();
            for (int i = 0; i < 3; i++) {
                if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                    strikes++;
                } else if (computerNumbers.contains(userNumbers.get(i))) {
                    balls++;
                }
            }
            if (strikes == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            else if (strikes > 0 || balls > 0) {
                System.out.println( balls + "볼 " + strikes + "스트라이크");
            }
            else if (strikes == 0 && balls == 0) {
                System.out.println("낫싱");
            }
        }
    }
}
