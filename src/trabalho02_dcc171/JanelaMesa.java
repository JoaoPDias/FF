package trabalho02_dcc171;

import java.awt.HeadlessException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaMesa extends javax.swing.JFrame {

    private List<Mesa> mesas;
    private JList<Mesa> lstMesas = new JList<>(new DefaultListModel<>());
    private JList<Pedido> lstPedidos = new JList<>(new DefaultListModel<>());
    private JanelaItem janelaItem;
    private JanelaCardapio janelaCardapio;
    private LocalTime t;
    private MesaDAO daoMesa;
    private Pedido pedido;
    private PedidoDAO daoPedido;
    private ItemPedidoDAO daoItemPedido;

    public JanelaMesa() throws IOException {
        initComponents();
        t = LocalTime.now();
        this.daoMesa = new MesaDAO();
        this.mesas = daoMesa.getMesas();
        lstMesas.setModel(new MesaListModel(mesas));
        janelaCardapio = new JanelaCardapio(this);

        lstMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstMesas.addListSelectionListener(new ListSelectionListener() {
            PedidoDAO daoPedido;

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Mesa selecionada = lstMesas.getSelectedValue();
                    try {
                        this.daoPedido = new PedidoDAO(selecionada);
                    } catch (IOException ex) {
                        Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lstPedidos.setModel(new PedidoListModel(lstMesas.getSelectedValue()));

                } catch (IOException ex) {
                    Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        lstPedidos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {

                    daoItemPedido = new ItemPedidoDAO(lstPedidos.getSelectedValue());
                    descricaoPedido.setText(daoItemPedido.getItemPedidos().toString());
                    StringBuilder s = new StringBuilder(descricaoPedido.getText());
                    s.append("Valor Final: R$ ").append(lstPedidos.getSelectedValue().getValorTotal());
                    descricaoPedido.setText(s.toString());

                } catch (IOException ex) {
                    Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollMesas = new javax.swing.JScrollPane(lstMesas);
        scrollPedidos = new javax.swing.JScrollPane(lstPedidos);
        jScrollPane3 = new javax.swing.JScrollPane();
        descricaoPedido = new javax.swing.JTextArea();
        btnCriaMesa = new javax.swing.JButton();
        btnExcluiMesa = new javax.swing.JButton();
        btnCriaPedido = new javax.swing.JButton();
        btnFechaPedido = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        btnCardapio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(572, 500));

        descricaoPedido.setColumns(20);
        descricaoPedido.setRows(5);
        jScrollPane3.setViewportView(descricaoPedido);

        btnCriaMesa.setText("Criar Mesa");
        btnCriaMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriaMesaActionPerformed(evt);
            }
        });

        btnExcluiMesa.setText("Excluir Mesa");
        btnExcluiMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiMesaActionPerformed(evt);
            }
        });

        btnCriaPedido.setText("Criar Pedido");
        btnCriaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriaPedidoActionPerformed(evt);
            }
        });

        btnFechaPedido.setText("Fechar Pedido");
        btnFechaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaPedidoActionPerformed(evt);
            }
        });

        btnAddItem.setText("Adicionar Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnCardapio.setText("Cardápio");
        btnCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardapioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnCriaMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluiMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriaPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechaPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCardapio))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPedidos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(scrollMesas, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriaMesa)
                    .addComponent(btnExcluiMesa)
                    .addComponent(btnCriaPedido)
                    .addComponent(btnFechaPedido)
                    .addComponent(btnAddItem)
                    .addComponent(btnCardapio)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriaMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriaMesaActionPerformed

        Mesa t;
        try {
            t = new Mesa();
            daoMesa.inserir(t);
        } catch (IOException ex) {
            Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        lstMesas.setModel(new MesaListModel(daoMesa.getMesas()));
        lstMesas.updateUI();

    }//GEN-LAST:event_btnCriaMesaActionPerformed

    private void btnExcluiMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiMesaActionPerformed
        if (lstMesas.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }

        for (Pedido p : lstMesas.getSelectedValue().getPedidos()) {
            if (p.isConta() == true) {
                JOptionPane.showMessageDialog(null, "Existem pedidos em aberto. Feche-os", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
            return;
        }

        try {
            daoMesa.excluir(lstMesas.getSelectedValue());
        } catch (IOException ex) {
            Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        lstMesas.setModel(new MesaListModel(daoMesa.getMesas()));
        lstMesas.clearSelection();
        lstMesas.updateUI();
    }//GEN-LAST:event_btnExcluiMesaActionPerformed

    private void btnCriaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriaPedidoActionPerformed
        try {
            if (lstMesas.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }

            Pedido p;
            LocalTime t = LocalTime.now();
            p = new Pedido(lstMesas.getSelectedValue(), t);

            try {
                this.daoPedido = new PedidoDAO(lstMesas.getSelectedValue());
                daoPedido.inserir(p);
            } catch (IOException ex) {
                Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
            lstPedidos.setModel(new PedidoListModel(lstMesas.getSelectedValue()));
            lstPedidos.updateUI();
            lstMesas.updateUI();
        } catch (IOException ex) {
            Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCriaPedidoActionPerformed

    private void btnFechaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaPedidoActionPerformed
        try {
            if (lstPedidos.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um Pedido", "ERRO!", JOptionPane.ERROR_MESSAGE);;
            }
            if (lstPedidos.getSelectedValue().getHoraFechamento() == null) {
                daoPedido = new PedidoDAO(lstMesas.getSelectedValue());
                daoPedido.fecharPedido(lstPedidos.getSelectedValue().getNumPedido());
                lstPedidos.getSelectedValue().setHoraFechamento(LocalTime.now());
                StringBuilder s = new StringBuilder(descricaoPedido.getText());
                s.append("Valor Final: R$ ").append(lstPedidos.getSelectedValue().getValorTotal());
                descricaoPedido.setText(s.toString());
                lstPedidos.updateUI();
            } else {
                return;
            }

        } catch (IOException ex) {
            Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFechaPedidoActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        try {
            if (lstPedidos.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um Pedido", "ERRO!", JOptionPane.ERROR_MESSAGE);;
                return;
            } else if (lstPedidos.getSelectedValue().getHoraFechamento() != null) {
                return;
            }
            janelaItem = new JanelaItem(this, lstPedidos.getSelectedValue());
            janelaItem.setVisible(true);

        } catch (HeadlessException ex) {
            Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JanelaMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardapioActionPerformed
        janelaCardapio.setVisible(true);
    }//GEN-LAST:event_btnCardapioActionPerformed

    public JTextArea getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(JTextArea descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCardapio;
    private javax.swing.JButton btnCriaMesa;
    private javax.swing.JButton btnCriaPedido;
    private javax.swing.JButton btnExcluiMesa;
    private javax.swing.JButton btnFechaPedido;
    private javax.swing.JTextArea descricaoPedido;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane scrollMesas;
    private javax.swing.JScrollPane scrollPedidos;
    // End of variables declaration//GEN-END:variables

    /*void gravarproduto(ItemPedido itemp ,double preco) {
       lstPedidos.getSelectedValue().getDescricao().append("\n").append(nome).append(": " + "R$").append(preco).append("\n").append("Quantidade: ").append(qtd).append("\n");
       descricaoPedido.setText(lstPedidos.getSelectedValue().imprimeFinal(lstPedidos.getSelectedValue()));
    }
    void recebetotal( double total){
        lstPedidos.getSelectedValue().getDescricao().append("\n").append("Total parcial: ").append(total + lstPedidos.getSelectedValue().getValorFinal()).append("\n");
        descricaoPedido.setText(lstPedidos.getSelectedValue().imprimeFinal(lstPedidos.getSelectedValue()));
        lstPedidos.getSelectedValue().acrescentaFinal(total, lstPedidos.getSelectedValue());
    }*/
}
