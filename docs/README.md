public static void main(String[] args)
-> 메인 함수로 각각의 주요 함수들을 호출하고 IllegalArgumentException이 발생한 경우 return하여 프로그램 종료

private static List<Integer> makeRandomNum()
-> 3자리의 난수를 만들고 return

private static int checkStrikeBall(List<Integer> randomNum)
-> 이 함수 안에서 수를 입력 받고 strike와 ball이 몇 개인지 return
-> strike가 1개 있을 때마다 4를 더한 값을, ball이 1개 있을 때마다 1을 더한 값을 return 해줌
-> ex) 2strike 1ball -> 9 return

boolean isRightValInCheck(String[] input)
-> checkStrikeBall() 내부에서 3자리의 서로 다른 수의 입력이 맞는지 확인
-> 맞는 형식의 값이 아니라면 false return

private static List<Integer> convertInputToList(String userInput)
-> checkStrikeBall에서 getUserInput()을 이용하여 입력을 받아서 유효성 검사 후 배열로 변환

private static int calculateStrikeBall(List<Integer> randomNum, List<Integer> numList)
-> convertInputToList에서 나온 List를 확인 하여 스트라이크와 볼이 몇 개인지 계산

private static void printStrikeBallResult(int strikeBall)
-> calculateStrikeBall에서 return한 값을 확인하여 strike와 ball이 각각 몇 개인지 출력

boolean isGameEnd(int strikeBall)
-> strike가 3개가 맞는지 확인
-> strike가 3개가 맞다면 게임 종료

boolean isContinue()
-> 게임이 끝났을 때 다음 게임을 진행할 것인지를 입력을 받기
-> 입력을 받은 후 계속할 것이면 true를, 아니면 false를 return

boolean isRightValInContinue(String input)
-> isContinue() 내부에서 1이나 2가 입력되었는지 확인
-> 맞는 형식의 값이 아니라면 false return