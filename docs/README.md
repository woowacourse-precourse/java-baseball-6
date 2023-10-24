# 기능 요구사항
<pre>
  Application : 
  - main : 환영인사출력 && 게임 시작(재시작 안할때까지 반복)

  Game : 
  - run() : 게임 시작 && 정답 맞출때까지 사용자 입력 계속 받음

  Computer : 
  - Computer() : 정답 생성(길이 3 && 중복 X)
  - check() : 사용자 입력에 대한 결과값 비교 후 출력
  User :
  - userChoice() : 사용자 입력 받고 검사 후 List<Integet>에 넣어서 return
  - userCheck() : 1. 길이가 3인지
                  2. 숫자 이외의 문자가 있는지
                  3. 중복된 숫자가 있는지
  - regame() : 게임 재시작 여부 물어보기
</pre>
**프로그래밍 요구사항**
<pre>
  1. build.gradle 변경 X, 외부 라이브러리 사용 X
  2. Java 코드 컨벤션 가이드를 준수한다.
  3. 프로그램 종료시 System.exit() 호출 X
  4. ApplicationTest의 모든 테스트를 성공해야 한다.
  5. JDK 17버전 사용
  6. 시작점은 Application의 main()
</pre>

**과제진행 요구사항**
<pre>
  1. java-baseball-6 저장소를 Fork & Clone해 시작한다.
</pre>


