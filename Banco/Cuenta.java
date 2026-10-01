import java.util.ArrayList;

public class Cuenta {
    protected Cliente titular;
    protected double saldo;
    protected ArrayList<Double> movimientos;

        public Cuenta() {
        this.titular = null;
        this.saldo = 0;
        this.movimientos = new ArrayList<>();
    }

        public Cuenta(Cliente titular) {
        this.titular = titular;
        this.saldo = 0;
        this.movimientos = new ArrayList<>();
    }

        public Cuenta(Cliente titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.movimientos = new ArrayList<>();
    }

        public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Double> getMovimientos() {
        return movimientos;
    }

    public void setTitular(Cliente titular) {
        if (titular == null) {
            System.out.println("Error: el titular no puede ser nulo");
        } else {
            this.titular = titular;
        }
    }

        public void registrarMovimiento(double monto) {
        movimientos.add(monto);
    }

        public void deposito(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto del depósito debe ser mayor a 0");
        } else {
            saldo = saldo + monto;
            registrarMovimiento(monto);
        }
    }

        public void retiro(double monto) {
            if (monto <= 0) {
             System.out.println("Error: el monto del retiro debe ser mayor a 0");
            } else if (monto > saldo) {
             System.out.println("Error: saldo insuficiente");
        } else {
            saldo = saldo - monto;
            registrarMovimiento(-monto);
        }
    }

        public String toString() {
        return "Titular: " + titular.getNombre() + ", RUT: " + titular.getrut()
                + ", Saldo: " + saldo + ", Movimientos: " + movimientos;
    }
}
