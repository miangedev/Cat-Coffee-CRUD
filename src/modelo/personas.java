package modelo;

public class personas {

    private int id;
    private String tipo_documento;
    private String numero_documento;
    private String razon_social;
    private String telefono;
    private String email;
    private String direccion;
    private int ROL_id;
    private String nombre;
    private String usuario;
    private String contrasena;


    public personas() {
        this.id = 0;
        this.tipo_documento = "";
        this.numero_documento = "";
        this.razon_social = "";
        this.telefono = "";
        this.email = "";
        this.direccion = "";
        this.ROL_id = 0;
        this.nombre = "";
        this.usuario = "";
        this.contrasena = "";
    }

    public personas(int id, String tipo_documento, String numero_documento, String razon_social, String telefono, String email, String direccion, int ROL_id, String nombre) {
        this.id = id;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.ROL_id = ROL_id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo_documento() { return tipo_documento; }
    public void setTipo_documento(String tipo_documento) { this.tipo_documento = tipo_documento; }

    public String getNumero_documento() { return numero_documento; }
    public void setNumero_documento(String numero_documento) { this.numero_documento = numero_documento; }

    public String getRazon_social() { return razon_social; }
    public void setRazon_social(String razon_social) { this.razon_social = razon_social; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public int getROL_id() { return ROL_id; }
    public void setROL_id(int ROL_id) { this.ROL_id = ROL_id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", tipo_documento=" + tipo_documento + ", numero_documento=" + numero_documento + ", razon_social=" + razon_social + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", ROL_id=" + ROL_id + ", nombre=" + nombre + '}';
    }
}