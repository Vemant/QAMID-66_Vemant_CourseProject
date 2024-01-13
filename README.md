[![Build status](https://ci.appveyor.com/api/projects/status/hgynbv7k2329bre4?svg=true)](https://ci.appveyor.com/project/Vemant/qamid-66-vemant-courseproject)

ИНСТРУКЦИЯ К ПРОЕКТУ:

- Запуск контейнера: java -jar ./artifacts/aqa-shop.jar
- Запуск тестов: ./gradlew test

Необходимые файлы лежат на пути src/test/java/ru/netology. Кратко о содержимом папок:
- Папка "data": классы для генерации данных для автотестирования и взаимодействия с базой данных MySQL
- Папка "page": page object
- Папка "tests": пакет с тестовыми классами; названия файлов с автотестами начинаются с Auto-
 
Файлы appveyor.yml, build.gradle, Plan.md, README.md, Report.md, Summary.md, 
docker-compose.yml лежат в головной папке проекта. 

