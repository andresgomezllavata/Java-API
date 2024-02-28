package com.rest.api.superhero.mapper;

import com.rest.api.superhero.dto.SuperheroDTO;
import com.rest.api.superhero.model.Superhero;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SuperheroMapper {

    private SuperheroMapper() {
    }

    public static SuperheroMapper createSuperheroMapper() {
        return new SuperheroMapper();
    }

    public Superhero toEntity(SuperheroDTO superheroDTO) {
        return new Superhero(superheroDTO.getName(), superheroDTO.getCity(), superheroDTO.getPower(), superheroDTO.wearsCape());
    }

    public SuperheroDTO toDTO(Superhero superhero) {
        return new SuperheroDTO(superhero.getName(), superhero.getCity(), superhero.getPower(), superhero.wearsCape());
    }

    public List<Superhero> toEntityList(List<SuperheroDTO> listDTO) {
        List<Superhero> list = new ArrayList<Superhero>();

        for(SuperheroDTO superheroDTO:listDTO){
            Superhero superhero = new Superhero(superheroDTO.getName(), superheroDTO.getCity(), superheroDTO.getPower(), superheroDTO.wearsCape());
            list.add(superhero);
        }

        return list;
    }

    public List<SuperheroDTO> toDTOList(List<Superhero> list) {
        List<SuperheroDTO> listDTO = new ArrayList<SuperheroDTO>();

        for(Superhero superhero:list){
            SuperheroDTO superheroDTO = new SuperheroDTO(superhero.getName(), superhero.getCity(), superhero.getPower(), superhero.wearsCape());
            listDTO.add(superheroDTO);
        }

        return listDTO;
    }
}
