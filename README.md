
# Инструкция по запуску  c Docker

- Устновить git  (https://git-scm.com/book/ru/v2/%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5-%D0%A3%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0-Git)
- Установить докер  Windows(https://docs.docker.com/desktop/windows/install/) / Ubuntu(https://docs.docker.com/engine/install/ubuntu/)
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
    
