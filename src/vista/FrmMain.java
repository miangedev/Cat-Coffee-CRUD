    package vista;

import java.awt.PopupMenu;
import javax.swing.JMenuItem;

public class FrmMain extends javax.swing.JFrame {
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMain objetoMain = new FrmMain();
                objetoMain.setLocationRelativeTo(null);
                objetoMain.setVisible(true);
            }
        });
    }

    public FrmMain() {
        dao.Conexion.abrirConexion();
        initComponents();
        FrmDiagLogin objLogin = new FrmDiagLogin((java.awt.Frame) null, true);
        objLogin.setLocationRelativeTo(null);
        objLogin.setVisible(true);
        this.setSize(960, 540);
    }

    private javax.swing.JPanel crearPanelConFondo(String rutaImagen) {
        return new javax.swing.JPanel() {
            private java.awt.Image imagen = new javax.swing.ImageIcon(
                    getClass().getResource(rutaImagen)).getImage();

            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = crearPanelConFondo("/recursos/fondo.png");
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        submenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        submenuAdminRol = new javax.swing.JMenuItem();
        submenuAdminPersonas = new javax.swing.JMenuItem();
        submenuAdminActivos = new javax.swing.JMenuItem();
        submenuAdminCategorias = new javax.swing.JMenuItem();
        submenuAdminCampanas = new javax.swing.JMenuItem();
        submenuAdminPrestamos = new javax.swing.JMenuItem();
        submenuAdminReservas = new javax.swing.JMenuItem();
        submenuAdminPenalizaciones = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        submenuReportes = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        submenuAcercaDe = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        submenuGestionarPrestamos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        jLabel1.setText("Cat Coffee");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(131, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap(131, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(144, 144, 144)));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Archivo");
        submenuSalir.setText("Salir");
        submenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(submenuSalir);
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Administración");

        submenuAdminRol.setText("Administrar Roles");
        submenuAdminRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminRolActionPerformed(evt);
            }
        });
        jMenu2.add(submenuAdminRol);

        submenuAdminPersonas.setText("Administrar Personas");
        submenuAdminPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminPersonasActionPerformed(evt);
            }
        });
        jMenu2.add(submenuAdminPersonas);

        submenuAdminActivos.setText("Administrar Activos");
        submenuAdminActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminActivosActionPerformed(evt);
            }
        });
        jMenu2.add(submenuAdminActivos);

        submenuAdminCategorias.setText("Administrar Categorias");
        submenuAdminCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminCategoriasActionPerformed(evt);
            }
        });
        jMenu2.add(submenuAdminCategorias);

        submenuAdminCampanas.setText("Administrar Campañas");
        submenuAdminCampanas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminCampanasActionPerformed(evt);
            }
        });
        jMenu2.add(submenuAdminCampanas);

        submenuAdminPrestamos.setText("Administrar Prestamos");
        submenuAdminPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminPrestamosActionPerformed(evt);
            }
        });
        jMenu2.add(submenuAdminPrestamos);

        submenuAdminReservas.setText("Administrar Reservas");
        submenuAdminReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminReservasActionPerformed(evt);
            }
        });
        jMenu2.add(submenuAdminReservas);

        submenuAdminPenalizaciones.setText("Administrar Penalizaciones");
        submenuAdminPenalizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminPenalizacionesActionPerformed(evt);
            }
        });
        jMenu2.add(submenuAdminPenalizaciones);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");
        submenuReportes.setText("Generar Reportes");
        submenuReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesActionPerformed(evt);
            }
        });
        jMenu5.setText("Gestión");
        submenuGestionarPrestamos.setText("Gestionar los Activos");
        submenuGestionarPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuGestionarPrestamosActionPerformed(evt);
            }
        });
        jMenu5.add(submenuGestionarPrestamos);
        jMenuBar1.add(jMenu5);
        jMenu3.add(submenuReportes);
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ayuda");
        submenuAcercaDe.setText("Acerca de ...");
        submenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAcercaDeActionPerformed(evt);
            }
        });
        jMenu4.add(submenuAcercaDe);
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private void submenuSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void submenuAdminRolActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagAdminRol objFrm = new FrmDiagAdminRol(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuAdminPersonasActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagAdminPersonas objFrm = new FrmDiagAdminPersonas(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuAdminActivosActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagAdminActivos objFrm = new FrmDiagAdminActivos(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuAdminCategoriasActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagAdminCategorias objFrm = new FrmDiagAdminCategorias(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuAdminCampanasActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagAdminCampanas objFrm = new FrmDiagAdminCampanas(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuAdminPrestamosActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagAdminPrestamos objFrm = new FrmDiagAdminPrestamos(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuAdminReservasActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagAdminReservas objFrm = new FrmDiagAdminReservas(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuAdminPenalizacionesActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagAdminPenalizaciones objFrm = new FrmDiagAdminPenalizaciones(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuGestionarPrestamosActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagGestionarActivos objFrm = new FrmDiagGestionarActivos(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuReportesActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagReportes objFrm = new FrmDiagReportes(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    private void submenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {
        FrmDiagAcercaDe objFrm = new FrmDiagAcercaDe(this, true);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem submenuSalir;
    private javax.swing.JMenuItem submenuAdminRol;
    private javax.swing.JMenuItem submenuAdminPersonas;
    private javax.swing.JMenuItem submenuAdminActivos;
    private javax.swing.JMenuItem submenuAdminCategorias;
    private javax.swing.JMenuItem submenuAdminCampanas;
    private javax.swing.JMenuItem submenuAdminPrestamos;
    private javax.swing.JMenuItem submenuAdminReservas;
    private javax.swing.JMenuItem submenuAdminPenalizaciones;
    private javax.swing.JMenuItem submenuReportes;
    private javax.swing.JMenuItem submenuGestionarPrestamos;
    private javax.swing.JMenuItem submenuAcercaDe;
    // End of variables declaration
}