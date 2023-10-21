<div align="center">

# 숫자 야구 미션 ⚾️
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/><br>

</div>

## 👩🏻‍💻 구현할 기능 목록

1. 게임을 시작할 때 상대방(컴퓨터)의 수를 생성해서 저장한다.<br>
   ✦ 조건: 1부터 9까지 _서로 다른_ 수로 이루어진 _3자리의_ 수 <br><br>
2. 게임 플레이어가 입력한 값을 예외 처리한다. <br><br>
3. 입력 값과 컴퓨터의 수를 비교하여 결과를 출력한다.<br>
   ✦ 같은 수가 같은 자리에 있으면 `스트라이크`<br>
   ✦ 같은 수가 다른 자리에 있으면 `볼`<br>
   ✦ 같은 수가 전혀 없으면 `낫싱`<br><br>
4. 숫자를 모두 맞추면(`3스트라이크`) 게임을 종료한다.<br><br>
5. 게임을 재시작 혹은 종료한다.

## 🏛️ 프로젝트 패키지 구조

1. <b>Application</b><br>
프로그램을 실행하고 게임 플레이어로부터 입력 받아 요청을 전달한다. 게임 진행 안내와 결과를 출력한다.<br><br>

2. <b>Controller</b><br>
가장 먼저 Application의 요청을 받는다. 입력된 값의 validation 예외는 이곳에서 처리한다. <br><br>

3. <b>Service</b><br>
핵심 로직을 담당한다. Controller에서 받은 확인된 요청을 처리한다.<br><br>

4. <b>Repository</b><br>
데이터 저장소이다. 데이터를 삽입하거나 삭제, 조회하는 등 데이터 처리 메서드를 정의한다.<br><br>

5. <b>Entity</b><br>
프로그램에서 다룰 데이터들을 객체화 한 것이다. 같은 엔티티끼리는 같은 속성을 가진다.<br><br>


## 🚨 입력 예외 처리
`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 통해 `String`으로 입력 받은 값은 아래의 형식을 지켜야 한다.

1. 입력 값의 길이는 3이어야 한다.<br><br>
2. 파싱한 각 문자는 정수로 변환 가능해야 한다.<br><br>
3. 각 숫자의 범위는 1부터 9이다.<br><br>
4. 각 숫자는 서로 다르다.
