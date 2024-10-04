package com.edu.umg.proyectoclaseumg;

import com.edu.umg.DAO.PersonaDAO;
import com.edu.umg.DTO.PersonaDTO;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "personaBean")
@SessionScoped
public class PersonaBean implements Serializable {

    private PersonaDTO persona;  // Objeto persona que se vincula con el formulario
    private List<PersonaDTO> personas;  // Lista de personas para mostrar en la tabla
    private PersonaDAO personaDAO;  // DAO para realizar las operaciones

    @PostConstruct
    public void init() {
        persona = new PersonaDTO();
        personaDAO = new PersonaDAO();
        personas = personaDAO.listaPersona();  // Inicializa la lista de personas
    }

    // Método para agregar una nueva persona
    public void agregarPersona() {
        try {
            personaDAO.agregarPersona(persona);
            personas = personaDAO.listaPersona();  // Refresca la lista
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Persona agregada correctamente"));
            persona = new PersonaDTO();  // Limpia el formulario
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo agregar la persona"));
        }
    }

    // Método para preparar la edición de una persona (abre el diálogo)
    public void prepararEdicion(PersonaDTO personaSeleccionada) {
        this.persona = personaSeleccionada;
    }

    // Método para actualizar la persona
    public void actualizarPersona() {
        try {
            personaDAO.actualizarPersona(persona);
            personas = personaDAO.listaPersona();  // Refresca la lista
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Persona actualizada correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo actualizar la persona"));
        }
    }

    // Método para preparar la eliminación de una persona
    public void prepararEliminacion(PersonaDTO personaSeleccionada) {
        this.persona = personaSeleccionada;
    }

    // Método para confirmar la eliminación de la persona
    public void confirmarEliminacion() {
        try {
            personaDAO.eliminarPersona(persona.getIdPersona());
            personas = personaDAO.listaPersona(); // Refresca la lista
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Persona eliminada correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar la persona"));
        }
    }

    // Getters y Setters
    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public List<PersonaDTO> getPersonas() {
        return personas;
    }

    public void setPersonas(List<PersonaDTO> personas) {
        this.personas = personas;
    }
}
