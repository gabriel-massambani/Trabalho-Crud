package com.semi.seminario_spring.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@EnableJpaRepositories
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double preco;

}
