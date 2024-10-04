package com.edu.umg.proyectoclaseumg;

import com.edu.umg.DTO.PersonaDTO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "bkn_indexUI")

public class AgregarPersonaUI implements Serializable {
    /*
    private PersonaDTO datosPersona;  // Objeto para capturar los datos del formulario
    private List<PersonaDTO> list;
    private DMLBdd dml = new DMLBdd();

    public AgregarPersonaUI() {
    }

    @PostConstruct
    public void init() {
        datosPersona = new PersonaDTO(); // Inicializar datosPersona
        setList(new ArrayList<PersonaDTO>());

        System.out.println("Iniciando la página...");
        try {
            this.listarPersonas();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarPersonaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.mostrarDatos();

        for (PersonaDTO personaDTO : getList()) {
            System.out.println("El nombre es: " + personaDTO.getNombre() + " - " + personaDTO.getApellido());
        }
    }

    public void listarPersonas() throws SQLException {
        System.out.println("Entrando a ver los registros");

        try {
            setList(dml.listaPersona());
            for (PersonaDTO personaDTO : getList()) {
                System.out.println("Datos de la lista:");
                System.out.println("ID Persona: " + personaDTO.getIdPersona());
                System.out.println("Nombre: " + personaDTO.getNombre() + " " + personaDTO.getApellido());
            }
        } catch (SQLException ex) {
            System.out.println("Error al realizar la consulta: " + ex);
        }
    }

    public void agregarPersona() {
        try {
            dml.agregarPersona(getDatosPersona());
            this.listarPersonas();  // Actualizar la lista después de la inserción
            datosPersona = new PersonaDTO();
        } catch (SQLException ex) {
            System.out.println("Error al realizar la consulta: " + ex);
        }
    }
    
    public void mostrarDatos() {
        System.out.println("El valor del nombre es: " + datosPersona.getNombre());
        System.out.println("El valor del apellido es: " + datosPersona.getApellido());
    }

    // Getters y Setters
    public PersonaDTO getDatosPersona() {
        return datosPersona;
    }

    public void setDatosPersona(PersonaDTO datosPersona) {
        this.datosPersona = datosPersona;
    }

    public List<PersonaDTO> getList() {
        return list;
    }

    public void setList(List<PersonaDTO> list) {
        this.list = list;
    }
*/
}
