package com.edu.umg.proyectoclaseumg;

import com.edu.umg.DTO.PersonaDTO;
import com.edu.umg.bdd.DMLBdd;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "personaBean")
@ViewScoped
public class PersonaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private PersonaDTO persona;
    private DMLBdd dml;
    private List<PersonaDTO> personas;

    @PostConstruct
    public void init() {
        persona = new PersonaDTO();
        dml = new DMLBdd();
        cargarPersonas();  // Cargar personas al inicio
    }

    public void agregarPersona() {
        try {
            dml.agregarPersona(persona);
            FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage("Persona agregada exitosamente."));
            persona = new PersonaDTO(); // Reset form
            cargarPersonas();  // Recargar la lista de personas
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage("Error al agregar persona: " + e.getMessage()));
        }
    }

    public void cargarPersonas() {
        try {
            personas = dml.listaPersona();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage("Error al cargar personas: " + e.getMessage()));
        }
    }
    
        public void eliminarPersona(PersonaDTO persona) {
    try {
        dml.eliminarPersona(persona.getIdPersona());
        FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage("Persona eliminada exitosamente."));
        cargarPersonas();  // Recargar la lista de personas
    } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage("Error al eliminar persona: " + e.getMessage()));
    }
}
        
       public void prepararEdicion(PersonaDTO persona) {
        this.persona = persona;
    }
    
    
    public void actualizarPersona() {
        try {
            dml.actualizarPersona(persona);
            FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage("Persona actualizada exitosamente."));
            persona = new PersonaDTO(); // Reset form
            cargarPersonas();  // Recargar la lista de personas
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage("Error al actualizar persona: " + e.getMessage()));
        }
    } 
    
    // Método para preparar la eliminación
    public void prepararEliminacion(PersonaDTO persona) {
        this.persona = persona;
    }
    
    // Método para confirmar la eliminación
    public void confirmarEliminacion() {
        try {
            dml.eliminarPersona(persona.getIdPersona());
            FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage("Persona eliminada exitosamente."));
            cargarPersonas();  // Recargar la lista de personas
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new javax.faces.application.FacesMessage("Error al eliminar persona: " + e.getMessage()));
        }
    }

    // Getters and Setters
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
