import java.time.LocalDate;
import java.time.Period;

public class CuentaJoven extends Cuenta{
     private double bonificacion;

    public CuentaJoven(Cliente titular, double saldo, double bonificacion) {
        super(titular, saldo);
        this.bonificacion = bonificacion;
    }

        public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        if (bonificacion < 0) {
            System.out.println("Error: la bonificación no puede ser negativa");
        } else {
            this.bonificacion = bonificacion;
        }
    }

        public boolean esTitularValido() {
        if (getTitular() == null || getTitular().getFechaDeNacimiento() == null) {
            return false;
        }
        int edad = Period.between(getTitular().getFechaDeNacimiento(), LocalDate.now()).getYears();
        if (edad >= 18 && edad <= 25) {
            return true;
        } else {
            return false;
        }
    }

        public double bonificar(double monto) {
        return monto + monto * bonificacion / 100;
    }

    @Override
    public void deposito(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto del depósito debe ser mayor a 0");
        } else {
            double montoFinal = bonificar(monto);
            saldo = saldo + montoFinal;
            registrarMovimiento(montoFinal);
        }
    }

        @Override
    public String toString() {
        return super.toString() + ", Bonificación: " + bonificacion + "%";
    }
}

