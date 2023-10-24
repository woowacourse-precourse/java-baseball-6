
#### 1. Game.class
- `computer`
- `Game()` : 생성자를 통해서 컴퓨터의 (1-9)까지 세자리 숫자를 생성한다.
- `getComputer()`

#### 2. GameController.class
- 실제로 야구게임을 실행시키는 클래스
- `run()` : 게임을 실행시킨다.

#### 3. GameService.class
- 야구게임에 대한 로직을 담당하는 클래스
- `setGame()` : 게임을 시작시키전 세팅하는 메소드
- `startGame()` : 게임을 시작시키는 함수
- `stopGame()` : 게임이 종료될 때 실행하는 함수
- `retryGame()` : 게임을 재시작시키는 함수
- `checkScore()` : 사용자의 숫자들을 배열로 받아와서 computer와 몇개를 맞췄는지 확인하고 값을 return하는 함수

#### 4. User.class
- `getUserNum()` :  사용자 숫자 입력받는 함수
- `parseUserNum()` 문자열로 들어오는 사용자 숫자를 int Array변환하고 그 과정에서 숫자가 아닌 값이 문자열에 포함되어 있으면 exception
- `checkUserNumSize()` 문자열의 길이가 NUMSIZE와 같은지 판별하는 함수
- `getNumbericValue()` 입력된 사용자의 값을 문자열에서 숫자로 변경하는 함수
- `checkDuplicateNum()` 중복된 숫자가 들어왔는지 체크하는 함수

#### 5.Message.class
- 게임동작시 출력되어야하는 메세지들을 관리하는 클래스
- `printScore()` : 몇개를 맞췄는지 출력하는 함수
- `printAskMsge()` : "숫자를 입력하세요 :" 
- `printStartMsg()` : 시작 메세지 출력
- `printEndMsg()` : 종료 메세지 출력
- `printRetryMsg()` : 다시시작 메세지 출력
- `printErrorMsg()` : 에러 메세지 출력

#### 6.

