# 우아한 테크코스 프리코스 #1 - 숫자 야구
#
## 기능 목록
### 1. 게임 시작 문구 출력
- 1.1. start()
  - 숫자 야구 게임 시작
- 1.2. startGame()
  - 게임 시작을 알리는 문구 출력
### 2. 컴퓨터가 서로 다른 임의의 수 3개 선택
- 2.1. getRandomNumber(List<Integer> computerNumber)
  - pickNumberInRange()를 활용하여 1~9 사이의 서로 다른 Random 값 3개를 추출
### 3. 플레이어의 숫자 입력
- 3.1. getUserInput()
  - 플레이어로부터 readLine()을 사용하여 3자리 숫자를 입력 받기
  - convertStringToInt 메서드를 통해 input을 int 타입 Array로 변환
  - input이 서로 다른 3자리 숫자가 아니라면 IllegalArgumentException 발생시키기
- 3.2. convertStringToInt(String input)
  - 입력 받은 String 타입 input을 int 타입 Array로 변환
- 3.3. getStrikeCount(List<Integer> computerNumber, int[] digits)
  - 사용자의 input과 컴퓨터의 3자리 숫자를 비교하여 스트라이크 개수를 리턴
- 3.4. getBallCount(List<Integer> computerNumber, int[] digits, int strikeCount) 
  - 사용자의 input과 컴퓨터의 3자리 숫자를 비교하여 볼 개수 리턴
### 4. 입력한 숫자에 대한 결과 출력
- 4.1. printResult(int strikeCount, int ballCount) 
  - strikeCount와 ballCount를 이용하여 입력 숫자에 대한 결과 값을 출력
### 5. 게임 재시작 및 종료에 대한 문구 출력
- 5.1. isEnd(int strikeCount) 
  - 3개의 숫자를 모두 맞혔는지 검사
  - strikeCount가 3일 때 true를 리턴
- 5.2. isRestart()
  - 재시작 및 종료에 대한 문구 출력 
  - readLine()을 활용하여 사용자의 input 받기
  - convertStringToInt 메서드를 통해 input을 int 타입 Array로 변환
  - input이 1 또는 2가 아니라면 IllegalArgumentException 발생시키기
