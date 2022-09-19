/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pertinax.view;

import br.com.pertinax.dao.BobstCoatedDAO;
import br.com.pertinax.dao.CartonAcopladoDAO;
import br.com.pertinax.dao.CartonCoatedDAO;
import br.com.pertinax.dao.CartonLaminadoDAO;
import br.com.pertinax.dao.GerenciaCartaoDAO;
import br.com.pertinax.model.BobstCoated;
import br.com.pertinax.model.CartonAcoplado;
import br.com.pertinax.model.CartonCoated;
import br.com.pertinax.model.CartonLaminado;
import br.com.pertinax.model.GerenciaCartao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author mrs_a
 */
public class FrmPrincipal extends javax.swing.JFrame {

    // Metodo pesquisa na lista BobstCoated nome e gramatura
    public void PesquisaNomeGramaturaBobstCoated() {
        String nome = "%" + txtpesquisanomebobst.getText() + "%";
        String gramatura = "%" + txtpesquisagrmbobst.getText() + "%";

        BobstCoatedDAO dao = new BobstCoatedDAO();
        List<BobstCoated> lista = dao.pesquisarNomeBobstCoated(nome, gramatura);
        DefaultTableModel dados = (DefaultTableModel) tb_bobstCoated.getModel();
        dados.setNumRows(0);
        for (BobstCoated c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getGrm_cartao(),
                c.getPertinax(),
                c.getFresa1(),
                c.getFresa2()
            });

        }
    }

    // Metodo pesquisa na lista CartaoCoated Faca, nome e gramatura
    public void PesquisaFacaNomeGramaturaCartaoCoated() {
        String faca = "%" + txtpesquisafacacoated.getText() + "%";
        String nome = "%" + txtpesquisanomecoated.getText() + "%";
        String gramatura = "%" + txtpesquisagrmcoated.getText() + "%";
        CartonCoatedDAO dao = new CartonCoatedDAO();
        List<CartonCoated> lista = dao.pesquisarCartonCoated(faca, nome, gramatura);
        DefaultTableModel dados = (DefaultTableModel) tb_cartonCoated.getModel();
        dados.setNumRows(0);
        for (CartonCoated c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getFaca(),
                c.getNome(),
                c.getGrm_cartao(),
                c.getUv(),
                c.getPertinax(),
                c.getFresa1(),
                c.getFresa2(),
                c.getObservacao()
            });

        }
    }

    // Metodo pesquisa na lista CartaoLaminado Faca, nome e gramatura
    public void PesquisaFacaNomeGramaturaCartaoLaminado() {
        String faca = "%" + txtpesquisafacalaminado.getText() + "%";
        String nome = "%" + txtpesquisanomelaminado.getText() + "%";
        String gramatura = "%" + txtpesquisagrmlaminado.getText() + "%";
        CartonLaminadoDAO dao = new CartonLaminadoDAO();
        List<CartonLaminado> lista = dao.pesquisarCartonLaminado(faca, nome, gramatura);
        DefaultTableModel dados = (DefaultTableModel) tb_cartonLaminado.getModel();
        dados.setNumRows(0);
        for (CartonLaminado c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getFaca(),
                c.getNome(),
                c.getGrm_cartao(),
                c.getGrm_laminado(),
                c.getGrm_total(),
                c.getUv(),
                c.getPertinax(),
                c.getFresa1(),
                c.getFresa2(),
                c.getObservacao()
            });

        }
    }

    // Metodo pesquisa na lista CartaoAcoplado Faca, nome e gramatura
    public void PesquisaFacaNomeGramaturaCartaoAcoplado() {
        String faca = "%" + txtpesquisafacaacoplado.getText() + "%";
        String nome = "%" + txtpesquisanomeacoplado.getText() + "%";
        String gramatura = "%" + txtpesquisagrmacoplado.getText() + "%";
        CartonAcopladoDAO dao = new CartonAcopladoDAO();
        List<CartonAcoplado> lista = dao.pesquisarCartonAcoplado(faca, nome, gramatura);
        DefaultTableModel dados = (DefaultTableModel) tb_cartonAcoplado.getModel();
        dados.setNumRows(0);
        for (CartonAcoplado c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getFaca(),
                c.getNome(),
                c.getGrm_cartao1(),
                c.getGrm_cartao2(),
                c.getGrm_total(),
                c.getUv(),
                c.getPertinax(),
                c.getFresa1(),
                c.getFresa2(),
                c.getObservacao()
            });

        }
    }

    //Metodo Atualiza cbnomecoated
    public void Atualizarcbnomecoated() {
        GerenciaCartaoDAO dao = new GerenciaCartaoDAO();
        List<GerenciaCartao> lista = dao.listarGerenciaCartao();

        cbnomecoated.removeAllItems();
        cbnomecoated.addItem("*");

        for (GerenciaCartao c : lista) {
            cbnomecoated.addItem(c);

        }
    }

    //Metodo Atualizar cbnomelaminado
    public void Atualizarcbnomelaminado() {
        GerenciaCartaoDAO dao = new GerenciaCartaoDAO();
        List<GerenciaCartao> lista = dao.listarGerenciaCartao();

        cbnomelaminado.removeAllItems();
        cbnomelaminado.addItem("*");

        for (GerenciaCartao c : lista) {
            cbnomelaminado.addItem(c);

        }
    }

    //Metodo Atualizar cbnomeacoplado
    public void Atualizarcbnomeacoplado() {
        GerenciaCartaoDAO dao = new GerenciaCartaoDAO();
        List<GerenciaCartao> lista = dao.listarGerenciaCartao();

        cbnomeacoplado.removeAllItems();
        cbnomeacoplado.addItem("*");

        for (GerenciaCartao c : lista) {
            cbnomeacoplado.addItem(c);

        }
    }

    //Metodo Atualizar cbnomebobst
    public void Atualizarcbnomebobst() {
        GerenciaCartaoDAO dao = new GerenciaCartaoDAO();
        List<GerenciaCartao> lista = dao.listarGerenciaCartao();

        cbnomebobst.removeAllItems();
        cbnomebobst.addItem("*");

        for (GerenciaCartao c : lista) {
            cbnomebobst.addItem(c);

        }
    }

    //Metodo listar padrão bobst
    public void listarBobstCoated() {
        BobstCoatedDAO dao = new BobstCoatedDAO();
        List<BobstCoated> lista = dao.listarBobstCoated();
        DefaultTableModel dados = (DefaultTableModel) tb_bobstCoated.getModel();
        dados.setNumRows(0);
        for (BobstCoated c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getGrm_cartao(),
                c.getPertinax(),
                c.getFresa1(),
                c.getFresa2()
            });

        }
    }

    //Metodo listar CartonCoated
    public void listarCartonCoated() {
        CartonCoatedDAO dao = new CartonCoatedDAO();
        List<CartonCoated> lista = dao.listarCartonCoated();
        DefaultTableModel dados = (DefaultTableModel) tb_cartonCoated.getModel();
        dados.setNumRows(0);
        for (CartonCoated c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getFaca(),
                c.getNome(),
                c.getGrm_cartao(),
                c.getUv(),
                c.getPertinax(),
                c.getFresa1(),
                c.getFresa2(),
                c.getObservacao()
            });

        }
    }

    //Metodo listar CartonLaminado
    public void listarCartonLaminado() {
        CartonLaminadoDAO dao = new CartonLaminadoDAO();
        List<CartonLaminado> lista = dao.listarCartonLaminado();
        DefaultTableModel dados = (DefaultTableModel) tb_cartonLaminado.getModel();
        dados.setNumRows(0);
        for (CartonLaminado c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getFaca(),
                c.getNome(),
                c.getGrm_cartao(),
                c.getGrm_laminado(),
                c.getGrm_total(),
                c.getUv(),
                c.getPertinax(),
                c.getFresa1(),
                c.getFresa2(),
                c.getObservacao()
            });

        }
    }

    //Metodo listar CartonAcoplado
    public void listarCartonAcoplado() {
        CartonAcopladoDAO dao = new CartonAcopladoDAO();
        List<CartonAcoplado> lista = dao.listarCartonAcoplado();
        DefaultTableModel dados = (DefaultTableModel) tb_cartonAcoplado.getModel();
        dados.setNumRows(0);
        for (CartonAcoplado c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getFaca(),
                c.getNome(),
                c.getGrm_cartao1(),
                c.getGrm_cartao2(),
                c.getGrm_total(),
                c.getUv(),
                c.getPertinax(),
                c.getFresa1(),
                c.getFresa2(),
                c.getObservacao()
            });

        }
    }

    //Metodo listar GerenciaCartao
    public void listarGerenciaCartao() {
        GerenciaCartaoDAO dao = new GerenciaCartaoDAO();
        List<GerenciaCartao> lista = dao.listarGerenciaCartao();
        DefaultTableModel dados = (DefaultTableModel) tb_gerenciaCartao.getModel();
        dados.setNumRows(0);
        for (GerenciaCartao c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),});

        }
    }

    //Personalizar cabeçalho da tabela bobstCoated
    public void Personalizartb_bobstCoated() {
        JTableHeader bobstCoated = tb_bobstCoated.getTableHeader();
        bobstCoated.setBackground(Color.black);
        bobstCoated.setFont(new Font("Tahoma", 1, 14));
        ((DefaultTableCellRenderer) bobstCoated.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    //Personalizar cabeçalho da tabela cartonCoated
    public void Personalizartb_cartonCoated() {
        JTableHeader cartonCoated = tb_cartonCoated.getTableHeader();
        cartonCoated.setBackground(Color.black);
        cartonCoated.setFont(new Font("Tahoma", 1, 14));
        ((DefaultTableCellRenderer) cartonCoated.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    //Personalizar cabeçalho da tabela cartonLaminado
    public void Personalizartb_cartonLaminado() {
        JTableHeader cartonLaminado = tb_cartonLaminado.getTableHeader();
        cartonLaminado.setBackground(Color.black);
        cartonLaminado.setFont(new Font("Tahoma", 1, 14));
        ((DefaultTableCellRenderer) cartonLaminado.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    //Personalizar cabeçalho da tabela cartonAcoplado
    public void Personalizartb_cartonAcoplado() {
        JTableHeader cartonAcoplado = tb_cartonAcoplado.getTableHeader();
        cartonAcoplado.setBackground(Color.black);
        cartonAcoplado.setFont(new Font("Tahoma", 1, 14));
        ((DefaultTableCellRenderer) cartonAcoplado.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    //Personalizar cabeçalho da tabela gerenciaCartao
    public void Personalizartb_gerenciaCartao() {
        JTableHeader gerenciaCartao = tb_gerenciaCartao.getTableHeader();
        gerenciaCartao.setBackground(Color.black);
        gerenciaCartao.setFont(new Font("Tahoma", 1, 14));
        ((DefaultTableCellRenderer) gerenciaCartao.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    int eixox;
    int eixoy;

    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);

        Personalizartb_bobstCoated();
        Personalizartb_cartonCoated();
        Personalizartb_cartonLaminado();
        Personalizartb_cartonAcoplado();
        Personalizartb_gerenciaCartao();

        Atualizarcbnomebobst();
        Atualizarcbnomecoated();
        Atualizarcbnomelaminado();
        Atualizarcbnomeacoplado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bobstCoated = new javax.swing.JTable();
        jPanel44 = new javax.swing.JPanel();
        txtpesquisanomebobst = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtpesquisagrmbobst = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_cartonCoated = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        txtpesquisafacacoated = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtpesquisanomecoated = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtpesquisagrmcoated = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_cartonLaminado = new javax.swing.JTable();
        jPanel54 = new javax.swing.JPanel();
        txtpesquisafacalaminado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtpesquisanomelaminado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtpesquisagrmlaminado = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_cartonAcoplado = new javax.swing.JTable();
        jPanel55 = new javax.swing.JPanel();
        txtpesquisafacaacoplado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtpesquisanomeacoplado = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtpesquisagrmacoplado = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        painel_cadastrar = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        txtfacacoated = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        cbnomecoated = new javax.swing.JComboBox();
        jPanel18 = new javax.swing.JPanel();
        cbuvcoated = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        txtpertinaxcoated = new javax.swing.JTextField();
        lPanel = new javax.swing.JPanel();
        txtfresa1coated = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        txtfresa2coated = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtobservacaocoated = new javax.swing.JTextArea();
        btncriarcoated = new javax.swing.JButton();
        btnalterarcoated = new javax.swing.JButton();
        btnexcluircoated = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        txtgrmcartaocoated = new javax.swing.JTextField();
        txtidcartaocoated = new javax.swing.JTextField();
        btnlimparcoated = new javax.swing.JButton();
        painel = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        txtfacalaminado = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        cbnomelaminado = new javax.swing.JComboBox();
        jPanel25 = new javax.swing.JPanel();
        txtgrmcartaolaminado = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        cbuvlaminado = new javax.swing.JComboBox<>();
        jPanel27 = new javax.swing.JPanel();
        txtpertinaxlaminado = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        txtfresa1laminado = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        txtfresa2laminado = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtobservacaolaminado = new javax.swing.JTextArea();
        jPanel31 = new javax.swing.JPanel();
        txtgrmlaminadolaminado = new javax.swing.JTextField();
        btncriarlaminado = new javax.swing.JButton();
        btnalterarlaminado = new javax.swing.JButton();
        btnexcluirlaminado = new javax.swing.JButton();
        txtidcartaolaminado = new javax.swing.JTextField();
        btnlimparlaminado = new javax.swing.JButton();
        painel2 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        txtfacaacoplado = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        cbnomeacoplado = new javax.swing.JComboBox();
        jPanel35 = new javax.swing.JPanel();
        txtgrmcartao1acoplado = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        txtgrmcartao2acoplado = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        cbuvacoplado = new javax.swing.JComboBox<>();
        jPanel39 = new javax.swing.JPanel();
        txtpertinaxacoplado = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        txtfresa1acoplado = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        txtfresa2acoplado = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtobservacaoacoplado = new javax.swing.JTextArea();
        btncriaracoplado = new javax.swing.JButton();
        btnalteraracoplado = new javax.swing.JButton();
        btnexcluiracoplado = new javax.swing.JButton();
        txtidcartaoacoplado = new javax.swing.JTextField();
        btnlimparacoplado = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        cbnomebobst = new javax.swing.JComboBox();
        jPanel46 = new javax.swing.JPanel();
        txtpertinaxbobst = new javax.swing.JTextField();
        jPanel47 = new javax.swing.JPanel();
        txtfresa1bobst = new javax.swing.JTextField();
        jPanel48 = new javax.swing.JPanel();
        txtfresa2bobst = new javax.swing.JTextField();
        btncriarbobst = new javax.swing.JButton();
        btnalterarbobst = new javax.swing.JButton();
        btnexcluirbobst = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        txtgrmcartaobobst = new javax.swing.JTextField();
        txtidcartaobobst = new javax.swing.JTextField();
        btnlimparbobst = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_gerenciaCartao = new javax.swing.JTable();
        jPanel50 = new javax.swing.JPanel();
        txtnomegerenciarcartao = new javax.swing.JTextField();
        btncriargerenciarcartao = new javax.swing.JButton();
        btnalterargerenciarcartao = new javax.swing.JButton();
        btnexcluirgerenciarcartao = new javax.swing.JButton();
        txtidgerenciarcartao = new javax.swing.JTextField();
        btnlimpargerenciarcartao = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lb_Minimizar = new javax.swing.JLabel();
        lb_Maximizar = new javax.swing.JLabel();
        lb_Fechar = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PertinaxApp 1.6");
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tb_bobstCoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_bobstCoated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Gramatura", "Pertinax", "Fresa1", "Fresa2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_bobstCoated.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_bobstCoated.setRowHeight(18);
        tb_bobstCoated.getTableHeader().setReorderingAllowed(false);
        tb_bobstCoated.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bobstCoatedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_bobstCoated);
        if (tb_bobstCoated.getColumnModel().getColumnCount() > 0) {
            tb_bobstCoated.getColumnModel().getColumn(0).setMinWidth(40);
            tb_bobstCoated.getColumnModel().getColumn(0).setPreferredWidth(40);
            tb_bobstCoated.getColumnModel().getColumn(0).setMaxWidth(40);
            tb_bobstCoated.getColumnModel().getColumn(2).setMinWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(2).setMaxWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(3).setMinWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(3).setPreferredWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(3).setMaxWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(4).setMinWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(4).setPreferredWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(4).setMaxWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(5).setMinWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(5).setPreferredWidth(200);
            tb_bobstCoated.getColumnModel().getColumn(5).setMaxWidth(200);
        }

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel44.setToolTipText("");
        jPanel44.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtpesquisanomebobst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisanomebobst.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisanomebobst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisanomebobstKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nome Cartão:");

        txtpesquisagrmbobst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisagrmbobst.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisagrmbobst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisagrmbobstKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Gramatura:");

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton18.setText("Limpar");
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisanomebobst, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisagrmbobst, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButton18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtpesquisanomebobst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addComponent(txtpesquisagrmbobst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel15)
                .addComponent(jButton18))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1343, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cartão Coated", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Lista Bobst", jPanel3);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tb_cartonCoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_cartonCoated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Faca", "Nome", "Gramatura", "UV", "Pertinax", "Fresa1", "Fresa2", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_cartonCoated.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_cartonCoated.setRowHeight(18);
        tb_cartonCoated.getTableHeader().setReorderingAllowed(false);
        tb_cartonCoated.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_cartonCoatedMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_cartonCoated);
        if (tb_cartonCoated.getColumnModel().getColumnCount() > 0) {
            tb_cartonCoated.getColumnModel().getColumn(0).setMinWidth(40);
            tb_cartonCoated.getColumnModel().getColumn(0).setPreferredWidth(40);
            tb_cartonCoated.getColumnModel().getColumn(0).setMaxWidth(40);
            tb_cartonCoated.getColumnModel().getColumn(1).setMinWidth(65);
            tb_cartonCoated.getColumnModel().getColumn(1).setPreferredWidth(65);
            tb_cartonCoated.getColumnModel().getColumn(1).setMaxWidth(65);
            tb_cartonCoated.getColumnModel().getColumn(2).setMinWidth(180);
            tb_cartonCoated.getColumnModel().getColumn(2).setPreferredWidth(180);
            tb_cartonCoated.getColumnModel().getColumn(2).setMaxWidth(180);
            tb_cartonCoated.getColumnModel().getColumn(3).setMinWidth(90);
            tb_cartonCoated.getColumnModel().getColumn(3).setPreferredWidth(90);
            tb_cartonCoated.getColumnModel().getColumn(3).setMaxWidth(90);
            tb_cartonCoated.getColumnModel().getColumn(4).setMinWidth(40);
            tb_cartonCoated.getColumnModel().getColumn(4).setPreferredWidth(40);
            tb_cartonCoated.getColumnModel().getColumn(4).setMaxWidth(40);
            tb_cartonCoated.getColumnModel().getColumn(5).setMinWidth(70);
            tb_cartonCoated.getColumnModel().getColumn(5).setPreferredWidth(70);
            tb_cartonCoated.getColumnModel().getColumn(5).setMaxWidth(70);
            tb_cartonCoated.getColumnModel().getColumn(6).setMinWidth(60);
            tb_cartonCoated.getColumnModel().getColumn(6).setPreferredWidth(60);
            tb_cartonCoated.getColumnModel().getColumn(6).setMaxWidth(60);
            tb_cartonCoated.getColumnModel().getColumn(7).setMinWidth(60);
            tb_cartonCoated.getColumnModel().getColumn(7).setPreferredWidth(60);
            tb_cartonCoated.getColumnModel().getColumn(7).setMaxWidth(60);
        }

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtpesquisafacacoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisafacacoated.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisafacacoated.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisafacacoatedKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Faca:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Nome Cartão:");

        txtpesquisanomecoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisanomecoated.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisanomecoated.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisanomecoatedKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("Gramatura:");

        txtpesquisagrmcoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisagrmcoated.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisagrmcoated.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisagrmcoatedKeyPressed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton19.setText("Limpar");
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisafacacoated, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisanomecoated, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisagrmcoated, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtpesquisafacacoated, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpesquisanomecoated, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpesquisagrmcoated, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.Alignment.CENTER))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1343, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Cartão Coated", jPanel7);

        tb_cartonLaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_cartonLaminado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Faca", "Nome", "Grm. Cart.", "Grm. Lamin.", "Grm. Total", "UV", "Pertinax", "Fresa1", "Fresa2", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_cartonLaminado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_cartonLaminado.setRowHeight(18);
        tb_cartonLaminado.getTableHeader().setReorderingAllowed(false);
        tb_cartonLaminado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_cartonLaminadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_cartonLaminado);
        if (tb_cartonLaminado.getColumnModel().getColumnCount() > 0) {
            tb_cartonLaminado.getColumnModel().getColumn(0).setMinWidth(40);
            tb_cartonLaminado.getColumnModel().getColumn(0).setPreferredWidth(40);
            tb_cartonLaminado.getColumnModel().getColumn(0).setMaxWidth(40);
            tb_cartonLaminado.getColumnModel().getColumn(1).setMinWidth(65);
            tb_cartonLaminado.getColumnModel().getColumn(1).setPreferredWidth(65);
            tb_cartonLaminado.getColumnModel().getColumn(1).setMaxWidth(65);
            tb_cartonLaminado.getColumnModel().getColumn(2).setMinWidth(180);
            tb_cartonLaminado.getColumnModel().getColumn(2).setPreferredWidth(180);
            tb_cartonLaminado.getColumnModel().getColumn(2).setMaxWidth(180);
            tb_cartonLaminado.getColumnModel().getColumn(3).setMinWidth(90);
            tb_cartonLaminado.getColumnModel().getColumn(3).setPreferredWidth(90);
            tb_cartonLaminado.getColumnModel().getColumn(3).setMaxWidth(90);
            tb_cartonLaminado.getColumnModel().getColumn(4).setMinWidth(100);
            tb_cartonLaminado.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_cartonLaminado.getColumnModel().getColumn(4).setMaxWidth(100);
            tb_cartonLaminado.getColumnModel().getColumn(5).setMinWidth(90);
            tb_cartonLaminado.getColumnModel().getColumn(5).setPreferredWidth(90);
            tb_cartonLaminado.getColumnModel().getColumn(5).setMaxWidth(90);
            tb_cartonLaminado.getColumnModel().getColumn(6).setMinWidth(40);
            tb_cartonLaminado.getColumnModel().getColumn(6).setPreferredWidth(40);
            tb_cartonLaminado.getColumnModel().getColumn(6).setMaxWidth(40);
            tb_cartonLaminado.getColumnModel().getColumn(7).setMinWidth(70);
            tb_cartonLaminado.getColumnModel().getColumn(7).setPreferredWidth(70);
            tb_cartonLaminado.getColumnModel().getColumn(7).setMaxWidth(70);
            tb_cartonLaminado.getColumnModel().getColumn(8).setMinWidth(60);
            tb_cartonLaminado.getColumnModel().getColumn(8).setPreferredWidth(60);
            tb_cartonLaminado.getColumnModel().getColumn(8).setMaxWidth(60);
            tb_cartonLaminado.getColumnModel().getColumn(9).setMinWidth(60);
            tb_cartonLaminado.getColumnModel().getColumn(9).setPreferredWidth(60);
            tb_cartonLaminado.getColumnModel().getColumn(9).setMaxWidth(60);
        }

        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtpesquisafacalaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisafacalaminado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisafacalaminado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisafacalaminadoKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Faca:");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Nome Cartão:");

        txtpesquisanomelaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisanomelaminado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisanomelaminado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisanomelaminadoKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Grm. Cart.:");

        txtpesquisagrmlaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisagrmlaminado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisagrmlaminado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisagrmlaminadoKeyPressed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton20.setText("Limpar");
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisafacalaminado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisanomelaminado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisagrmlaminado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButton20)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton20, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(txtpesquisagrmlaminado, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(txtpesquisanomelaminado, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtpesquisafacalaminado, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.CENTER)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1343, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Cartão Laminado", jPanel8);

        tb_cartonAcoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_cartonAcoplado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Faca", "Nome", "Grm. Cart.1", "Grm. Cart.2", "Grm. Total", "UV", "Pertinax", "Fresa1", "Fresa2", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_cartonAcoplado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_cartonAcoplado.setRowHeight(18);
        tb_cartonAcoplado.getTableHeader().setReorderingAllowed(false);
        tb_cartonAcoplado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_cartonAcopladoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_cartonAcoplado);
        if (tb_cartonAcoplado.getColumnModel().getColumnCount() > 0) {
            tb_cartonAcoplado.getColumnModel().getColumn(0).setMinWidth(40);
            tb_cartonAcoplado.getColumnModel().getColumn(0).setPreferredWidth(40);
            tb_cartonAcoplado.getColumnModel().getColumn(0).setMaxWidth(40);
            tb_cartonAcoplado.getColumnModel().getColumn(1).setMinWidth(65);
            tb_cartonAcoplado.getColumnModel().getColumn(1).setPreferredWidth(65);
            tb_cartonAcoplado.getColumnModel().getColumn(1).setMaxWidth(65);
            tb_cartonAcoplado.getColumnModel().getColumn(2).setMinWidth(180);
            tb_cartonAcoplado.getColumnModel().getColumn(2).setPreferredWidth(180);
            tb_cartonAcoplado.getColumnModel().getColumn(2).setMaxWidth(180);
            tb_cartonAcoplado.getColumnModel().getColumn(3).setMinWidth(90);
            tb_cartonAcoplado.getColumnModel().getColumn(3).setPreferredWidth(90);
            tb_cartonAcoplado.getColumnModel().getColumn(3).setMaxWidth(90);
            tb_cartonAcoplado.getColumnModel().getColumn(4).setMinWidth(90);
            tb_cartonAcoplado.getColumnModel().getColumn(4).setPreferredWidth(90);
            tb_cartonAcoplado.getColumnModel().getColumn(4).setMaxWidth(90);
            tb_cartonAcoplado.getColumnModel().getColumn(5).setMinWidth(90);
            tb_cartonAcoplado.getColumnModel().getColumn(5).setPreferredWidth(90);
            tb_cartonAcoplado.getColumnModel().getColumn(5).setMaxWidth(90);
            tb_cartonAcoplado.getColumnModel().getColumn(6).setMinWidth(40);
            tb_cartonAcoplado.getColumnModel().getColumn(6).setPreferredWidth(40);
            tb_cartonAcoplado.getColumnModel().getColumn(6).setMaxWidth(40);
            tb_cartonAcoplado.getColumnModel().getColumn(7).setMinWidth(70);
            tb_cartonAcoplado.getColumnModel().getColumn(7).setPreferredWidth(70);
            tb_cartonAcoplado.getColumnModel().getColumn(7).setMaxWidth(70);
            tb_cartonAcoplado.getColumnModel().getColumn(8).setMinWidth(60);
            tb_cartonAcoplado.getColumnModel().getColumn(8).setPreferredWidth(60);
            tb_cartonAcoplado.getColumnModel().getColumn(8).setMaxWidth(60);
            tb_cartonAcoplado.getColumnModel().getColumn(9).setMinWidth(60);
            tb_cartonAcoplado.getColumnModel().getColumn(9).setPreferredWidth(60);
            tb_cartonAcoplado.getColumnModel().getColumn(9).setMaxWidth(60);
        }

        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtpesquisafacaacoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisafacaacoplado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisafacaacoplado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisafacaacopladoKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Faca:");

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("Nome Cartão:");

        txtpesquisanomeacoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisanomeacoplado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisanomeacoplado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisanomeacopladoKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setText("Grm. Cart.1:");

        txtpesquisagrmacoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpesquisagrmacoplado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpesquisagrmacoplado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisagrmacopladoKeyPressed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.setText("Limpar");
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisafacaacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisanomeacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisagrmacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(txtpesquisafacaacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpesquisanomeacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtpesquisagrmacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Cartão Acoplado", jPanel9);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Lista CartonDruck", jPanel4);

        painel_cadastrar.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        painel_cadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Faca", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfacacoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfacacoated.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfacacoated.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfacacoatedKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfacacoated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfacacoated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nome Cartão", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel16.setPreferredSize(new java.awt.Dimension(207, 48));

        cbnomecoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnomecoated.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbnomecoated, 0, 195, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(cbnomecoated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tratamento UV", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cbuvcoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbuvcoated.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "Sim", "Não" }));
        cbuvcoated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbuvcoatedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbuvcoated, javax.swing.GroupLayout.Alignment.TRAILING, 0, 113, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(cbuvcoated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pertinax", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtpertinaxcoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpertinaxcoated.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtpertinaxcoated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtpertinaxcoated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fresa 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfresa1coated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfresa1coated.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout lPanelLayout = new javax.swing.GroupLayout(lPanel);
        lPanel.setLayout(lPanelLayout);
        lPanelLayout.setHorizontalGroup(
            lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa1coated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        lPanelLayout.setVerticalGroup(
            lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa1coated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fresa 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfresa2coated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfresa2coated.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa2coated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa2coated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Observação", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtobservacaocoated.setColumns(20);
        txtobservacaocoated.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtobservacaocoated.setLineWrap(true);
        txtobservacaocoated.setRows(5);
        jScrollPane5.setViewportView(txtobservacaocoated);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btncriarcoated.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncriarcoated.setText("Criar");
        btncriarcoated.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncriarcoated.setEnabled(false);
        btncriarcoated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncriarcoatedActionPerformed(evt);
            }
        });

        btnalterarcoated.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnalterarcoated.setText("Alterar");
        btnalterarcoated.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnalterarcoated.setEnabled(false);
        btnalterarcoated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarcoatedActionPerformed(evt);
            }
        });

        btnexcluircoated.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnexcluircoated.setText("Excluir");
        btnexcluircoated.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnexcluircoated.setEnabled(false);
        btnexcluircoated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluircoatedActionPerformed(evt);
            }
        });

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gramatura Cartão", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtgrmcartaocoated.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgrmcartaocoated.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtgrmcartaocoated, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtgrmcartaocoated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtidcartaocoated.setEditable(false);
        txtidcartaocoated.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtidcartaocoated.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtidcartaocoated.setBorder(null);
        txtidcartaocoated.setFocusable(false);

        btnlimparcoated.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlimparcoated.setText("Limpar");
        btnlimparcoated.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlimparcoated.setEnabled(false);
        btnlimparcoated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparcoatedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(btncriarcoated, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnalterarcoated, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnexcluircoated, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnlimparcoated, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(308, 1042, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtidcartaocoated, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtidcartaocoated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncriarcoated, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnalterarcoated, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnexcluircoated, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlimparcoated)
                        .addContainerGap())))
        );

        painel_cadastrar.addTab("Cartão Coated", jPanel10);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Faca", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfacalaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfacalaminado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfacalaminado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfacalaminadoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfacalaminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfacalaminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nome Cartão", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cbnomelaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnomelaminado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*" }));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbnomelaminado, 0, 195, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(cbnomelaminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gramatura Cartão", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtgrmcartaolaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgrmcartaolaminado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtgrmcartaolaminado, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtgrmcartaolaminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tratamento UV", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cbuvlaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbuvlaminado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "Sim", "Não" }));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbuvlaminado, javax.swing.GroupLayout.Alignment.TRAILING, 0, 113, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(cbuvlaminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pertinax", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtpertinaxlaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpertinaxlaminado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtpertinaxlaminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtpertinaxlaminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fresa 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfresa1laminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfresa1laminado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa1laminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa1laminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fresa 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfresa2laminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfresa2laminado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa2laminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa2laminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Observação", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtobservacaolaminado.setColumns(20);
        txtobservacaolaminado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtobservacaolaminado.setLineWrap(true);
        txtobservacaolaminado.setRows(5);
        jScrollPane6.setViewportView(txtobservacaolaminado);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gramatura Laminação", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtgrmlaminadolaminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgrmlaminadolaminado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtgrmlaminadolaminado, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtgrmlaminadolaminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btncriarlaminado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncriarlaminado.setText("Criar");
        btncriarlaminado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncriarlaminado.setEnabled(false);
        btncriarlaminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncriarlaminadoActionPerformed(evt);
            }
        });

        btnalterarlaminado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnalterarlaminado.setText("Alterar");
        btnalterarlaminado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnalterarlaminado.setEnabled(false);
        btnalterarlaminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarlaminadoActionPerformed(evt);
            }
        });

        btnexcluirlaminado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnexcluirlaminado.setText("Excluir");
        btnexcluirlaminado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnexcluirlaminado.setEnabled(false);
        btnexcluirlaminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirlaminadoActionPerformed(evt);
            }
        });

        txtidcartaolaminado.setEditable(false);
        txtidcartaolaminado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtidcartaolaminado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtidcartaolaminado.setBorder(null);
        txtidcartaolaminado.setFocusable(false);

        btnlimparlaminado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlimparlaminado.setText("Limpar");
        btnlimparlaminado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlimparlaminado.setEnabled(false);
        btnlimparlaminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparlaminadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(btncriarlaminado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnalterarlaminado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnexcluirlaminado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(1010, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtidcartaolaminado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(btnlimparlaminado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncriarlaminado)
                    .addComponent(btnalterarlaminado)
                    .addComponent(btnexcluirlaminado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlimparlaminado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtidcartaolaminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painel_cadastrar.addTab("Cartão Laminado", painel);

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Faca", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfacaacoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfacaacoplado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfacaacoplado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfacaacopladoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfacaacoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfacaacoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nome Cartão", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cbnomeacoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnomeacoplado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*" }));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbnomeacoplado, 0, 195, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(cbnomeacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gramatura Cartão 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtgrmcartao1acoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgrmcartao1acoplado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtgrmcartao1acoplado, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtgrmcartao1acoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gramatura Cartão 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtgrmcartao2acoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgrmcartao2acoplado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtgrmcartao2acoplado, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtgrmcartao2acoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tratamento UV", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cbuvacoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbuvacoplado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "Sim", "Não" }));
        cbuvacoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbuvacopladoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbuvacoplado, javax.swing.GroupLayout.Alignment.TRAILING, 0, 113, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(cbuvacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pertinax", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtpertinaxacoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpertinaxacoplado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtpertinaxacoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtpertinaxacoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fresa 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfresa1acoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfresa1acoplado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa1acoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa1acoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fresa 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfresa2acoplado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfresa2acoplado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa2acoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa2acoplado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Observação", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtobservacaoacoplado.setColumns(20);
        txtobservacaoacoplado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtobservacaoacoplado.setLineWrap(true);
        txtobservacaoacoplado.setRows(5);
        jScrollPane7.setViewportView(txtobservacaoacoplado);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btncriaracoplado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncriaracoplado.setText("Criar");
        btncriaracoplado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncriaracoplado.setEnabled(false);
        btncriaracoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncriaracopladoActionPerformed(evt);
            }
        });

        btnalteraracoplado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnalteraracoplado.setText("Alterar");
        btnalteraracoplado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnalteraracoplado.setEnabled(false);
        btnalteraracoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalteraracopladoActionPerformed(evt);
            }
        });

        btnexcluiracoplado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnexcluiracoplado.setText("Excluir");
        btnexcluiracoplado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnexcluiracoplado.setEnabled(false);
        btnexcluiracoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluiracopladoActionPerformed(evt);
            }
        });

        txtidcartaoacoplado.setEditable(false);
        txtidcartaoacoplado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtidcartaoacoplado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtidcartaoacoplado.setBorder(null);
        txtidcartaoacoplado.setFocusable(false);

        btnlimparacoplado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlimparacoplado.setText("Limpar");
        btnlimparacoplado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlimparacoplado.setEnabled(false);
        btnlimparacoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparacopladoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel2Layout = new javax.swing.GroupLayout(painel2);
        painel2.setLayout(painel2Layout);
        painel2Layout.setHorizontalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painel2Layout.createSequentialGroup()
                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painel2Layout.createSequentialGroup()
                                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painel2Layout.createSequentialGroup()
                                .addComponent(btncriaracoplado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnalteraracoplado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnexcluiracoplado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(1010, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtidcartaoacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addComponent(btnlimparacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painel2Layout.setVerticalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncriaracoplado)
                    .addComponent(btnalteraracoplado)
                    .addComponent(btnexcluiracoplado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlimparacoplado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtidcartaoacoplado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painel_cadastrar.addTab("Cartão Acoplado", painel2);

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nome Cartão", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cbnomebobst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnomebobst.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*" }));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbnomebobst, 0, 195, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(cbnomebobst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pertinax", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtpertinaxbobst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpertinaxbobst.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtpertinaxbobst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtpertinaxbobst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fresa 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfresa1bobst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfresa1bobst.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa1bobst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa1bobst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fresa 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtfresa2bobst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfresa2bobst.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa2bobst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfresa2bobst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btncriarbobst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncriarbobst.setText("Criar");
        btncriarbobst.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncriarbobst.setEnabled(false);
        btncriarbobst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncriarbobstActionPerformed(evt);
            }
        });

        btnalterarbobst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnalterarbobst.setText("Alterar");
        btnalterarbobst.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnalterarbobst.setEnabled(false);
        btnalterarbobst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarbobstActionPerformed(evt);
            }
        });

        btnexcluirbobst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnexcluirbobst.setText("Excluir");
        btnexcluirbobst.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnexcluirbobst.setEnabled(false);
        btnexcluirbobst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirbobstActionPerformed(evt);
            }
        });

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gramatura Cartão", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtgrmcartaobobst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgrmcartaobobst.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtgrmcartaobobst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtgrmcartaobobstKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtgrmcartaobobst, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtgrmcartaobobst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtidcartaobobst.setEditable(false);
        txtidcartaobobst.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtidcartaobobst.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtidcartaobobst.setBorder(null);
        txtidcartaobobst.setFocusable(false);

        btnlimparbobst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlimparbobst.setText("Limpar");
        btnlimparbobst.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlimparbobst.setEnabled(false);
        btnlimparbobst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparbobstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtidcartaobobst, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btncriarbobst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnalterarbobst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnexcluirbobst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnlimparbobst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1085, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncriarbobst)
                    .addComponent(btnalterarbobst)
                    .addComponent(btnexcluirbobst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlimparbobst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(txtidcartaobobst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painel_cadastrar.addTab("Padrão Bobst", jPanel13);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_cadastrar)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_cadastrar)
        );

        jTabbedPane1.addTab("Cadastrar", jPanel5);

        jTabbedPane5.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tb_gerenciaCartao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_gerenciaCartao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cartões Cadastrado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_gerenciaCartao.setToolTipText("");
        tb_gerenciaCartao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_gerenciaCartao.setMinimumSize(new java.awt.Dimension(35, 0));
        tb_gerenciaCartao.setName(""); // NOI18N
        tb_gerenciaCartao.setRowHeight(18);
        tb_gerenciaCartao.getTableHeader().setReorderingAllowed(false);
        tb_gerenciaCartao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_gerenciaCartaoMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tb_gerenciaCartao);
        if (tb_gerenciaCartao.getColumnModel().getColumnCount() > 0) {
            tb_gerenciaCartao.getColumnModel().getColumn(0).setMinWidth(40);
            tb_gerenciaCartao.getColumnModel().getColumn(0).setPreferredWidth(40);
            tb_gerenciaCartao.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nome Cartão", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtnomegerenciarcartao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnomegerenciarcartao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnomegerenciarcartao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnomegerenciarcartaoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtnomegerenciarcartao, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtnomegerenciarcartao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btncriargerenciarcartao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncriargerenciarcartao.setText("Criar");
        btncriargerenciarcartao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncriargerenciarcartao.setEnabled(false);
        btncriargerenciarcartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncriargerenciarcartaoActionPerformed(evt);
            }
        });

        btnalterargerenciarcartao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnalterargerenciarcartao.setText("Alterar");
        btnalterargerenciarcartao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnalterargerenciarcartao.setEnabled(false);
        btnalterargerenciarcartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterargerenciarcartaoActionPerformed(evt);
            }
        });

        btnexcluirgerenciarcartao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnexcluirgerenciarcartao.setText("Excluir");
        btnexcluirgerenciarcartao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnexcluirgerenciarcartao.setEnabled(false);
        btnexcluirgerenciarcartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirgerenciarcartaoActionPerformed(evt);
            }
        });

        txtidgerenciarcartao.setEditable(false);
        txtidgerenciarcartao.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtidgerenciarcartao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtidgerenciarcartao.setBorder(null);
        txtidgerenciarcartao.setFocusable(false);

        btnlimpargerenciarcartao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlimpargerenciarcartao.setText("Limpar");
        btnlimpargerenciarcartao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlimpargerenciarcartao.setEnabled(false);
        btnlimpargerenciarcartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpargerenciarcartaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidgerenciarcartao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addGroup(jPanel49Layout.createSequentialGroup()
                                    .addComponent(btncriargerenciarcartao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnalterargerenciarcartao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnexcluirgerenciarcartao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnlimpargerenciarcartao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncriargerenciarcartao)
                    .addComponent(btnalterargerenciarcartao)
                    .addComponent(btnexcluirgerenciarcartao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlimpargerenciarcartao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtidgerenciarcartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Gerenciar Cartão", jPanel49);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Icone_P_menor.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel5.setText("PertinaxApp 1.6");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Programa para cadastro de Pertinax");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Software Livre");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Desenvolvido por:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MarcosAlsleben.gif"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("2021");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Sobre", jPanel11);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        jTabbedPane1.addTab("Menu", jPanel14);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel17.setBackground(new java.awt.Color(102, 102, 102));
        jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel17MouseDragged(evt);
            }
        });
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel17MousePressed(evt);
            }
        });

        lb_Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Minimizar.png"))); // NOI18N
        lb_Minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_Minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_MinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_MinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_MinimizarMouseExited(evt);
            }
        });

        lb_Maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaximizarMais.png"))); // NOI18N
        lb_Maximizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_Maximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_MaximizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_MaximizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_MaximizarMouseExited(evt);
            }
        });

        lb_Fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fechar.png"))); // NOI18N
        lb_Fechar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_Fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_FecharMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_FecharMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_FecharMouseExited(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("PertinaxApp 1.6");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_Minimizar)
                .addGap(4, 4, 4)
                .addComponent(lb_Maximizar)
                .addGap(4, 4, 4)
                .addComponent(lb_Fechar))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_Minimizar)
                        .addComponent(lb_Maximizar)
                        .addComponent(lb_Fechar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        setSize(new java.awt.Dimension(1365, 705));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncriarlaminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncriarlaminadoActionPerformed

        // botao Criar Laminado
        CartonLaminado obj = new CartonLaminado();

        if ("".equals(txtgrmcartaolaminado.getText())) {
            txtgrmcartaolaminado.setText("0");
        }

        if ("".equals(txtgrmlaminadolaminado.getText())) {
            txtgrmlaminadolaminado.setText("0");
        }
        if ("".equals(txtpertinaxlaminado.getText())) {
            txtpertinaxlaminado.setText("0");
        }
        if ("".equals(txtfresa1laminado.getText())) {
            txtfresa1laminado.setText("0");
        }
        if ("".equals(txtfresa2laminado.getText())) {
            txtfresa2laminado.setText("0");
        }

        obj.setFaca(txtfacalaminado.getText());
        obj.setNome(cbnomelaminado.getSelectedItem().toString());
        obj.setGrm_cartao(Integer.parseInt(txtgrmcartaolaminado.getText()));
        obj.setGrm_laminado(Integer.parseInt(txtgrmlaminadolaminado.getText()));
        obj.setGrm_total(Integer.parseInt(txtgrmcartaolaminado.getText()) + Integer.parseInt(txtgrmlaminadolaminado.getText()));
        obj.setUv(cbuvlaminado.getSelectedItem().toString());
        obj.setPertinax(Float.parseFloat(txtpertinaxlaminado.getText().replace(",", ".")));
        obj.setFresa1(Float.parseFloat(txtfresa1laminado.getText().replace(",", ".")));
        obj.setFresa2(Float.parseFloat(txtfresa2laminado.getText().replace(",", ".")));
        obj.setObservacao(txtobservacaolaminado.getText());

        CartonLaminadoDAO dao = new CartonLaminadoDAO();

        dao.cadastrarLaminado(obj);

        //Limpa os paineis
        txtfacalaminado.setText(null);
        cbnomelaminado.setSelectedItem("*");
        txtgrmcartaolaminado.setText(null);
        txtgrmlaminadolaminado.setText(null);
        cbuvlaminado.setSelectedItem("*");
        txtpertinaxlaminado.setText(null);
        txtfresa1laminado.setText(null);
        txtfresa2laminado.setText(null);
        txtobservacaolaminado.setText(null);
        txtidcartaolaminado.setText(null);

        //desabilita botões
        btncriarlaminado.setEnabled(false);
        btnalterarlaminado.setEnabled(false);
        btnlimparlaminado.setEnabled(false);
        btnexcluirlaminado.setEnabled(false);
    }//GEN-LAST:event_btncriarlaminadoActionPerformed

    private void btncriarcoatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncriarcoatedActionPerformed

        // botao Criar Coated
        CartonCoated obj = new CartonCoated();

        if ("".equals(txtgrmcartaocoated.getText())) {
            txtgrmcartaocoated.setText("0");
        }
        if ("".equals(txtpertinaxcoated.getText())) {
            txtpertinaxcoated.setText("0");
        }
        if ("".equals(txtfresa1coated.getText())) {
            txtfresa1coated.setText("0");
        }
        if ("".equals(txtfresa2coated.getText())) {
            txtfresa2coated.setText("0");
        }

        obj.setFaca(txtfacacoated.getText());
        obj.setNome(cbnomecoated.getSelectedItem().toString());
        obj.setGrm_cartao(Integer.parseInt(txtgrmcartaocoated.getText()));
        obj.setUv(cbuvcoated.getSelectedItem().toString());
        obj.setPertinax(Float.parseFloat(txtpertinaxcoated.getText().replace(",", ".")));
        obj.setFresa1(Float.parseFloat(txtfresa1coated.getText().replace(",", ".")));
        obj.setFresa2(Float.parseFloat(txtfresa2coated.getText().replace(",", ".")));
        obj.setObservacao(txtobservacaocoated.getText());

        CartonCoatedDAO dao = new CartonCoatedDAO();

        dao.cadastrarCoated(obj);

        //Limpa os paineis
        txtfacacoated.setText(null);
        cbnomecoated.setSelectedItem("*");
        txtgrmcartaocoated.setText(null);
        cbuvcoated.setSelectedItem("*");
        txtpertinaxcoated.setText(null);
        txtfresa1coated.setText(null);
        txtfresa2coated.setText(null);
        txtobservacaocoated.setText(null);
        txtidcartaocoated.setText(null);

        //desabilita botões
        btncriarcoated.setEnabled(false);
        btnalterarcoated.setEnabled(false);
        btnlimparcoated.setEnabled(false);
        btnexcluircoated.setEnabled(false);

    }//GEN-LAST:event_btncriarcoatedActionPerformed

    private void btncriaracopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncriaracopladoActionPerformed

        // botao Criar Acoplado
        CartonAcoplado obj = new CartonAcoplado();

        if ("".equals(txtgrmcartao1acoplado.getText())) {
            txtgrmcartao1acoplado.setText("0");
        }
        if ("".equals(txtgrmcartao2acoplado.getText())) {
            txtgrmcartao2acoplado.setText("0");
        }
        if ("".equals(txtpertinaxacoplado.getText())) {
            txtpertinaxacoplado.setText("0");
        }
        if ("".equals(txtfresa1acoplado.getText())) {
            txtfresa1acoplado.setText("0");
        }
        if ("".equals(txtfresa2acoplado.getText())) {
            txtfresa2acoplado.setText("0");
        }

        obj.setFaca(txtfacaacoplado.getText());
        obj.setNome(cbnomeacoplado.getSelectedItem().toString());
        obj.setGrm_cartao1(Integer.parseInt(txtgrmcartao1acoplado.getText()));
        obj.setGrm_cartao2(Integer.parseInt(txtgrmcartao2acoplado.getText()));
        obj.setGrm_total(Integer.parseInt(txtgrmcartao1acoplado.getText()) + Integer.parseInt(txtgrmcartao2acoplado.getText()));
        obj.setUv(cbuvacoplado.getSelectedItem().toString());
        obj.setPertinax(Float.parseFloat(txtpertinaxacoplado.getText().replace(",", ".")));
        obj.setFresa1(Float.parseFloat(txtfresa1acoplado.getText().replace(",", ".")));
        obj.setFresa2(Float.parseFloat(txtfresa2acoplado.getText().replace(",", ".")));
        obj.setObservacao(txtobservacaoacoplado.getText());

        CartonAcopladoDAO dao = new CartonAcopladoDAO();

        dao.cadastrarAcoplado(obj);

        //Limpa os paineis
        txtfacaacoplado.setText(null);
        cbnomeacoplado.setSelectedItem("*");
        txtgrmcartao1acoplado.setText(null);
        txtgrmcartao2acoplado.setText(null);
        cbuvacoplado.setSelectedItem("*");
        txtpertinaxacoplado.setText(null);
        txtfresa1acoplado.setText(null);
        txtfresa2acoplado.setText(null);
        txtobservacaoacoplado.setText(null);
        txtidcartaoacoplado.setText(null);

        //desabilita botões
        btncriaracoplado.setEnabled(false);
        btnalteraracoplado.setEnabled(false);
        btnlimparacoplado.setEnabled(false);
        btnexcluiracoplado.setEnabled(false);


    }//GEN-LAST:event_btncriaracopladoActionPerformed

    private void btncriarbobstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncriarbobstActionPerformed

        // botao Criar PadraoBobst
        BobstCoated obj = new BobstCoated();

        if ("".equals(txtgrmcartaobobst.getText())) {
            txtgrmcartaobobst.setText("0");
        }
        if ("".equals(txtpertinaxbobst.getText())) {
            txtpertinaxbobst.setText("0");
        }
        if ("".equals(txtfresa1bobst.getText())) {
            txtfresa1bobst.setText("0");
        }
        if ("".equals(txtfresa2bobst.getText())) {
            txtfresa2bobst.setText("0");
        }

        obj.setNome(cbnomebobst.getSelectedItem().toString());
        obj.setGrm_cartao(Integer.parseInt(txtgrmcartaobobst.getText()));
        obj.setPertinax(Float.parseFloat(txtpertinaxbobst.getText().replace(",", ".")));
        obj.setFresa1(Float.parseFloat(txtfresa1bobst.getText().replace(",", ".")));
        obj.setFresa2(Float.parseFloat(txtfresa2bobst.getText().replace(",", ".")));

        BobstCoatedDAO dao = new BobstCoatedDAO();

        dao.cadastrarBobst(obj);

        //Limpa os paineis        
        cbnomebobst.setSelectedItem("*");
        txtgrmcartaobobst.setText(null);
        txtpertinaxbobst.setText(null);
        txtfresa1bobst.setText(null);
        txtfresa2bobst.setText(null);
        txtidcartaobobst.setText(null);

        //desabilita botões
        btncriarbobst.setEnabled(false);
        btnalterarbobst.setEnabled(false);
        btnlimparbobst.setEnabled(false);
        btnexcluirbobst.setEnabled(false);

    }//GEN-LAST:event_btncriarbobstActionPerformed

    private void btncriargerenciarcartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncriargerenciarcartaoActionPerformed

        // botao Criar Cartao
        GerenciaCartao obj = new GerenciaCartao();

        obj.setNome(txtnomegerenciarcartao.getText());

        GerenciaCartaoDAO dao = new GerenciaCartaoDAO();

        dao.cadastrarCartao(obj);

        //Limpa os paineis        
        txtnomegerenciarcartao.setText(null);

        //habilitar e desabilitar botões
        btncriargerenciarcartao.setEnabled(false);
        btnexcluirgerenciarcartao.setEnabled(false);
        btnalterargerenciarcartao.setEnabled(false);
        btnlimpargerenciarcartao.setEnabled(false);

        Atualizarcbnomebobst();
        Atualizarcbnomecoated();
        Atualizarcbnomelaminado();
        Atualizarcbnomeacoplado();


    }//GEN-LAST:event_btncriargerenciarcartaoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listarBobstCoated();
        listarCartonCoated();
        listarCartonLaminado();
        listarCartonAcoplado();
        listarGerenciaCartao();
    }//GEN-LAST:event_formWindowActivated

    private void tb_gerenciaCartaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_gerenciaCartaoMouseClicked

        //Pega dados da tabela tb_gerenciaCartao com duplo click
        tb_gerenciaCartao.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    txtidgerenciarcartao.setText(tb_gerenciaCartao.getValueAt(tb_gerenciaCartao.getSelectedRow(), 0).toString());
                    txtnomegerenciarcartao.setText(tb_gerenciaCartao.getValueAt(tb_gerenciaCartao.getSelectedRow(), 1).toString());

                    //desabilita botões
                    btncriargerenciarcartao.setEnabled(false);
                    btnalterargerenciarcartao.setEnabled(false);
                    btnlimpargerenciarcartao.setEnabled(true);
                    btnexcluirgerenciarcartao.setEnabled(true);
                }
            }
        });
    }//GEN-LAST:event_tb_gerenciaCartaoMouseClicked

    private void tb_bobstCoatedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bobstCoatedMouseClicked

        //Pega dados da tabela tb_bobstCoated com duplo click        
        tb_bobstCoated.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    txtidcartaobobst.setText(tb_bobstCoated.getValueAt(tb_bobstCoated.getSelectedRow(), 0).toString());
                    cbnomebobst.addItem(tb_bobstCoated.getValueAt(tb_bobstCoated.getSelectedRow(), 1).toString());
                    cbnomebobst.setSelectedItem(tb_bobstCoated.getValueAt(tb_bobstCoated.getSelectedRow(), 1).toString());
                    txtgrmcartaobobst.setText(tb_bobstCoated.getValueAt(tb_bobstCoated.getSelectedRow(), 2).toString());
                    txtpertinaxbobst.setText(tb_bobstCoated.getValueAt(tb_bobstCoated.getSelectedRow(), 3).toString());
                    txtfresa1bobst.setText(tb_bobstCoated.getValueAt(tb_bobstCoated.getSelectedRow(), 4).toString());
                    txtfresa2bobst.setText(tb_bobstCoated.getValueAt(tb_bobstCoated.getSelectedRow(), 5).toString());

                    jTabbedPane1.setSelectedIndex(2);
                    painel_cadastrar.setSelectedIndex(3);

                    //desabilita botões
                    btncriarbobst.setEnabled(false);
                    btnalterarbobst.setEnabled(true);
                    btnlimparbobst.setEnabled(true);
                    btnexcluirbobst.setEnabled(true);
                }
            }
        });
    }//GEN-LAST:event_tb_bobstCoatedMouseClicked

    private void tb_cartonCoatedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_cartonCoatedMouseClicked

        //Pega dados da tabela tb_CartonCoated com duplo click        
        tb_cartonCoated.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    txtidcartaocoated.setText(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 0).toString());
                    txtfacacoated.setText(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 1).toString());
                    cbnomecoated.addItem(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 2).toString());
                    cbnomecoated.setSelectedItem(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 2).toString());
                    txtgrmcartaocoated.setText(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 3).toString());
                    cbuvcoated.setSelectedItem(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 4).toString());
                    txtpertinaxcoated.setText(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 5).toString());
                    txtfresa1coated.setText(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 6).toString());
                    txtfresa2coated.setText(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 7).toString());
                    txtobservacaocoated.setText(tb_cartonCoated.getValueAt(tb_cartonCoated.getSelectedRow(), 8).toString());

                    jTabbedPane1.setSelectedIndex(2);
                    painel_cadastrar.setSelectedIndex(0);

                    //desabilita botões
                    btncriarcoated.setEnabled(false);
                    btnalterarcoated.setEnabled(true);
                    btnlimparcoated.setEnabled(true);
                    btnexcluircoated.setEnabled(true);
                }
            }
        });
    }//GEN-LAST:event_tb_cartonCoatedMouseClicked

    private void tb_cartonLaminadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_cartonLaminadoMouseClicked

        //Pega dados da tabela tb_CartonLaminado com duplo click        
        tb_cartonLaminado.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    txtidcartaolaminado.setText(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 0).toString());
                    txtfacalaminado.setText(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 1).toString());
                    cbnomelaminado.addItem(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 2).toString());
                    cbnomelaminado.setSelectedItem(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 2).toString());
                    txtgrmcartaolaminado.setText(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 3).toString());
                    txtgrmlaminadolaminado.setText(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 4).toString());
                    cbuvlaminado.setSelectedItem(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 6).toString());
                    txtpertinaxlaminado.setText(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 7).toString());
                    txtfresa1laminado.setText(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 8).toString());
                    txtfresa2laminado.setText(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 9).toString());
                    txtobservacaolaminado.setText(tb_cartonLaminado.getValueAt(tb_cartonLaminado.getSelectedRow(), 10).toString());

                    jTabbedPane1.setSelectedIndex(2);
                    painel_cadastrar.setSelectedIndex(1);

                    //desabilita botões
                    btncriarlaminado.setEnabled(false);
                    btnalterarlaminado.setEnabled(true);
                    btnlimparlaminado.setEnabled(true);
                    btnexcluirlaminado.setEnabled(true);
                }
            }
        });
    }//GEN-LAST:event_tb_cartonLaminadoMouseClicked

    private void tb_cartonAcopladoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_cartonAcopladoMouseClicked

        //Pega dados da tabela tb_CartonAcoplado com duplo click        
        tb_cartonAcoplado.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    txtidcartaoacoplado.setText(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 0).toString());
                    txtfacaacoplado.setText(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 1).toString());
                    cbnomeacoplado.addItem(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 2).toString());
                    cbnomeacoplado.setSelectedItem(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 2).toString());
                    txtgrmcartao1acoplado.setText(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 3).toString());
                    txtgrmcartao2acoplado.setText(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 4).toString());
                    cbuvacoplado.setSelectedItem(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 6).toString());
                    txtpertinaxacoplado.setText(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 7).toString());
                    txtfresa1acoplado.setText(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 8).toString());
                    txtfresa2acoplado.setText(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 9).toString());
                    txtobservacaoacoplado.setText(tb_cartonAcoplado.getValueAt(tb_cartonAcoplado.getSelectedRow(), 10).toString());

                    jTabbedPane1.setSelectedIndex(2);
                    painel_cadastrar.setSelectedIndex(2);

                    //desabilita botões
                    btncriaracoplado.setEnabled(false);
                    btnalteraracoplado.setEnabled(true);
                    btnlimparacoplado.setEnabled(true);
                    btnexcluiracoplado.setEnabled(true);
                }
            }
        });
    }//GEN-LAST:event_tb_cartonAcopladoMouseClicked

    private void cbuvacopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbuvacopladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbuvacopladoActionPerformed

    private void btnalterarcoatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarcoatedActionPerformed

        // botao Alterar Coated
        CartonCoated obj = new CartonCoated();

        obj.setFaca(txtfacacoated.getText());
        obj.setNome(cbnomecoated.getSelectedItem().toString());
        obj.setGrm_cartao(Integer.parseInt(txtgrmcartaocoated.getText()));
        obj.setUv(cbuvcoated.getSelectedItem().toString());
        obj.setPertinax(Float.parseFloat(txtpertinaxcoated.getText().replace(",", ".")));
        obj.setFresa1(Float.parseFloat(txtfresa1coated.getText().replace(",", ".")));
        obj.setFresa2(Float.parseFloat(txtfresa2coated.getText().replace(",", ".")));
        obj.setObservacao(txtobservacaocoated.getText());
        obj.setId(Integer.parseInt(txtidcartaocoated.getText()));

        CartonCoatedDAO dao = new CartonCoatedDAO();

        dao.alterarCoated(obj);

        //Limpa os paineis
        txtfacacoated.setText(null);
        cbnomecoated.setSelectedItem("*");
        txtgrmcartaocoated.setText(null);
        cbuvcoated.setSelectedItem("*");
        txtpertinaxcoated.setText(null);
        txtfresa1coated.setText(null);
        txtfresa2coated.setText(null);
        txtobservacaocoated.setText(null);
        txtidcartaocoated.setText(null);

        //desabilita botões
        btncriarcoated.setEnabled(false);
        btnalterarcoated.setEnabled(false);
        btnlimparcoated.setEnabled(false);
        btnexcluircoated.setEnabled(false);
    }//GEN-LAST:event_btnalterarcoatedActionPerformed

    private void btnalterarlaminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarlaminadoActionPerformed

        // botao Alterar Laminado
        CartonLaminado obj = new CartonLaminado();

        if ("".equals(txtgrmcartaolaminado.getText())) {
            txtgrmcartaolaminado.setText("0");
        }

        if ("".equals(txtgrmlaminadolaminado.getText())) {
            txtgrmlaminadolaminado.setText("0");
        }

        obj.setFaca(txtfacalaminado.getText());
        obj.setNome(cbnomelaminado.getSelectedItem().toString());
        obj.setGrm_cartao(Integer.parseInt(txtgrmcartaolaminado.getText()));
        obj.setGrm_laminado(Integer.parseInt(txtgrmlaminadolaminado.getText()));
        obj.setGrm_total(Integer.parseInt(txtgrmcartaolaminado.getText()) + Integer.parseInt(txtgrmlaminadolaminado.getText()));
        obj.setUv(cbuvlaminado.getSelectedItem().toString());
        obj.setPertinax(Float.parseFloat(txtpertinaxlaminado.getText().replace(",", ".")));
        obj.setFresa1(Float.parseFloat(txtfresa1laminado.getText().replace(",", ".")));
        obj.setFresa2(Float.parseFloat(txtfresa2laminado.getText().replace(",", ".")));
        obj.setObservacao(txtobservacaolaminado.getText());
        obj.setId(Integer.parseInt(txtidcartaolaminado.getText()));

        CartonLaminadoDAO dao = new CartonLaminadoDAO();

        dao.alterarLaminado(obj);

        //Limpa os paineis
        txtfacalaminado.setText(null);
        cbnomelaminado.setSelectedItem("*");
        txtgrmcartaolaminado.setText(null);
        txtgrmlaminadolaminado.setText(null);
        cbuvlaminado.setSelectedItem("*");
        txtpertinaxlaminado.setText(null);
        txtfresa1laminado.setText(null);
        txtfresa2laminado.setText(null);
        txtobservacaolaminado.setText(null);
        txtidcartaolaminado.setText(null);

        //desabilita botões
        btncriarlaminado.setEnabled(false);
        btnalterarlaminado.setEnabled(false);
        btnlimparlaminado.setEnabled(false);
        btnexcluirlaminado.setEnabled(false);
    }//GEN-LAST:event_btnalterarlaminadoActionPerformed

    private void btnalteraracopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalteraracopladoActionPerformed

        // botao Alterar Acoplado
        CartonAcoplado obj = new CartonAcoplado();

        if ("".equals(txtgrmcartao1acoplado.getText())) {
            txtgrmcartao1acoplado.setText("0");
        }

        if ("".equals(txtgrmcartao2acoplado.getText())) {
            txtgrmcartao2acoplado.setText("0");
        }

        obj.setFaca(txtfacaacoplado.getText());
        obj.setNome(cbnomeacoplado.getSelectedItem().toString());
        obj.setGrm_cartao1(Integer.parseInt(txtgrmcartao1acoplado.getText()));
        obj.setGrm_cartao2(Integer.parseInt(txtgrmcartao2acoplado.getText()));
        obj.setGrm_total(Integer.parseInt(txtgrmcartao1acoplado.getText()) + Integer.parseInt(txtgrmcartao2acoplado.getText()));
        obj.setUv(cbuvacoplado.getSelectedItem().toString());
        obj.setPertinax(Float.parseFloat(txtpertinaxacoplado.getText().replace(",", ".")));
        obj.setFresa1(Float.parseFloat(txtfresa1acoplado.getText().replace(",", ".")));
        obj.setFresa2(Float.parseFloat(txtfresa2acoplado.getText().replace(",", ".")));
        obj.setObservacao(txtobservacaoacoplado.getText());
        obj.setId(Integer.parseInt(txtidcartaoacoplado.getText()));

        CartonAcopladoDAO dao = new CartonAcopladoDAO();

        dao.alterarAcoplado(obj);

        //Limpa os paineis
        txtfacaacoplado.setText(null);
        cbnomeacoplado.setSelectedItem("*");
        txtgrmcartao1acoplado.setText(null);
        txtgrmcartao2acoplado.setText(null);
        cbuvacoplado.setSelectedItem("*");
        txtpertinaxacoplado.setText(null);
        txtfresa1acoplado.setText(null);
        txtfresa2acoplado.setText(null);
        txtobservacaoacoplado.setText(null);
        txtidcartaoacoplado.setText(null);

        //desabilita botões
        btncriaracoplado.setEnabled(false);
        btnalteraracoplado.setEnabled(false);
        btnlimparacoplado.setEnabled(false);
        btnexcluiracoplado.setEnabled(false);
    }//GEN-LAST:event_btnalteraracopladoActionPerformed

    private void btnalterarbobstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarbobstActionPerformed

        // botao Alterar PadraoBobst
        BobstCoated obj = new BobstCoated();

        obj.setNome(cbnomebobst.getSelectedItem().toString());
        obj.setGrm_cartao(Integer.parseInt(txtgrmcartaobobst.getText()));
        obj.setPertinax(Float.parseFloat(txtpertinaxbobst.getText().replace(",", ".")));
        obj.setFresa1(Float.parseFloat(txtfresa1bobst.getText().replace(",", ".")));
        obj.setFresa2(Float.parseFloat(txtfresa2bobst.getText().replace(",", ".")));
        obj.setId(Integer.parseInt(txtidcartaobobst.getText()));

        BobstCoatedDAO dao = new BobstCoatedDAO();

        dao.alterarBobst(obj);

        //Limpa os paineis        
        cbnomebobst.setSelectedItem("*");
        txtgrmcartaobobst.setText(null);
        txtpertinaxbobst.setText(null);
        txtfresa1bobst.setText(null);
        txtfresa2bobst.setText(null);
        txtidcartaobobst.setText(null);

        //desabilita botões
        btncriarbobst.setEnabled(false);
        btnalterarbobst.setEnabled(false);
        btnlimparbobst.setEnabled(false);
        btnexcluirbobst.setEnabled(false);
    }//GEN-LAST:event_btnalterarbobstActionPerformed

    private void btnalterargerenciarcartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterargerenciarcartaoActionPerformed

        // botao Alterar Cartao
        GerenciaCartao obj = new GerenciaCartao();

        obj.setNome(txtnomegerenciarcartao.getText());
        obj.setId(Integer.parseInt(txtidgerenciarcartao.getText()));

        GerenciaCartaoDAO dao = new GerenciaCartaoDAO();

        dao.alterarCartao(obj);

        //Limpa os paineis        
        txtnomegerenciarcartao.setText(null);
        txtidgerenciarcartao.setText(null);

        //habilitar e desabilitar botões
        btncriargerenciarcartao.setEnabled(false);
        btnexcluirgerenciarcartao.setEnabled(false);
        btnalterargerenciarcartao.setEnabled(false);
        btnlimpargerenciarcartao.setEnabled(false);

        Atualizarcbnomebobst();
        Atualizarcbnomecoated();
        Atualizarcbnomelaminado();
        Atualizarcbnomeacoplado();
    }//GEN-LAST:event_btnalterargerenciarcartaoActionPerformed

    private void btnexcluircoatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluircoatedActionPerformed

        // botao Excluir Coated
        CartonCoated obj = new CartonCoated();

        obj.setId(Integer.parseInt(txtidcartaocoated.getText()));

        CartonCoatedDAO dao = new CartonCoatedDAO();

        dao.excluirCoated(obj);

        //Limpa os paineis
        txtfacacoated.setText(null);
        cbnomecoated.setSelectedItem("*");
        txtgrmcartaocoated.setText(null);
        cbuvcoated.setSelectedItem("*");
        txtpertinaxcoated.setText(null);
        txtfresa1coated.setText(null);
        txtfresa2coated.setText(null);
        txtobservacaocoated.setText(null);
        txtidcartaocoated.setText(null);

        //desabilita botões
        btncriarcoated.setEnabled(false);
        btnalterarcoated.setEnabled(false);
        btnlimparcoated.setEnabled(false);
        btnexcluircoated.setEnabled(false);
    }//GEN-LAST:event_btnexcluircoatedActionPerformed

    private void btnexcluirlaminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirlaminadoActionPerformed

        // botao Excluir Laminado
        CartonLaminado obj = new CartonLaminado();

        obj.setId(Integer.parseInt(txtidcartaolaminado.getText()));

        CartonLaminadoDAO dao = new CartonLaminadoDAO();

        dao.excluirLaminado(obj);

        //Limpa os paineis
        txtfacalaminado.setText(null);
        cbnomelaminado.setSelectedItem("*");
        txtgrmcartaolaminado.setText(null);
        txtgrmlaminadolaminado.setText(null);
        cbuvlaminado.setSelectedItem("*");
        txtpertinaxlaminado.setText(null);
        txtfresa1laminado.setText(null);
        txtfresa2laminado.setText(null);
        txtobservacaolaminado.setText(null);
        txtidcartaolaminado.setText(null);

        //desabilita botões
        btncriarlaminado.setEnabled(false);
        btnalterarlaminado.setEnabled(false);
        btnlimparlaminado.setEnabled(false);
        btnexcluirlaminado.setEnabled(false);
    }//GEN-LAST:event_btnexcluirlaminadoActionPerformed

    private void btnexcluiracopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluiracopladoActionPerformed

        // botao Excluir Acoplado
        CartonAcoplado obj = new CartonAcoplado();

        obj.setId(Integer.parseInt(txtidcartaoacoplado.getText()));

        CartonAcopladoDAO dao = new CartonAcopladoDAO();

        dao.excluirAcoplado(obj);

        //Limpa os paineis
        txtfacaacoplado.setText(null);
        cbnomeacoplado.setSelectedItem("*");
        txtgrmcartao1acoplado.setText(null);
        txtgrmcartao2acoplado.setText(null);
        cbuvacoplado.setSelectedItem("*");
        txtpertinaxacoplado.setText(null);
        txtfresa1acoplado.setText(null);
        txtfresa2acoplado.setText(null);
        txtobservacaoacoplado.setText(null);
        txtidcartaoacoplado.setText(null);

        //desabilita botões
        btncriaracoplado.setEnabled(false);
        btnalteraracoplado.setEnabled(false);
        btnlimparacoplado.setEnabled(false);
        btnexcluiracoplado.setEnabled(false);
    }//GEN-LAST:event_btnexcluiracopladoActionPerformed

    private void btnexcluirbobstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirbobstActionPerformed

        // botao Excluir PadraoBobst
        BobstCoated obj = new BobstCoated();

        obj.setId(Integer.parseInt(txtidcartaobobst.getText()));

        BobstCoatedDAO dao = new BobstCoatedDAO();

        dao.excluirBobst(obj);

        //Limpa os paineis        
        cbnomebobst.setSelectedItem("*");
        txtgrmcartaobobst.setText(null);
        txtpertinaxbobst.setText(null);
        txtfresa1bobst.setText(null);
        txtfresa2bobst.setText(null);
        txtidcartaobobst.setText(null);

        //desabilita botões
        btncriarbobst.setEnabled(false);
        btnalterarbobst.setEnabled(false);
        btnlimparbobst.setEnabled(false);
        btnexcluirbobst.setEnabled(false);
    }//GEN-LAST:event_btnexcluirbobstActionPerformed

    private void btnexcluirgerenciarcartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirgerenciarcartaoActionPerformed

        // botao Excluir Cartao
        GerenciaCartao obj = new GerenciaCartao();

        obj.setId(Integer.parseInt(txtidgerenciarcartao.getText()));

        GerenciaCartaoDAO dao = new GerenciaCartaoDAO();

        dao.excluirCartao(obj);

        //Limpa os paineis        
        txtnomegerenciarcartao.setText(null);
        txtidgerenciarcartao.setText(null);

        //habilitar e desabilitar botões
        btncriargerenciarcartao.setEnabled(false);
        btnexcluirgerenciarcartao.setEnabled(false);
        btnalterargerenciarcartao.setEnabled(false);
        btnlimpargerenciarcartao.setEnabled(false);

        Atualizarcbnomebobst();
        Atualizarcbnomecoated();
        Atualizarcbnomelaminado();
        Atualizarcbnomeacoplado();
    }//GEN-LAST:event_btnexcluirgerenciarcartaoActionPerformed

    private void txtpesquisanomebobstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisanomebobstKeyPressed

        // Pesquisar nome e gramatura na lista BobstCoated
        PesquisaNomeGramaturaBobstCoated();

    }//GEN-LAST:event_txtpesquisanomebobstKeyPressed

    private void txtpesquisafacalaminadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisafacalaminadoKeyPressed

        // Pesquisar na lista cartonlaminado
        PesquisaFacaNomeGramaturaCartaoLaminado();
    }//GEN-LAST:event_txtpesquisafacalaminadoKeyPressed

    private void txtpesquisanomelaminadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisanomelaminadoKeyPressed

        // Pesquisar na lista cartonlaminado
        PesquisaFacaNomeGramaturaCartaoLaminado();
    }//GEN-LAST:event_txtpesquisanomelaminadoKeyPressed

    private void txtpesquisafacacoatedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisafacacoatedKeyPressed

        // Pesquisar na lista cartonCoated
        PesquisaFacaNomeGramaturaCartaoCoated();
    }//GEN-LAST:event_txtpesquisafacacoatedKeyPressed

    private void txtpesquisanomecoatedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisanomecoatedKeyPressed

        // Pesquisar na lista cartonCoated
        PesquisaFacaNomeGramaturaCartaoCoated();
    }//GEN-LAST:event_txtpesquisanomecoatedKeyPressed

    private void txtpesquisafacaacopladoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisafacaacopladoKeyPressed

        // Pesquisar na lista CartonAcoplado
        PesquisaFacaNomeGramaturaCartaoAcoplado();
    }//GEN-LAST:event_txtpesquisafacaacopladoKeyPressed

    private void txtpesquisanomeacopladoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisanomeacopladoKeyPressed

        // Pesquisar na lista CartonAcoplado
        PesquisaFacaNomeGramaturaCartaoAcoplado();
    }//GEN-LAST:event_txtpesquisanomeacopladoKeyPressed

    private void btnlimparbobstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparbobstActionPerformed

        //Limpa os paineis        
        cbnomebobst.setSelectedItem("*");
        txtgrmcartaobobst.setText(null);
        txtpertinaxbobst.setText(null);
        txtfresa1bobst.setText(null);
        txtfresa2bobst.setText(null);
        txtidcartaobobst.setText(null);

        //desabilita botões
        btncriarbobst.setEnabled(false);
        btnalterarbobst.setEnabled(false);
        btnlimparbobst.setEnabled(false);
        btnexcluirbobst.setEnabled(false);
    }//GEN-LAST:event_btnlimparbobstActionPerformed

    private void btnlimparacopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparacopladoActionPerformed

        //Limpa os paineis
        txtfacaacoplado.setText(null);
        cbnomeacoplado.setSelectedItem("*");
        txtgrmcartao1acoplado.setText(null);
        txtgrmcartao2acoplado.setText(null);
        cbuvacoplado.setSelectedItem("*");
        txtpertinaxacoplado.setText(null);
        txtfresa1acoplado.setText(null);
        txtfresa2acoplado.setText(null);
        txtobservacaoacoplado.setText(null);
        txtidcartaoacoplado.setText(null);

        //desabilita botões
        btncriaracoplado.setEnabled(false);
        btnalteraracoplado.setEnabled(false);
        btnlimparacoplado.setEnabled(false);
        btnexcluiracoplado.setEnabled(false);

    }//GEN-LAST:event_btnlimparacopladoActionPerformed

    private void btnlimparlaminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparlaminadoActionPerformed

        //Limpa os paineis
        txtfacalaminado.setText(null);
        cbnomelaminado.setSelectedItem("*");
        txtgrmcartaolaminado.setText(null);
        txtgrmlaminadolaminado.setText(null);
        cbuvlaminado.setSelectedItem("*");
        txtpertinaxlaminado.setText(null);
        txtfresa1laminado.setText(null);
        txtfresa2laminado.setText(null);
        txtobservacaolaminado.setText(null);
        txtidcartaolaminado.setText(null);

        //desabilita botões
        btncriarlaminado.setEnabled(false);
        btnalterarlaminado.setEnabled(false);
        btnlimparlaminado.setEnabled(false);
        btnexcluirlaminado.setEnabled(false);
    }//GEN-LAST:event_btnlimparlaminadoActionPerformed

    private void btnlimparcoatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparcoatedActionPerformed

        //Limpa os paineis
        txtfacacoated.setText(null);
        cbnomecoated.setSelectedItem("*");
        txtgrmcartaocoated.setText(null);
        cbuvcoated.setSelectedItem("*");
        txtpertinaxcoated.setText(null);
        txtfresa1coated.setText(null);
        txtfresa2coated.setText(null);
        txtobservacaocoated.setText(null);
        txtidcartaocoated.setText(null);

        //desabilita botões
        btncriarcoated.setEnabled(false);
        btnalterarcoated.setEnabled(false);
        btnlimparcoated.setEnabled(false);
        btnexcluircoated.setEnabled(false);
    }//GEN-LAST:event_btnlimparcoatedActionPerformed

    private void btnlimpargerenciarcartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpargerenciarcartaoActionPerformed

        //Limpa os paineis        
        txtnomegerenciarcartao.setText(null);
        txtidgerenciarcartao.setText(null);

        //habilita e desabilitar botões
        btncriargerenciarcartao.setEnabled(false);
        btnexcluirgerenciarcartao.setEnabled(false);
        btnalterargerenciarcartao.setEnabled(false);
        btnlimpargerenciarcartao.setEnabled(false);
    }//GEN-LAST:event_btnlimpargerenciarcartaoActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        listarBobstCoated();
        txtpesquisanomebobst.setText(null);
        txtpesquisagrmbobst.setText(null);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        listarCartonCoated();
        txtpesquisafacacoated.setText(null);
        txtpesquisanomecoated.setText(null);
        txtpesquisagrmcoated.setText(null);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed

        listarCartonLaminado();
        txtpesquisafacalaminado.setText(null);
        txtpesquisanomelaminado.setText(null);
        txtpesquisagrmlaminado.setText(null);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        listarCartonAcoplado();
        txtpesquisafacaacoplado.setText(null);
        txtpesquisanomeacoplado.setText(null);
        txtpesquisagrmacoplado.setText(null);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void txtnomegerenciarcartaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomegerenciarcartaoKeyPressed

        //habilitar e desabilitar botões        
        if (!"".equals(txtidgerenciarcartao.getText())) {
            btnalterargerenciarcartao.setEnabled(true);
            btncriargerenciarcartao.setEnabled(false);
        } else {
            btnalterargerenciarcartao.setEnabled(false);
            btncriargerenciarcartao.setEnabled(true);
        }
        btnlimpargerenciarcartao.setEnabled(true);
    }//GEN-LAST:event_txtnomegerenciarcartaoKeyPressed

    private void txtfacacoatedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfacacoatedKeyPressed

        //habilitar e desabilitar botões
        if (!"".equals(txtidcartaocoated.getText())) {
            btnalterarcoated.setEnabled(true);
            btncriarcoated.setEnabled(false);
        } else {
            btnalterarcoated.setEnabled(false);
            btncriarcoated.setEnabled(true);
        }
        btnlimparcoated.setEnabled(true);

    }//GEN-LAST:event_txtfacacoatedKeyPressed

    private void cbuvcoatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbuvcoatedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbuvcoatedActionPerformed

    private void txtfacalaminadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfacalaminadoKeyPressed

        //habilitar e desabilitar botões
        if (!"".equals(txtidcartaolaminado.getText())) {
            btnalterarlaminado.setEnabled(true);
            btncriarlaminado.setEnabled(false);
        } else {
            btnalterarlaminado.setEnabled(false);
            btncriarlaminado.setEnabled(true);
        }
        btnlimparlaminado.setEnabled(true);
    }//GEN-LAST:event_txtfacalaminadoKeyPressed

    private void txtfacaacopladoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfacaacopladoKeyPressed

        //habilitar e desabilitar botões
        if (!"".equals(txtidcartaoacoplado.getText())) {
            btnalteraracoplado.setEnabled(true);
            btncriaracoplado.setEnabled(false);
        } else {
            btnalteraracoplado.setEnabled(false);
            btncriaracoplado.setEnabled(true);
        }
        btnlimparacoplado.setEnabled(true);
    }//GEN-LAST:event_txtfacaacopladoKeyPressed

    private void txtgrmcartaobobstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgrmcartaobobstKeyPressed

        //habilitar e desabilitar botões
        if (cbnomebobst.getSelectedItem().toString() != "*") {
            if (!"".equals(txtidcartaobobst.getText())) {
                btnalterarbobst.setEnabled(true);
                btncriarbobst.setEnabled(false);
            } else {
                btnalterarbobst.setEnabled(false);
                btncriarbobst.setEnabled(true);
            }

            btnlimparbobst.setEnabled(true);
        } else {
        }
    }//GEN-LAST:event_txtgrmcartaobobstKeyPressed

    private void txtpesquisagrmbobstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisagrmbobstKeyPressed

        // Pesquisar gramatura na lista BobstCoated
        PesquisaNomeGramaturaBobstCoated();
    }//GEN-LAST:event_txtpesquisagrmbobstKeyPressed

    private void txtpesquisagrmcoatedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisagrmcoatedKeyPressed

        //pesquisar na lista cartonCoated
        PesquisaFacaNomeGramaturaCartaoCoated();
    }//GEN-LAST:event_txtpesquisagrmcoatedKeyPressed

    private void txtpesquisagrmlaminadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisagrmlaminadoKeyPressed
        //pesquisar na lista cartonLamiando
        PesquisaFacaNomeGramaturaCartaoLaminado();
    }//GEN-LAST:event_txtpesquisagrmlaminadoKeyPressed

    private void txtpesquisagrmacopladoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisagrmacopladoKeyPressed

        //pesquisar na lista cartonAcoplado
        PesquisaFacaNomeGramaturaCartaoAcoplado();
    }//GEN-LAST:event_txtpesquisagrmacopladoKeyPressed

    private void lb_FecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_FecharMouseClicked
        // Transição de fechamento
        for (double i = 1.0; i >= 0.0; i = i - 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(15);
            } catch (Exception e) {
            }
        }

        // Fechar janela     
        dispose();

    }//GEN-LAST:event_lb_FecharMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Transição de abertura
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(35);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void lb_FecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_FecharMouseEntered
        // Troca Ícone
        lb_Fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fechar_Over.png")));
    }//GEN-LAST:event_lb_FecharMouseEntered

    private void lb_FecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_FecharMouseExited
        // Troca Ícone
        lb_Fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fechar.png")));
    }//GEN-LAST:event_lb_FecharMouseExited

    private void lb_MaximizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MaximizarMouseEntered
        // Troca Ícone
        if (this.getWidth() > 1365) {
            lb_Maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaximizarMenos_Over.png")));
        } else {
            lb_Maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaximizarMais_Over.png")));
        }
    }//GEN-LAST:event_lb_MaximizarMouseEntered

    private void lb_MaximizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MaximizarMouseExited
        // Troca ícone
        if (this.getWidth() > 1365) {
            lb_Maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaximizarMenos.png")));
        } else {
            lb_Maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaximizarMais.png")));
        }
    }//GEN-LAST:event_lb_MaximizarMouseExited

    private void lb_MinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MinimizarMouseEntered
        // Troca ìcone
        lb_Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Minimizar_Over.png")));
    }//GEN-LAST:event_lb_MinimizarMouseEntered

    private void lb_MinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MinimizarMouseExited
        // Troca ìcone
        lb_Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Minimizar.png")));
    }//GEN-LAST:event_lb_MinimizarMouseExited

    private void lb_MaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MaximizarMouseClicked
        // Maximizar janela
        if (this.getWidth() > 1365) {
            this.setSize(1365, 705);
            this.setLocationRelativeTo(null);
            lb_Maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaximizarMais.png")));
        } else {
            this.setExtendedState(MAXIMIZED_BOTH);
            lb_Maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaximizarMenos.png")));
        }

    }//GEN-LAST:event_lb_MaximizarMouseClicked

    private void lb_MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_MinimizarMouseClicked
        // Diminuir janela
        this.setExtendedState(ICONIFIED);

    }//GEN-LAST:event_lb_MinimizarMouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // Minimizar janela
        if (evt.getClickCount() == 2) {
            // Maximizar janela
            if (this.getWidth() > 1365) {
                this.setSize(1365, 705);
                this.setLocationRelativeTo(null);
                lb_Maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaximizarMais.png")));
            } else {
                this.setExtendedState(MAXIMIZED_BOTH);
                lb_Maximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaximizarMenos.png")));
            }
        }

    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MousePressed
        // TODO add your handling code here:

        eixox = evt.getX();
        eixoy = evt.getY();
    }//GEN-LAST:event_jPanel17MousePressed

    private void jPanel17MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - eixox, y - eixoy);
    }//GEN-LAST:event_jPanel17MouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnalteraracoplado;
    private javax.swing.JButton btnalterarbobst;
    private javax.swing.JButton btnalterarcoated;
    private javax.swing.JButton btnalterargerenciarcartao;
    private javax.swing.JButton btnalterarlaminado;
    private javax.swing.JButton btncriaracoplado;
    private javax.swing.JButton btncriarbobst;
    private javax.swing.JButton btncriarcoated;
    private javax.swing.JButton btncriargerenciarcartao;
    private javax.swing.JButton btncriarlaminado;
    private javax.swing.JButton btnexcluiracoplado;
    private javax.swing.JButton btnexcluirbobst;
    private javax.swing.JButton btnexcluircoated;
    private javax.swing.JButton btnexcluirgerenciarcartao;
    private javax.swing.JButton btnexcluirlaminado;
    private javax.swing.JButton btnlimparacoplado;
    private javax.swing.JButton btnlimparbobst;
    private javax.swing.JButton btnlimparcoated;
    private javax.swing.JButton btnlimpargerenciarcartao;
    private javax.swing.JButton btnlimparlaminado;
    private javax.swing.JComboBox cbnomeacoplado;
    private javax.swing.JComboBox cbnomebobst;
    private javax.swing.JComboBox cbnomecoated;
    private javax.swing.JComboBox cbnomelaminado;
    private javax.swing.JComboBox<String> cbuvacoplado;
    private javax.swing.JComboBox<String> cbuvcoated;
    private javax.swing.JComboBox<String> cbuvlaminado;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JPanel lPanel;
    private javax.swing.JLabel lb_Fechar;
    private javax.swing.JLabel lb_Maximizar;
    private javax.swing.JLabel lb_Minimizar;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painel2;
    private javax.swing.JTabbedPane painel_cadastrar;
    private javax.swing.JTable tb_bobstCoated;
    private javax.swing.JTable tb_cartonAcoplado;
    private javax.swing.JTable tb_cartonCoated;
    private javax.swing.JTable tb_cartonLaminado;
    private javax.swing.JTable tb_gerenciaCartao;
    private javax.swing.JTextField txtfacaacoplado;
    private javax.swing.JTextField txtfacacoated;
    private javax.swing.JTextField txtfacalaminado;
    private javax.swing.JTextField txtfresa1acoplado;
    private javax.swing.JTextField txtfresa1bobst;
    private javax.swing.JTextField txtfresa1coated;
    private javax.swing.JTextField txtfresa1laminado;
    private javax.swing.JTextField txtfresa2acoplado;
    private javax.swing.JTextField txtfresa2bobst;
    private javax.swing.JTextField txtfresa2coated;
    private javax.swing.JTextField txtfresa2laminado;
    private javax.swing.JTextField txtgrmcartao1acoplado;
    private javax.swing.JTextField txtgrmcartao2acoplado;
    private javax.swing.JTextField txtgrmcartaobobst;
    private javax.swing.JTextField txtgrmcartaocoated;
    private javax.swing.JTextField txtgrmcartaolaminado;
    private javax.swing.JTextField txtgrmlaminadolaminado;
    private javax.swing.JTextField txtidcartaoacoplado;
    private javax.swing.JTextField txtidcartaobobst;
    private javax.swing.JTextField txtidcartaocoated;
    private javax.swing.JTextField txtidcartaolaminado;
    private javax.swing.JTextField txtidgerenciarcartao;
    private javax.swing.JTextField txtnomegerenciarcartao;
    private javax.swing.JTextArea txtobservacaoacoplado;
    private javax.swing.JTextArea txtobservacaocoated;
    private javax.swing.JTextArea txtobservacaolaminado;
    private javax.swing.JTextField txtpertinaxacoplado;
    private javax.swing.JTextField txtpertinaxbobst;
    private javax.swing.JTextField txtpertinaxcoated;
    private javax.swing.JTextField txtpertinaxlaminado;
    private javax.swing.JTextField txtpesquisafacaacoplado;
    private javax.swing.JTextField txtpesquisafacacoated;
    private javax.swing.JTextField txtpesquisafacalaminado;
    private javax.swing.JTextField txtpesquisagrmacoplado;
    private javax.swing.JTextField txtpesquisagrmbobst;
    private javax.swing.JTextField txtpesquisagrmcoated;
    private javax.swing.JTextField txtpesquisagrmlaminado;
    private javax.swing.JTextField txtpesquisanomeacoplado;
    private javax.swing.JTextField txtpesquisanomebobst;
    private javax.swing.JTextField txtpesquisanomecoated;
    private javax.swing.JTextField txtpesquisanomelaminado;
    // End of variables declaration//GEN-END:variables

}
