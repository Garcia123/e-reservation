package com.platzi.ereservation.modelo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Clase que representa a la tabla cliente
 * @author Jose
 */
@Data
@Entity
@Table(name = "cliente")
@NamedQuery(name="Cliente.findByIdentification", query = "select c from Cliente c where c.identificationCli = ?1")
public class Cliente {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String idCli;

    private String nombreCli;
    private String apellidoCli;
    private String identificationCli;
    private String direcionCli;
    private String telefonoCli;
    private String emailCli;

    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> reservas;

    public Cliente() {}
}
