package com.example.crud.model;

import com.example.crud.model.Kontaktperson;
import com.example.crud.dao.KontaktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KontaktpersonByIdConverter implements Converter<Long, Kontaktperson> {

    private KontaktRepository kontaktrepository;

    @Autowired
    public KontaktpersonByIdConverter(KontaktRepository kontaktrepository) {
        this.kontaktrepository = kontaktrepository;
    }

    @Override
    public Kontaktperson convert(Long id) {
        Optional<Kontaktperson> optionalIngredient = kontaktrepository.findById(id);
        return optionalIngredient.isPresent() ?
                optionalIngredient.get() : null;
    }


}














