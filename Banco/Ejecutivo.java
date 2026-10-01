import java.time.LocalDate;

public class Ejecutivo extends Persona{
    private String usuario;
    private String password;

        public Ejecutivo() {
        super();
        this.usuario = "";
        this.password = "";
    }

        public Ejecutivo(String nombre, LocalDate fechaDeNacimiento, String rut, String usuario, String password) {
        super(nombre, fechaDeNacimiento, rut);
        this.usuario = usuario;
        this.password = password;
    }

        public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

        public void setUsuario(String usuario) {
        if (usuario == null) {
            System.out.println("Error: el usuario no puede ser nulo");
        } else if (usuario.length() != 10) {
            System.out.println("Error: el usuario debe tener exactamente 10 caracteres");
        } else {
            this.usuario = usuario;
        }
    }

    public void setPassword(String password) {
        if (password == null) {
            System.out.println("Error: la contraseña no puede ser nula");
        } else if (password.length() != 10) {
            System.out.println("Error: la contraseña debe tener exactamente 10 caracteres");
        } else {
            this.password = password;
        }
    }

        public String toString() {
        return super.toString() + ", Usuario: " + usuario + ", Password: " + password;
    }
}
    

