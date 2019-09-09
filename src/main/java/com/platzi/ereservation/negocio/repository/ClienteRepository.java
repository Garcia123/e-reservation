package com.platzi.ereservation.negocio.repository;

import com.platzi.ereservation.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * interface para definir las operaciones de bd relacionadas con el cliente.
 * @author Jose
 * */
public interface ClienteRepository extends JpaRepository <Cliente, String> {

    /**
     *Definicion del metodo para buscar los clientes por su apellido
     * @param apellidoCli
     * @return clientes
     * */
    List<Cliente> findByApellidoCli(String apellidoCli);

    Cliente findByIdentification(String identificationCli);


}
