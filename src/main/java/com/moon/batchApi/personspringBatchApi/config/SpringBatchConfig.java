package com.moon.batchApi.personspringBatchApi.config;


import com.moon.batchApi.personspringBatchApi.model.Personn;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReader<Personn> personnItemReader;
    @Autowired
    private ItemProcessor<Personn,Personn> personnItemProcessor;
    @Autowired
    private ItemWriter<Personn> personnItemWriter;



    //Creation d'un job et creation du step contenu dans le job
    @Bean
    public Job personnJob(){
    Step step1 = stepBuilderFactory.get("step1-personne").<Personn,Personn>chunk(100)
            .reader(personnItemReader)
            .processor(personnItemProcessor)
            .writer(personnItemWriter)
            .build();

        return jobBuilderFactory.get("Data-loaded-Personn").start(step1).build();
    }


    @Bean
    @StepScope
    FlatFileItemReader<Personn> flatFileItemReader(@Value("${inputFile}") Resource resource){

        FlatFileItemReader<Personn> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setName("CSV-Reader-Personn");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;


    }

    @Bean
    public LineMapper<Personn> lineMapper(){
        DefaultLineMapper<Personn> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"id","fistName","lastName","age","address","country","accountName","idSociety"});
        lineMapper.setLineTokenizer(lineTokenizer);
        BeanWrapperFieldSetMapper<Personn> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Personn.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }








}
