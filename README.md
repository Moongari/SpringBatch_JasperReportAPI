## Lessons SPRING BATCH
1. Introduction to my course
2. Install development tools
3. Create springBatch API and SpringBoot app
    1. Create project's folder
    2. Need Java 8 install on your machine 
	3. Install Dependances with spring IO : Web,DevTools,Lombock,SpringBatch,PostGreSql,DataJpa,spring-batch-core (version 4.3.0) with Maven 
    3. Unzip your project on your machine
	4. mvn clean / install to check if application is done
	5. Create 5 packages on your project (component,config,controller,Dao, model)
	6. create on your folder resources a personn.csv file
	7. Modify your application.properties 
		1. insert this line : inputFile= classpath:/personn.csv
		2. insert this line : spring.batch.job.enabled=false
		3. Modify server port : server.port=8082
	8. check and get information on application.properties to update your file
	9. install PostMan on your machine to start your spring batch api
	
4. Add Header
    1. Generate Component
    2. Add Html 
    3. Add Css

5. List Foods
    1. Create Food Model
    2. Create data.ts
        1. add sample foods
    3. Add images to assets
    4. create Food service
    5. Create Home component
        1. Add.ts
        2. Add html
        3. Add css