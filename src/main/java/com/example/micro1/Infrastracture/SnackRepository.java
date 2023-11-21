package com.example.micro1.Infrastracture;
import com.example.micro1.Domain.Snack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnackRepository extends JpaRepository<Snack,Long> {

}