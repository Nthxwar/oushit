package modulo1;

public class Adoptante {

    // Atributos
    private String cedula;
    private String nombreCompleto;
    private String telefono;
    private String contrasena;
    private String tipoVivienda;
    private double espacioInterior;
    private double espacioExterior;
    private double horasFueraCasa;
    private boolean experienciaMascotas;
    private String tipoMascotaAnterior;
    private double presupuesto;
    private int numeroHijos;
    private String estadoPerfil;

    // Constructor
    public Adoptante(String cedula, String nombreCompleto, String telefono,
                     String contrasena, String tipoVivienda,
                     double espacioInterior, double espacioExterior,
                     double horasFueraCasa, boolean experienciaMascotas,
                     String tipoMascotaAnterior, double presupuesto,
                     int numeroHijos) {

        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.tipoVivienda = tipoVivienda;
        this.espacioInterior = espacioInterior;
        this.espacioExterior = espacioExterior;
        this.horasFueraCasa = horasFueraCasa;
        this.experienciaMascotas = experienciaMascotas;
        this.tipoMascotaAnterior = tipoMascotaAnterior;
        this.presupuesto = presupuesto;
        this.numeroHijos = numeroHijos;
        this.estadoPerfil = "Activo";
    }

    // Getters
    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public double getEspacioInterior() {
        return espacioInterior;
    }

    public double getEspacioExterior() {
        return espacioExterior;
    }

    public double getHorasFueraCasa() {
        return horasFueraCasa;
    }

    public boolean isExperienciaMascotas() {
        return experienciaMascotas;
    }

    public String getTipoMascotaAnterior() {
        return tipoMascotaAnterior;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public int getNumeroHijos() {
        return numeroHijos;
    }

    public String getEstadoPerfil() {
        return estadoPerfil;
    }

    // Setters
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public void setEspacioInterior(double espacioInterior) {
        this.espacioInterior = espacioInterior;
    }

    public void setEspacioExterior(double espacioExterior) {
        this.espacioExterior = espacioExterior;
    }

    public void setHorasFueraCasa(double horasFueraCasa) {
        this.horasFueraCasa = horasFueraCasa;
    }

    public void setExperienciaMascotas(boolean experienciaMascotas) {
        this.experienciaMascotas = experienciaMascotas;
    }

    public void setTipoMascotaAnterior(String tipoMascotaAnterior) {
        this.tipoMascotaAnterior = tipoMascotaAnterior;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setNumeroHijos(int numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public void setEstadoPerfil(String estadoPerfil) {
        this.estadoPerfil = estadoPerfil;
    }

    // Método para mostrar información//
    public void mostrarInformacion() {

        System.out.println("\n--- PERFIL DEL ADOPTANTE ---");
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Tipo de vivienda: " + tipoVivienda);
        System.out.println("Espacio interior: " + espacioInterior + " m2");
        System.out.println("Espacio exterior: " + espacioExterior + " m2");
        System.out.println("Horas fuera de casa: " + horasFueraCasa);
        System.out.println("Experiencia con mascotas: " + (experienciaMascotas ? "Sí" : "No"));
        System.out.println("Mascota anterior: " + tipoMascotaAnterior);
        System.out.println("Presupuesto: " + presupuesto);
        System.out.println("Hijos menores de 15 años: " + numeroHijos);
        System.out.println("Estado del perfil: " + estadoPerfil);
    }
}