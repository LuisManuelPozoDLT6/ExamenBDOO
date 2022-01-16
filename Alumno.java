package u1_examen_practico_pozo_de_la_torre_luis_manuel_5_b;

public class Alumno {

    private String id;
    private String nombre;
    private String apellido;
    private String teléfono;
    private String edad;
    private String tipoDeSangre;
    private String email;
    private String carrera;
    private String Promedio;

    public Alumno() {
    }

    public Alumno(String id, String nombre, String apellido, String teléfono, String edad, String tipoDeSangre, String email, String carrera, String Promedio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.teléfono = teléfono;
        this.edad = edad;
        this.tipoDeSangre = tipoDeSangre;
        this.email = email;
        this.carrera = carrera;
        this.Promedio = Promedio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    public void setTipoDeSangre(String tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPromedio() {
        return Promedio;
    }

    public void setPromedio(String Promedio) {
        this.Promedio = Promedio;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tel\u00e9fono=" + teléfono + ", edad=" + edad + ", tipoDeSangre=" + tipoDeSangre + ", email=" + email + ", carrera=" + carrera + ", Promedio=" + Promedio + '}';
    }

}
