# 구현할 기능

- [x] 난수 생성기 구현 (RandomNumberGenerator)
    - [x] 각 자리의 숫자가 1~9 사이의 범위에 있도록 구현
    - [x] 서로 다른 3자리의 숫자가 되도록 구현


- [x] 검증기 구현 (InputValidator)
    - [x] 유저가 입력한 세자리의 입력값 검증 (UserAnswerInputValidator)
        - [x] 입력값이 3자리값 인지 검증
        - [x] 입력값이 숫자 값인지 검증
        - [x] 입력값이 1~9 사이 숫자 값인지 검증
        - [x] 입력값이 서로 다른 숫자인지 검증
    - [x] 유저의 재시작/종료 구분 수 검증 (GameRetryInputValidator)
        - [x] 입력값이 1 또는 2의 값인지 검증


- [x]  볼,스트라이크 계산기 구현 (BallStrikeCalculator)
    - [x] 유저의 입력값과 정답을 비교하여 볼과 스트라이크 계산 구현


- [x] 유저가 보게될 View 클래스 구현 (Narrator)
    - [x] 게임 시작 메시지 출력 구현
    - [x] 게임 끝 메시지 출력 구현
    - [x] 숫자 입력 메시지 출력 구현
    - [x] 게임 재시작 메시지 출력 구현
    - [x] BallStrikeCalculator가 전달한 Score 출력 구현


- [ ] 숫자야구를 컨트롤하는 Controller 클래스 구현 (BaseballController)
    - [x] 실제 숫자야구의 로직을 수행하는 playBaseBall 메서드 구현
    - [x] 여러 요소들을 활용하여 게임을 구동하는 runGame 메서드 구현
        - [x] 게임 종료 후 재시작/종료를 구분하는 gamePlayFlag 설정