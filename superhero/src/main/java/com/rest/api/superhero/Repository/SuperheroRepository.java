package com.rest.api.superhero.repository;

import com.rest.api.superhero.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SuperheroRepository extends JpaRepository<Superhero, String> {
    @Query("SELECT u FROM Superhero u WHERE u.name LIKE %:partialName%")
    public List<Superhero> findByNameContaining(@Param("partialName") String partialName);

}
