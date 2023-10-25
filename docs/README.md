#  🥎 java-baseball-game 🥎
<div align="center">

<p align="center"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVL6Ue7peX_Z5FfWF-IhlnUMsl9s-XvOaAcg&usqp=CAU" height="300px" width="300px"></p>


 ### 🧦 baseball game Application ⚾
  <img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white"/>
 <img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/>
  
  <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat-square&logo=Visual Studio Code&logoColor=white"/>

</div>

## ⚾ 숫자 야구 게임
이 프로젝트는 Java를 사용하여 구현된 숫자 야구 게임입니다. 이 게임은 컴퓨터가 무작위로 생성한 3자리 숫자를 맞히는 게임으로, 플레이어는 볼과 스트라이크를 통해 숫자를 추측합니다.
  
## 🚀 게임 규칙
 - 게임은 컴퓨터가 생성한 3자리 숫자를 맞히는 것이 목표
 - 사용자가 3자리 숫자를 입력하면, 볼과 스트라이크를 계산하여 결과 출력
 - 사용자가 3자리 숫자를 입력하지 않았을 경우(잘못된 값을 입력할 경우) IllegalArgumentException을 발생 시킨 후 종료
 - 스트라이크: 숫자와 위치가 모두 일치
 - 볼: 숫자는 일치하지만 위치가 다름
 - 낫싱: 일치하는 숫자가 없음
 - 게임에서 스트라이크가 3개가 되면 게임 종료
 - 종료 후 게임을 다시 시작하거나 완전 종료 (재시작: 1, 종료: 2)

<br/>

## ⚾ 숫자 야구 게임 기능 목록
1. **게임 시작 메시지 출력**
   - 사용자가 게임을 시작할 때 "숫자 야구 게임을 시작합니다." 메시지를 출력합니다.

2. **게임 재시작 또는 종료 선택**
   - 사용자가 게임을 재시작하거나 종료할 수 있도록 옵션을 제공합니다.
   - "1"을 입력하면 게임을 재시작하고, "2"를 입력하면 게임이 종료됩니다.

3. **게임 관리자 초기화**
   - GameManager 클래스를 초기화하고 컴퓨터가 생성한 3자리 숫자를 랜덤으로 생성합니다.

4. **게임 플레이 루프**
   - 게임 플레이를 계속 반복하는 루프를 시작합니다.

5. **숫자 입력**
   - 플레이어에게 숫자를 입력하도록 요청합니다.

6. **입력 유효성 검사**
   - 플레이어가 입력한 숫자가 3자리의 숫자인지 검사합니다.
   - 유효하지 않으면 에러 메시지를 출력하고 다시 입력을 요청합니다.

7. **볼과 스트라이크 계산**
   - 플레이어가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교하여 볼과 스트라이크를 계산합니다.

8. **게임 결과 출력**
   - 각 라운드의 결과(볼, 스트라이크, 낫싱)를 출력합니다.

9. **게임 승리 확인**
   - 스트라이크가 3개가 되면 플레이어가 게임에서 승리했음을 알립니다.

10. **게임 종료 확인**
    - 게임이 종료되었는지 확인하고, 게임을 재시작할지 종료할지 선택할 수 있도록 메시지를 출력합니다.

11. **게임 종료 메시지 출력**
    - 게임이 종료되면 "게임 종료" 메시지를 출력합니다.

<br/>

## ⚙️ 개발환경 및 언어
  - git 
  - vs code
  - java 언어
