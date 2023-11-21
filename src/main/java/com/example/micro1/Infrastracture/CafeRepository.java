package com.example.micro1.Infrastracture;
import com.example.micro1.Domain.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends JpaRepository<Cafe,Long> {

}