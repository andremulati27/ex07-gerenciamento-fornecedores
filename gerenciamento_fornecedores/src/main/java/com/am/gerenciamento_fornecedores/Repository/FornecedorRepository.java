package com.am.gerenciamento_fornecedores.Repository;

import com.am.gerenciamento_fornecedores.Model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
}
