[![Build status](https://ci.appveyor.com/api/projects/status/hgynbv7k2329bre4?svg=true)](https://ci.appveyor.com/project/Vemant/qamid-66-vemant-courseproject)

ИНСТРУКЦИЯ К ПРОЕКТУ:

Запуск контейнера: java -jar ./artifacts/aqa-shop.jar
Запуск тестов: ./gradlew test

Необходимые файлы лежат на пути src/test/java/ru/netology. Кратко о содержимом папок:
- Папка "autopayment": автоматизированные тесты для способа оплаты не по кредиту (для каждого поля ввода отдельный класс)
- Папка "credit": ручные тесты для способа оплаты по кредиту ((для каждого поля ввода отдельный класс))
- Папка "data": класс генерации данных DataGenerator для автоматизированного тестирования autopayment
- Папка "payment": ручные тесты для способа оплаты не по кредиту ((для каждого поля ввода отдельный класс))

Файлы appveyor.yml, build.gradle, Plan.md, README.md, Report.md, Summary.md, 
docker-compose.yml лежат в головной папке проекта. 

