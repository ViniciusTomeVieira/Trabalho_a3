/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import twitter.controller.Gerenciador;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela que mostra a regra cadastrada na conta
 */
public class TweetsRulesView extends JFrame{
    
    //JLabel
    private JLabel jlRules;
    //JTable
    private JTable jtRules;
    //Layout
    private GridBagConstraints constraints;
    private GridBagLayout layout;
    private JPanel jpPrincipal, jpTitle, jpRules;
    //Referencia do Gerenciador
    private Gerenciador gerenciador;
    
    public TweetsRulesView(String title){
        
        //Chama o singleton do Gerenciador.java
        gerenciador = Gerenciador.Gerenciador();
        
        initComponents();
        
        //Configura a view
        setTitle(title);
        setBounds(200, 200, 700, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    class TweetRulesTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public int getRowCount() {
            return gerenciador.getRulesResponse().getData().size();
        }

        @Override
        public String getValueAt(int row, int col) {
            try {
                String texto = "ID: " + gerenciador.getRulesResponse().getData().get(row).getId() + "    " +
                               "Value: " + gerenciador.getRulesResponse().getData().get(row).getValue() + "    " +
                               "Tag: " + gerenciador.getRulesResponse().getData().get(row).getTag();
                return texto;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }

    }
    class TweetRulesRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;


        public Component getTableCellRendererComponent(JTable table,
                String value, boolean isSelected, boolean hasFocus, int row,
                int column) {

            setText(value);

            return this;
        }

    }
    //Inicia os componentes da tela e os ajusta corretamente
    private void initComponents(){
  
        //JLabels
        jlRules = new JLabel("Regra cadastrada");
        
        //JLabels/Layout
        jlRules.setForeground(Color.white);
        
        //Inicia os componentes de layout
        constraints = new GridBagConstraints();
        layout = new GridBagLayout();
        jpPrincipal = new JPanel();
        jpTitle = new JPanel();
        jpRules = new JPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpTitle.setLayout(layout);
        jpTitle.setBackground(new Color(0, 172, 238));;
        jpRules.setLayout(new BorderLayout());
        jpPrincipal.setBackground(new Color(0, 172, 238));
        
        
        //JTable
        jtRules = new JTable();
        jtRules.setModel(new TweetRulesTableModel());
        for (int x = 0; x < jtRules.getColumnModel().getColumnCount(); x++) {
            jtRules.getColumnModel().getColumn(x).setWidth(1000);
            jtRules.getColumnModel().getColumn(x).setMinWidth(1000);
            jtRules.getColumnModel().getColumn(x).setMaxWidth(1000);
        }
        jtRules.setRowHeight(40);
        jtRules.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtRules.setShowGrid(true);
        jtRules.setGridColor(Color.blue);
        jtRules.setIntercellSpacing(new Dimension(0, 5));
        jtRules.setDefaultRenderer(Object.class, new TweetRulesRenderer());
        
        //jtTweets.setPreferredSize(new Dimension(600, 600));
        jtRules.setFillsViewportHeight(true);
        
        JScrollPane js=new JScrollPane(jtRules);
        //js.setBounds(10, 0, jtTweets.getBounds().width,  jtTweets.getBounds().height);
        js.setVisible(true);
        
        //Adiciona os componentes no painel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 20, 0);
        jpTitle.add(jlRules,constraints);        
        
        jpRules.add(js, BorderLayout.CENTER); 
        
        jpPrincipal.add(jpTitle, BorderLayout.NORTH);
        jpPrincipal.add(jpRules, BorderLayout.CENTER);
        
        setLayout(new BorderLayout());
        add(jpPrincipal,BorderLayout.CENTER);        
    }   
}