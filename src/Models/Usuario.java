package Models;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private static Map<String, String> usuarios = new HashMap<>();

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Static methods for user management
    public static boolean crearUsuario(String nombreUsuario, String contrasena) {
        if (usuarios.containsKey(nombreUsuario)) {
            return false; // Usuario ya existe
        }
        usuarios.put(nombreUsuario, contrasena);
        return true;
    }

    public static boolean ingresar(String nombreUsuario, String contrasena) {
        return usuarios.containsKey(nombreUsuario) && usuarios.get(nombreUsuario).equals(contrasena);
    }
}