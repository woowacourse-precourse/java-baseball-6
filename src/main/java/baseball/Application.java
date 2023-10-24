package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        String answerNumbers = createNumbers();

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumbers = inputNumbers();
            String hint = compareString(answerNumbers, inputNumbers);
            System.out.println(hint);
            if(hint.startsWith("3스트라이크")){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if(endNumbers() == 2){
                    System.out.println("게임 종료");
                    break;
                }
                answerNumbers = createNumbers();
            }
        }
    }

    /** 상대방(컴퓨터)의 수를 저장하는 메소드 */
    private static String createNumbers() {
        String answerNumber = "";

        while(answerNumber.length() != 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answerNumber.contains(""+randomNumber)){
                answerNumber += randomNumber;
            }
        }

        return answerNumber;
    }

    /** 사용자의 입력값을 받고 잘못된 입력값의 경우 IllegalArgumnetException 발생 */
    private static String inputNumbers() {
        String input = Console.readLine();

        if(input.length() != 3){
            throw new IllegalArgumentException();
        } else if(input.charAt(0)==input.charAt(1) || input.charAt(1)==input.charAt(2)
                || input.charAt(0)==input.charAt(2)){
            throw new IllegalArgumentException();
        }

        return input;
    }
    /** 재시작/종료 여부를 결정하는 메소드
     *  1,2 이외의 값을 입력한 경우 IllegalArgumnetException 발생
     *  */
    private static Integer endNumbers() {   // 게임을 계속 진행할 것인지 아닌 지 결정하는 값을 입력
        String input = Console.readLine();

        if(input.length() != 1 || !(input.equals("1") || input.equals("2"))){
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    /** 문제의 답과 사용자의 입력값을 비교하여 힌트를 제공 */
    private static String compareString(String str1, String str2){
        String result = "";
        int ball = 0, strike = 0;

        for(int i=0; i< str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(i)){
                strike++;
            } else if(str2.contains(""+str1.charAt(i))){
                ball++;
            }
        }

        if(strike == 0 && ball == 0){
            result += "낫싱";
        } else if (strike == 3){
            result += "3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (strike == 0 && ball > 0){
            result += ball + "볼 ";
        } else if (ball == 0 && strike > 0){
            result += strike + "스트라이크";
        } else {
            result += ball + "볼 " + strike + "스트라이크";
        }

        return result;
    }

}