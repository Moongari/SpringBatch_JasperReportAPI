package com.moon.batchApi.personspringBatchApi.component;

import com.moon.batchApi.personspringBatchApi.model.Personn;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonnItemProcessor implements ItemProcessor<Personn,Personn> {


    private static final Map<String,String> nameByAccountSociety = new HashMap<>();

    public PersonnItemProcessor() {

        nameByAccountSociety.put("1","EDF");
        nameByAccountSociety.put("2","Orange");
        nameByAccountSociety.put("3","Atos");
        nameByAccountSociety.put("4","GDF");
        nameByAccountSociety.put("5","ING");
        nameByAccountSociety.put("6","Peugeot");
        nameByAccountSociety.put("7","Poste");


    }


    @Override
    public Personn process(Personn personn) {

        String accountSociety = personn.getIdSociety();
        String nameOfSociety = nameByAccountSociety.get(accountSociety);
        personn.setIdSociety(nameOfSociety);
        return personn;
    }
}
