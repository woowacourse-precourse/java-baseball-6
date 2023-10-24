## 📄 기능 목록

* 난수 생성
  * 1 부터 9 사이의 서로 다른 무작위 숫자 3개를 가진 난수를 리턴하는 함수
  * ```camp.nextstep.edu.missionutils.Randoms```의 ```pickNumberInRange()```를 사용
* 입력 처리
  * 서로 다른 3자리의 수 
  * 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수
  * ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```를 사용
* 출력 처리
  * 게임 시작 문구 : ```'숫자 야구 게임을 시작합니다.'```
  * 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시 : ```'1볼 1스트라이크'```
  * 하나도 없는 경우 : ```'낫싱'```
  * 3개의 숫자를 모두 맞힐 경우 : ```'3개의 숫자를 모두 맞히셨습니다! 게임 종료'```
* 정답 처리
  * 스트라이크 : 입력된 수, 난수 쌍의 위치와 수가 같을 때
  * 볼 : 난수에 입력된 수가 포함이 되어있을 때
  * 낫싱 : 난수와 입력된 수가 하나도 일치하지 않을 때
* 예외 처리 ```IllegalArgumentException```
  * 게임 중
    * 1-9가 아닌 숫자가 포함되었을 때
    * 입력된 수의 길이가 3이 아닐 때
    * 입력된 숫자에 중복이 있을 때
  * 게임 종료 후
    * 1또는 2가 아닐 때
## 🎯 요구 사항
* JDK 17 버전에서 실행 가능
* 프로그램 실행의 시작점은 Application의 main()
* build.gradle 파일 변경 불가, 외부 라이브러리 사용 불가
* Java 코드 컨벤션 준수 
  * https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java
* 프로그램 종료 시 System.exit() 호출 금지
* ApplicationTest의 모든 테스트 성공 필요