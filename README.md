<p align="center">
    <img src="https://github.com/Park-Wonbin/poapper-android-tutorial/blob/master/readme_img.jpg" width="40%"/>
</p>

# Android Tutorial
POSTECH 개발 동아리 'PoApper'에서 진행하는 Android 강의용 repository 입니다.

## Prerequisite
- MacOS / Windows
- Git
- Kotlin : https://kotlinlang.org/
- IDE : [**Android Studio**](https://developer.android.com/studio)
- Basic : https://codelabs.developers.google.com/android-kotlin-fundamentals/

## Getting Started

기본적인 **Kotlin** 문법 익히기 : https://thdev.tech/kotlin/2016/08/02/Basic-Kotlin-01
  - `val`과 `var`의 차이점을 안다!
  - `?`와 `!`의 사용을 구분할 수 있다!
  - `함수 생성`과 `반복문`을 사용할 수 있다!

**Android Studio**에서 **Git** 사용하기 : https://ywook.tistory.com/4

### Download

원하는 폴더에 다음 명령어를 칩니다.

```bash
git clone https://github.com/Park-Wonbin/PoApper_Android_Tutorial.git
cd PoApper_Android_Tutorial
```

## Week1
### 학습할 내용
- Layout(Linear, Frame)
  - `LinearLayout`과 `FrameLayout`을 자유롭게 다룰 수 있다!
  - `margin`, `padding` 등 다양한 속성들을 이해하고 있다!
- EditText, TextView
  - `width`, `gravity`, `size` 등 다양한 속성들을 이해하고 있다!
  - `Button`, `ImageView` 등 다른 **Element**들을 사용할 수 있다!
  - **Activity**에서 코드를 통해 텍스트를 읽어와서 표시할 수 있다!
  - **Layout**과 **Activity**의 상호작용을 이해한다! (ex. `onClickListener`)
- CardView - ***첫번째 Material Design 요소 알아보기***
  - 라이브러리를 적용하고 **xml**을 이용하여 디자인을 잘할 수 있다!
- Intent
  - 화면(Activity)전환, 전화걸기, 값 이동 등 **intent** 사용법을 잘 알고있다!
- Toast
  - **Toast**를 이용하여 간단한 메세지를 출력할 수 있다!
  
### 이번주 과제
- 화면(Layout)이 총 세 개 필요합니다.
  - 로그인
  - 회원 가입
  - 메인 화면
- 로그인 화면
  - 아이디, 비밀번호 입력칸과 로그인, 회원 가입 버튼이 필요합니다.
  - 로그인이 성공하면 메인화면으로 이동합니다. 기존의 화면은 없앱니다.
  - 로그인이 실패하면 경고 메시지를 띄웁니다.
  - 로그인은 hard-code 된 아이디와 비밀번호로 진행합니다.
  - 회원 가입 버튼을 누르면 회원 가입 화면으로 넘어갑니다.
- 회원 가입
  - 아이디, 비밀번호 입력칸과 가입 버튼이 필요합니다.
  - 가입 버튼을 누르면, 서버에 회원 가입 요청을 보냅니다.(아직 네트워크 통신은 안하셔도 됩니다! 비밀번호 확인만 구현해주세요.)
    - 만약 회원 가입이 성공하면, 메시지와 함께 로그인 화면으로 돌아옵니다.
    - 실패하면 경고 메시지를 띄웁니다.
- 메인 화면
  - 로그인에 성공한 아이디와 비밀번호를 보여주는 TextView가 필요합니다.

## Week2
### 학습할 내용
- SharedPreferences
  - **SharedPreferences**가 무엇인지 안다!
  - `getString`, `edit`, `commit`, `clear` 등을 사용할 수 있다!
- Activity Life Cycle
  - 안드로이드의 기본적인 **Life Cycle**을 이해하고 이용하는 방법을 안다!
- Color, String, etc... Values
  - `Color`, `String` 등의 **Values** 값들을 미리 설정해둘 수 있다!
- Image Asset
  - **Image Asset** 사용법을 안다!
  - 액션 아이콘을 추가하거나 앱 아이콘을 변경할 수 있다!
- Floating Action Button - ***두번째 Material Design 요소 알아보기***
  - **FAB**를 구현할 수 있다!
  - 기본적인 애니메이션을 적용할 수 있다!
  
### 이번주 과제
- 이전에 과제에 이어서 추가하시면 됩니다.
- 로그인 화면
  - 자동 로그인 기능을 구현해야 됩니다.
  - checkBox를 검색하고 사용해보세요.
  - 자동 로그인을 설정한 상태로 로그인이 완료되면 아이디를 SharedPreferences에 기록해둡니다. 
- 메인 화면
  - FAB를 구현해야 합니다.
  - 더보기 FAB를 눌렀을 때 검색, 글쓰기 등의 버튼이 등장해야 됩니다.
- 디자인
  - 앱 아이콘을 자신이 원하는 로고 또는 이미지로 수정하세요.
  - 앱의 메인 색상을 고르고 변경하세요.

## Week3
### 학습할 내용
- RecyclerView
    - **RecyclerView**를 이해하고 구현할 수 있다!
    - **data class**를 생성할 수 있다!
    - **Adapter**를 구현할 수 있다!
    - [참고 자료 1](https://recipes4dev.tistory.com/154?category=790402)
    - [참고 자료 2](https://recipes4dev.tistory.com/168?category=790402)
- SwipeRefreshLayout - ***세번째 Material Design 요소 알아보기***
    - 당겨서 새로고침 기능을 구현할 수 있다!
- ScrollView
    - **ScrollView**를 이용하여 더 많은 내용을 표시할 수 있다!

### 이번주 과제
- 이전에 과제에 이어서 추가하시면 됩니다.
- 메인 화면
    - RecyclerView를 이용하여 게시판 목록을 볼 수 있도록 만드셔야 합니다.
    - 글의 제목, 작성 시간 등의 정보를 표시하여야 합니다.
        - 글에 대한 정보를 담을 data class를 생성하세요.
    - 글을 누르면 자세히 보기 화면으로 넘어갑니다.
    - 테스트 데이터를 hard-code 하여 사용하세요.
    - 당겨서 새로고침을 구현하세요.
        - 새로고침시 새로운 아이템을 하나 추가합니다.
- 자세히 보기 화면
    - 메인화면에서 누른 글의 세부 정보를 받아와 보여줍니다.
    - 글의 제목, 작성자, 작성 시간, 내용 등을 표시합니다.
    - 글이 길 경우 스크롤하여 읽을 수 있도록 하여야 합니다.

## Week4
- Toolbar
- Navigation Drawer
- Better Design

## Week5
- AsyncTask
- Using OpenSource(Retrofit, Glide)

## Curriculum
- 레이아웃 디자인하기! - 로그인 / 회원가입 구현
- 벡엔드 처리하기! - 글 목록 / 정렬 / 검색 구현
- GitHub 사용하기! - 완성된 앱을 깃에 올리고 링크 제출

### 참고 사이트
- [Material Design Icon](https://icons8.com/)
- [Material Design Colors](https://material.io/design/color/#tools-for-picking-colors)
- [안드로이드 개발자가 꼭 알아야할 필수 라이브러리](https://academy.realm.io/kr/posts/360andev-chris-guzman-android-libraries-beginner/)
- [Java to Kotlin conversion](https://try.kotlinlang.org/)
