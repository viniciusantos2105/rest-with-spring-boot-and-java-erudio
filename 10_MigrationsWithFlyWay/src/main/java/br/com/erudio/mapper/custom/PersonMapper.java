package br.com.erudio.mapper.custom;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertVoToEntity(Person person){
        PersonVOV2 personVOV2 = new PersonVOV2();
        personVOV2.setId(person.getId());
        personVOV2.setFirstName(person.getFirstName());
        personVOV2.setLastName(person.getLastName());
        personVOV2.setAddress(person.getAddress());
        personVOV2.setGender(person.getGender());
        personVOV2.setBirthday(new Date());
        return personVOV2;
    }

    public Person convertEntityToVo(PersonVOV2 entity){
        Person vo = new Person();
        vo.setId(entity.getId());
        vo.setFirstName(entity.getFirstName());
        vo.setLastName(entity.getLastName());
        vo.setAddress(entity.getAddress());
        vo.setGender(entity.getGender());
        return vo;
    }

}
