package com.ramon.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramon.gerenciador.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}
