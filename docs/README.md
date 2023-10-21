# 구현할 기능 목록 정리

- 체크리스트
    - [x]  ~~git clone & Checkout branch~~
    - [x]  ~~자바 버전 17로 변경~~

- 기능 요구 사항
    - [x]  ~~게임 시작 문구 출력~~
    - [x]  ~~서로 다른 1~9까지의 3자리 숫자 생성~~
    - [x]  ~~사용자의 숫자 입력 받기~~
    - [x]  ~~사용자의 숫자와 생성된 숫자 비교 알고리즘~~
    - [X]  ~~입력한 수에 대한 결과(볼, 스트, 낫싱) 판단 알고리즘~~
    - [x]  ~~입력한 수에 대한 결과 출력~~
    - [ ]  3개의 숫자를 맞췄을 경우 문구 출력
    - [ ]  게임 종료 후 재시작 / 종료 기능 실행
    - [ ]  잘못된 값 입력 시 프로그램 종료

- 프로그래밍 요구 사항
    - [x]  ~~파일의 시작점 : `Application`의 `main()`~~
    - [x]  ~~`Randoms` 및 `Console` API 사용~~
    - [ ]  `System.exit()` 호출하지 않고 프로그램 종료

- 과제 진행 요구 사항
    - [x]  ~~`docs/README.md`에 구현할 기능 목록 정리~~

<br>

### 클래스 / 메서드 정리

1. Application
    - main()
      : 애플리케이션 시작 제어

2. GameProgress
    - printStart()
      : 게임 시작 문구 출력
    - printResult()
      : 3개의 숫자 맞췄을 경우 문구 출력

3. ComputerNum
    - genComputerNum()
     : 서로 다른 1~9까지의 3자리 숫자 생성

4. UserNum
    - getUserNum()
      : readLine()으로 사용자 숫자 입력
    - SplitUserNum()
      : 입력받은 숫자 글자 단위로 분리, Test 위해 별도 메서드 생성
      
5. Compare
    - entireCount(), strikeCount(), ballCount()
     : 사용자 숫자와 컴퓨터 숫자 비교 메서드
  
6. Judgement
    - judgement()
     : 최종 볼, 스트라이크, 낫싱 텍스트 출력

6. class WhetherRestart
    - 게임 종료 후 1 입력하면 재시작, 2 입력하면 종료하는 메서드

7. class PrintResult
    - 입력한 수에 대한 결과 출력 메서드 + 잘못된 값 입력 시 프로그램 종료
