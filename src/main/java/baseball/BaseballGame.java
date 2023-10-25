package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseballGame {
    private List<Integer> computer;
    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 게임 전체 진행 과정 관리
     */
    public void play() {
        computer = makeRandomThreeNumbers();
        boolean correct;
        do{
            System.out.print("숫자를 입력해주세요 : ");
            Optional<String> input = Optional.ofNullable(Console.readLine());
            List<Integer> integers = judgePersonInputFormat(input);
            String playOneTurnResult = playOneTurn(integers);
            System.out.println(playOneTurnResult);
            correct = isCorrect(playOneTurnResult);
        }while(!correct);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        if (askReplay()) {
            play();
        }
    }

    /**
     * 정답을 무작위 수로 배정한다.
     *
     * @return 무작위 3자리 Integer List
     */
    private List<Integer> makeRandomThreeNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    /**
     * 볼카운트 계산 과정 관리
     *
     * @param input 사용자가 입력한 값
     * @return 볼카운트
     */
    private String playOneTurn(List<Integer> input) {
        if (isNothing(input)) {
            // 만약 낫싱이라면 더 이상 진행하지 않아도 되므로 return
            return "낫싱";
        }
        return countBallAndStrike(input);
    }

    /**
     * 볼과 스트라이크 판단
     *
     * @param input 사용자 입력 값
     * @return 볼과 스트라이크를 계산
     */
    private String countBallAndStrike(List<Integer> input) {
        int ball = 0;
        int strike = 0;

        for (int i=0; i<input.size(); i++){
            int inputNumber = input.get(i);
            if (computer.contains(inputNumber)){
                // 만약 입력값이 정답 list에 포함되어 있을 때
                if (computer.get(i) == inputNumber) {
                    // 자리가 일치하면 strike
                    strike++;
                } else {
                    // 자리가 다르면 ball
                    ball++;
                }
            }
        }
        return makeBallCountToString(ball, strike);
    }

    /**
     * 게임의 재시작 여부 판단
     *
     * @return 게임 재시작 희망 여부 true/false
     */
    private boolean askReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Optional<String> playAgain = Optional.ofNullable(Console.readLine());
        return judgePlayAgainInput(playAgain);
    }

    /**
     * input이 정답과 일치하는지 확인
     *
     * @param playOneTurnResult 사용자가 입력한 값에 대한 볼카운트
     * @return 3스트라이크의 여부 true/false
     */
    private boolean isCorrect(String playOneTurnResult) {
        return playOneTurnResult.equals("3스트라이크") ? true : false;
    }

    /**
     * 볼과 스트라이크 개수를 string으로 변환
     *
     * @param ball 사용자 입력에서 볼의 개수
     * @param strike 사용자 입력에서 스트라이크 개수
     * @return 볼과 스트라이크 string
     */
    private String makeBallCountToString(int ball, int strike) {
        StringBuilder ballCount = new StringBuilder();
        if (ball != 0) {
            ballCount.append(ball + "볼 ");
        }
        if (strike != 0) {
            ballCount.append(strike + "스트라이크");
        }
        return ballCount.toString().trim();
    }

    /**
     * 낫싱인지 판단
     *
     * @param input 사용자 입력 값
     * @return 낫싱의 true / false
     */
    private boolean isNothing(List<Integer> input) {
        for (Integer integer : input) {
            if (computer.contains(integer)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자 입력 값의 검증 과정 관리
     *
     * @param playerInput 사용자 입력 값
     * @return 한자리씩 끊어서 Integer List
     */
    private List<Integer> judgePersonInputFormat(Optional<String> playerInput) {
        String trimmedInput = playerInput.orElse("null").trim();
        isNumbers(trimmedInput);
        isEffectiveThreeLengthNumber(trimmedInput);
        isContainZero(trimmedInput);
        return refactorStringToIntegers(trimmedInput);
    }

    /**
     * 숫자가 아닌 다른 값을 입력받았는지 확인
     *
     * @param trimmedInput 사용자 입력 값
     * @throws IllegalArgumentException if 숫자가 아닐 떄
     */
    private void isNumbers(String trimmedInput) {
        char[] chars = trimmedInput.toCharArray();
        for (char ch : chars){
            if (!(48 <= ch && ch <= 57)) {
                throwIllegalException("입력 형식이 올바르지 않습니다.");
            }
        }
    }

    /**
     * 세자리 수인지 확인
     *
     * @param trimmedInput 사용자 입력값
     * @throws IllegalArgumentException if 세자리가 아님
     */
    private void isEffectiveThreeLengthNumber(String trimmedInput) {
        Integer input = Integer.parseInt(trimmedInput);

        int inputDividedBy100 = input / 100;
        if (inputDividedBy100 == 0 || inputDividedBy100 >= 10) {
            throwIllegalException("세 자리의 숫자를 입력해야합니다.");
        }
    }

    /**
     * 0이 포함되어 있는지 확인
     *
     * @param trimmedInput
     * @throws IllegalArgumentException if 0이 있을 때
     */
    private void isContainZero(String trimmedInput) {
        if(trimmedInput.contains("0")){
            throwIllegalException("입력 숫자의 범위는 1부터 9까지 입니다.");
        }
    }

    /**
     * 입력 받은 문자열을 Integer List로 변환
     *
     * @param trimmedInput trim된 사용자 input
     * @return 한 자리씩 끊어서 Integer List
     */
    private List<Integer> refactorStringToIntegers(String trimmedInput) {
        List<Integer> inputNumbers = new ArrayList<>();
        String[] split = trimmedInput.split("");
        for (String s : split) {
            inputNumbers.add(Integer.parseInt(s));
        }
        return inputNumbers;
    }

    /**
     * 사용자의 재시작 여부를 판단
     *
     * @param playAgain 게임 재시작 여부에 대한 사용자 input
     * @throws IllegalArgumentException if 입력값이 1 또는 2가 아닐 때
     * @return 재시작 여부 true/false
     */
    boolean judgePlayAgainInput(Optional<String> playAgain) {
        String trimmedInput = playAgain.orElse("null").trim();

        if (!isOneOrTwo(trimmedInput)) {
            throwIllegalException("1 또는 2의 값을 입력해야합니다.");
        }

        Integer input = Integer.parseInt(trimmedInput);
        return input == 1 ? true : false;
    }

    /**
     * 1 또는 2인지 확인
     *
     * @param trimmedInput 재시작 여부 입력값
     * @return 1 또는 2인지 true/false
     */
    private boolean isOneOrTwo(String trimmedInput) {
        return trimmedInput.equals("1") || trimmedInput.equals("2");
    }

    /**
     * 오류 발생
     *
     * @param message 오류 메세지
     * @throws IllegalArgumentException if 0이 있을 때
     */
    private void throwIllegalException(String message) {
        throw new IllegalArgumentException(message);
    }
}