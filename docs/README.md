컴퓨터 숫자 생성: 컴퓨터는 1부터 9까지의 서로 다른 숫자 세 개를 생성합니다.
generateComputerNumbers(): Randoms 라이브러리를 사용하여 중복되지 않는 임의의 숫자 세 개를 생성합니다.

사용자 입력 처리: 사용자로부터 세 자리 숫자를 입력받습니다.
parseInput(String input): Console 라이브러리를 사용하여 사용자의 입력을 받아 처리합니다.

스트라이크와 볼 계산: 컴퓨터가 생성한 숫자와 사용자가 입력한 숫자를 비교하여 스트라이크와 볼을 계산합니다.
countStrikesAndBalls(List<Integer> computerNumbers,List<Integer> userNumbers): 컴퓨터와 사용자의 숫자 리스트를 비교하여 스트라이크와 볼을 계산하고, 결과 값을 반환합니다.

결과 출력: 게임 결과(스트라이크 수, 볼 수, 낫싱)를 출력합니다.
printResult(Map<String,Integer> resultsMap ,boolean isGameWon): 게임 결과에 따른 메시지를 출력합니다.

게임 종료 여부 확인 및 재시작: 모든 숫자가 맞으면 게임을 종료하고, 재시작 여부를 묻습니다.
main 함수 내에서 이루어집니다.

예외 처리: 올바르지 않은 값(세 자리 이외의 수 등)이 입력될 경우 예외(IllegalArgumentException)가 발생하며 프로그램은 종료됩니다.
parseInput(String input): 세 자리 수 외에 다른 값들에 대해 예외처리 합니다.
