# 기능 목록

## 기능
- 랜덤한 1부터 9의 서로 다른 3자리의 수 생성
- 시작을 알리는 문구 출력
- 정답 추측 입력을 요구하는 문구 출력
- 사용자의 정답 추측을 입력 받는 기능
  - 사용자의 입력이 요구 사항에 맞지 않으면 예외 발생
    - 사용자의 입력이 3자리 숫자가 아닐 때
    - 사용자의 입력이 3자리의 수가 아닐 때
    - 반복된 숫자가 존재할 때
- 제출 된 숫자가 요구 사항에 따라 어떤 결과를 갖는지 판단
- 결과를 출력
- 정답을 맞추면 게임 종료
- 게임 재시작 여부를 묻는 문구 출력
- 게임 재시작 여부를 입력 받는 기능
- 게임 재시작 여부를 확인하여 프로그램 종료 또는 게임 재시작



## 클래스
- Game
- PlayResult

### 클래스 상세 설명
#### Game
##### 멤버 변수
- `private final List<Integer> answerList`
  - 정답의 결과.
  - 크기가 3인 ArrayList로 `camp.nextstep.edu.missionutils.Randoms`
    의 `pickNumberInRange`로 1부터 9까지의 서로 다른 정수가 들어감.
##### 메서드
- `private void init()`
  - Game 클래스를 초기화
  - 게임을 시작할 때, 재시작 때 호출
- `public void run()`
  - 게임을 실행하는 메서드
  - 종료되면 프로그램이 종료
- `private void playingGame()`
  - 하나의 야구 게임이 실행되는 메서드
  - `run()` 메서드에서 반복되어서 실행됨
- `private String inputNumbers()`
  - 사용자에게 3자리 수의 문자열을 입력 받는 메서드
  - 사용자에게 입력을 요구하는 문구 출력
- `private void validateInputNumbers(String input)`
  - 사용자에게 받은 3자리 수의 문자열을 검증하는 메서드
  - 다음과 같은 검증 로직이 있음
    - 사용자에게 받은 문자열이 3자리가 아닐 경우
    - 사용자에게 받은 문자열이 숫자로 이루어져 있지 않는 경우
    - 사용자에게 받은 문자열에 반복되는 숫자가 있을 경우
- `private boolean checkAnswer(String input)`
  - 정답을 체크하는 메서드
  - 정답일 때, true를 반환
  - 판단하는 메서드 `judge`와 결과를 보여주는 메서드 `showResult`를 호출
- `private PlayResult judge(List<Integer> submittedList)`
  - 입력이 어떤 결과를 가지는지 판단하고 반환
- `private void showResult(PlayResult result)`
  - 결과를 보여주는 메서드
  - 볼, 스트라이크 형식으로 출력
- `private boolean checkPlayAgain()`
  - 게임 재시작 여부를 묻고 반환
  - 입력을 받고, 요구 사항에 맞지 않은 입력을 할 때, 예회 발생
    - 입력이 "1" 또는 "2"가 아닐 경우

#### PlayResult
게임의 결과를 담는 클래스
##### 멤버 변수
- `private final int strikeNum`
  - 스트라이크(위치와 값이 일치하는 값)의 수를 저장
- `private final int ballNum`
  - 볼(값은 일치하지만, 위치가 다른 값)의 수를 저장
##### 메서드
- `public int getStrikeNum()`
  - `strikeNum`을 반환
- `public int getBallNum()`
  - `ballNum`을 반환