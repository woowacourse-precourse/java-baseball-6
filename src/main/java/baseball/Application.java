package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

class BaseballGame{
    int strike = 0;
    int ball = 0;

    void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    List<Integer> getRandomNum(){
        List<Integer> randomNum = new ArrayList<>();
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
       // System.out.println(Arrays.deepToString(randomNum.toArray()));
        return randomNum;
    }
    List<Integer> getUserInput() throws IllegalArgumentException{
        List<Integer> userNum = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        // 예외 처리 0포함할 경우 OR 길이가 3보다 클 경우 OR 같은 숫자를 입력한 경우
        if(userInput.contains("0") || userInput.length() != 3){
            throw new IllegalArgumentException();
        }
        int guessNum = Integer.parseInt(userInput);

        userNum.add(guessNum / 100);
        userNum.add((guessNum % 100) / 10);
        userNum.add(guessNum % 10);

        return userNum;
    }
    void compareNum(List<Integer> randomNum, List<Integer> userNum){
        strike = 0;
        ball = 0;

        for (int i = 0; i < randomNum.size(); i++) {
            for (int j = 0; j < userNum.size(); j++) {
                if (randomNum.get(i).equals(userNum.get(j)) && i == j) {
                    strike++;
                }
                if (randomNum.get(i).equals(userNum.get(j)) && i != j) {
                    ball++;
                }
            }
        }

    }
    int printHint(){
        if (strike == 0 && ball == 0)
            System.out.println("낫싱");

        if(strike == 0 && ball != 0)
            System.out.printf("%d볼\n", ball);

        if(strike != 0 && ball == 0)
            System.out.printf("%d스트라이크\n", strike);

        if(strike !=0 && ball != 0)
            System.out.printf("%d볼 %d스트라이크\n", strike, ball);

        if (strike == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        return strike;
    }

    int continueGame()throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playInput = Console.readLine();
        int play = Integer.parseInt(playInput);
        if(!(play == 1 || play == 2))
            throw new IllegalArgumentException();

        return play;

    }
}
public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        BaseballGame b = new BaseballGame();

        // 게임 시작멘트 출력
        b.printStart();

        while(true) {
            // 랜덤으로 세 자리 숫자 생성
            List<Integer> randomNum = b.getRandomNum();
            while (true) {
                // 사용자에게 세 자리 수 입력받기
                List<Integer> userNum = b.getUserInput();
                // 랜덤값과 사용자 입력값을 비교
                b.compareNum(randomNum,userNum);
                // 힌트 출력
                int strikeResult = b.printHint();
                // 3개의 숫자를 모두 맞히면 게임 종료
                if (strikeResult == 3)
                    break;
            }
            // 다시 시작할 건지 종료할 건지 멘트 출력
            int playResult = b.continueGame();
            // 사용자 입력이 2 -> 완전히 종료
            if(playResult == 2)
                break;
        }
    }
}


