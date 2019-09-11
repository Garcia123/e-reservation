package com.platzi.ereservation.vista.resources.vo;

import com.platzi.ereservation.modelo.Reserva;
import lombok.Data;
import java.util.Set;

@Data
public class ClienteVO {
        private String nombreCli;
        private String apellidoCli;
        private String identificationCli;
        private String direcionCli;
        private String telefonoCli;
        private String emailCli;
        private Set<Reserva> reservas;

        public ClienteVO() {}

}
