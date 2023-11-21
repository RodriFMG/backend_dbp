package com.example.micro1.Infrastracture;
import com.example.micro1.Domain.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida,Long> {

}
