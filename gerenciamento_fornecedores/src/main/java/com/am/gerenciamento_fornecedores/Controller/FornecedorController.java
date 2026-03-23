package com.am.gerenciamento_fornecedores.Controller;


import com.am.gerenciamento_fornecedores.Model.FornecedorModel;
import com.am.gerenciamento_fornecedores.Service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll() {
        List<FornecedorModel> fornecedores = fornecedorService.findAll();
        return ResponseEntity.status(200).body(fornecedores);
    }

    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedorModel) {
        FornecedorModel fornecedor = fornecedorService.criarFornecedor(fornecedorModel);
        return ResponseEntity.status(201).body(fornecedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FornecedorModel>> findById(@PathVariable Long id) {
        Optional<FornecedorModel> fornecedor = fornecedorService.findById(id);
        return ResponseEntity.status(200).body(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorModel> atualizarFornecedor(@PathVariable Long id, @RequestBody FornecedorModel fornecedorModel) {
        FornecedorModel fornecedor = fornecedorService.findById(id).get();
        fornecedor.setNomeFantasia(fornecedorModel.getNomeFantasia());
        return ResponseEntity.status(200).body(fornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.status(204).build();
    }


}
