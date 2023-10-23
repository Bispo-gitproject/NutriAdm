package com.nutriadm.Nutriadm.Services;

import com.nutriadm.Nutriadm.Entity.ClienteEntity;
import com.nutriadm.Nutriadm.Repository.ClienteRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public boolean cadastrarCliente(ClienteEntity cliente) {
        clienteRepository.save(cliente);
        return true;
    }

    public ClienteEntity consultarClienteCpf(ClienteEntity cliente) {
        return clienteRepository.findNomeByCpf(cliente.getCpf());

    }

    public List<ClienteEntity> consultarClientes() {
        return clienteRepository.findAll();
    }


}
