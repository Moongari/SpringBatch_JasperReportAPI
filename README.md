## Lessons SPRING BATCH and Create a report with JasperReport 
1. Introduction to my course SpringBatch with SpringBoot MVC
2. Install development tools(intellij, PostGreSql,Postman, git bash,JasperReport)
3. Create springBatch API and SpringBoot app
    1. Create project's folder
    2. Need Java 8 install on your machine 
	3. Install Dependances with spring IO : Web,DevTools,Lombock,SpringBatch,PostGreSql,DataJpa,spring-batch-core (version 4.3.0) with Maven 
    3. Unzip your project on your machine
	4. mvn clean / install to check if application is done
	5. Create 5 packages in your project (component,config,controller,Dao, model)
	6. create on your folder resources a personn.csv file
	7. Modify your application.properties 
		1. insert this line : inputFile= classpath:/personn.csv
		2. insert this line : spring.batch.job.enabled=false
		3. Modify server port : server.port=8082
	8. check and get information on application.properties to update your file
	9. install PostMan on your machine to start your spring batch api
	
4. Create a SpringBatchConfig Class in config folder
	1. add annotation (@Configuratio, @EnableBatchProcessing)
    2. create a Job personnJob  (@Bean)
    3. create 5 instance of variable(JobBuilderFactory,StepBuilderFactory,ItemReade<Personn>, ItemProcessor<Personn,Personn>, ItemWriter<Personn> => inject this by @Autowired
	4. create and read the file personn.csv by the method (flatFileItemReader and lineMapper)
	5. in the folder component , create 2 class (PersonnItemProcessor, PersonnItemWriter)
	6. in Model folder create Personn class  add @Entity and lombock annotation
	7. in Dao folder create PersonnRepository class 
	8. in controller folder create a PersonnController for to will use this api use this annotation(@RestController,@ControllerAdvice)

5. Create a api getAllPersonn
	1. add List<Personn> findAll(); in the PersonnRepository
    2. Test this api into PostMan

6. install JaspertReport Studio
	1. Create an account into webSite
    2. download the last version TIB_js-studiocomm_6.20.0_windows_x86_64.exe
	3. install on your computer
	4. follow installation
	5. go to Repository Explorer
	6. Go to File => new JasperReport and select SimpleBlue Template
	7. modify the name of file => personnes.jrxml and click Next
	8. select Data adapter => Database jdbc connection
	9. select table Icon and insert this query => select¨* form orders
	10.Select number of fields like the model Personn => 8 fields
	11. Modify all Fields like in your Personn Model
	12. Select Preview in the jasperReport
	13. select Source code of JasperReport (Code xml)
	14. Paste this code source in the IDE Intellij but create a new file personns.jrxml
	15. Add Maven dependancy jasperReport in the pom.xml  => https://mvnrepository.com/artifact/net.sf.jasperreports/jasperreports/6.20.0
	
	
	
7. Create database in PostgreSql
    1. Create Database name : BatchPersonne
	
	
8. Create Api report 
    1. Create folder Service
	2. Create class ExportReport

9. Create Api Controller Report 
    1. Create endPoint generateReport
	2. test your endPoint with Postman

	
     