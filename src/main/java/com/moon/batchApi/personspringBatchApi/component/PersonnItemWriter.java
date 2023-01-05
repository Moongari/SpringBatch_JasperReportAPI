package com.moon.batchApi.personspringBatchApi.component;

import com.moon.batchApi.personspringBatchApi.Dao.PersonnRepository;
import com.moon.batchApi.personspringBatchApi.model.Personn;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonnItemWriter implements ItemWriter<Personn> {

    @Autowired
    private PersonnRepository personnRepository;




    @Override
    public void write(List<? extends Personn> list) throws Exception {
        personnRepository.saveAll(list);
    }
}
