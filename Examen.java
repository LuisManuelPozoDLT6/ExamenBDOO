package u1_examen_practico_pozo_de_la_torre_luis_manuel_5_b;

import com.db4o.ObjectContainer;
import com.db4o.Db4o;
import com.db4o.ObjectSet;
import java.util.Collections;
import java.util.Scanner;

public class Examen {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        leer.useDelimiter("\n");

        String[] titulos = {"ID", "Nombre", "Apellido", "Teléfono", "Edad", "Tipo de sangre", "Email", "Carrera", "Promedio"};
        String[][] tipoSangre = {{"1", "A+"}, {"2", "B+"}, {"3", "AB+"}, {"4", "O+"}, {"5", "A-"}, {"6", "B-"}, {"7", "AB-"}, {"8", "O-"}};
        int opc, opcSangre = 0, val = 0, opcModificar, fila = 0, col = 0, opCriterio, opcOrden;
        double mayor, menor, totalProm = 0, promGen = 0;
        String id, tel, email;
        Alumno p, q, r;

        String ALUMNOSBD = "C:\\Users\\HP MASTER\\Alumnos.db4o";
        ObjectContainer db = Db4o.openFile(Db4o.newConfiguration(), ALUMNOSBD);

        ObjectSet buscar = db.queryByExample(new Alumno("1", null, null, null, null, null, null, null, null));
        if (!buscar.hasNext()) {
            db.store(new Alumno("1", "María", "Martínez Sánchez", "7358529478", "30", "AB+", "Correo@gmail.com", "DSM", "9.8"));
            db.store(new Alumno("2", "Luis Eduardo", "González Flores", "777123953", "24", "A+", "Correo2@yahoo.com", "IRD", "9"));
            db.store(new Alumno("3", "Camila", "Cárdenas Talamantes", "7729517646", "15", "O-", "Correo3@outlook.com", "IRD", "7"));
            db.store(new Alumno("4", "Noah", "Talamantes Gutiérrez", "7359646601", "22", "B-", "Correo4@utez.edu.mx", "DSM", "8.6"));
            db.store(new Alumno("5", "Gabriela", "Torcazas Díaz", "7774681980", "28", "AB-", "Correo5@gmail.com", "DSM", "6.9"));
        }

        do {
            System.out.println("--- Menú ---");
            System.out.println("1.- Agregar registro");
            System.out.println("2.- Modificar registro");
            System.out.println("3.- Eliminar registro");
            System.out.println("4.- Promedios");
            System.out.println("5.- Alumnos reprobados");
            System.out.println("6.- Mostrar registros");
            System.out.println("7.- Salir");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    Alumno nuevoAlumno = new Alumno();
                    do {
                        System.out.println("ID del alumno");
                        id = leer.next();

                        ObjectSet buscarAlumno = db.queryByExample(new Alumno(id, null, null, null, null, null, null, null, null));
                        if (buscarAlumno.hasNext()) {
                            System.out.println("Ya hay un registro identico registrado");
                            val = 0;
                        } else {
                            val = -1;
                            nuevoAlumno.setId(id);
                        }
                    } while (val != -1);
                    val = 0;
                    System.out.println("Nombre del alumnos");
                    nuevoAlumno.setNombre(leer.next());
                    System.out.println("Apellidos del alumno");
                    nuevoAlumno.setApellido(leer.next());
                    do {
                        System.out.println("Teléfono del alumno");
                        tel = leer.next();

                        ObjectSet buscarAlumno = db.queryByExample(new Alumno(null, null, null, tel, null, null, null, null, null));
                        if (buscarAlumno.hasNext()) {
                            System.out.println("Ya hay un registro identico registrado");
                            val = 0;
                        } else {
                            val = -1;
                            nuevoAlumno.setTeléfono(tel);
                        }
                    } while (val != -1);
                    val = 0;
                    System.out.println("Edad del alumno");
                    nuevoAlumno.setEdad(leer.next());
                    System.out.println("Tipo de sangre del alumno");
                    System.out.println(tipoSangre.length);
                    do {
                        for (int j = 0; j < tipoSangre.length; j++) {
                            System.out.println(tipoSangre[j][0] + "- " + tipoSangre[j][1]);
                        }
                        opcSangre = leer.nextInt();
                        switch (opcSangre) {
                            case 1:
                                nuevoAlumno.setTipoDeSangre("A+");
                                break;
                            case 2:
                                nuevoAlumno.setTipoDeSangre("B+");
                                break;
                            case 3:
                                nuevoAlumno.setTipoDeSangre("AB+");
                                break;
                            case 4:
                                nuevoAlumno.setTipoDeSangre("O+");
                                break;
                            case 5:
                                nuevoAlumno.setTipoDeSangre("A-");
                                break;
                            case 6:
                                nuevoAlumno.setTipoDeSangre("B-");
                                break;
                            case 7:
                                nuevoAlumno.setTipoDeSangre("AB-");
                                break;
                            case 8:
                                nuevoAlumno.setTipoDeSangre("O-");
                                break;
                            default:
                                System.out.println("Tipo de sangre inválida");
                                opcSangre = -1;
                                break;
                        }
                    } while (opcSangre == -1);
                    do {
                        System.out.println("Email del alumno");
                        email = leer.next();

                        ObjectSet buscarAlumno = db.queryByExample(new Alumno(null, null, null, null, null, null, email, null, null));
                        if (buscarAlumno.hasNext()) {
                            System.out.println("Ya hay un registro identico registrado");
                            val = 0;
                        } else {
                            val = -1;
                            nuevoAlumno.setEmail(email);
                        }
                    } while (val != -1);
                    val = 0;
                    System.out.println("Carrera del alumno");
                    nuevoAlumno.setCarrera(leer.next());
                    System.out.println("Promedio del alumno");
                    nuevoAlumno.setPromedio(leer.next());

                    try {
                        db.store(nuevoAlumno);
                    } finally {
                    }
                    break;

                case 2:
                    System.out.println("Ingrese ID de alumno a modificar");
                    id = leer.next();

                    ObjectSet buscarAlumno = db.queryByExample(new Alumno(id, null, null, null, null, null, null, null, null));
                    if (buscarAlumno.hasNext()) {
                        Alumno modificar = (Alumno) buscarAlumno.next();

                        System.out.println("Campo que desea modificar");
                        for (int j = 1; j < titulos.length; j++) {
                            System.out.println(j + " " + titulos[j]);
                        }
                        opcModificar = leer.nextInt();
                        switch (opcModificar) {
                            case 1:
                                System.out.println("Ingresa el nuevo nombre");
                                modificar.setNombre(leer.next());
                                break;
                            case 2:
                                System.out.println("Ingresa el nuevo apellido");
                                modificar.setApellido(leer.next());
                                break;
                            case 3:
                                do {
                                    System.out.println("Ingresa el nuevo teléfono del alumno");
                                    tel = leer.next();
                                    ObjectSet buscarModificar = db.queryByExample(new Alumno(null, null, null, tel, null, null, null, null, null));
                                    if (buscarAlumno.hasNext()) {
                                        System.out.println("Ya hay un registro identico registrado");
                                        val = 0;
                                    } else {
                                        val = -1;
                                        modificar.setTeléfono(tel);
                                    }
                                } while (val != -1);
                                break;
                            case 4:
                                System.out.println("Ingrese la nueva edad del alumno");
                                modificar.setEdad(leer.next());
                                break;
                            case 5:
                                do {
                                    System.out.println("Ingrese el nuevo tipo de sangre");
                                    for (int j = 0; j < tipoSangre.length; j++) {
                                        System.out.println(tipoSangre[j][0] + "- " + tipoSangre[j][1]);
                                    }
                                    opcSangre = leer.nextInt();
                                    switch (opcSangre) {
                                        case 1:
                                            modificar.setTipoDeSangre("A+");
                                            break;
                                        case 2:
                                            modificar.setTipoDeSangre("B+");
                                            break;
                                        case 3:
                                            modificar.setTipoDeSangre("AB+");
                                            break;
                                        case 4:
                                            modificar.setTipoDeSangre("O+");
                                            break;
                                        case 5:
                                            modificar.setTipoDeSangre("A-");
                                            break;
                                        case 6:
                                            modificar.setTipoDeSangre("B-");
                                            break;
                                        case 7:
                                            modificar.setTipoDeSangre("AB-");
                                            break;
                                        case 8:
                                            modificar.setTipoDeSangre("O-");
                                            break;
                                        default:
                                            System.out.println("Tipo de sangre inválida");
                                            opcSangre = -1;
                                            break;
                                    }
                                } while (opcSangre == -1);
                                break;
                            case 6:
                                do {
                                    System.out.println("Ingresa el nuevo email del alumno");
                                    email = leer.next();

                                    ObjectSet buscarModificar = db.queryByExample(new Alumno(null, null, null, null, null, null, email, null, null));
                                    if (buscarModificar.hasNext()) {
                                        System.out.println("Ya hay un registro identico registrado");
                                        val = 0;
                                    } else {
                                        val = -1;
                                        modificar.setEmail(email);
                                    }
                                } while (val != -1);
                                val = 0;
                                break;
                            case 7:
                                System.out.println("Ingresa la nueva carrera del alumno");
                                modificar.setCarrera(leer.next());
                                break;
                            case 8:
                                System.out.println("Ingresa el nuevo promedio del alumno");
                                modificar.setPromedio(leer.next());
                                break;
                            default:
                                System.out.println("Opción inválida!");
                        }

                        db.store(modificar);
                        System.out.println("Registro modificado");
                        System.out.println(modificar);
                    } else {
                        System.out.println("No se ha encontrado al alumno");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el id del alumno a eliminar");
                    id = leer.next();
                    ObjectSet alumnoEliminar = db.queryByExample(new Alumno(id, null, null, null, null, null, null, null, null));
                    if (alumnoEliminar.hasNext()) {
                        Alumno encontrado = (Alumno) alumnoEliminar.next();
                        db.delete(encontrado);
                        System.out.println("Se ha borrado a:");
                        System.out.println(encontrado);
                    } else {
                        System.err.println("No se encontraron Alumnos con el id ingresado");
                    }
                    break;
                case 4:
                    ObjectSet resultados = db.queryByExample(new Alumno(null, null, null, null, null, null, null, null, null));

                    q = (Alumno) resultados.get(0);
                    mayor = Double.parseDouble(q.getPromedio());
                    menor = Double.parseDouble(q.getPromedio());

                    while (resultados.hasNext()) {
                        p = (Alumno) resultados.next();
                        if (Double.parseDouble(p.getPromedio()) > mayor) {
                            mayor = Double.parseDouble(p.getPromedio());
                        } else if (Double.parseDouble(p.getPromedio()) < menor) {
                            menor = Double.parseDouble(p.getPromedio());
                        }
                        totalProm += Double.parseDouble(p.getPromedio());
                        promGen = totalProm / resultados.size();
                    }

                    System.out.println("Promedio más alto: " + mayor);
                    System.out.println("Promedio más bajo: " + menor);
                    System.out.println("Promedio total: " + promGen);

                    break;
                case 5:
                    ObjectSet lista = db.queryByExample(new Alumno(null, null, null, null, null, null, null, null, null));

                    System.out.println("-----Reprobados------");
                    while (lista.hasNext()) {
                        p = (Alumno) lista.next();
                        if (Double.parseDouble(p.getPromedio()) <= 7) {
                            System.out.println(p.getNombre() + " " + p.getApellido() + " alumno reprobado");
                        }
                    }
                    break;
                case 6:
                    ObjectSet res = db.queryByExample(new Alumno(null, null, null, null, null, null, null, null, null));
                    String[][] alumnos = new String[res.size()][9];
                    while (res.hasNext()) {
                        p = (Alumno) res.next();
                        alumnos[fila][0] = p.getId();
                        alumnos[fila][1] = p.getNombre();
                        alumnos[fila][2] = p.getApellido();
                        alumnos[fila][3] = p.getTeléfono();
                        alumnos[fila][4] = p.getEdad();
                        alumnos[fila][5] = p.getTipoDeSangre();
                        alumnos[fila][6] = p.getEmail();
                        alumnos[fila][7] = p.getCarrera();
                        alumnos[fila][8] = p.getPromedio();
                        fila++;
                    }
                    fila = 0;
                    System.out.println("Selecciona el criterio para ordenar los registros");
                    for (int j = 0; j < titulos.length; j++) {
                        System.out.println(j + 1 + " " + titulos[j]);
                    }
                    opCriterio = leer.nextInt();
                    System.out.println("Selecciona la opción deseada para ordenar la tabla");
                    System.out.println("1. Ascendente");
                    System.out.println("2. Descendente");
                    opcOrden = leer.nextInt();
                    switch (opcOrden) {
                        case 1:
                            new Examen().registros(titulos, new Examen().ascendente(opCriterio - 1, alumnos));
                            break;
                        case 2:
                            new Examen().registros(titulos, new Examen().descendente(opCriterio - 1, alumnos));
                            break;
                        default:
                            System.out.println("Opción inválida!");
                    }
                    break;
                case 7:
                    db.close();
                    break;
                default:
                    System.out.println("Opción inválida!");
            }
        } while (opc != 7);
    }

    public String[][] ascendente(int pos, String alumnos[][]) {
        int dif, dif2;
        String auxId, auxNom, auxAp, auxTel, auxEdad, auxSangre, auxEmail, auxCarr, auxProm;
        for (int i = 0; i < alumnos.length - 1; i++) {
            for (int j = 0; j < alumnos.length - 1; j++) {
                dif = alumnos[j][pos].compareToIgnoreCase(alumnos[j + 1][pos]);
                dif2 = alumnos[j + 1][pos].compareToIgnoreCase(alumnos[j][pos]);
                if (dif < dif2) {
                    auxId = alumnos[j][0];
                    alumnos[j][0] = alumnos[j + 1][0];
                    alumnos[j + 1][0] = auxId;
                    auxNom = alumnos[j][1];
                    alumnos[j][1] = alumnos[j + 1][1];
                    alumnos[j + 1][1] = auxNom;
                    auxAp = alumnos[j][2];
                    alumnos[j][2] = alumnos[j + 1][2];
                    alumnos[j + 1][2] = auxAp;
                    auxTel = alumnos[j][3];
                    alumnos[j][3] = alumnos[j + 1][3];
                    alumnos[j + 1][3] = auxTel;
                    auxEdad = alumnos[j][4];
                    alumnos[j][4] = alumnos[j + 1][4];
                    alumnos[j + 1][4] = auxEdad;
                    auxSangre = alumnos[j][5];
                    alumnos[j][5] = alumnos[j + 1][5];
                    alumnos[j + 1][5] = auxSangre;
                    auxEmail = alumnos[j][6];
                    alumnos[j][6] = alumnos[j + 1][6];
                    alumnos[j + 1][6] = auxEmail;
                    auxCarr = alumnos[j][7];
                    alumnos[j][7] = alumnos[j + 1][7];
                    alumnos[j + 1][7] = auxCarr;
                    auxProm = alumnos[j][8];
                    alumnos[j][8] = alumnos[j + 1][8];
                    alumnos[j + 1][8] = auxProm;
                }
            }
        }
        return alumnos;
    }

    public String[][] descendente(int pos, String alumnos[][]) {
        int dif, dif2;
        String auxId, auxNom, auxAp, auxTel, auxEdad, auxSangre, auxEmail, auxCarr, auxProm;
        for (int i = 0; i < alumnos.length - 1; i++) {
            for (int j = 0; j < alumnos.length - 1; j++) {
                dif = alumnos[j][pos].compareToIgnoreCase(alumnos[j + 1][pos]);
                dif2 = alumnos[j + 1][pos].compareToIgnoreCase(alumnos[j][pos]);
                if (dif > dif2) {
                    auxId = alumnos[j][0];
                    alumnos[j][0] = alumnos[j + 1][0];
                    alumnos[j + 1][0] = auxId;
                    auxNom = alumnos[j][1];
                    alumnos[j][1] = alumnos[j + 1][1];
                    alumnos[j + 1][1] = auxNom;
                    auxAp = alumnos[j][2];
                    alumnos[j][2] = alumnos[j + 1][2];
                    alumnos[j + 1][2] = auxAp;
                    auxTel = alumnos[j][3];
                    alumnos[j][3] = alumnos[j + 1][3];
                    alumnos[j + 1][3] = auxTel;
                    auxEdad = alumnos[j][4];
                    alumnos[j][4] = alumnos[j + 1][4];
                    alumnos[j + 1][4] = auxEdad;
                    auxSangre = alumnos[j][5];
                    alumnos[j][5] = alumnos[j + 1][5];
                    alumnos[j + 1][5] = auxSangre;
                    auxEmail = alumnos[j][6];
                    alumnos[j][6] = alumnos[j + 1][6];
                    alumnos[j + 1][6] = auxEmail;
                    auxCarr = alumnos[j][7];
                    alumnos[j][7] = alumnos[j + 1][7];
                    alumnos[j + 1][7] = auxCarr;
                    auxProm = alumnos[j][8];
                    alumnos[j][8] = alumnos[j + 1][8];
                    alumnos[j + 1][8] = auxProm;
                }
            }
        }
        return alumnos;
    }

    public void registros(String titulos[], String alumnos[][]) {
        for (int i = 0; i < titulos.length; i++) {
            System.out.print(titulos[i] + " ");
        }
        System.out.println("");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < alumnos.length; i++) {
            for (int j = 0; j < alumnos[0].length; j++) {
                System.out.print(alumnos[i][j] + "| ");
            }
            System.out.println("");
            System.out.println("------------------------------------------------");
        }
    }

}
