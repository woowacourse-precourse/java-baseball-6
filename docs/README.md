## DTO

- ### Player
    - 입력값
    - 정수 배열로 변환한 입력값
    - 게임 재시작 여부
- ### Computer
    - 정수 배열로 변환한 난수
- ### Result
    - ball 갯수
    - strike 갯수
    - 정답 여부

## Service

- ### GameLogic
    - 컴퓨터 난수 생성
    - ball 갯수 세기
    - strike 갯수 세기
- ### GameResult
    - Result 객체를 받아 결과 출력
- ### Validate
    - 게임 중 사용자 입력 에러 체크
        - 1~9 범위 확인
        - 사이즈 3 확인
        - 중복된 숫자 확인
    - 게임 종료 사용자 입력 에러 체크
        - 사이즈 1 확인
        - 0~1 범위 확인
- ### Convert
    - 문자열을 받아 정수 배열로 변환

## 상수

- RESTART/END