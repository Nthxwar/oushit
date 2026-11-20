package modulo1;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionAdoptante {

    private ArrayList<Adoptante> adoptantes = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Buscar adoptante por cédula
    private Adoptante buscarAdoptante(String cedula) {

        for (Adoptante a : adoptantes) {

            if (a.getCedula().equals(cedula)) {
                return a;
            }
        }

        return null;
    }

    // Validar cédula de 10 dígitos
    private boolean validarCedula(String cedula) {
        return cedula.matches("[0-9]{10}");
    }

    // Validar cédula única
    private boolean validarCedulaUnica(String cedula, Adoptante actual) {

        Adoptante encontrado = buscarAdoptante(cedula);

        return encontrado == null || encontrado == actual;
    }

    // Validar teléfono de 10 dígitos
    private boolean validarTelefono(String telefono) {
        return telefono.matches("[0-9]{10}");
    }

    // Validar nombre completo
    private boolean validarNombre(String nombre) {
        return nombre.trim().matches(".*\\s+.*");
    }

    // Validar contraseña
    private boolean validarContrasena(String contrasena) {
        return !contrasena.trim().isEmpty();
    }

    // Validar tipo de vivienda
    private boolean validarTipoVivienda(String tipo) {

        return tipo.equalsIgnoreCase("Casa")
                || tipo.equalsIgnoreCase("Departamento");
    }

    // Leer texto obligatorio
    private String leerTextoObligatorio(String mensaje) {

        String valor;

        do {
            System.out.print(mensaje);
            valor = sc.nextLine().trim();

            if (valor.isEmpty()) {
                System.out.println("Error: Los campos obligatorios deben estar completos");
            }

        } while (valor.isEmpty());

        return valor;
    }

    // Leer cédula
    private String leerCedula() {

        String cedula;

        do {
            cedula = leerTextoObligatorio("Ingrese la cédula: ");

            if (!validarCedula(cedula)) {
                System.out.println("Error: La cédula debe contener exactamente 10 dígitos");
            }

        } while (!validarCedula(cedula));

        return cedula;
    }

    // Leer teléfono
    private String leerTelefono() {

        String telefono;

        do {
            telefono = leerTextoObligatorio("Ingrese el teléfono: ");

            if (!validarTelefono(telefono)) {
                System.out.println("Error: El teléfono debe contener exactamente 10 dígitos");
            }

        } while (!validarTelefono(telefono));

        return telefono;
    }

    // Leer nombre completo
    private String leerNombre() {

        String nombre;

        do {
            nombre = leerTextoObligatorio("Ingrese nombres y apellidos: ");

            if (!validarNombre(nombre)) {
                System.out.println("Error: Debe ingresar el nombre completo");
            }

        } while (!validarNombre(nombre));

        return nombre;
    }

    // Leer contraseña
    private String leerContrasena() {

        String contrasena;

        do {
            contrasena = leerTextoObligatorio("Ingrese la contraseña: ");

            if (!validarContrasena(contrasena)) {
                System.out.println("Error: Debe ingresar una contraseña");
            }

        } while (!validarContrasena(contrasena));

        return contrasena;
    }

    // Leer número decimal mayor que cero
    private double leerPositivo(String mensaje, String error) {

        double numero;

        System.out.print(mensaje);
        numero = Double.parseDouble(sc.nextLine());

        while (numero <= 0) {

            System.out.println(error);
            System.out.print(mensaje);
            numero = Double.parseDouble(sc.nextLine());
        }

        return numero;
    }

    // Leer horas fuera de casa
    private double leerHorasFuera() {

        double horas;

        System.out.print("Horas diarias fuera de casa: ");
        horas = Double.parseDouble(sc.nextLine());

        while (horas <= 0 || horas > 24) {

            System.out.println("Error: Las horas fuera de casa deben estar entre 0 y 24");
            System.out.print("Ingrese nuevamente las horas: ");
            horas = Double.parseDouble(sc.nextLine());
        }

        return horas;
    }

    // Leer número de hijos
    private int leerNumeroHijos() {

        int hijos;

        System.out.print("Número de hijos menores de 15 años: ");
        hijos = Integer.parseInt(sc.nextLine());

        while (hijos < 0) {

            System.out.println("Error: Ingrese una cantidad válida de hijos menores de 15 años");
            System.out.print("Ingrese nuevamente la cantidad: ");
            hijos = Integer.parseInt(sc.nextLine());
        }

        return hijos;
    }

    // Leer experiencia previa
    private boolean leerExperiencia() {

        String respuesta;

        System.out.print("¿Tiene experiencia previa con mascotas? (Sí/No): ");
        respuesta = sc.nextLine();

        while (!respuesta.equalsIgnoreCase("Si")
                && !respuesta.equalsIgnoreCase("Sí")
                && !respuesta.equalsIgnoreCase("No")) {

            System.out.println("Error: La respuesta debe ser Sí o No");
            System.out.print("Ingrese nuevamente (Sí/No): ");
            respuesta = sc.nextLine();
        }

        return respuesta.equalsIgnoreCase("Si")
                || respuesta.equalsIgnoreCase("Sí");
    }

    // Leer tipo de vivienda
    private String leerTipoVivienda() {

        String tipo;

        System.out.print("Tipo de vivienda (Casa/Departamento): ");
        tipo = sc.nextLine();

        while (!validarTipoVivienda(tipo)) {

            System.out.println("Error: El tipo de vivienda seleccionado no es válido");
            System.out.print("Ingrese Casa o Departamento: ");
            tipo = sc.nextLine();
        }

        return tipo;
    }

    // A1: Registrar adoptante
    public void registrarAdoptante() {

        System.out.println("\n--- REGISTRAR ADOPTANTE ---");

        String cedula = leerCedula();

        if (buscarAdoptante(cedula) != null) {
            System.out.println("Error: La cédula ingresada ya se encuentra registrada");
            return;
        }

        String nombre = leerNombre();
        String telefono = leerTelefono();
        String contrasena = leerContrasena();
        String vivienda = leerTipoVivienda();

        double interior = leerPositivo(
                "Espacio interior disponible (m2): ",
                "Error: El espacio disponible debe ser mayor a cero"
        );

        double exterior = leerPositivo(
                "Espacio exterior disponible (m2): ",
                "Error: El espacio disponible debe ser mayor a cero"
        );

        double horas = leerHorasFuera();

        boolean experiencia = leerExperiencia();

        String tipoMascota = "No aplica";

        if (experiencia) {
            tipoMascota = leerTextoObligatorio("Tipo de mascota anterior: ");
        }

        double presupuesto = leerPositivo(
                "Presupuesto estimado: ",
                "Error: El presupuesto debe ser mayor a cero"
        );

        int hijos = leerNumeroHijos();

        Adoptante nuevo = new Adoptante(
                cedula, nombre, telefono, contrasena, vivienda,
                interior, exterior, horas, experiencia,
                tipoMascota, presupuesto, hijos
        );

        adoptantes.add(nuevo);

        System.out.println("Registro exitoso. El perfil del adoptante ha sido creado correctamente");
    }

    // A2: Consultar adoptante
    public void consultarAdoptante() {

        System.out.println("\n--- CONSULTAR ADOPTANTE ---");

        String cedula = leerCedula();

        Adoptante adoptante = buscarAdoptante(cedula);

        if (adoptante == null) {
            System.out.println("Error: El adoptante no se encuentra registrado en el sistema.");
        } else {
            adoptante.mostrarInformacion();
        }
    }

    // A2: Actualizar adoptante
    public void actualizarAdoptante() {

        System.out.println("\n--- ACTUALIZAR PERFIL ---");

        String cedulaActual = leerCedula();

        Adoptante adoptante = buscarAdoptante(cedulaActual);

        if (adoptante == null) {
            System.out.println("Error: El adoptante no se encuentra registrado en el sistema.");
            return;
        }

        System.out.println("Ingrese los nuevos datos:");

        String nuevaCedula = leerCedula();

        if (!validarCedulaUnica(nuevaCedula, adoptante)) {
            System.out.println("Error: La cédula ingresada no es válida o ya se encuentra registrada.");
            return;
        }

        String nombre = leerNombre();
        String telefono = leerTelefono();
        String contrasena = leerContrasena();
        String vivienda = leerTipoVivienda();

        double interior = leerPositivo(
                "Nuevo espacio interior (m2): ",
                "Error: El espacio disponible debe ser mayor a cero"
        );

        double exterior = leerPositivo(
                "Nuevo espacio exterior (m2): ",
                "Error: El espacio disponible debe ser mayor a cero"
        );

        double horas = leerHorasFuera();
        boolean experiencia = leerExperiencia();

        String tipoMascota = "No aplica";

        if (experiencia) {
            tipoMascota = leerTextoObligatorio("Tipo de mascota anterior: ");
        }

        double presupuesto = leerPositivo(
                "Nuevo presupuesto: ",
                "Error: El presupuesto debe ser mayor a cero"
        );

        int hijos = leerNumeroHijos();

        // Guardar los cambios
        adoptante.setCedula(nuevaCedula);
        adoptante.setNombreCompleto(nombre);
        adoptante.setTelefono(telefono);
        adoptante.setContrasena(contrasena);
        adoptante.setTipoVivienda(vivienda);
        adoptante.setEspacioInterior(interior);
        adoptante.setEspacioExterior(exterior);
        adoptante.setHorasFueraCasa(horas);
        adoptante.setExperienciaMascotas(experiencia);
        adoptante.setTipoMascotaAnterior(tipoMascota);
        adoptante.setPresupuesto(presupuesto);
        adoptante.setNumeroHijos(hijos);

        System.out.println("Operación exitosa. La información del adoptante se ha actualizado correctamente.");
    }

    // A3: Eliminar perfil (eliminación lógica)
    public void eliminarAdoptante() {

        System.out.println("\n--- ELIMINAR PERFIL ---");

        String cedula = leerCedula();

        Adoptante adoptante = buscarAdoptante(cedula);

        if (adoptante == null) {
            System.out.println("Error: El adoptante no se encuentra registrado en el sistema.");
            return;
        }

        System.out.print("¿Está seguro de eliminar su perfil? (Sí/No): ");
        String confirmacion = sc.nextLine();

        if (confirmacion.equalsIgnoreCase("Si")
                || confirmacion.equalsIgnoreCase("Sí")) {

            adoptante.setEstadoPerfil("Inactivo");

            System.out.println("Operación exitosa. El perfil del adoptante ha sido desactivado correctamente.");

        } else if (confirmacion.equalsIgnoreCase("No")) {

            System.out.println("Operación cancelada. No se realizaron cambios.");

        } else {

            System.out.println("Error: Debe confirmar o cancelar la eliminación.");
        }
    }

    // A4: Iniciar sesión
    public void iniciarSesion() {

        System.out.println("\n--- INICIO DE SESIÓN ---");

        System.out.print("Ingrese su cédula: ");
        String cedula = sc.nextLine();

        Adoptante adoptante = buscarAdoptante(cedula);

        if (adoptante == null) {
            System.out.println("No estás registrado. Por favor, regístrate.");
            return;
        }

        System.out.print("Ingrese su contraseña: ");
        String contrasena = sc.nextLine();

        if (cedula.trim().isEmpty() || contrasena.trim().isEmpty()) {
            System.out.println("Error: Todos los campos son obligatorios.");
            return;
        }

        if (!adoptante.getContrasena().equals(contrasena)) {
            System.out.println("Error: La contraseña ingresada es incorrecta.");
            return;
        }

        if (!adoptante.getEstadoPerfil().equalsIgnoreCase("Activo")) {
            System.out.println("Error: Tu perfil se encuentra inactivo. No puedes ingresar al sistema.");
            return;
        }

        System.out.println("Inicio de sesión exitoso. Bienvenido al sistema.");
    }

    // Menú principal
    public void mostrarMenu() {

        int opcion = 0;

        while (opcion != 6) {

            System.out.println("\n========== GESTIÓN DE ADOPTANTES ==========");
            System.out.println("1. Registrar adoptante");
            System.out.println("2. Consultar adoptante");
            System.out.println("3. Actualizar perfil");
            System.out.println("4. Eliminar perfil");
            System.out.println("5. Iniciar sesión");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                registrarAdoptante();
            } else if (opcion == 2) {
                consultarAdoptante();
            } else if (opcion == 3) {
                actualizarAdoptante();
            } else if (opcion == 4) {
                eliminarAdoptante();
            } else if (opcion == 5) {
                iniciarSesion();
            } else if (opcion == 6) {
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}
