package proyecto.mercadeo;

import dao.Conexion;
import java.util.Scanner;
import modelo.AdminActivosBD;
import modelo.AdminCampanasBD;
import modelo.AdminCategoriasBD;
import modelo.AdminPenalizacionPrestamosBD;
import modelo.AdminPersonasBD;
import modelo.AdminPrestamosActivoPersonasBD;
import modelo.AdminReservasActivosClientesBD;
import modelo.AdminRolBD;
import modelo.activos;
import modelo.campanas;
import modelo.categorias;
import modelo.penalizacionprestamos;
import modelo.personas;
import modelo.prestamosactivopersonas;
import modelo.reservasactivosclientes;
import modelo.rol;
import modelo.RelacionesBD;
import modelo.reporteactivoscategorias;
import modelo.reporteactivosprestados;
import modelo.reportepenalizacioncliente;

public class Main {
    
    

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vista.FrmMain objetoMain = new vista.FrmMain();
                objetoMain.setLocationRelativeTo(null);
                objetoMain.setVisible(true);
            }
        });
        Conexion.abrirConexion();
        AdminRolBD objAdmRolDB = new AdminRolBD();
        AdminActivosBD objAdmActBD = new AdminActivosBD();
        Scanner leerOpcion = new Scanner(System.in);
        Scanner leerNumero = new Scanner(System.in);
        Scanner leerTexto = new Scanner(System.in);
        int opcionPrincipal = 0, opcionRol = 0, opcionActivos = 0;
        int id = 0;
        String NombreRol = "", nombre = "", tipo = "", marca = "", modelo = "", ano_adquisicion = "", estado = "";
        double valor_comercial = 0;
        int CATEGORIAS_id = 0;
        boolean salirPrincipal = false, salirRol = false, salirActivo = false;
        AdminPersonasBD objAdmPerBD = new AdminPersonasBD();
        int opcionPersonas = 0;
        String tipo_documento = "", numero_documento = "", razon_social = "", telefono = "", email = "", direccion = "", nombrePersona = "";
        int ROL_id = 0;
        boolean salirPersona = false;
        AdminCampanasBD objAdmCamBD = new AdminCampanasBD();
        int opcionCampanas = 0;
        String descripcion = "", fecha_inicio = "", fecha_fin = "", estadoCampana = "", nombreCampana = "";
        int PERSONAS_id = 0;
        boolean salirCampana = false;
        AdminCategoriasBD objAdmCatBD = new AdminCategoriasBD();
        int opcionCategorias = 0, dias_prestamo = 0;
        double porcentaje_penalizacion = 0;
        String nombreCategoria = "";
        boolean salirCategoria = false;
        AdminPenalizacionPrestamosBD objAdmPenaliBD = new AdminPenalizacionPrestamosBD();
        int opcionPenali = 0, dias_retraso = 0, PRESTAMOS_ACTIVO_PERSONA_id = 0, pagada = 0;
        double valor_penali = 0;
        String fecha_generacion = "";
        boolean salirPenali = false;
        AdminPrestamosActivoPersonasBD objAdmPrestaBD = new AdminPrestamosActivoPersonasBD();
        int opcionPrestamo = 0, ACTIVOS_id = 0;
        String fecha_fin_programa = "", fecha_entrega_real = "", estadoPrestamo = "";
        boolean salirPrestamo = false;
        AdminReservasActivosClientesBD objAdmReservaBD = new AdminReservasActivosClientesBD();
        int opcionReserva = 0;
        String fecha_reserva = "", estadoReserva = "";
        boolean salirReserva = false;
        RelacionesBD objRelDB = new RelacionesBD();
        int opcionReportes = 0;
        String numeroDocumento = "";
        boolean salirReportes = false;

        while (!salirPrincipal) {
            System.out.println("\nMENU PRINCIPAL\n");
            System.out.println("1. Administrar tabla ROL");
            System.out.println("2. Administrar tabla ACTIVOS");
            System.out.println("3. Administrar tabla CAMPAÑAS");
            System.out.println("4. Administrar tabla CATEGORIAS");
            System.out.println("5. Administrar tabla PENALIZACIÓN DE PERSONA POR ACTIVO");
            System.out.println("6. Administrar tabla PERSONAS");
            System.out.println("7. Administrar tabla PRESTAMO DE ACTIVOS POR PERSONA");
            System.out.println("8. Administrar tabla RESERVAS DE ACTIVOS POR CLIENTE");
            System.out.println("9. Consultar Reportes");
            System.out.println("10. Salir");
            System.out.print("\nDigite opción: ");

            opcionPrincipal = leerOpcion.nextInt();
            switch (opcionPrincipal) {
                case 1://1. Administrar tabla rol
                    while (!salirRol) {
                        System.out.println("\nMENU TABLA ROL\n");
                        System.out.println("1. Listar todo");
                        System.out.println("2. Listar Uno");
                        System.out.println("3. Insertar");
                        System.out.println("4. Actualizar");
                        System.out.println("5. Eliminar");
                        System.out.println("6. Salir");
                        System.out.print("\nDigite opción: ");

                        opcionRol = leerOpcion.nextInt();

                        switch (opcionRol) {
                            case 1 -> {
                                //1. Listar todo
                                for (Object obj : objAdmRolDB.listarTodo()) {
                                    System.out.println(obj);
                                }
                            }
                            case 2 -> {
                                //2. Listar Uno
                                rol objRolLU = new rol();

                                System.out.print("Ingrese ID del rol: ");
                                id = leerNumero.nextInt();
                                objRolLU.setId(id);

                                objRolLU = (rol) objAdmRolDB.listarUno(objRolLU);

                                System.out.println("");//Salto de linea
                                System.out.println(objRolLU);
                            }
                            case 3 -> {
                                //3. Insertar
                                rol objRolInst = new rol();
                                System.out.print("\nIngrese nombre de Rol: ");
                                NombreRol = leerTexto.nextLine();

                                objRolInst.setRol(NombreRol);

                                objAdmRolDB.insertar(objRolInst);
                            }
                            case 4 -> {
                                //4. Actualizar
                                rol objRolLUACT = new rol();

                                System.out.print("Ingrese ID del rol: ");
                                id = leerNumero.nextInt();
                                objRolLUACT.setId(id);

                                objRolLUACT = (rol) objAdmRolDB.listarUno(objRolLUACT);
                                System.out.println("");//Salto de linea
                                System.out.println(objRolLUACT);

                                //Actualizar
                                System.out.print("\nIngrese nuevo nombre del Rol: ");
                                NombreRol = leerTexto.nextLine();
                                objRolLUACT.setRol(NombreRol);

                                objAdmRolDB.actualizar(objRolLUACT);
                            }
                            case 5 -> {
                                //5. Eliminar
                                rol objRolElim = new rol();
                                System.out.print("Ingrese ID del rol: ");
                                id = leerNumero.nextInt();
                                objRolElim.setId(id);

                                objAdmRolDB.eliminar(objRolElim);
                            }
                            case 6 -> //6. Salir
                                salirRol = true;
                            default ->
                                System.out.println("\n!!! La opción no existe !!!\n");
                        }
                    }
                    break;

                case 2://2. Administrar tabla activos
                    while (!salirActivo) {
                        System.out.println("\nMENU TABLA ACTIVOS\n");
                        System.out.println("1. Listar todo");
                        System.out.println("2. Listar Uno");
                        System.out.println("3. Insertar");
                        System.out.println("4. Actualizar");
                        System.out.println("5. Eliminar");
                        System.out.println("6. Salir");
                        System.out.print("\nDigite opción: ");

                        opcionActivos = leerOpcion.nextInt();

                        switch (opcionActivos) {
                            case 1 -> {
                                //1. Listar todo
                                for (Object obj : objAdmActBD.listarTodo()) {
                                    System.out.println(obj);
                                }
                            }
                            case 2 -> {
                                //2. Listar Uno
                                activos objActivoLU = new activos();

                                System.out.print("Ingrese ID del activo: ");
                                id = leerNumero.nextInt();
                                objActivoLU.setId(id);

                                objActivoLU = (activos) objAdmActBD.listarUno(objActivoLU);

                                System.out.println("");//Salto de linea
                                System.out.println(objActivoLU);
                            }
                            case 3 -> {
                                //3. Insertar
                                activos objActivoInst = new activos();

                                System.out.print("\nIngrese Nombre: ");
                                nombre = leerTexto.nextLine();
                                objActivoInst.setNombre(nombre);

                                System.out.print("Ingrese Tipo: ");
                                tipo = leerTexto.nextLine();
                                objActivoInst.setTipo(tipo);

                                System.out.print("Ingrese Marca: ");
                                marca = leerTexto.nextLine();
                                objActivoInst.setMarca(marca);

                                System.out.print("Ingrese Modelo: ");
                                modelo = leerTexto.nextLine();
                                objActivoInst.setModelo(modelo);

                                System.out.print("Ingrese Año de Adquisicion (YYYY-MM-DD): ");
                                ano_adquisicion = leerTexto.nextLine();
                                objActivoInst.setAno_adquisicion(ano_adquisicion);

                                System.out.print("Ingrese Valor Comercial: ");
                                valor_comercial = leerNumero.nextDouble();
                                objActivoInst.setValor_comercial(valor_comercial);

                                System.out.print("Ingrese Estado (DISPONIBLE/RESERVADO/PRESTADO): ");
                                estado = leerTexto.nextLine();
                                objActivoInst.setEstado(estado);

                                System.out.print("Ingrese ID de Categoria: ");
                                CATEGORIAS_id = leerNumero.nextInt();
                                objActivoInst.setCATEGORIAS_id(CATEGORIAS_id);

                                objAdmActBD.insertar(objActivoInst);
                            }
                            case 4 -> {
                                //4. Actualizar
                                activos objActivoLUACT = new activos();

                                System.out.print("Ingrese ID del activo: ");
                                id = leerNumero.nextInt();
                                objActivoLUACT.setId(id);

                                objActivoLUACT = (activos) objAdmActBD.listarUno(objActivoLUACT);
                                System.out.println("");//Salto de linea
                                System.out.println(objActivoLUACT);

                                //Actualizar
                                System.out.print("\nIngrese Nuevo Nombre: ");
                                nombre = leerTexto.nextLine();
                                objActivoLUACT.setNombre(nombre);

                                System.out.print("Ingrese Nuevo Tipo: ");
                                tipo = leerTexto.nextLine();
                                objActivoLUACT.setTipo(tipo);

                                System.out.print("Ingrese Nueva Marca: ");
                                marca = leerTexto.nextLine();
                                objActivoLUACT.setMarca(marca);

                                System.out.print("Ingrese Nuevo Modelo: ");
                                modelo = leerTexto.nextLine();
                                objActivoLUACT.setModelo(modelo);

                                System.out.print("Ingrese Nuevo Año de Adquisicion (YYYY-MM-DD): ");
                                ano_adquisicion = leerTexto.nextLine();
                                objActivoLUACT.setAno_adquisicion(ano_adquisicion);

                                System.out.print("Ingrese Nuevo Valor Comercial: ");
                                valor_comercial = leerNumero.nextDouble();
                                objActivoLUACT.setValor_comercial(valor_comercial);

                                System.out.print("Ingrese Nuevo Estado (DISPONIBLE/RESERVADO/PRESTADO): ");
                                estado = leerTexto.nextLine();
                                objActivoLUACT.setEstado(estado);

                                System.out.print("Ingrese Nuevo ID de Categoria: ");
                                CATEGORIAS_id = leerNumero.nextInt();
                                objActivoLUACT.setCATEGORIAS_id(CATEGORIAS_id);

                                objAdmActBD.actualizar(objActivoLUACT);
                            }
                            case 5 -> {
                                //5. Eliminar
                                activos objActivoElim = new activos();

                                System.out.print("Ingrese ID del activo: ");
                                id = leerNumero.nextInt();
                                objActivoElim.setId(id);

                                objAdmActBD.eliminar(objActivoElim);
                            }
                            case 6 -> //6. Salir
                                salirActivo = true;
                            default ->
                                System.out.println("\n!!! La opción no existe !!!\n");
                        }
                    }
                    break;
                case 3://3. Administrar tabla campanas
                    while (!salirCampana) {
                        System.out.println("\nMENU TABLA CAMPAÑAS\n");
                        System.out.println("1. Listar todo");
                        System.out.println("2. Listar Uno");
                        System.out.println("3. Insertar");
                        System.out.println("4. Actualizar");
                        System.out.println("5. Eliminar");
                        System.out.println("6. Salir");
                        System.out.print("\nDigite opción: ");

                        opcionCampanas = leerOpcion.nextInt();

                        switch (opcionCampanas) {
                            case 1 -> {
                                //1. Listar todo
                                for (Object obj : objAdmCamBD.listarTodo()) {
                                    System.out.println(obj);
                                }
                            }
                            case 2 -> {
                                //2. Listar Uno
                                campanas objCampanaLU = new campanas();

                                System.out.print("Ingrese ID de la campaña: ");
                                id = leerNumero.nextInt();
                                objCampanaLU.setId(id);

                                objCampanaLU = (campanas) objAdmCamBD.listarUno(objCampanaLU);

                                System.out.println("");//Salto de linea
                                System.out.println(objCampanaLU);
                            }
                            case 3 -> {
                                //3. Insertar
                                campanas objCampanaInst = new campanas();

                                System.out.print("\nIngrese Nombre: ");
                                nombreCampana = leerTexto.nextLine();
                                objCampanaInst.setNombre(nombreCampana);

                                System.out.print("Ingrese Descripcion: ");
                                descripcion = leerTexto.nextLine();
                                objCampanaInst.setDescripcion(descripcion);

                                System.out.print("Ingrese Fecha Inicio (YYYY-MM-DD): ");
                                fecha_inicio = leerTexto.nextLine();
                                objCampanaInst.setFecha_inicio(fecha_inicio);

                                System.out.print("Ingrese Fecha Fin (YYYY-MM-DD): ");
                                fecha_fin = leerTexto.nextLine();
                                objCampanaInst.setFecha_fin(fecha_fin);

                                System.out.print("Ingrese Estado (PLANIFICADA/EN_EJECUCION/FINALIZADA): ");
                                estadoCampana = leerTexto.nextLine();
                                objCampanaInst.setEstado(estadoCampana);

                                System.out.print("Ingrese ID de Persona: ");
                                PERSONAS_id = leerNumero.nextInt();
                                objCampanaInst.setPERSONAS_id(PERSONAS_id);

                                objAdmCamBD.insertar(objCampanaInst);
                            }
                            case 4 -> {
                                //4. Actualizar
                                campanas objCampanaLUACT = new campanas();

                                System.out.print("Ingrese ID de la campaña: ");
                                id = leerNumero.nextInt();
                                objCampanaLUACT.setId(id);

                                objCampanaLUACT = (campanas) objAdmCamBD.listarUno(objCampanaLUACT);
                                System.out.println("");//Salto de linea
                                System.out.println(objCampanaLUACT);

                                //Actualizar
                                System.out.print("\nIngrese Nuevo Nombre: ");
                                nombreCampana = leerTexto.nextLine();
                                objCampanaLUACT.setNombre(nombreCampana);

                                System.out.print("Ingrese Nueva Descripcion: ");
                                descripcion = leerTexto.nextLine();
                                objCampanaLUACT.setDescripcion(descripcion);

                                System.out.print("Ingrese Nueva Fecha Inicio (YYYY-MM-DD): ");
                                fecha_inicio = leerTexto.nextLine();
                                objCampanaLUACT.setFecha_inicio(fecha_inicio);

                                System.out.print("Ingrese Nueva Fecha Fin (YYYY-MM-DD): ");
                                fecha_fin = leerTexto.nextLine();
                                objCampanaLUACT.setFecha_fin(fecha_fin);

                                System.out.print("Ingrese Nuevo Estado (PLANIFICADA/EN_EJECUCION/FINALIZADA): ");
                                estadoCampana = leerTexto.nextLine();
                                objCampanaLUACT.setEstado(estadoCampana);

                                System.out.print("Ingrese Nuevo ID de Persona: ");
                                PERSONAS_id = leerNumero.nextInt();
                                objCampanaLUACT.setPERSONAS_id(PERSONAS_id);

                                objAdmCamBD.actualizar(objCampanaLUACT);
                            }
                            case 5 -> {
                                //5. Eliminar
                                campanas objCampanaElim = new campanas();

                                System.out.print("Ingrese ID de la campaña: ");
                                id = leerNumero.nextInt();
                                objCampanaElim.setId(id);

                                objAdmCamBD.eliminar(objCampanaElim);
                            }
                            case 6 -> //6. Salir
                                salirCampana = true;
                            default ->
                                System.out.println("\n!!! La opción no existe !!!\n");
                        }
                    }
                    break;
                case 4://4. Administrar tabla categorias
                    while (!salirCategoria) {
                        System.out.println("\nMENU TABLA CATEGORIAS\n");
                        System.out.println("1. Listar todo");
                        System.out.println("2. Listar Uno");
                        System.out.println("3. Insertar");
                        System.out.println("4. Actualizar");
                        System.out.println("5. Eliminar");
                        System.out.println("6. Salir");
                        System.out.print("\nDigite opcion: ");

                        opcionCategorias = leerOpcion.nextInt();

                        switch (opcionCategorias) {
                            case 1 -> {
                                for (Object obj : objAdmCatBD.listarTodo()) {
                                    System.out.println(obj);
                                }
                            }
                            case 2 -> {
                                categorias objCatLU = new categorias();
                                System.out.print("Ingrese ID de la categoria: ");
                                id = leerNumero.nextInt();
                                objCatLU.setId(id);
                                objCatLU = (categorias) objAdmCatBD.listarUno(objCatLU);
                                System.out.println("");
                                System.out.println(objCatLU);
                            }
                            case 3 -> {
                                categorias objCatInst = new categorias();
                                System.out.print("\nIngrese Nombre (PREMIUM/STANDARD): ");
                                nombreCategoria = leerTexto.nextLine();
                                objCatInst.setNombre(nombreCategoria);
                                System.out.print("Ingrese Dias de Prestamo: ");
                                dias_prestamo = leerNumero.nextInt();
                                objCatInst.setDias_prestamo(dias_prestamo);
                                System.out.print("Ingrese Porcentaje de Penalizacion: ");
                                porcentaje_penalizacion = leerNumero.nextDouble();
                                objCatInst.setPorcentaje_penalizacion(porcentaje_penalizacion);
                                objAdmCatBD.insertar(objCatInst);
                            }
                            case 4 -> {
                                categorias objCatLUACT = new categorias();
                                System.out.print("Ingrese ID de la categoria: ");
                                id = leerNumero.nextInt();
                                objCatLUACT.setId(id);
                                objCatLUACT = (categorias) objAdmCatBD.listarUno(objCatLUACT);
                                System.out.println("");
                                System.out.println(objCatLUACT);
                                System.out.print("\nIngrese Nuevo Nombre (PREMIUM/STANDARD): ");
                                nombreCategoria = leerTexto.nextLine();
                                objCatLUACT.setNombre(nombreCategoria);
                                System.out.print("Ingrese Nuevos Dias de Prestamo: ");
                                dias_prestamo = leerNumero.nextInt();
                                objCatLUACT.setDias_prestamo(dias_prestamo);
                                System.out.print("Ingrese Nuevo Porcentaje de Penalizacion: ");
                                porcentaje_penalizacion = leerNumero.nextDouble();
                                objCatLUACT.setPorcentaje_penalizacion(porcentaje_penalizacion);
                                objAdmCatBD.actualizar(objCatLUACT);
                            }
                            case 5 -> {
                                categorias objCatElim = new categorias();
                                System.out.print("Ingrese ID de la categoria: ");
                                id = leerNumero.nextInt();
                                objCatElim.setId(id);
                                objAdmCatBD.eliminar(objCatElim);
                            }
                            case 6 ->
                                salirCategoria = true;
                            default ->
                                System.out.println("\n!!! La opcion no existe !!!\n");
                        }
                    }
                    break;
                case 5://5. Administrar tabla penalizacion
                    while (!salirPenali) {
                        System.out.println("\nMENU TABLA PENALIZACION\n");
                        System.out.println("1. Listar todo");
                        System.out.println("2. Listar Uno");
                        System.out.println("3. Insertar");
                        System.out.println("4. Actualizar");
                        System.out.println("5. Eliminar");
                        System.out.println("6. Salir");
                        System.out.print("\nDigite opcion: ");

                        opcionPenali = leerOpcion.nextInt();

                        switch (opcionPenali) {
                            case 1 -> {
                                for (Object obj : objAdmPenaliBD.listarTodo()) {
                                    System.out.println(obj);
                                }
                            }
                            case 2 -> {
                                penalizacionprestamos objPenaliLU = new penalizacionprestamos();
                                System.out.print("Ingrese ID de la penalizacion: ");
                                id = leerNumero.nextInt();
                                objPenaliLU.setId(id);
                                objPenaliLU = (penalizacionprestamos) objAdmPenaliBD.listarUno(objPenaliLU);
                                System.out.println("");
                                System.out.println(objPenaliLU);
                            }
                            case 3 -> {
                                penalizacionprestamos objPenaliInst = new penalizacionprestamos();
                                System.out.print("\nIngrese Dias de Retraso: ");
                                dias_retraso = leerNumero.nextInt();
                                objPenaliInst.setDias_retraso(dias_retraso);
                                System.out.print("Ingrese Valor Penalizacion: ");
                                valor_penali = leerNumero.nextDouble();
                                objPenaliInst.setValor_penali(valor_penali);
                                System.out.print("Ingrese Fecha Generacion (YYYY-MM-DD): ");
                                fecha_generacion = leerTexto.nextLine();
                                objPenaliInst.setFecha_generacion(fecha_generacion);
                                System.out.print("Ingrese Pagada (0=No, 1=Si): ");
                                pagada = leerNumero.nextInt();
                                objPenaliInst.setPagada(pagada);
                                System.out.print("Ingrese ID del Prestamo: ");
                                PRESTAMOS_ACTIVO_PERSONA_id = leerNumero.nextInt();
                                objPenaliInst.setPRESTAMOS_ACTIVO_PERSONA_id(PRESTAMOS_ACTIVO_PERSONA_id);
                                objAdmPenaliBD.insertar(objPenaliInst);
                            }
                            case 4 -> {
                                penalizacionprestamos objPenaliLUACT = new penalizacionprestamos();
                                System.out.print("Ingrese ID de la penalizacion: ");
                                id = leerNumero.nextInt();
                                objPenaliLUACT.setId(id);
                                objPenaliLUACT = (penalizacionprestamos) objAdmPenaliBD.listarUno(objPenaliLUACT);
                                System.out.println("");
                                System.out.println(objPenaliLUACT);
                                System.out.print("\nIngrese Nuevos Dias de Retraso: ");
                                dias_retraso = leerNumero.nextInt();
                                objPenaliLUACT.setDias_retraso(dias_retraso);
                                System.out.print("Ingrese Nuevo Valor Penalizacion: ");
                                valor_penali = leerNumero.nextDouble();
                                objPenaliLUACT.setValor_penali(valor_penali);
                                System.out.print("Ingrese Nueva Fecha Generacion (YYYY-MM-DD): ");
                                fecha_generacion = leerTexto.nextLine();
                                objPenaliLUACT.setFecha_generacion(fecha_generacion);
                                System.out.print("Ingrese Pagada (0=No, 1=Si): ");
                                pagada = leerNumero.nextInt();
                                objPenaliLUACT.setPagada(pagada);
                                System.out.print("Ingrese Nuevo ID del Prestamo: ");
                                PRESTAMOS_ACTIVO_PERSONA_id = leerNumero.nextInt();
                                objPenaliLUACT.setPRESTAMOS_ACTIVO_PERSONA_id(PRESTAMOS_ACTIVO_PERSONA_id);
                                objAdmPenaliBD.actualizar(objPenaliLUACT);
                            }
                            case 5 -> {
                                penalizacionprestamos objPenaliElim = new penalizacionprestamos();
                                System.out.print("Ingrese ID de la penalizacion: ");
                                id = leerNumero.nextInt();
                                objPenaliElim.setId(id);
                                objAdmPenaliBD.eliminar(objPenaliElim);
                            }
                            case 6 ->
                                salirPenali = true;
                            default ->
                                System.out.println("\n!!! La opcion no existe !!!\n");
                        }
                    }
                    break;
                case 6://6. Administrar tabla personas
                    while (!salirPersona) {
                        System.out.println("\nMENU TABLA PERSONAS\n");
                        System.out.println("1. Listar todo");
                        System.out.println("2. Listar Uno");
                        System.out.println("3. Insertar");
                        System.out.println("4. Actualizar");
                        System.out.println("5. Eliminar");
                        System.out.println("6. Salir");
                        System.out.print("\nDigite opción: ");

                        opcionPersonas = leerOpcion.nextInt();

                        switch (opcionPersonas) {
                            case 1 -> {
                                //1. Listar todo
                                for (Object obj : objAdmPerBD.listarTodo()) {
                                    System.out.println(obj);
                                }
                            }
                            case 2 -> {
                                //2. Listar Uno
                                personas objPersonaLU = new personas();

                                System.out.print("Ingrese ID de la persona: ");
                                id = leerNumero.nextInt();
                                objPersonaLU.setId(id);

                                objPersonaLU = (personas) objAdmPerBD.listarUno(objPersonaLU);

                                System.out.println("");//Salto de linea
                                System.out.println(objPersonaLU);
                            }
                            case 3 -> {
                                //3. Insertar
                                personas objPersonaInst = new personas();

                                System.out.print("\nIngrese Tipo de Documento: ");
                                tipo_documento = leerTexto.nextLine();
                                objPersonaInst.setTipo_documento(tipo_documento);

                                System.out.print("Ingrese Numero de Documento: ");
                                numero_documento = leerTexto.nextLine();
                                objPersonaInst.setNumero_documento(numero_documento);

                                System.out.print("Ingrese Razon Social: ");
                                razon_social = leerTexto.nextLine();
                                objPersonaInst.setRazon_social(razon_social);

                                System.out.print("Ingrese Telefono: ");
                                telefono = leerTexto.nextLine();
                                objPersonaInst.setTelefono(telefono);

                                System.out.print("Ingrese Email: ");
                                email = leerTexto.nextLine();
                                objPersonaInst.setEmail(email);

                                System.out.print("Ingrese Direccion: ");
                                direccion = leerTexto.nextLine();
                                objPersonaInst.setDireccion(direccion);

                                System.out.print("Ingrese ID del Rol: ");
                                ROL_id = leerNumero.nextInt();
                                objPersonaInst.setROL_id(ROL_id);

                                System.out.print("Ingrese Nombre: ");
                                nombrePersona = leerTexto.nextLine();
                                objPersonaInst.setNombre(nombrePersona);

                                objAdmPerBD.insertar(objPersonaInst);
                            }
                            case 4 -> {
                                //4. Actualizar
                                personas objPersonaLUACT = new personas();

                                System.out.print("Ingrese ID de la persona: ");
                                id = leerNumero.nextInt();
                                objPersonaLUACT.setId(id);

                                objPersonaLUACT = (personas) objAdmPerBD.listarUno(objPersonaLUACT);
                                System.out.println("");//Salto de linea
                                System.out.println(objPersonaLUACT);

                                //Actualizar
                                System.out.print("\nIngrese Nuevo Tipo de Documento: ");
                                tipo_documento = leerTexto.nextLine();
                                objPersonaLUACT.setTipo_documento(tipo_documento);

                                System.out.print("Ingrese Nuevo Numero de Documento: ");
                                numero_documento = leerTexto.nextLine();
                                objPersonaLUACT.setNumero_documento(numero_documento);

                                System.out.print("Ingrese Nueva Razon Social: ");
                                razon_social = leerTexto.nextLine();
                                objPersonaLUACT.setRazon_social(razon_social);

                                System.out.print("Ingrese Nuevo Telefono: ");
                                telefono = leerTexto.nextLine();
                                objPersonaLUACT.setTelefono(telefono);

                                System.out.print("Ingrese Nuevo Email: ");
                                email = leerTexto.nextLine();
                                objPersonaLUACT.setEmail(email);

                                System.out.print("Ingrese Nueva Direccion: ");
                                direccion = leerTexto.nextLine();
                                objPersonaLUACT.setDireccion(direccion);

                                System.out.print("Ingrese Nuevo ID del Rol: ");
                                ROL_id = leerNumero.nextInt();
                                objPersonaLUACT.setROL_id(ROL_id);

                                System.out.print("Ingrese Nuevo Nombre: ");
                                nombrePersona = leerTexto.nextLine();
                                objPersonaLUACT.setNombre(nombrePersona);

                                objAdmPerBD.actualizar(objPersonaLUACT);
                            }
                            case 5 -> {
                                //5. Eliminar
                                personas objPersonaElim = new personas();

                                System.out.print("Ingrese ID de la persona: ");
                                id = leerNumero.nextInt();
                                objPersonaElim.setId(id);

                                objAdmPerBD.eliminar(objPersonaElim);
                            }
                            case 6 -> //6. Salir
                                salirPersona = true;
                            default ->
                                System.out.println("\n!!! La opción no existe !!!\n");
                        }
                    }
                    break;
                case 7://7. Administrar tabla prestamos
                    while (!salirPrestamo) {
                        System.out.println("\nMENU TABLA PRESTAMOS\n");
                        System.out.println("1. Listar todo");
                        System.out.println("2. Listar Uno");
                        System.out.println("3. Insertar");
                        System.out.println("4. Actualizar");
                        System.out.println("5. Eliminar");
                        System.out.println("6. Salir");
                        System.out.print("\nDigite opcion: ");

                        opcionPrestamo = leerOpcion.nextInt();

                        switch (opcionPrestamo) {
                            case 1 -> {
                                for (Object obj : objAdmPrestaBD.listarTodo()) {
                                    System.out.println(obj);
                                }
                            }
                            case 2 -> {
                                prestamosactivopersonas objPrestaLU = new prestamosactivopersonas();
                                System.out.print("Ingrese ID del prestamo: ");
                                id = leerNumero.nextInt();
                                objPrestaLU.setId(id);
                                objPrestaLU = (prestamosactivopersonas) objAdmPrestaBD.listarUno(objPrestaLU);
                                System.out.println("");
                                System.out.println(objPrestaLU);
                            }
                            case 3 -> {
                                prestamosactivopersonas objPrestaInst = new prestamosactivopersonas();
                                System.out.print("\nIngrese Fecha Inicio (YYYY-MM-DD): ");
                                fecha_inicio = leerTexto.nextLine();
                                objPrestaInst.setFecha_inicio(fecha_inicio);
                                System.out.print("Ingrese Fecha Fin Programada (YYYY-MM-DD): ");
                                fecha_fin_programa = leerTexto.nextLine();
                                objPrestaInst.setFecha_fin_programa(fecha_fin_programa);
                                System.out.print("Ingrese Fecha Entrega Real (YYYY-MM-DD): ");
                                fecha_entrega_real = leerTexto.nextLine();
                                objPrestaInst.setFecha_entrega_real(fecha_entrega_real);
                                System.out.print("Ingrese Estado (ACTIVO/ATRASADO/FINALIZADO): ");
                                estadoPrestamo = leerTexto.nextLine();
                                objPrestaInst.setEstado(estadoPrestamo);
                                System.out.print("Ingrese ID de Persona: ");
                                PERSONAS_id = leerNumero.nextInt();
                                objPrestaInst.setPERSONAS_id(PERSONAS_id);
                                System.out.print("Ingrese ID de Activo: ");
                                ACTIVOS_id = leerNumero.nextInt();
                                objPrestaInst.setACTIVOS_id(ACTIVOS_id);
                                objAdmPrestaBD.insertar(objPrestaInst);
                            }
                            case 4 -> {
                                prestamosactivopersonas objPrestaLUACT = new prestamosactivopersonas();
                                System.out.print("Ingrese ID del prestamo: ");
                                id = leerNumero.nextInt();
                                objPrestaLUACT.setId(id);
                                objPrestaLUACT = (prestamosactivopersonas) objAdmPrestaBD.listarUno(objPrestaLUACT);
                                System.out.println("");
                                System.out.println(objPrestaLUACT);
                                System.out.print("\nIngrese Nueva Fecha Inicio (YYYY-MM-DD): ");
                                fecha_inicio = leerTexto.nextLine();
                                objPrestaLUACT.setFecha_inicio(fecha_inicio);
                                System.out.print("Ingrese Nueva Fecha Fin Programada (YYYY-MM-DD): ");
                                fecha_fin_programa = leerTexto.nextLine();
                                objPrestaLUACT.setFecha_fin_programa(fecha_fin_programa);
                                System.out.print("Ingrese Nueva Fecha Entrega Real (YYYY-MM-DD): ");
                                fecha_entrega_real = leerTexto.nextLine();
                                objPrestaLUACT.setFecha_entrega_real(fecha_entrega_real);
                                System.out.print("Ingrese Nuevo Estado (ACTIVO/ATRASADO/FINALIZADO): ");
                                estadoPrestamo = leerTexto.nextLine();
                                objPrestaLUACT.setEstado(estadoPrestamo);
                                System.out.print("Ingrese Nuevo ID de Persona: ");
                                PERSONAS_id = leerNumero.nextInt();
                                objPrestaLUACT.setPERSONAS_id(PERSONAS_id);
                                System.out.print("Ingrese Nuevo ID de Activo: ");
                                ACTIVOS_id = leerNumero.nextInt();
                                objPrestaLUACT.setACTIVOS_id(ACTIVOS_id);
                                objAdmPrestaBD.actualizar(objPrestaLUACT);
                            }
                            case 5 -> {
                                prestamosactivopersonas objPrestaElim = new prestamosactivopersonas();
                                System.out.print("Ingrese ID del prestamo: ");
                                id = leerNumero.nextInt();
                                objPrestaElim.setId(id);
                                objAdmPrestaBD.eliminar(objPrestaElim);
                            }
                            case 6 ->
                                salirPrestamo = true;
                            default ->
                                System.out.println("\n!!! La opcion no existe !!!\n");
                        }
                    }
                    break;
                case 8://8. Administrar tabla reservas
                    while (!salirReserva) {
                        System.out.println("\nMENU TABLA RESERVAS\n");
                        System.out.println("1. Listar todo");
                        System.out.println("2. Listar Uno");
                        System.out.println("3. Insertar");
                        System.out.println("4. Actualizar");
                        System.out.println("5. Eliminar");
                        System.out.println("6. Salir");
                        System.out.print("\nDigite opcion: ");

                        opcionReserva = leerOpcion.nextInt();

                        switch (opcionReserva) {
                            case 1 -> {
                                for (Object obj : objAdmReservaBD.listarTodo()) {
                                    System.out.println(obj);
                                }
                            }
                            case 2 -> {
                                reservasactivosclientes objReservaLU = new reservasactivosclientes();
                                System.out.print("Ingrese ID de la reserva: ");
                                id = leerNumero.nextInt();
                                objReservaLU.setId(id);
                                objReservaLU = (reservasactivosclientes) objAdmReservaBD.listarUno(objReservaLU);
                                System.out.println("");
                                System.out.println(objReservaLU);
                            }
                            case 3 -> {
                                reservasactivosclientes objReservaInst = new reservasactivosclientes();
                                System.out.print("\nIngrese Fecha Reserva (YYYY-MM-DD): ");
                                fecha_reserva = leerTexto.nextLine();
                                objReservaInst.setFecha_reserva(fecha_reserva);
                                System.out.print("Ingrese Estado (ACTIVA/CANCELADA/ATENDIDA): ");
                                estadoReserva = leerTexto.nextLine();
                                objReservaInst.setEstado(estadoReserva);
                                System.out.print("Ingrese ID de Activo: ");
                                ACTIVOS_id = leerNumero.nextInt();
                                objReservaInst.setACTIVOS_id(ACTIVOS_id);
                                System.out.print("Ingrese ID de Persona: ");
                                PERSONAS_id = leerNumero.nextInt();
                                objReservaInst.setPERSONAS_id(PERSONAS_id);
                                objAdmReservaBD.insertar(objReservaInst);
                            }
                            case 4 -> {
                                reservasactivosclientes objReservaLUACT = new reservasactivosclientes();
                                System.out.print("Ingrese ID de la reserva: ");
                                id = leerNumero.nextInt();
                                objReservaLUACT.setId(id);
                                objReservaLUACT = (reservasactivosclientes) objAdmReservaBD.listarUno(objReservaLUACT);
                                System.out.println("");
                                System.out.println(objReservaLUACT);
                                System.out.print("\nIngrese Nueva Fecha Reserva (YYYY-MM-DD): ");
                                fecha_reserva = leerTexto.nextLine();
                                objReservaLUACT.setFecha_reserva(fecha_reserva);
                                System.out.print("Ingrese Nuevo Estado (ACTIVA/CANCELADA/ATENDIDA): ");
                                estadoReserva = leerTexto.nextLine();
                                objReservaLUACT.setEstado(estadoReserva);
                                System.out.print("Ingrese Nuevo ID de Activo: ");
                                ACTIVOS_id = leerNumero.nextInt();
                                objReservaLUACT.setACTIVOS_id(ACTIVOS_id);
                                System.out.print("Ingrese Nuevo ID de Persona: ");
                                PERSONAS_id = leerNumero.nextInt();
                                objReservaLUACT.setPERSONAS_id(PERSONAS_id);
                                objAdmReservaBD.actualizar(objReservaLUACT);
                            }
                            case 5 -> {
                                reservasactivosclientes objReservaElim = new reservasactivosclientes();
                                System.out.print("Ingrese ID de la reserva: ");
                                id = leerNumero.nextInt();
                                objReservaElim.setId(id);
                                objAdmReservaBD.eliminar(objReservaElim);
                            }
                            case 6 ->
                                salirReserva = true;
                            default ->
                                System.out.println("\n!!! La opcion no existe !!!\n");
                        }
                    }
                    break;
                case 9://9. Reportes
                    while (!salirReportes) {
                        System.out.println("\nMENU REPORTES\n");
                        System.out.println("1. Activos por categoria");
                        System.out.println("2. Activos prestados con penalizacion");
                        System.out.println("3. Penalizaciones por cliente");
                        System.out.println("4. Salir");
                        System.out.print("\nDigite opcion: ");

                        opcionReportes = leerOpcion.nextInt();

                        switch (opcionReportes) {
                            case 1 -> {
                                for (Object obj : objRelDB.reporteactivosporcategoria()) {
                                    System.out.println(obj);
                                }
                            }
                            case 2 -> {
                                for (Object obj : objRelDB.reporteactivosprestados()) {
                                    System.out.println(obj);
                                }
                            }
                            case 3 -> {
                                System.out.print("Ingrese numero de documento: ");
                                numeroDocumento = leerTexto.nextLine();
                                for (Object obj : objRelDB.reportepenalizacionporcliente(numeroDocumento)) {
                                    System.out.println(obj);
                                }
                            }
                            case 4 ->
                                salirReportes = true;
                            default ->
                                System.out.println("\n!!! La opcion no existe !!!\n");
                        }
                    }
                    break;

                case 10://10. Salir
                    salirPrincipal = true;
                    break;
                default:
                    System.out.println("\n!!! La opción no existe !!!\n");
            }
        }
    }
}
