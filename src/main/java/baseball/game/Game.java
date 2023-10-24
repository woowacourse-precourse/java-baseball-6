package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    private List<Integer> computerNum; // 컴퓨터에서 지정한 숫자.


    public Game(List<Integer> computerNum) { // 생성자.
        this.computerNum = computerNum;
    }

    public void startGame() {
        // todo : 정답을 맞출 경우 게임을 종료하는 로직과 정답을 맞추지 못할 경우 다시 사용자 입력을 받는 로직
        boolean result = false;
        do {
            int[] userNum = inputNumber();
            result = compareNumber(userNum);
        } while (!result);

    }

    public int[] inputNumber() {
        // todo: 사용자한테 입력받기
        //  Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        // String input = sc.nextLine(); // 입력받은 내용 저장.
        // todo : 입력값에 대한 예외 처리
        // 1. 길이 2. 값의 범위

//        if(input.length()!=3){
//            // 예외
//            throw new IllegalStateException("숫자는 3개 입력만 가능합니다.");
//        }

        exception(input);

        //   String[] inputArr = new String[3];
        int[] userNum = new int[3];
        for (int i = 0; i < 3; i++) {
            userNum[i] = Integer.parseInt(input.substring(i, i + 1)); // 입력 받은 문자열을 하나씩 잘라서 정수로 변환해서 정수 배열에 저장.
        }

        return userNum;

    }

    public boolean compareNumber(int[] userNum) { // 컴퓨터 번호와 사용자가 입력한 번호 비교
        // todo 1: 컴퓨터 숫자배열에 사용자가 입력한 수가 몇개나 들어있는지를 확인
        int ball = 0;
        int strike = 0;
        int diff = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNum.contains(userNum[i])) {
                ball += 1;
            }
        }

        // todo 2 : 위치도 일치하는지 확인
        for (int i = 0; i < 3; i++) {
            if (computerNum.get(i) == userNum[i]) {
                strike += 1;
            }
        }
        diff = ball - strike;
        // strike 가 있으면 무조건 ball 도 존재
        // ball 이 있어도 strike 는 0 일수 있음.

        if (ball == 0 && strike == 0) { // 하나도 못맞춤
            System.out.println("낫싱");

        } else if (ball > 0 && strike == 0) { // 숫자만 맞춤
            System.out.println(ball + "볼");

        } else if (diff > 0) { // 맞춘게 있다는 뜻.
            System.out.println(diff + "볼 " + strike + "스트라이크");
        } else {
            System.out.println(strike + "스트라이크");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false; // 다시


    }


    /**
     * 예외 처리
     */
    private void exception(String input) {

        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자만 입력할 수 있습니다.");
        }

        final String REGEX = "[0-9]+";
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException("0~9 이외의 숫자는 입력할 수 없습니다.");
        }

    }

    // 1. 게임을 시작하면 컴퓨터에서 랜덤한 숫자 3개를 정한다.
    // 컴퓨터의 수는 게임이 끝날때 까지 변하지 않으므로 static(클래스 변수로 선언한다.)
    // 생각해 보니까 static 으로 하면 안될것 같음. static 변수로 하면 무조건 실행을 하고 종료될때까지
    // 한번 지정한 값으로 해야되는데 게임을 여러번 다시 할수 있으므로 그때마다 컴퓨터의 수를 바꿔줘야 되기때문
    // 컴퓨터 수는 Main 메서드에서 랜덤으로 만들어 준다.
    // 2. 사용자에게 랜덤한 숫자 3개를 입력 받는다.
    // 사용자의 수는 매 사이클 마다 입력을 받아서 컴퓨터와 비교하므로
    // 3. 컴퓨터가 지정한 숫자와 사용자가 입력한 숫자를 비교해서 결과를 출력한다.
    // 우선 문자열로 받아서 사용자의 입력 값 하나씩 컴퓨터 숫자에 있는지 확인한다. 이때 있는 경우마다 볼의 수를 증가
    //
    // 4. 전체를 다 맞추지 못할경우는 계속해서 사용자 입력을 다시 받는다.
    // 5. 3개의 숫자를 다 맞출경우 다시 시작할지 종료할지 묻는다.
    //

}
