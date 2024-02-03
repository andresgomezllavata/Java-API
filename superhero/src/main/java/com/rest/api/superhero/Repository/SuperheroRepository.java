package com.rest.api.superhero.Repository;

import com.rest.api.superhero.Model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;

public interface SuperheroRepository extends JpaRepository<Superhero, String> {

}
