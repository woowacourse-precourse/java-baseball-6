# 구현할 기능 목록

### `void startGame()`

- 게임 시작과 동시에 시작 메시지 출력

### `int generateComputerNumber()`

- 컴퓨터의 숫자 생성 및 반환하기

### `int getUserInput()`

- `int userNumber`: 사용자로부터 숫자 입력 받기
- `return validateNumber`: 사용자로부터 받은 숫자의 유효성 검사

### `int isValidateNumber(int num)`

- 사용자로부터 입력 받은 숫자가 올바른지 검증
- 올바르지 않은 숫자일 경우 exception 발생
- return num

### `void printHint(int num)`

- 사용자가 현재 입력한 값에 대한 힌트를 출력

### `int countBall()`

- 볼 개수 카운트

### `int countStrike()`

- 스트라이크 개수 카운트

### `int getOptionNumber(String num)`

- 게임을 계속하는 것과 관련해서 1과 2가 아닌 수를 입력 받을 시 exception 발생
- return num

### `boolean continueOrQuit(int optionNumber)`

- getOptionNumber로 검증한 숫자를 바탕으로 게임을 계속할지 중단할지 결정