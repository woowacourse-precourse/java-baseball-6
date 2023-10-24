🚀 기능 구현 정리

- 상대방(컴퓨터)
    - [x] 게임 시작 - 1에서 9까지 서로 다른 임의의 수 3개를 선택하는 기능
    - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException후 애플리케이션은 종료
    - [x] 입력한 숫자에 대한 결과(스트라이크,볼,낫싱,정답)를 출력하는 기능
    - [x] 게임 재시작

🎯 프로그래밍 요구 사항

- [x] JDK 17 버전 사용
- [x] 프로그램 실행의 시작점은 Application의 main()
- [x] build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [x] Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [x] 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [x] 라이브러리
  camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
