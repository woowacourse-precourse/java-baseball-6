# 1. Game class

- 설명 : 유저의 입력을 받는 클래스로서, 다음 게임 여부에 대한 입력도 입력 받는다.

### startGame

- [x] 새로운 게임 시작할 때마다, 랜덤값 생성한다.
- [x] 유저의 입력을 받아 입력에 대한 결과를 반환한다.
- [x] 입력에 대한 예외 검사를 진행한다.

# 2. BasicController class

- 설명 : client는 Controller와만 통신을 하게 만들어 내부 동작을 추상화 시킨다.

### checkNumber

- [x] 통신하는 Computer 객체를 생성한다.
- [x] Computer 객체에 user 입력을 전달하여 게임 결과를 리턴받는다.
- [x] 결과값을 ResultView에 매개변수로 전달하여, 결과를 출력한다.
- [x] 3 스트라이크 경우 True, 아닐 경우 False를 리턴한다.

### makeIntegerArray

- [x] 입력값을 크기 3인 Integer 배열로 만들어 리턴한다.

# 3. Computer class

- 설명 : Computer의 랜덤값을 저장하고, 유저의 입력값과 비교하는 `CheckService` util 함수를 호출한다.

### createRandomNumber

- [x] 컴퓨터의 랜덤값을 생성한다.

### compareNumber

- [x] 유저의 입력값과 컴퓨터 랜덤값을 비교하는 `CheckService` util의 `matchNumber`를 호출한다.
- [x] 게임의 결과인 `GameResultDTO`를 리턴한다.

# 4. CheckService class

- 설명 : client의 입력과 컴퓨터의 값을 비교

### matchNumber

- [x] 입력값과 컴퓨터 값을 파라미터로 받는다.
- [x] 파라미터로 받은 두 값을 비교한다.
- [x] GameResult 객체를 만들어 스트라이크 횟수, 볼 횟수, 3 스트라이크 여부를 저장한다.
- [x] GameResult를 리턴한다.

# 5. GameResult class

- 설명 : 게임 결과값을 저장하는 객체
- [x] 멤버변수 : 스트라이크, 볼, 성공(3 스트라이크)

# 6. ResultView class

- 설명 : GameResult를 출력하는 역할

### printResult

- [x] 스트라이크, 볼 횟수가 0이 아닌 경우 해당 숫자와 문자열을 출력한다.
- [x] 스트라이크, 볼 둘다 0일 경우 "낫싱"을 출력한다.
- [x] 3 스트라이크 경우, 성공 문자열을 출력한다.

