package com.nutriadm.Nutriadm.Repository;

import com.nutriadm.Nutriadm.Entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

     List<ProdutoEntity> findByNomeContaining(String nome);
     List<ProdutoEntity> findByPrecoLessThan(BigDecimal preco);

}
