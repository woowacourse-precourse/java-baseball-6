## 흐름에 따른 이해

1. 게임 시작
   1. 시작 문구 출력
   2. 컴퓨터의 수 생성
2. 사용자로부터 숫자 입력 -> 정답 조건 만족할 때까지 반복
   1. 숫자 유효성 검사
      1. 비어있거나 숫자가 아닌지
      2. 세 개의 숫자가 입력되었는지
      3. 각 자리의 숫자가 1부터 9사이의 숫자로 이루어져 있는지
      4. 중복되는 숫자가 없는지
      5. 위의 조건들을 불만족할 시 IllegalArgumentException 발생
   2. 힌트 문구 출력
   3. 정답 조건 만족하는지 확인
3. 게임 종료
   1. 종료 문구 출력
   2. 사용자로부터 게임 재시작 여부 입력
      1. 1을 입력하였을 시 1-2부터 재시작
      2. 2를 입력하였을 시 완전히 종료
      3. 그 외의 값 IllegalArgumentException 발생

## class별 기능 구현 목록

### GameController
게임의 전반적인 흐름을 관리하는 클래스

- [ ] void proceedGame() : 게임 진행
- [ ] void showStartMessage() : 게임 시작 메시지 출력
- [ ] void setComputerNumber() : 컴퓨터 수 세팅
- [ ] void setUserNumber() : 사용자 수 세팅
- [ ] void showHint() : 힌트 출력
- [ ] void showEndMessage() : 게임 종료 문구 출력

### HintCalculator
컴퓨터 수와 사용자 수를 비교하여 스트라이크 수와 볼 수를 저장하는 클래스

- [ ] HintCalculator(List <Integer>, List <Integer>) : user, computer 비교 후 ball, strike count 저장
- [ ] boolean isThreeStrike() : 3스트라이크인지 반환

### ComputerNumber
컴퓨터 수를 저장하는 클래스

- [ ] ComputerNumber() : computer 수 랜덤 생성한 뒤 저장
- [ ] List<Integer> getNumber() : 컴퓨터 수 반환

### UserNumber
사용자 수의 유효성을 검사하고 저장하는 클래스

- [ ] UserNumber(String) : 입력받은 값 유효성 검사 후 저장
- [ ] void validate(String) : 유효성 검사
- [ ] List<Integer> getNumber() : 사용자 수 반환

### InputView
사용자로부터 입력받는 클래스

- [x] String inputUserNumber() : 사용자 수 입력
- [ ] String inputRestartValue() : 게임 재시작 여부 입력

### OutputView
사용자에게 출력하여 보여주는 클래스

- [ ] void printHint(int, int) : 힌트 출력
- [x] void printStartMessage() : 게임 시작 메시지 출력
- [x] void printEndMessage() : 게임 종료 메시지 출력