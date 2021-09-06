
# Описание задания
Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:
- если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich 
- если ниже - отсюда https://giphy.com/search/broke 
## Ссылки
    - REST API курсов валют - https://docs.openexchangerates.org/ 
    - REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide 
## Must Have
- Сервис на Spring Boot 2 + Java / Kotlin
- Запросы приходят на HTTP endpoint, туда передается код валюты
- Для взаимодействия с внешними сервисами используется Feign
- Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки
- На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)
- Для сборки должен использоваться Gradle
- Результатом выполнения должен быть репо на GitHub с инструкцией по запуску
## Nice to Have
- Сборка и запуск Docker контейнера с этим сервисом


# Инструкция по запуску  c Docker

- Устновить git  (https://git-scm.com/book/ru/v2/%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5-%D0%A3%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0-Git)
- Установить докер  (https://docs.docker.com/desktop/windows/install/)
- В консоли выполнить команду  : git clone https://github.com/ArthurNeyman/richOrBroke 
- В консоли выполнить команду  : cd richOrBroke
- В консоли выполнить команду  : docker build -t rich-or-broke .
- В консоли выпонить команду  : docker run  -p 8080:8080 rich-or-broke 
- В браузере перейти по ссылке http://localhost:8080/currency/USD , где USD это валюта о курсе которой вы хотите узнать

# Инструкция по запуску  без Docker
- Установить java(https://www.java.com/ru/download/help/download_options.html)
- Устновить git  (https://git-scm.com/book/ru/v2/%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5-%D0%A3%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0-Git)
- В консоли выполнить команду  : git clone https://github.com/ArthurNeyman/richOrBroke 
- В консоли выполнить команду  : cd richOrBroke
- В консоли выполнить команду  : ./gradlew build
- В консоли выполнить команду  : java -jar ./build/libs/TaskForAlfaBank-0.0.1-SNAPSHOT.jar
- В браузере перейти по ссылке : http://localhost:8080/currency/USD , где USD это валюта о курсе которой вы хотите узнать
    
