package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameManager {
    private final Player player1;
    private final Player player2;
    private GameState gameState = GameState.START;
    private List<Integer> numbers;

    public GameManager(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.numbers = player2.generateRandomNumber();
    }
    public String checkAnswer(String inputNumber) {
        //인풋 값 검증
        if (!isNumberAndIsSizeThree(inputNumber)) {
            throw new IllegalArgumentException();
        }
        //String -> List<int> 로 변환
        List<Integer> intInputNumbers = parseIntList(inputNumber);

        //서로 다른값인지 검증
        if (containSameNumber(intInputNumbers)) {
            throw new IllegalArgumentException();
        }

        //컴퓨터는 플레이어의 숫자 3개를 보고 볼, 스트라이크, 아웃을 판단한다(3)
        return inputNumberResult(intInputNumbers);
    }

    //볼, 스트라이크, 아웃 판단 함수
    private String inputNumberResult(List<Integer> playerInputNumbers) {
        int strike = 0;
        int ball = 0;

        //스트라이크 판단
        for (int i = 0; i < this.numbers.size(); i++) {
            if (this.numbers.get(i).equals(playerInputNumbers.get(i))) {
                strike++;
            }
        }

        //볼 판단
        for (int i = 0; i < this.numbers.size(); i++) {
            for (int j = 0; j < this.numbers.size(); j++) {
                if (i != j) {
                    if (this.numbers.get(i).equals(playerInputNumbers.get(j))) {
                        ball++;
                    }
                }
            }
        }

        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }

    //입력으로 받은 String값이 3자리 숫자인지 검증크는 코드
    private Boolean isNumberAndIsSizeThree(String str) {
        // 패턴을 이용하여 1~9 까지의 3자리 숫자인지 검증(공백)
        String pattern = "^[1-9]{3}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);

        return m.matches();
    }

    //String -> List<Integer>
    private List<Integer> parseIntList(String str) {
        String[] numbers = str.split("");
        List<Integer> numbersToInt = new ArrayList<>();
        for (String number : numbers) {
            int numberToInt = Integer.parseInt(number);
            numbersToInt.add(numberToInt);
        }
        return numbersToInt;
    }

    //같은 숫자가 있는지 검증하는 함수
    private Boolean containSameNumber(List<Integer> integerList) {
        if (integerList.size() > 1) {
            for (int i = 0; i < integerList.size() - 1; i++) {
                for (int j = (i + 1); j < integerList.size(); j++) {
                    if (integerList.get(i).equals(integerList.get(j))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (this.gameState != GameState.END) {
            //플레이어가 1번 플로우에서 컴퓨터가 생각한 숫자를 맞출때까지 2~4번을 반복한다.(5)
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                //플레이어가 숫자 3개를 컴퓨터에게 제출한다(2)
                String answerResult = this.checkAnswer(player1.answer());
                //컴퓨터는 판단한 결과를 플레이어에게 알려준다(4)
                System.out.println(answerResult);
                if (answerResult.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            //플레이어가 숫자 3개를 맞췄을 경우 다시 시작하거나 완전히 종료 시킨다(6)
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartAnswer =  player1.answer();
            if (restartAnswer.equals("1") || restartAnswer.equals("2")) {
                if (Integer.parseInt(restartAnswer) == GameState.RESTART.ordinal()) {
                    this.gameState = GameState.RESTART;
                    //컴퓨터가 서로 다른 랜덤한 숫자 3개를 선택한다(1)
                    this.numbers = player2.generateRandomNumber();
                } else {
                    this.gameState = GameState.END;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

}
