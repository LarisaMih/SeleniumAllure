# SeleniumAllure
1) Пример Gradle задачи

task AllTestHouseHoldStage(type: Test) {
    useTestNG {
          environment('env','Stage')
        suites 'TestNG.xml'
        dependsOn 'cleanTest'
         logging.captureStandardOutput LogLevel.INFO
    }
    
    gradlew test AllTestHouseHoldStage
    Далее создаем фаил XML, а в тестах  в скобках пишем название группы, тогда можно запустить таску и выполняться тесты соответсвующие
    
    2) Пример запуска батника
    3) Пример выполнения скринов 
    4) Пример аттача файла и текста
    
