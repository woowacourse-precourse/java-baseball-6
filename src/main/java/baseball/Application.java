package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        baseball baseball = new baseball();
        baseball.startBaseball();
    }
    static class baseball{
        private List<Integer> checkNumber;
        private List<Integer> inputNumber;

        public void startBaseball(){
            this.checkNumber = new ArrayList<>();
            while (this.checkNumber.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!this.checkNumber.contains(randomNumber)) {
                    this.checkNumber.add(randomNumber);
                }
            }
            setInputNumber();
        }

        public void setInputNumber(){
            System.out.print("숫자를 입력해주세요 : ");
            this.inputNumber = new ArrayList<>();
            try {
                int inputNumber = Integer.parseInt(Console.readLine());
                if (inputNumber < 111 || inputNumber > 999) {
                    throw new IllegalArgumentException("Invalid input number");
                }else{
                    while(inputNumber > 0) {
                        this.inputNumber.add(0,inputNumber %10);
                        inputNumber /= 10;
                    }
                }
            } catch (NumberFormatException  ex) {
               throw new IllegalArgumentException("Invalid input number");
            }
            checkNumber();
        }

        public void checkNumber(){
            int ballCount = 0;
            int strikeCount = 0;
            String returnString = "";
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(Objects.equals(this.checkNumber.get(i), this.inputNumber.get(j))) {
                        if(i == j) strikeCount++;
                        else ballCount++;
                    }
                }
            }
            if(ballCount > 0) returnString = returnString + ballCount + "볼 ";
            if(strikeCount > 0) returnString = returnString + strikeCount + "스트라이크 ";
            if(returnString.isEmpty()) returnString = "낫싱";
            System.out.println(returnString);
            if(strikeCount == 3) endGame();
            else setInputNumber();
        }

        public void endGame(){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                int gameNumber = Integer.parseInt(Console.readLine());
                if(gameNumber == 1) startBaseball();
                else if(gameNumber == 2) return;
                else throw new IllegalArgumentException("Invalid input number");
            } catch (NumberFormatException  ex) {
                throw new IllegalArgumentException("Invalid input number");
            }
        }
    }
}
