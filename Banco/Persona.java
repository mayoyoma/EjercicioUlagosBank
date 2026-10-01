import java.time.LocalDate; 
import java.time.Period;

public class Persona {
    private String nombre; 
    private LocalDate fechaDeNacimiento; 
    private String rut; 

    public Persona(){
        this.nombre = ""; 
        this.fechaDeNacimiento = null; 
        this.rut = ""; 
    }

    public Persona(String nombre, LocalDate fechaDeNacimiento, String rut){
        this.nombre = nombre; 
        this.fechaDeNacimiento = fechaDeNacimiento; 
        this.rut = rut; 
    }

    public String getNombre(){
        return nombre; 
    }

    public LocalDate getFechaDeNacimiento(){
        return fechaDeNacimiento; 
    }

    public String getrut(){
        return rut; 
    }

    public void setNombre(String nombre){
        if (nombre == null){
             System.out.println("Error: el nombre no puede ser nulo");
        } else if (nombre.isEmpty()){
             System.out.println("Error: el nombre no puede estar vacio"); 
        } else {
            this.nombre = nombre; 
        }
    } 

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
         if (fechaDeNacimiento == null){
            System.out.println("Error: la fecha de nacimiento no puede ser nula");
        }else if (fechaDeNacimiento.isAfter(LocalDate.now())){
            System.out.println("Error: la fecha de nacimiento no puede ser futura");
        }else {
            this.fechaDeNacimiento = fechaDeNacimiento; 
        }
    
}
    public void setRut(String rut){
        if (rut == null){
            System.out.println("Error: el rut no puede ser nulo"); 
        }else if (!rut.contains("-")){
            System.out.println("Error: el rut debe llevar guion");
        } else {
            int posicionGuion = rut.indexOf("-");
            String cuerpo = rut.substring(0, posicionGuion);
            char dv = rut.charAt(posicionGuion + 1);

            int suma = 0; 
            int multiplicador = 2; 
            for (int i = cuerpo.length() - 1; i>=0; i--){
                int digito = Character.getNumericValue(cuerpo.charAt(i)); 
                suma = suma + digito * multiplicador; 
                multiplicador++; 
                if (multiplicador > 7){
                    multiplicador = 2; 
                }
            }

            int result = 11 - (suma % 11); 
            char dvCorrecto; 
            if (result == 11){
                dvCorrecto = '0'; 
            } else if (result == 10){
                dvCorrecto = 'K'; 
            } else {
                dvCorrecto = (char) ('0'+result);
            }
            if (Character.toUpperCase(dv) == dvCorrecto) {
                this.rut = rut;
            } else {
                System.out.println("Error: dígito verificador incorrecto");
            }
        }
    }

    public String ToString(){
        return "Nombre: " + nombre + ", RUT: " + rut + ", Fecha de nacimiento: " + fechaDeNacimiento;
    } 

    public boolean esMayorDeEdad() {
    if (fechaDeNacimiento == null) {
        return false;
    }
    int edad = Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
    if (edad >= 18) {
        return true;
    } else {
        return false;
    }
}
}
