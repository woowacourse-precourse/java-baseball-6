# 기능 구현 목록

## Application.java

1. 프로그램 시작 메시지 출력
2. 게임 진행 여부 판단 변수 설정
3. 게임 루프 실행
4. Baseball 객체 생성 (랜덤 숫자 생성 포함)
5. GameRunner 객체 생성 및 게임 실행
6. 게임 계속 여부 묻기
7. 사용자 입력 유효성 검사
8. 게임 계속 여부 판단
9. 프로그램 종료 메시지 출력

## Baseball.java

1. 컴퓨터의 랜덤 숫자 저장 (Constructor)
2. 스트라이크 개수 세기
3. 볼 개수 세기
4. 게임 승리 판단

## Utils.java

1. 게임 재시작 또는 종료 입력 유효성 검사 (`validateRestartOrExitInput`)
2. 랜덤 숫자 생성 (`generateRandomNumber`)
3. 사용자 입력 유효성 검사 (`validateUserInput`)
    - 입력 길이 검사 (`validateStringLength`)
    - 자연수 검사 (`validateStringNaturalNumbers`)
    - 모든 문자가 다른지 검사 (`validateAllDifferentCharacters`)
4. 문자열을 정수 리스트로 변환 (`stringToIntegerList`)

## GameRunner.java

1. `Baseball` 객체를 멤버 변수로 저장 (Constructor)
2. 게임 실행 (`run` 메서드)
    - 사용자 입력 받기 (`getUserInput`)
    - 스트라이크와 볼 개수 계산
    - 결과 출력 (`printResult`)
    - 게임 승리 판단 및 종료 메시지 출력
