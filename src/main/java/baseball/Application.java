package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        boolean continueGame = true;
        while(continueGame) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            while(true) {
                // 입력
                String input = "";
                System.out.print("숫자를 입력해주세요 : ");
                input = camp.nextstep.edu.missionutils.Console.readLine();
                if (isValidInput(input)) {  // 올바른 입력
                    ;
                } else {
                    throw new IllegalArgumentException();
                }
                // 입력받은 숫자와 비교하여 결과 출력
                int result = playBaseball(computer, input);
                // 3스트라이크 시 루프 종료
                if(result==6) {
                    break;
                }
            }
            // 재경기 여부
            continueGame = playAgain();
            if(continueGame) {
                continue;
            } else {
                break;
            }
        }
    }

    private static boolean isValidInput(String input) {
        // 문자열의 길이가 3인지
        if (input.length() != 3) {
            return false;
        }
        // 입력받은 문자열이 숫자로만 이루어져 있는지
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        // 입력받은 숫자에 중복이 있는지
        if((input.charAt(0)==input.charAt(1) || input.charAt(0)==input.charAt(2) || input.charAt(1)==input.charAt(2))) {
            return false;
        }
        // 모든 조건을 만족 시 유효한 입력
        return true;
    }

    private static int playBaseball(List<Integer> computer, String input) {
        int ballCount = 0;
        int strikeCount = 0;
        char temp;

        for(int i=0; i<3; i++) {
            temp = input.charAt(i);
            if (computer.contains(Character.getNumericValue(temp))) {
                ballCount++;
            }
        }

        if(ballCount==0) {
            System.out.println("낫싱");
            return 0;                           // 0s0b
        } else if(ballCount==1) {
            for(int i=0; i<3; i++) {
                temp = input.charAt(i);
                if(computer.get(i) == Character.getNumericValue(temp)) {
                    strikeCount++;
                }
            }
            if(strikeCount==1) {
                System.out.println("1스트라이크");
                return 1;                       // 1s0b
            } else {
                System.out.println("1볼");
                return 2;                       // 0s1b
            }

        } else if(ballCount==2) {
            for(int i=0; i<3; i++) {
                temp = input.charAt(i);
                if(computer.get(i) == Character.getNumericValue(temp)) {
                    strikeCount++;
                }
            }
            if(strikeCount==2) {
                System.out.println("2스트라이크");
                return 3;                       // 2s0b
            } else if(strikeCount==1) {
                System.out.println("1볼 1스트라이크");
                return 4;                       // 1s1b
            } else {
                System.out.println("2볼");
                return 5;                       // 0s2b
            }
        }
        else {  // ballCount==3
            for(int i=0; i<3; i++) {
                temp = input.charAt(i);
                if(computer.get(i) == Character.getNumericValue(temp)) {
                    strikeCount++;
                }
            }
            if(strikeCount==3) {
                System.out.println("3스트라이크");
                return 6;                       // 3s0b
            } else if(strikeCount==2) {
                System.out.println("1볼 2스트라이크");
                return 7;                       // 2s1b
            } else if(strikeCount==1) {
                System.out.println("2볼 1스트라이크");
                return 8;                       // 1s2b
            } else {
                System.out.println("3볼");
                return 9;                       // 0s3b
            }
        }
    }

    private static boolean playAgain() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = camp.nextstep.edu.missionutils.Console.readLine();

        try {
            int i = Integer.parseInt(s);
            if (i==1) return true;
            else if (i==2) return false;
            else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
