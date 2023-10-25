# 구현할 기능 목록
### GameController 클래스 기능 명세
- **기능 1. 게임 시작하기**
  - 설명: 새로운 게임을 시작한다.
  - 연관 메서드: `startGame()`
- **기능 2. 게임 세션 생성하기**
  - 설명: 하나의 게임 세션을 생성한다. 사용자는 게임 세션을 반복하여 진행할 수 있다.
  - 연관 메서드: `playGame()`
- **기능 3. 컴퓨터, 유저에게 정답 생성 요청하기**
  - 설명: 컴퓨터, 유저에게 각각 정답을 생성할 것을 요청한다.
  - 연관 메서드: `playGame()` 내부 구현
- **기능 4. 입력 값 전달하기**
  - 설명: 사용자가 입력한 정답을 컴퓨터에게 전달한다.
  - 연관 메서드: `playGame()` 내부 구현
- **기능 5. 게임이 끝난 후에 재시작/종료 결정하기**
  - 설명: 컴퓨터로부터 게임 종료 결과를 전달받고, 재시작/종료를 결정한다.
  - 연관 메서드: `checkRetry()`

### User 클래스 기능 명세
- **기능 1. 정답 입력하기**
  - 설명: 사용자는 3자리의 숫자로 구성된 'answer'를 입력한다..
  - 연관 메서드: `generateAnswer()`

### Computer 클래스 기능 명세
- **기능 1. 정답 생성하기**
  - 설명: 게임 컨트롤러로부터 요청을 받아, 서로 다른 3자리의 정답 숫자를 생성한다.
  - 연관 메서드: `generateAnswer()`
- **기능 2. 전달받은 입력 값 분석하기**
  - 설명: 사용자가 입력한 3자리 값을 정답과 비교하여 분석한다.
  - 연관 메서드: `compareAnswer()`
- **기능 3. 분석 결과를 바탕으로 한 출력 결과 생성하기**
  - 설명: 스트라이크, 볼의 개수를 파악하고 조건에 맞는 문자열을 반환한다.
  - 연관 메서드: `getCompareResult()`

### Validator 클래스 기능 명세
- **기능 1. 입력 값의 유니크성 검사하기**
  - 설명: 사용자가 입력한 숫자 리스트를 집합으로 변환하여, 집합의 크기가 3인지 검사한다.
  - 연관 메서드: `checkValidOfAnswerUnique()`
  - 예외처리 : `IllegalArgumentException`를 발생시킨다.
- **기능 2. 입력 값의 크기 검사하기**
  - 설명: 사용자가 입력한 숫자 리스트의 크기가 정확히 3자리인지 검사한다.
  - 연관 메서드: `checkValidOfAnswerSize()`
  - 예외처리 : `IllegalArgumentException`를 발생시킨다.
- **기능 3. 게임 재시작에 대한 입력값 검사하기**
  - 설명: 사용자가 입력한 값이 1 또는 2인지 검사한다.
  - 연관 메서드: `checkValidOfRetry()`
  - 예외처리 : `IllegalArgumentException`를 발생시킨다.

## 클래스 설명
### GameController 클래스
#### 개요
GameController 클래스는 숫자 야구 게임의 메인 컨트롤러로서, 사용자와 컴퓨터 사이의 게임 로직을 처리합니다.
게임을 시작하면 컴퓨터는 정답을 설정하고, 사용자는 숫자를 추측하여 입력합니다. 사용자의 추측이 정답과 일치하면 게임은 종료됩니다.

#### 속성
- user: User
  - 게임에 참가하는 사용자 객체이다.
- computer: Computer
  - 게임에 참가하는 컴퓨터 객체이다.

#### 주요 메소드
- public void `startGame()`: void
  - 숫자 야구 게임을 시작하는 메서드.
  - 게임이 종료되어도 사용자가 다시 시작을 원하면 게임을 재시작합니다.
- private boolean `playGame()`: boolean
  - 하나의 게임 세션을 실행하는 메서드.
  - 컴퓨터가 정답을 설정하고, 사용자에게 숫자를 입력받아 컴퓨터의 정답과 비교합니다.
  - 사용자가 정답을 맞히면 checkRetry 메서드를 호출하여 게임을 계속 진행할지 결정합니다.
- private boolean `checkRetry()`: boolean
  - 사용자가 게임을 다시 시작할 것인지 확인하는 메서드.
  - 사용자로부터 입력받은 응답이 '1'이면 게임을 재시작하고, 그렇지 않으면 게임을 종료합니다.


### Player 추상 클래스
#### 개요
Player는 추상 클래스로서 게임 참가자(User 및 Computer)의 기본 틀을 제공하여 코드 중복을 최소화한다.
#### 속성
- answer: List<Integer\>
  - User 또는 컴퓨터의 정답을 저장하는 리스트이다.
  - 각 숫자는 0-9 사이의 정수이며, 리스트의 길이는 3자리이다.
- ANSWER_SIZE: int (상수)
  - 정답의 크기를 나타내는 상수로 현재 값은 3입니다.
#### 주요 메소드
- abstract List<Integer\> `generateAnswer()`: List<Integer\>
  - 참가자의 정답을 생성하는 추상 메서드로, 하위 클래스에서 구현한다.

### User 클래스
#### 개요
User 클래스는 사용자의 동작을 표현하는 클래스로, Player 추상 클래스를 상속받는다.
사용자는 3자리 숫자로 구성된, 'answer'를 입력할 수 있다.

#### 주요 메소드
- protected List<Integer\> `generateAnswer()`: List<Integer\>
  - 사용자로부터 입력받은 정답을 생성하는 메서드.
  - 사용자의 입력값을 문자 배열로 변환하고, 각 문자를 숫자로 변환하여 리스트에 추가한다. 추가 전, 해당 정답이 유효한지 (크기와 중복 여부) 확인한다.
- private void `checkValidOfAnswerUnique(List<Integer> tempAnswer)`: void
  - 입력된 정답 리스트 내의 숫자들이 중복되지 않는지 검사하는 메서드.
  - 중복되는 숫자가 있을 경우, 예외를 발생시킵니다.
- private void `checkValidOfAnswerSize(List<Integer> tempAnswer)`: void
  - 입력된 정답 리스트의 크기가 유효한지 (3자리인지) 검사하는 메서드.
  - 유효하지 않은 크기일 경우, 예외를 발생시킵니다.

### Computer 클래스
#### 개요
Computer 클래스는 컴퓨터 플레이어의 동작을 표현하는 클래스로, Player 추상 클래스를 상속받는다.
컴퓨터는 무작위로 3자리의 숫자로 구성된 answer를 생성할 수 있으며, 사용자의 입력을 평가하여 결과를 반환합니다.

#### 주요 메소드
- protected List<Integer\> `generateAnswer()`: List<Integer\>
  - 컴퓨터가 무작위로 정답을 생성하는 메서드.
  - 1부터 9까지의 범위에서 무작위로 숫자를 선택하며, 중복되는 숫자가 없도록 합니다.
- public boolean `compareAnswer(List<Integer> userAnswer)`: boolean
  - 사용자의 입력된 정답과 컴퓨터의 정답을 비교하여 평가 결과를 반환하는 메서드.
  - 평가 결과에 따라 스트라이크와 볼의 개수를 계산하며, 모든 숫자가 일치하면 true를 반환합니다.
  - 평가 결과를 displayCompareResult 메서드를 통해 출력합니다.
- private void `getCompareResult(int strikeCount, int ballCount)`: String
  - 평가 결과를 문자열로 반환하는 메소드.
  - 볼과 스트라이크의 개수에 따라 해당하는 문자열을 반환합니다. 만약 모두 0이라면 "낫싱"을 반환합니다.

### Validator 클래스
#### 개요
Validator 클래스는 프로그램 실행 간, 사용자의 입력값을 검증하는 클래스입니다.

#### 주요 메소드
- public static boolean `checkValidOfAnswer(String input)`: boolean
  - 사용자의 입력값이 유효한지 검사하는 메서드.
  - 입력값이 3자리의 숫자로 구성되어 있는지 검사합니다.
  - 만약 유효하지 않은 값이라면 예외를 발생시킵니다.
- public static boolean `checkValidOfRetry(String input)`: boolean
  - 사용자의 입력값이 유효한지 검사하는 메서드.
  - 입력값이 1 또는 2인지 검사합니다.
  - 만약 유효하지 않은 값이라면 예외를 발생시킵니다.
- public static boolean `checkValidOfRetry(String input)`: boolean
  - 사용자의 입력값이 유효한지 검사하는 메서드.
  - 입력값이 1 또는 2인지 검사합니다.
  - 만약 유효하지 않은 값이라면 예외를 발생시킵니다.
