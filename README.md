[![Build status](https://ci.appveyor.com/api/projects/status/hgynbv7k2329bre4?svg=true)](https://ci.appveyor.com/project/Vemant/qamid-66-vemant-courseproject)

ИНСТРУКЦИЯ К ПРОЕКТУ:

Запуск контейнера: java -jar ./artifacts/aqa-shop.jar

Файлы appveyor.yml, build.gradle, Plan.md, README.md, Report.md, Summary.md, 
docker-compose.yml лежат в головной папке проекта. 

Файлы с автотестами будут лежать в 
src/test/java/ru/netology/autopayment/PaymentAutoTest.java

Файлы с ручными тестами платежа по кредиту будут лежать в
src/test/java/ru/netology/credit
Для каждого поля - НОМЕР КАРТЫ, МЕСЯЦ, ГОД, ВЛАДЕЛЕЦ, CVV - отдельный файл с тестами

Файлы с ручными тестами платежа по кредиту лежат в
src/test/java/ru/netology/payment
Для каждого поля - НОМЕР КАРТЫ, МЕСЯЦ, ГОД, ВЛАДЕЛЕЦ, CVV - отдельный файл с тестами
