# DataStoreTest

### DataStore? 🤷‍♀️
1. 새로운 Jetpack 라이브러리로 SharedPreference를 대체하여 데이터를 저장할 수 있는 수단.
2. key-value 형태 또는 Protocol Buffer를 이용해서 Typed-Object 형태로 데이터를 저장할 수 있다.
  
### DataStore 장점
1. Kotlin, Coroutine 및 Flow를 사용하였다. 이를 통해 일관성과 트랜잭션을 지원함으로서 데이터를 비동기적으로 저장한다.
2. 내부적으로 IO 스레드에서 동작하기 때문에 런타임 오류로부터 안전하다.
3. Protocol Buffer를 이용하면 Type safety한 코드를 작성할 수 있다.

### 코드

| branch               | 목표(?)                            |
|----------------------|---------------------------------|
| master               | - preference를 get/set하는 유즈케이스 만들어보기<br>- 제네릭 사용해서 타입 상관없이 하나의 유즈케이스로 유연히 사용할 수 있도록 하고 싶었음  |
| preference-type-test | - 만들어둔 유즈케이스를 다양한 타입으로 테스트<br>- String, Int, Boolean    |
| migration            | - SharedPreference를 DataStore로 마이그레이션 해보기 |
| plugin-callback      | - 다른 페이지로 이동해서 preference 수정하고 돌아왔을 때 별도 로직 추가 없이 구독해뒀던 Flow에서 값 받아서 뷰 변경되는지 확인 |


### 참고
- [Hello DataStore, Bye SharedPreferences👋 — Android📱 — Part 1: Preference DataStore](https://medium.com/scalereal/hello-datastore-bye-sharedpreferences-android-f46c610b81d5)
- [(번역) 안녕 DataStore, 안녕SharedPreferences👋 - Android📱 - Part 1: Preference DataStore](https://velog.io/@y109384/%EC%95%88%EB%85%95-DataStore-%EC%95%88%EB%85%95SharedPreferences-Android-Part-1-Preference-DataStore)
- [Modern data storage on Android: Meet Jetpack DataStore — Part 1/2](https://levelup.gitconnected.com/modern-data-storage-on-android-meet-jetpack-datastore-part-1-2-9f314c994fc8)
