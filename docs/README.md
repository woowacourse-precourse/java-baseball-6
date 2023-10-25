# 구현 목록

## BaseBallGame.class

- `public String getUserInputAndPrint` 지문을 출력하고 유저의 숫자를 입력받음
- `public String getMenuInputAndPrint` 메뉴를 출력하고 메뉴의 숫자를 입력받음
- `public static void validateUserInput(String input)` 유저 입력을 검증함
- `public static Integer validateAndConvertMenuInput(String input) ` 메뉴 입력을 검증하고 `int`형으로 바꿈
- `public void initGame()` 게임을 시작하며 정답을 초기화함
- `public void startGameWithMenu()` 메뉴를 보여주며 게임을 시작함
- `public void playGame()` 게임을 시작함
- `public boolean checkGuess(List<Integer> userInputList)` 정답과 비교해서 출력함
- `public static List<Integer> stringToNumberList(String input) ` `string`을 `List<Interger>`로 바꿈
- `public static int countStrikes(List<Integer> answer, List<Integer> guess)` 스트라이크 갯수를 셈
- `public static int countBalls(List<Integer> answer, List<Integer> guess)` 볼의 갯수를 셈