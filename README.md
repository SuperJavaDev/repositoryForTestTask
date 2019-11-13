Для запуска приложения необходимо указать в application.yaml конфиги к бд (Если не POSTGRES - то тогда закидывайте и драйвер уж).
Alarm, использую LIQUIBASE, он накатит на базу 3 таблички, USERS/DATABASECHANGELOG/DATABASECHANGELOGLOCK
Нужно накатить плагин lombok
Сборку делаем на Spring Boot, скорее всего конфигурацию деплоя писать не придется,
 но если придется, то вы справитесь.

swagger url - http://localhost:8080/swagger-ui.html#/
В свагере при вызове create - не передавайте id
