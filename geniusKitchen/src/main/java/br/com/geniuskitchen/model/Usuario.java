package br.com.geniuskitchen.model;

import br.com.geniuskitchen.enums.TipoUsuario;

public class Usuario {
	
    private String username;
    private String password;
    private TipoUsuario tipo;
    
    public Usuario() {}
    public Usuario(String username, String password, String tipo) {
        this.username = username;
        this.password = password;
        this.tipo = TipoUsuario.valueOf(tipo);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = TipoUsuario.valueOf(tipo.toUpperCase());
    }

    
    public boolean UsuarioDiferenteDeNull() {
    	
    	boolean status = false;
    	
    	if((this.password != null && this.password != "") && (this.username != null && this.username != "")) status = true;
    	
    	return status;
    }
}
