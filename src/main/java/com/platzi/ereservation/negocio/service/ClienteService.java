package com.platzi.ereservation.negocio.service;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase para definir los servicios del cliente
 * */
@Service
@Transactional(readOnly = true) // todos los que no tengan transaccional es readOnly
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Metodo usado para guardar un cliente
     * @param cliente el cliente no debe tener id debe de estar null.
     * */
    @Transactional
    public Cliente create(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    /**
     * Metodo para actualizar un cliente
     * @param cliente el objeto cliente debe tener el id para actualizar.
     * */
    @Transactional
    public  Cliente update(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    /**
     * Metodo para eliminar un cliente
     * @param cliente
     * */
    @Transactional
    public void delete(Cliente cliente){
        this.clienteRepository.delete(cliente);
    }

    /**
     * metodo para consultar por su identificacion
     * @param identificacionCli codidigo de identificacion.
     * */
    public Cliente findByIdentificacion(String identificacionCli){
        return this.clienteRepository.findByIdentification(identificacionCli);
    }

    public List<Cliente> findByApellidoCli(String apellidoCli){
        return this.clienteRepository.findByApellidoCli(apellidoCli);
    }
}
