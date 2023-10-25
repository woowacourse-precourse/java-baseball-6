## 게임의 흐름

---

- 정답
    - 중복이 없는 숫자 3개의 순서가 있는 집합
- 질문
    - 중복이 없는 숫자 3개의 순서가 있는 집합
- 출력
    - 게임 시작문구
    - 입력 요구문구
    - 정답 문구
    - 게임 재시작 질문 문구
    - 에러 내용 출력
- 게임 진행
    - 사용자가 게임에 접속 시 게임이 시작된다.
        - 게임시작 문구를 출력한다.
        - 게임을 초기화한다.
            - 문제를 생성한다.
    - 게임이 시작되면 질문 입력 문구가 출력된다.
        - 질문을 입력한다.
            - 질문에 대한 유효성을 검사한다.
                - 길이가 3이아니거나
                - 숫자가 아닌 값이 있거나
                - 중복이 되는 숫자가 있으면
                - 에러 발생 후 어플리케이션 종료
            - 질문에 대한 응답을 작성 한다.
            - 정답일 경우 정답 문구와 함께 종료질문 문구를 출력한다.
    - 종료 질문 문구
        - 사용자가 1을 입력하면 게임 진행으로 간다.
        - 사용자가 2를 입력하면 어플리케이션을 종료한다.
            - 1, 2 이외의 입력은 에러 발생후 어플리케이션 종료

## 클래스 설계

---

- 입출력을 담당할 GameView
    - 볼, 스트라이크 갯수 표시
    - 하나도 없는 경우
    - 3개의 숫자를 모두 맞힐 경우
    - 게임 시작 문구 출력
- 게임의 생성, 초기화, 입력, 규칙을 담당할 Game
- 숫자의 생성을 관리하는 NumberGenerator
- 유효성 검사를 담당하는 Validation
- 볼 카운트의 값 전달 및 관리를 담당하는 BallCount

## 처리할 에러 목록

---

- 길이가 3이 아닌 문자열 : SizeNotMatch
- 1 ~ 9의 숫자가 아닌 문자열 : QueryMustPossibleInteger
- 중복되는 숫자가 들어오는 경우 : NumberDuplicate
- 게임이 끝난 후 1, 2가 아닌 이외의 값이 들어오는 경우 : NotEscapeCode

## 구현한 목록

---

### game

- run: 외부에서 게임을 실행하도록 해준다.
- initGame: 게임의 숫자를 초기화한다.
- hitterResult: ballcount에 따른 값을 gameView에 전달
- gameSet: 사용자가 정답을 맞출 시 게임이 종료될 때의 입력과 출력을 진행
- stateStringToInt: 게임 재시작 시 입력값 검증과 int 변환
- determineQuery: 사용자 질문을 ballcount로 판단함
- isStrike: 질문의 한 값이 스트라이크인지 판별
- isNothing: 질문의 한 값이 존재하지 않는지지 판별
- inputPlayerQuery: 질문의 입력과 유효성 검사
- queryToList: 질문을 List 컬렉션으로 변환
- findDuplicatedNumber: 질문 변환 시 중복값이 있는지 판별
- isPlay: 게임의 진행, 재시작, 종료를 파악

### GameView

- startBoot: 시작을 알리는 출력문
- inputMessage: 입력을 요구하는 출력문
- gameSetView: 게임 종료를 알리는 출력문
- strikeBallView: 스트라이크 볼 갯수를 출력
- strikeView: 스트라이크 갯수를 출력
- ballView: 볼 갯수를 출력
- nothing: 낫싱을 출력

### BallCount

- getStrike: strike 갯수를 가져오는 메서드
- getBall: ball 갯수를 가져오는 메서드
- putStrike: strike 갯수를 증가시키는 메서드
- putBall: ball 갯수를 증가시키는 메서드

### Validation

- allPossibleDigit: 질문에 가능한 값만 존재하는 판별
- checkRestartString: 재시작 입력값이 가능한 값인지 판별
- checkValidNumber: 재시작 입력값이 1, 2인지 판별
- checkLength: 재시작 입력값의 길이가 1인지 판별
- querySizeCheck: 질문의 길이가 3인지 판별
- duplicateCheck: 질문에 중복값이 있는지 판별

### NumberGengerator

- numberGenerate: 숫자를 중복되지 않게 3개의 값을 생성함
- putNotDuplicatedNumber: 집어 넣을 값이 중복되지 않는 값이면 문제 List 컬렉션에 집어넣