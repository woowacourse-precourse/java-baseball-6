# 기능 목록

### 1. 점수 계산

- 입력된 숫자의 점수를 계산한다.
    - 같은 위치의 같은 숫자 개수만큼 스트라이크를 늘린다.
    - 다른 위치의 같은 숫자 개수만큼 볼을 늘린다.

### 2. 입력 예외 처리

- `DDD` (`D`는 1~9 사이의 자연수) 형태의 입력이 아닌 경우, 예외를 발생시킨다.
- 같은 숫자가 두 개 이상 포함되어있는 경우, 예외를 발생시킨다.
- 게임 재시작 입력에 대해서, `1` 또는 `2`가 아닌 경우, 예외를 발생시킨다.

### 3. 게임 진행

- 게임 애플리케이션을 시작한다.
- 게임 애플리케이션을 종료한다.
- 게임 시작 시 `숫자 야구 게임을 시작합니다.` 문구를 출력한다.
- 게임 종료 시 `3개의 숫자를 모두 맞히셨습니다! 게임 종료` 문구를 출력한다.
- 게임 종료 시 `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 문구를 출력한다.
- 턴 마다  `숫자를 입력해주세요 :` 문구를 출력한다.
- 턴 마다 사용자 입력에 대해 점수를 출력한다.


## 코드 기능 목록

### Application - 애플리케이션의 진입점
- List<Integer> numbers : 게임 진행 중의 정답을 유지
- run() : 게임 실행, 진행, 생명주기 관리
- initializeNumber(): 게임 내 정답 점수 초기화

### InputProcessor - 입력과 관련된 static methods 포함
- validateRestartInput() : 재시작 여부 입력의 유효성을 검증한다.
- validatePitchInput() : 투구 입력의 유효성을 검증한다.
- parsePitchInput() : 투구 입력을 List 객체로 파싱한다.

### OutputProcessor - 출력과 관련된 static methods 포함
- printExitMessage() : 게임 종료 메세지를 출력한다.
- printCompleteMessage() : 게임 성공 메세지를 출력한다.
- printPitchInputMessage() : 숫자 입력 요청 메세지를 출력한다.
- printStartMessage() : 게임 시작 메세지를 출력한다.
- printScore() : 점수 메세지를 출력한다.

### Score - 투구 결과 점수를 저장하는 클래스 
- Integer strike : 스트라이크 개수
- Integer ball : 볼 개수

### ScoreCalculator - 투구와 정답을 비교해 점수를 계산하는 클래스
- calculate() : 
