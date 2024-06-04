package com.semi.seminario_spring.datasources;

import com.semi.seminario_spring.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
