package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String REGEX = "[1-9]+"; //유효한 숫자만 추출하기 위한 정규식

    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        Boolean onGoingGame;
        Boolean gameContinue = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(gameContinue) {
            generateRandomNumbers(computer, 3);
            onGoingGame = true;
            //System.out.println("컴퓨터 숫자 : " + computer);

            while (onGoingGame) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                isValidInput(input); //입력 검증

                //스트라이크와 볼 수 계산
                int strike = calculateStrike(input, computer);
                int ball = calculateBall(input, computer);

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    input = Console.readLine();
                    if (input.charAt(0) == '2') {
                        onGoingGame = false;
                        gameContinue = false;
                    }
                    else if(input.charAt(0) == '1'){
                        onGoingGame = false;
                    }
                    else{
                        throw new IllegalArgumentException("잘못된 게임 종료 입력입니다. 게임을 종료합니다.");
                    }
                } else if (strike != 0 && ball != 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if(strike == 0 && ball == 0){
                    System.out.println("낫싱");
                }
                else if (strike == 0) {
                    System.out.println(ball + "볼");
                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                }
            }
        }
    }

    private static int calculateBall(String input, List<Integer> computer) {
        int ball = 0;

        for(int i=0; i<input.length(); i++){
            int number = Character.getNumericValue(input.charAt(i));
            if(computer.get((i+1)%3) == number || computer.get((i+2)%3) == number){ //입력한 값은 맞지만 위치가 다를 때
                ++ball;
            }
        }

        return ball;
    }

    //스트라이크 계산
    private static int calculateStrike(String input, List<Integer> computer) {
        int strike = 0;

        for(int i=0; i<input.length(); i++){
            if((Character.getNumericValue(input.charAt(i)) == computer.get(i))){ //같은 위치에 같은 수가 있다면 strike
                strike++;
            }
        }

        return strike;
    }

    // size 개의 수를 List에 담는다.
    private static void generateRandomNumbers(List<Integer> computer, int size) {
        computer.clear();
        int count = 0;
        while(count < size){
            Integer number = Randoms.pickNumberInRange(1, 9);
            if(computer.contains(number)) continue; //웁복수 제거
            count++;
            computer.add(number);
        }
    }

    /**
     *  입력이 유효한지 확인한다
     *  1. 문자가 입력이 되었는지
     *  2. 숫자만 입력했을 때 4자리 이상 입력했는지 확인한다.
     *  3. 중복되는 숫자가 있는지 확인한다.
     */
    private static void isValidInput(String input) {
        if(input.length() != 3){ //입력의 길이가 3자가 아닌 경우
            throw  new IllegalArgumentException("입력은 3자리 숫자만 입력해야 합니다.");
        }

        if(!input.matches(REGEX)) { //입력에 1~9이외의 문자가 있는 경우
            throw new IllegalArgumentException("입력에 문자 입력과 숫자 0은 불가능합니다.");
        }

        //중복 수 확인 (ex) 339, 333, 787 등..)
        boolean[] chk = new boolean[10];
        for(char digit : input.toCharArray()){
            int num = Character.getNumericValue(digit);
            if(chk[num]) throw new IllegalArgumentException("중복되는 숫자입력은 불가능 합니다.");
            chk[num] = true;
        }
    }


}
