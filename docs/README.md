**프로젝트 구조**

- `model`
    - `BaseballGame.java`
    - `Validator.java`
    - `Constants.java`
- `View`
    - `UserView.java`
- `controller`
    - `GameController.java`
- `Application.java`

---

**구현할 기능 목록**

- `BaseballGame.java`
    - 게임 메인 로직 처리
        - 랜덤 숫자 생성
        - 스트라이크, 볼 계산
        - 재시작/종료 판단
- `Validator.java`
    - 사용자 입력값 유효성 검사
        - 게임 진행 시 입력값
            - 3글자인지 검사
            - 정수인지 검사
            - 중복 숫자가 없는지 검사
        - 재시작/종료 입력값
            - 정수인지 검사
            - 1글자인지 검사
            - 1또는 2인지 검사
- `Constants.java`
    - 상수 관리
- `UserView.java`
    - 사용자 입력 및 게임 출력
- `GameController.java`
    - `BaseballGame.java`와 `UserView.java` 연결