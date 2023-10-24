generateRandomNumbers(): 컴퓨터가 임의의 3자리 서로 다른 숫자를 생성하고 반환합니다.

isValidInput(String input): 사용자가 입력한 숫자의 유효성을 검사합니다. 입력의 길이, 숫자 범위 및 중복된 숫자 여부를 확인합니다.

areDigitsUnique(String input): 사용자 입력의 숫자가 서로 다른지 확인합니다.

parseInput(String input): 사용자 입력을 정수 리스트로 파싱합니다.

calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers): 사용자 입력과 컴퓨터의 숫자를 비교하여 스트라이크와 볼을 계산하고 Result 객체로 반환합니다.

Result 클래스: 게임 결과를 저장하고 출력 형식을 정의합니다. 스트라이크와 볼에 따라 다른 결과 메시지를 반환합니다.

게임 루프: 게임을 시작하고 사용자가 3스트라이크를 달성하거나 게임을 종료할 때까지 반복됩니다.

사용자로부터 숫자 입력을 받고 결과를 출력하는 부분이 게임의 핵심 부분입니다.

사용자가 게임을 새로 시작하거나 종료할 수 있는 선택을 받고, 게임을 다시 시작하거나 종료합니다.