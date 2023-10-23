package com.nutriadm.Nutriadm.Repository;

import com.nutriadm.Nutriadm.Entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {

    @Autowired
    ClienteEntity findNomeByCpf(String cpf);

}
