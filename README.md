# DataStoreTest

### DataStore? ๐คทโโ๏ธ
1. ์๋ก์ด Jetpack ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ก SharedPreference๋ฅผ ๋์ฒดํ์ฌ ๋ฐ์ดํฐ๋ฅผ ์ ์ฅํ  ์ ์๋ ์๋จ.
2. key-value ํํ ๋๋ Protocol Buffer๋ฅผ ์ด์ฉํด์ Typed-Object ํํ๋ก ๋ฐ์ดํฐ๋ฅผ ์ ์ฅํ  ์ ์๋ค.
  
### DataStore ์ฅ์ 
1. Kotlin, Coroutine ๋ฐ Flow๋ฅผ ์ฌ์ฉํ์๋ค. ์ด๋ฅผ ํตํด ์ผ๊ด์ฑ๊ณผ ํธ๋์ญ์์ ์ง์ํจ์ผ๋ก์ ๋ฐ์ดํฐ๋ฅผ ๋น๋๊ธฐ์ ์ผ๋ก ์ ์ฅํ๋ค.
2. ๋ด๋ถ์ ์ผ๋ก IO ์ค๋ ๋์์ ๋์ํ๊ธฐ ๋๋ฌธ์ ๋ฐํ์ ์ค๋ฅ๋ก๋ถํฐ ์์ ํ๋ค.
3. Protocol Buffer๋ฅผ ์ด์ฉํ๋ฉด Type safetyํ ์ฝ๋๋ฅผ ์์ฑํ  ์ ์๋ค.

### ์ฝ๋

| branch               | ๋ชฉํ(?)                            |
|----------------------|---------------------------------|
| master               | - preference๋ฅผ get/setํ๋ ์ ์ฆ์ผ์ด์ค ๋ง๋ค์ด๋ณด๊ธฐ<br>- ์ ๋ค๋ฆญ ์ฌ์ฉํด์ ํ์ ์๊ด์์ด ํ๋์ ์ ์ฆ์ผ์ด์ค๋ก ์ ์ฐํ ์ฌ์ฉํ  ์ ์๋๋ก ํ๊ณ  ์ถ์์  |
| preference-type-test | - ๋ง๋ค์ด๋ ์ ์ฆ์ผ์ด์ค๋ฅผ ๋ค์ํ ํ์์ผ๋ก ํ์คํธ<br>- String, Int, Boolean    |
| migration            | - SharedPreference๋ฅผ DataStore๋ก ๋ง์ด๊ทธ๋ ์ด์ ํด๋ณด๊ธฐ |
| plugin-callback      | - ๋ค๋ฅธ ํ์ด์ง๋ก ์ด๋ํด์ preference ์์ ํ๊ณ  ๋์์์ ๋ ๋ณ๋ ๋ก์ง ์ถ๊ฐ ์์ด ๊ตฌ๋ํด๋๋ Flow์์ ๊ฐ ๋ฐ์์ ๋ทฐ ๋ณ๊ฒฝ๋๋์ง ํ์ธ |


### ์ฐธ๊ณ 
- [Hello DataStore, Bye SharedPreferences๐ โ Android๐ฑ โ Part 1: Preference DataStore](https://medium.com/scalereal/hello-datastore-bye-sharedpreferences-android-f46c610b81d5)
- [(๋ฒ์ญ) ์๋ DataStore, ์๋SharedPreferences๐โ-โAndroid๐ฑโ-โPart 1: Preference DataStore](https://velog.io/@y109384/%EC%95%88%EB%85%95-DataStore-%EC%95%88%EB%85%95SharedPreferences-Android-Part-1-Preference-DataStore)
- [Modern data storage on Android: Meet Jetpack DataStore โ Part 1/2](https://levelup.gitconnected.com/modern-data-storage-on-android-meet-jetpack-datastore-part-1-2-9f314c994fc8)
