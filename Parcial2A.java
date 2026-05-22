import java.util.Scanner;

public class Parcial2A {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cantEspacios;
        int cantVehiculos;

        int carrosAsignados = 0;
        int motosAsignadas = 0;
        int vehiculosSinEspacio = 0;
        int espaciosDisponibles = 0;

        System.out.println("Ingrese cantidad de espacios:");
        cantEspacios = scanner.nextInt();

        int[] numeroEspacio = new int[cantEspacios];
        String[] tipoEspacio = new String[cantEspacios];
        String[] estadoEspacio = new String[cantEspacios];

        for (int i = 0; i < cantEspacios; i++) {

            System.out.println("\nEspacio #" + (i + 1));

            System.out.println("Numero del espacio:");
            numeroEspacio[i] = scanner.nextInt();

            System.out.println("Tipo permitido (carro/moto):");
            tipoEspacio[i] = scanner.next();

            System.out.println("Estado inicial (disponible/ocupado):");
            estadoEspacio[i] = scanner.next();
        }

        System.out.println("\nCantidad de vehiculos que desean ingresar:");
        cantVehiculos = scanner.nextInt();

        for (int i = 0; i < cantVehiculos; i++) {

            scanner.nextLine();

            String placaVehiculo;
            String tipoVehiculo;
            String propietarioVehiculo;

            boolean espacioEncontrado = false;

            System.out.println("\nVehiculo #" + (i + 1));

            System.out.println("Ingrese placa:");
            placaVehiculo = scanner.nextLine();

            System.out.println("Ingrese tipo de vehiculo (carro/moto):");
            tipoVehiculo = scanner.nextLine();

            System.out.println("Ingrese nombre del propietario:");
            propietarioVehiculo = scanner.nextLine();

            System.out.println("Placa: " + placaVehiculo);
            System.out.println("Tipo: " + tipoVehiculo);
            System.out.println("Propietario: " + propietarioVehiculo);

            for (int j = 0; j < cantEspacios; j++) {

                if (tipoVehiculo.equals(tipoEspacio[j]) &&
                        estadoEspacio[j].equals("disponible")) {

                    estadoEspacio[j] = "ocupado";

                    System.out.println("Vehiculo asignado al espacio: " + numeroEspacio[j]);

                    espacioEncontrado = true;

                    if (tipoVehiculo.equals("carro")) {
                        carrosAsignados++;
                    } else {
                        motosAsignadas++;
                    }

                    break;
                }
            }

            if (!espacioEncontrado) {
                System.out.println("No existe espacio disponible para este vehiculo");
                vehiculosSinEspacio++;
            }
        }

        System.out.println("\n----- ESTADO FINAL DEL PARQUEADERO -----");

        for (int i = 0; i < cantEspacios; i++) {

            System.out.println("Espacio: " + numeroEspacio[i] + " | Tipo: " + tipoEspacio[i]
                    + " | Estado: " + estadoEspacio[i]);

            if (estadoEspacio[i].equals("disponible")) {
                espaciosDisponibles++;
            }
        }

        System.out.println("\nEspacios disponibles: " + espaciosDisponibles);

        System.out.println("Carros asignados correctamente: " + carrosAsignados);

        System.out.println("Motos asignadas correctamente: " + motosAsignadas);

        System.out.println("Vehiculos que no pudieron ingresar: " + vehiculosSinEspacio);

        scanner.close();
    }
}
