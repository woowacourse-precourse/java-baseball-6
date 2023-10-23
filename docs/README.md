# 전체적인 구조
1. 게임 시작이 되면 먼저 1부터 9까지 서로 다른 숫자 3개를 랜덤으로 선택해야한다.
2. 게이머는 3자리 숫자를 입력하고 이에 대한 힌트를 제공해야한다.
3. 힌트를 확인한뒤에 게이머는 이를 토대로 다음숫자를 예측하고 입력한다.
4. 정답을 맞추면 게임이 종료되고 플레이어는 게임을 다시 시작하거나 종료할수있어야한다.

# 프로그래밍 요구 사항
1. 프로그램 실행의 시작점은 Application의 main()이다.
2. build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
3. Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
4. 프로그램 종료 시 System.exit()를 호출하지 않는다.
5. 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
6. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다. 

# 라이브러리
1. camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
2. Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
3. 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

- baseball 패키지에 위치한 Application 클래스 내에 작성되어야하며 
- main() 메서드 내에서 프로그램이 실행되어야한다.
- 로직은 generateRandomNumber, isValidNumber, 그리고 checkNumber 메서드를 통해 구현되어야하며
- 사용자의 입력 및 출력은 Console.readLine() 및 System.out.println()을 통해 처리되어야한다.
- OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended 오류가 뜨지만
- Gradle 구성을 통해 이 문제를 해결하거나 라이브러리를 통해 해결할 수 있지만 요구 사항을 만족해야하기에 경고를 무시하고 프로젝트를 진행했다.