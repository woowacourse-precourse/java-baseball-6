## DTO

- ### Player
    - 입력값
    - 정수 배열로 변환한 입력값
    - 게임 재시작 여부
- ### Computer
    - 난수
    - 정수 배열로 변환한 난수
- ### Result
    - ball 갯수
    - strike 갯수
    - 정답 여부

## Service

- ### GameLogic
    - ball 갯수 세기
    - strike 갯수 세기
    - 한 번의 추측 종료 후 Result 객체 초기화
    - 정답 여부 확인 및 Result 객체 상태 업데이트
- ### Generator
    - 컴퓨터 난수 생성
- ### ResultPrint
    - Result 객체를 받아 결과 출력
- ### Validation
    - 게임 중 사용자 입력 에러 체크
        - 1~9 범위 확인
        - 사이즈 3 확인
        - 중복된 숫자 확인
    - 게임 종료 사용자 입력 에러 체크
        - 사이즈 1 확인
        - 1~2 범위 확인
- ### Convert
    - 숫자 문자열을 받아, 정보를 담는 정수 배열로 변환
        - index: 1~9 뽑힐 수 있는 숫자의 목록
        - value: 숫자의 위치 정보. 0:뽑히지 않음 1:백의 자리 2: 십의 자리 3: 일의 자리
    - 중복 되서 뽑힌 숫자가 있는 지 확인 하기 위해 정수 배열로 변환
        - index: 1~9 뽑힐 수 있는 숫자의 목록
        - value: 숫자가 뽑힌 횟수

## Application

- RESTART/END 상수: 게임 재시작 여부를 나타냄. Player객체의 condition값과 비교