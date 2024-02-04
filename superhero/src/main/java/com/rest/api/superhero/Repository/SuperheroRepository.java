package com.rest.api.superhero.Repository;

import com.rest.api.superhero.Model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;

public interface SuperheroRepository extends JpaRepository<Superhero, String> {
    @Query("SELECT u FROM Superhero u WHERE u.name LIKE %:partialName%")
    public List<Superhero> findByNameContaining(@Param("partialName") String partialName);
}
