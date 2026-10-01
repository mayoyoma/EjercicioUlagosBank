import java.time.LocalDate;

public class Cliente extends Persona {
    private String password;
    private String productos;

    public Cliente(){
        super(); 
        this.password = ""; 
        this.productos = ""; 

    }

    public String getPassword() {
    return password;
}

public String getProductos() {
    return productos;
}

    public Cliente(String nombre, LocalDate fechaDeNacimiento, String rut, String password, String productos){
        super(nombre, fechaDeNacimiento, rut);
        this.password = password;
        this.productos = productos;
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


public void setProductos(String productos) {
    if (productos == null) {
        System.out.println("Error: los productos no pueden ser nulos");
    } else if (productos.isEmpty()) {
        System.out.println("Error: los productos no pueden estar vacíos");
    } else {
        this.productos = productos;
    }
}

public String toString() {
    return super.toString() + ", Password: " + password + ", Productos: " + productos;
}


    
}
