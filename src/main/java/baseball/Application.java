package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    /* Variable */
    private String menuCursor;
    private List<Integer> randomNumbers;
    private String inputNumbers;

    /* Public Method */
    // 시작
    public void start() {
        final String MENU_RESTART = "1";
        final String MENU_EXIT = "2";

        System.out.println("숫자 야구 게임을 시작합니다.");
        while ( true ) {
            play();
            selectMenu();
            if ( menuCursor.equals(MENU_RESTART) )
                continue;
            if ( menuCursor.equals(MENU_EXIT) ) {
                System.out.print("애플리케이션을 종료합니다.");
                break;
            }
        }
    }

    /* Private Method */
    // 프로그램 초기화
    private void initiate() {
        this.menuCursor = "";
        this.randomNumbers = pickUniqueRandomNumber();
        this.inputNumbers = "";
    }

    // 숫자 선정
    private List<Integer> pickUniqueRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    // 사용자로부터 메뉴 입력받기
    private void selectMenu() {
        String input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = readLine();
        if ( !validate(input, 1, 1, 2) )
            throw new IllegalArgumentException();
        menuCursor = input;
    }

    // 사용자로부터 숫자 입력받기
    private void setInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        inputNumbers = readLine();

        if ( !validate(inputNumbers, 3,1, 9 ) )
            throw new IllegalArgumentException();
    }

    // 숫자 맞히기 시작
    private void play() {
        final String THREE_STRIKE = "3스트라이크";

        initiate();
        while ( true ) {
            setInputNumber();
            String result = matchNumbers(randomNumbers, inputNumbers);
            System.out.println(result);

            if ( result.equals(THREE_STRIKE) ) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    // 입력값 유효성 검사
    private boolean validate(String input, int length, int startInclusive, int endInclusive) {
        if ( input.length() != length )
            return false;

        if ( !isUniqueNumbers(input) )
            return false;

        String regex = "^[" + startInclusive + "-" + endInclusive + "]*$";
        return input.matches(regex);
    }

    // 입력값 중복 검사
    private boolean isUniqueNumbers(String inputNumbers) {
        Set<Character> used = new HashSet<>();

        for ( char c : inputNumbers.toCharArray() ) {
            if ( !used.add(c) )
                return false;
        }

        return true;
    }

    // 입력받은 숫자 일치 여부 확인
    private String matchNumbers(List<Integer> randomNumbers, String inputNumbers) {
        final String RESULT_BALL = "볼";
        final String RESULT_STRIKE = "스트라이크";
        final String RESULT_NOTHING = "낫싱";

        int ballCount = 0;
        int strikeCount = 0;

        for ( int i = 0; i < inputNumbers.length(); i++ ) {
            Integer s = Integer.parseInt(inputNumbers.substring(i, i + 1));

            int index = randomNumbers.indexOf(s);

            if ( index == i ) {
                strikeCount++;
                continue;
            }
            if ( index != -1 ) ballCount++;
        }

        if ( strikeCount + ballCount == 0 )
            return RESULT_NOTHING;

        if ( ballCount == 0 )
            return strikeCount + RESULT_STRIKE;

        if ( strikeCount == 0 )
            return ballCount + RESULT_BALL;

        return ballCount + RESULT_BALL + " " + strikeCount + RESULT_STRIKE;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.start();
    }
}
