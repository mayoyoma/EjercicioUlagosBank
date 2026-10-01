import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Ejecutivo> ejecutivos = new ArrayList<>();
    static ArrayList<Cuenta> cuentas = new ArrayList<>();
 
    public static void main(String[] args) {
        Ejecutivo admin = new Ejecutivo();
        admin.setNombre("kishi");
        admin.setUsuario("kishi20077");
        admin.setPassword("pudu000000");
        ejecutivos.add(admin);
 
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n Ulagos Banco oficial de la vida");
            System.out.println("1. Ingresar como Ejecutivo");
            System.out.println("2. Ingresar como Cliente");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());
 
            if (opcion == 1) {
                loginEjecutivo();
            } else if (opcion == 2) {
                loginCliente();
            } else if (opcion == 0) {
                System.out.println("Gracias por ingresar a la pagina");
            } else {
                System.out.println("Opción inválida");
            }
        }
    }
 
    static void loginEjecutivo() {
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
 
        Ejecutivo encontrado = null;
        for (int i = 0; i < ejecutivos.size(); i++) {
            Ejecutivo e = ejecutivos.get(i);
            if (e.getUsuario().equals(usuario) && e.getPassword().equals(password)) {
                encontrado = e;
            }
        }
 
        if (encontrado == null) {
            System.out.println("Usuario o password incorrectos");
        } else {
            menuEjecutivo();
        }
    }
 
    static void loginCliente() {
        System.out.print("RUT (ej: 12345678-5): ");
        String rut = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
 
        Cliente encontrado = null;
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getrut().equals(rut) && c.getPassword().equals(password)) {
                encontrado = c;
            }
        }
 
        if (encontrado == null) {
            System.out.println("RUT o password incorrectos");
        } else {
            menuCliente(encontrado);
        }
    }
 
    static void menuEjecutivo() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- Menú Ejecutivo ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Crear ejecutivo");
            System.out.println("3. Crear cuenta");
            System.out.println("4. Crear cuenta joven");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());
 
            if (opcion == 1) {
                crearCliente();
            } else if (opcion == 2) {
                crearEjecutivo();
            } else if (opcion == 3) {
                crearCuenta();
            } else if (opcion == 4) {
                crearCuentaJoven();
            } else if (opcion != 0) {
                System.out.println("Opción inválida");
            }
        }
    }
 
    static void crearCliente() {
        Cliente c = new Cliente();
 
        System.out.print("Nombre: ");
        c.setNombre(sc.nextLine());
 
        System.out.print("Año de nacimiento: ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.print("Mes de nacimiento: ");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.print("Día de nacimiento: ");
        int dia = Integer.parseInt(sc.nextLine());
        c.setFechaDeNacimiento(java.time.LocalDate.of(anio, mes, dia));
 
        System.out.print("RUT (ej: 12345678-5): ");
        c.setRut(sc.nextLine());
 
        System.out.print("Password (10 caracteres): ");
        c.setPassword(sc.nextLine());
 
        System.out.print("Productos (ej: Cuenta corriente): ");
        c.setProductos(sc.nextLine());
 
        clientes.add(c);
        System.out.println("Cliente creado");
    }
 
    static void crearEjecutivo() {
        Ejecutivo e = new Ejecutivo();
 
        System.out.print("Nombre: ");
        e.setNombre(sc.nextLine());
 
        System.out.print("Año de nacimiento: ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.print("Mes de nacimiento: ");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.print("Día de nacimiento: ");
        int dia = Integer.parseInt(sc.nextLine());
        e.setFechaDeNacimiento(java.time.LocalDate.of(anio, mes, dia));
 
        System.out.print("RUT (ej: 12345678-5): ");
        e.setRut(sc.nextLine());
 
        System.out.print("Usuario (10 caracteres): ");
        e.setUsuario(sc.nextLine());
 
        System.out.print("Password (10 caracteres): ");
        e.setPassword(sc.nextLine());
 
        ejecutivos.add(e);
        System.out.println("Ejecutivo creado");
    }
 
    static Cliente buscarCliente(String rut) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getrut().equals(rut)) {
                return clientes.get(i);
            }
        }
        return null;
    }
 
    static void crearCuenta() {
        System.out.print("RUT del titular: ");
        Cliente titular = buscarCliente(sc.nextLine());
 
        if (titular == null) {
            System.out.println("Error: no existe un cliente con ese RUT");
        } else {
            Cuenta cuenta = new Cuenta(titular);
            cuentas.add(cuenta);
            System.out.println("Cuenta creada");
        }
    }
 
    static void crearCuentaJoven() {
        System.out.print("RUT del titular: ");
        Cliente titular = buscarCliente(sc.nextLine());
 
        if (titular == null) {
            System.out.println("Error: no existe un cliente con ese RUT");
        } else {
            System.out.print("Saldo inicial: ");
            double saldo = Double.parseDouble(sc.nextLine());
            System.out.print("Bonificación (%): ");
            double bonificacion = Double.parseDouble(sc.nextLine());
 
            CuentaJoven cj = new CuentaJoven(titular, saldo, bonificacion);
            if (cj.esTitularValido()) {
                cuentas.add(cj);
                System.out.println("Cuenta joven creada");
            } else {
                System.out.println("Error: el titular debe tener entre 18 y 25 años");
            }
        }
    }
 
    static void menuCliente(Cliente cliente) {
        System.out.println("(pendiente)");
    }
}
