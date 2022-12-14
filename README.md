# Setel Automation Project For API end-to-end, Mobile, Web Admin, Web dashboard and web eCommerce regression tests, 
* Pre-Requisites:
    1. Install JDK 8 (version 1.8.0_281)
    2. Install IDE (preferred IntelliJ IDEA)
    3. Install Maven
    4. Install Allure


* Setup environment variables (both system and project)
     1. JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_301.jdk/Contents/Home
     2. PATH=$JAVA_HOME/bin:$PATH
     3. PATH=/usr/local/Cellar/maven/3.8.3/libexec
     4. AUTOMATION_USER_LOGIN=automation-user
     5. AUTOMATION_USER_PASS=RWoH31Pw6Max
     6. GET_DEPENDENCIES_TOKEN=2FVB3DuheKTSjhzSr4zo

 
 * Clone the project
    `git clone https://gitlab.com/setel/automation/setel-automated-test.git`
 
 * Download the core framework and build the project
 
    `mvn clean install -U -DskipTests=true --settings=settings.xml`
 
 * Run Tests
    mvn clean test -pl {module} 
    Following parameters can be used:
     * -Dsuite={suite_name}
     * -DenvBaseUrl={environment_url}
     * -Dtest={suiteName}#{testName}
     * -DsetelUI.suiteXmlFile={xmlFile}

     
 * Generate allure report
    `allure serve {module}/allure-results`
    
 For Detailed installation doc, Please refer
  * [macOS](https://setelnow.atlassian.net/wiki/spaces/QA/pages/462259482/Installation+for+macOS+Machine)
  * [Windows](https://setelnow.atlassian.net/wiki/spaces/QA/pages/1733789105/Installation+for+Windows+OS+Machine)
       
    
    
