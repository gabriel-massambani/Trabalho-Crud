package com.semi.seminario_spring.datasources;

import com.semi.seminario_spring.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
