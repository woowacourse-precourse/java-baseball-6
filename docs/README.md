## 🌠 기능 목록 설계


- [x] 전체 게임 관리 : `BaseballGame`
  - [x] GameController 관리
  - [x] IllegalArgumentException이 발생하면 종료


- [x] 게임 관리 : `GameController`
  - [x] 게임 초기화
  - [x] 게임 운영 관리
    - [x] 한 판 진행
      - [x] 사용자 입력이 정답인지 체크
    - [x] 게임 재시작 여부 묻기
    - [x] 재시작을 원하면 다시 게임 한 판



- [x] 컴퓨터 숫자 생성기 : `ComputerNumberGenerator`
  - [x] 서로 다른 랜덤한 수 3개를 조합



- [x] 결과 생성기 : `ResultGenerator`
  - [x] 볼, 스트라이크 갯수 연산 
  - [x] 볼, 스트라이크 값 객체에 저장



- [x] 사용자 입력 관리 : `InputProcessor`
  - [x] 사용자 입력 검증 : `InputValidator`
    - [x] 입력 값이 없는 경우
    - [x] 입력이 정수가 아닌 경우
    - [x] 입력이 3자리가 아닌 경우
    - [x] 입력에 중복된 수가 있는 경우
    - [x] 입력이 1,2 가 아닌 경우
  - [x] 사용자 입력 처리 : `InputConverter`
    - [x] 문자열 -> 정수 변환
    - [x] 문자열 -> 정수 리스트 변환



- [x] 출력문 관리 : `OutputView`
  - [x] 게임 시작 문구 안내
  - [x] 숫자 입력 안내
  - [x] 게임 결과(스트라이크, 볼, 낫싱) 안내
  - [x] 게임 종료 안내
  - [x] 게임 재시작 안내