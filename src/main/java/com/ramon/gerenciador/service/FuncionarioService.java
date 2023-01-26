package com.ramon.gerenciador.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.gerenciador.exception.FuncionarioNaoEncontradoException;
import com.ramon.gerenciador.model.Funcionario;
import com.ramon.gerenciador.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listar(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                .collect(Collectors.toList());
    }

    public Funcionario adicionar(Funcionario funcionario){
        funcionario.setCodigoRegistro(UUID.randomUUID().toString());
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscar(Long id){
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Cliente com id:" + id +"  não encontrado"));
    }

    public void excluir(Long id){
        funcionarioRepository.deleteById(id);
    }
    
    
}
