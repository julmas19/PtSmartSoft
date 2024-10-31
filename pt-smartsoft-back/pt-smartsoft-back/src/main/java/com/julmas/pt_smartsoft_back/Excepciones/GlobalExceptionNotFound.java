package com.julmas.pt_smartsoft_back.Excepciones;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//Clase de control global para Exepciones de tipo NOT_FOUND"
//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class GlobalExceptionNotFound extends RuntimeException {

    private static final long serialVersionUID=1L;
    // Campos de imformacion
    private final String resourceType;
    private final String resourceId;

    // Constructor
    public GlobalExceptionNotFound(String resourceType, String resourceId){
        super(String.format("%s con id %s no existe", resourceType,resourceId));
        this.resourceId = resourceId;
        this.resourceType = resourceType;
    }

    // Getters
    public String getResourceType(){
        return resourceType;
    }
    public String getResourceId(){
        return resourceId;
    }
}
