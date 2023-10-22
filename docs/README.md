# 기능 구현 목록

## 게임 진행 관점의 절차적 구현

1. 게임 시작 문구 출력
2. 랜덤한 세자리수 생성
3. Player의 숫자 입력
4. 게임 규칙에 따른 결과 반환
5. Player가 정답을 맞힐 때까지 3과 4의 과정을 반복, 맞혔으면 6으로 이동
6. 게임 종료 문구 출력 후, 재시작과 종료 선택 문구 출력
7. 재시작 선택할 경우 2로 이동, 종료 선택할 경우 게임을 완전히 종

## 구현을 위해 필요한 기능

- ### Controller
    - GameController
        - 게임 시작 및 종료 관리
        - Player와 Computer의 입출력 관리
- ### Model
    - Player
        - Player의 숫자를 관리
    - Computer
        - Computer의 숫리를 관리
- ### View
    - InputView
        - Player 입장의 뷰
    - ComputerView
        - Computer 입장의 뷰
- ### Util
    - RandomNumberGenerator
        - 랜덤한 세자리수 생성
    - InputValidator
        - Player의 입력값의 유효성을 판별
    - StringToIntegerListParser
        - String 입력값을 Integer 리스트로 변환
    - StrikeAndBallCounter
      - Player의 입력값 채점
- ### Constant
    - GameConstant
        - 게임 관련 상수 모음
    - GameMessage
        - 게임 진행 메시지 모음
    - ExceptionMessage
        - 예외 발생 메시지 모음