package com.nutriadm.Nutriadm.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nutriadm.Nutriadm.Entity.ClienteEntity;
import com.nutriadm.Nutriadm.Services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/clientes")
@Api(value = "com.nutriadm.Controller", tags = "Exemplo")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    private static final Logger LOGGER = Logger.getLogger(ClienteController.class.getName());

    @GetMapping("/consultacpf")
    @ApiOperation("Consultar cliente por CPF")
    public ResponseEntity<String> consultarCliente(@RequestParam(required = true) String cpf,
                                                   @RequestParam(required = false) String nome,
                                                   @RequestParam(required = false) String email) {
        try {
            ClienteEntity cliente = new ClienteEntity(nome, email, cpf);
            ClienteEntity clienteConsultado = clienteService.consultarClienteCpf(cliente);
            if (clienteConsultado != null) {
                ObjectMapper mapper = new ObjectMapper();
                String clienteJson = mapper.writeValueAsString(clienteConsultado);
                return ResponseEntity.ok(clienteJson);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao consultar cliente por CPF", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao consultar cliente por CPF");
        }
    }

    @PostMapping("/cadastra")
    @ApiOperation("Cadastrar um novo cliente")
    public ResponseEntity<Void> cadastrarCliente(@RequestParam(required = true) String cpf,
                                                 @RequestParam(required = true) String nome,
                                                 @RequestParam(required = false) String email) {
        ClienteEntity cliente = new ClienteEntity(nome,email,cpf);
        if (clienteService.cadastrarCliente(cliente)) {
            return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                            .buildAndExpand(cliente.getId()).toUri()).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
