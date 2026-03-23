package com.am.gerenciamento_fornecedores.Service;


import com.am.gerenciamento_fornecedores.Model.FornecedorModel;
import com.am.gerenciamento_fornecedores.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<FornecedorModel> findAll(){ return fornecedorRepository.findAll();}
    public Optional<FornecedorModel> findById(Long id) {
        return fornecedorRepository.findById(id);
    }
    public FornecedorModel criarFornecedor(FornecedorModel fornecedor) { return fornecedorRepository.save(fornecedor); }
    public FornecedorModel atualizarFornecedor(FornecedorModel fornecedor, Long id) {
        FornecedorModel fornecedorAtualizado = fornecedorRepository.findById(id).get();
        fornecedorAtualizado.setNomeFantasia(fornecedor.getNomeFantasia());
        return fornecedorRepository.save(fornecedorAtualizado);
    }
    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
