package com.nutriadm.Nutriadm.Services;

import com.nutriadm.Nutriadm.Entity.ProdutoEntity;
import com.nutriadm.Nutriadm.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    public List<ProdutoEntity> buscarPorPreco(BigDecimal preco) {
        return produtoRepository.findByPrecoLessThan(preco);
    }

    // outras operações
}
