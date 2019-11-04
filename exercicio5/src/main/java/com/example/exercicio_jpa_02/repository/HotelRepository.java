package com.example.exercicio_jpa_02.repository;

import com.example.exercicio_jpa_02.model.Cama;
import com.example.exercicio_jpa_02.model.Hotel;
import com.example.exercicio_jpa_02.model.TipoQuartoQtdCama;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
    @Query(value = "SELECT c FROM Hotel h JOIN h.quartos q JOIN q.camas c WHERE h.id = :id")
    public List<Cama> findAllCamas(@Param("id") Long id);
    
    public List<TipoQuartoQtdCama> countQuartosECamas(@Param("id") Long id);
}
