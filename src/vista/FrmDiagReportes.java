package vista;

import javax.swing.table.DefaultTableModel;
import modelo.RelacionesBD;
import modelo.reporteactivoscategorias;
import modelo.reporteactivosprestados;
import modelo.reportepenalizacioncliente;

public class FrmDiagReportes extends javax.swing.JDialog {

    RelacionesBD objRelDB = new RelacionesBD();
    DefaultTableModel modeloTabla;

    public FrmDiagReportes(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void configurarTabla(String[] cabecera) {
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblReporte.setModel(this.modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnReporte1 = new javax.swing.JButton();
        btnReporte2 = new javax.swing.JButton();
        btnReporte3 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();
        lblStatus = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar Reportes");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Numero Documento (Reporte 3):");

        btnReporte1.setBackground(new java.awt.Color(0, 51, 51));
        btnReporte1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnReporte1.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte1.setText("1. Activos por Categoria");
        btnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte1ActionPerformed(evt);
            }
        });

        btnReporte2.setBackground(new java.awt.Color(0, 51, 51));
        btnReporte2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnReporte2.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte2.setText("2. Activos Prestados");
        btnReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte2ActionPerformed(evt);
            }
        });

        btnReporte3.setBackground(new java.awt.Color(0, 51, 51));
        btnReporte3.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnReporte3.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte3.setText("3. Penalizaciones por Cliente");
        btnReporte3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte3ActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 51, 51));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblStatus.setForeground(new java.awt.Color(200, 255, 200));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Seleccione un reporte para generar.");

        jScrollPane1.setViewportView(tblReporte);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnReporte1)
                .addGap(15, 15, 15)
                .addComponent(btnReporte2)
                .addGap(15, 15, 15)
                .addComponent(btnReporte3)
                .addGap(15, 15, 15)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte1).addComponent(btnReporte2)
                    .addComponent(btnReporte3).addComponent(btnSalir))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblStatus)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void btnReporte1ActionPerformed(java.awt.event.ActionEvent evt) {
        configurarTabla(new String[]{"ID", "Nombre", "Tipo", "Marca", "Modelo", "Año Adq.", "Valor Comercial", "Estado", "Categoria"});
        int count = 0;
        for (Object obj : objRelDB.reporteactivosporcategoria()) {
            reporteactivoscategorias o = (reporteactivoscategorias) obj;
            String[] fila = {
                Integer.toString(o.getId()),
                o.getNombre(),
                o.getTipo(),
                o.getMarca(),
                o.getModelo(),
                o.getAno_adquisicion(),
                Double.toString(o.getValor_comercial()),
                o.getEstado(),
                o.getCategoria()
            };
            modeloTabla.addRow(fila);
            count++;
        }
        lblStatus.setText(count + " registro(s) — Activos por Categoria");
    }

    private void btnReporte2ActionPerformed(java.awt.event.ActionEvent evt) {
        configurarTabla(new String[]{"ID Prestamo", "Persona", "Activo", "Tipo", "Marca", "Modelo", "Fecha Inicio", "Fecha Fin", "Estado", "Pagada"});
        int count = 0;
        for (Object obj : objRelDB.reporteactivosprestados()) {
            reporteactivosprestados o = (reporteactivosprestados) obj;
            String[] fila = {
                Integer.toString(o.getPrestamo_id()),
                o.getPersona(),
                o.getActivo(),
                o.getTipo(),
                o.getMarca(),
                o.getModelo(),
                o.getFecha_inicio(),
                o.getFecha_fin_programa(),
                o.getEstado(),
                Integer.toString(o.getPagada())
            };
            modeloTabla.addRow(fila);
            count++;
        }
        lblStatus.setText(count + " registro(s) — Activos Prestados con Penalizacion");
    }

    private void btnReporte3ActionPerformed(java.awt.event.ActionEvent evt) {
        String doc = txtDocumento.getText().trim();
        if (doc.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el numero de documento para el reporte 3.");
            return;
        }
        configurarTabla(new String[]{"Nombre", "Num. Documento", "Dias Retraso", "Valor Penalizacion", "Fecha Generacion"});
        int count = 0;
        for (Object obj : objRelDB.reportepenalizacionporcliente(doc)) {
            reportepenalizacioncliente o = (reportepenalizacioncliente) obj;
            String[] fila = {
                o.getNombre(),
                o.getNumero_documento(),
                Integer.toString(o.getDias_retraso()),
                Double.toString(o.getValor_penali()),
                o.getFecha_generacion()
            };
            modeloTabla.addRow(fila);
            count++;
        }
        lblStatus.setText(count + " registro(s) — Penalizaciones para documento: " + doc);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnReporte1;
    private javax.swing.JButton btnReporte2;
    private javax.swing.JButton btnReporte3;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblReporte;
    private javax.swing.JTextField txtDocumento;
    // End of variables declaration
}