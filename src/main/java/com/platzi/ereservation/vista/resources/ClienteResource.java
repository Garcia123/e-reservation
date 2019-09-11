package com.platzi.ereservation.vista.resources;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.service.ClienteService;
import com.platzi.ereservation.vista.resources.vo.ClienteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que representa el servico rest del cliente
 * @author Jose
 * */
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping
    @ApiOperation(value = "Crear cliente", notes = "Servicio para crear un nuevo cliente")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "cliente creado correctamente"), @ApiResponse(code = 400, message = "solicitud invalida")})
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVO){
        Cliente cliente = new Cliente();
        cliente.setNombreCli(clienteVO.getNombreCli());
        cliente.setApellidoCli(clienteVO.getApellidoCli());
        cliente.setDirecionCli(clienteVO.getDirecionCli());
        cliente.setTelefonoCli(clienteVO.getTelefonoCli());
        cliente.setEmailCli(clienteVO.getEmailCli());
        return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar cliente", notes = "Servicio para actualizar un cliente")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "cliente actualizado correctamente"), @ApiResponse(code = 404, message = "cliente no encontrado")})
    public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion")String identificacion,  @RequestBody ClienteVO clienteVO){
        Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
        if(cliente == null){
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }else {
            cliente.setNombreCli(clienteVO.getNombreCli());
            cliente.setApellidoCli(clienteVO.getApellidoCli());
            cliente.setDirecionCli(clienteVO.getDirecionCli());
            cliente.setTelefonoCli(clienteVO.getTelefonoCli());
            cliente.setEmailCli(clienteVO.getEmailCli());
        }

        return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar cliente", notes = "Servicio para eliminar un cliente")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "cliente eliminado correctamente"), @ApiResponse(code = 404, message = "cliente no encontrado")})
    public void removCliente(@PathVariable("identificacion")String identificacion){
        Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
        if(cliente != null){
            this.clienteService.delete(cliente);
        }
    }

    @GetMapping
    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Listar cliente", notes = "Servicio para listar todos los cliente")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "cliente encontrados correctamente"), @ApiResponse(code = 404, message = "cliente no encontrado")})
    public ResponseEntity<List<Cliente>> fndAll(){
        return ResponseEntity.ok(this.clienteService.findAll());
    }
}
