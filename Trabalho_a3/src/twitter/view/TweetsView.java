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
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import twitter.controller.Gerenciador;

/**
 *
 * @author vinny
 */
public class TweetsView extends JFrame implements ActionListener {
    
    //JLabel
    private JLabel jlName, jlId, jlUsername, jlDate;
    //JTextField
    private JTextField jtfUser, jtfAmount;
    //JButton
    private JButton jbSearch;
    //JTable
    private JTable jtTweets;
    //Layout
    private GridBagConstraints constraints;
    private GridBagLayout layout;
    private JPanel jpPrincipal;
    //Referencia do Gerenciador
    private Gerenciador gerenciador;
    
    public TweetsView(String title){
        
        //Chama o singleton do Gerenciador.java
        gerenciador = Gerenciador.Gerenciador();
        //Se adiciona como observador no gerenciador
        //gerenciador.addObservador(this);
        
        initComponents();
        
        //Configura a view
        setTitle(title);
        setBounds(200, 200, 1000, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    class TabuleiroTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public int getRowCount() {
            return gerenciador.getTweets().getData().size();
        }

        @Override
        public String getValueAt(int row, int col) {
            try {
                return gerenciador.getTweets().getData().get(row).getText();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }

    }
    class TabuleiroRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        public Component getTableCellRendererComponent(JTable table,
                String value, boolean isSelected, boolean hasFocus, int row,
                int column) {

            setText("xesq");

            return this;
        }

    }
    //Inicia os componentes da tela e os ajusta corretamente
    private void initComponents(){
  
        //JLabels
        jlId = new JLabel(gerenciador.getUsuarios().getData().get(0).getId());
        jlName = new JLabel(gerenciador.getUsuarios().getData().get(0).getName());
        jlUsername = new JLabel(gerenciador.getUsuarios().getData().get(0).getUsername());
        
        ImageIcon iconLogo = new ImageIcon("Images/twitter.png");
        Image newImage = iconLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        iconLogo.setImage(newImage);
        //jlImage.setIcon(iconLogo);
        
        //JLabels/Layout
        //jlImage.setForeground(Color.white);
        //jlUser.setForeground(Color.white);
        //jlAmount.setForeground(Color.white);
        //jlUserSample.setForeground(Color.white);
        
        //JTextFields
        jtfUser = new JTextField();
        jtfAmount = new JTextField();
        
        //JTextFields/Layout
        jtfAmount.setPreferredSize( new Dimension( 200, 24 ) ); 
        jtfUser.setPreferredSize( new Dimension( 200, 24 ) ); 
        
        //JButtons
        jbSearch = new JButton();
        jbSearch.setText("PESQUISAR");
        
        //JButtons/Layout
        jbSearch.setBackground(new Color(0,185,255));
        jbSearch.setForeground(Color.white);
        
        //JButtons/Acao
        jbSearch.addActionListener(this);
        
        //Inicia os componentes de layout
        constraints = new GridBagConstraints();
        layout = new GridBagLayout();
        jpPrincipal = new JPanel();
        jpPrincipal.setLayout(layout);
        jpPrincipal.setBackground(new Color(0, 172, 238));
        
        //JTable
        jtTweets = new JTable();
        jtTweets.setModel(new TabuleiroTableModel());
        for (int x = 0; x < jtTweets.getColumnModel().getColumnCount(); x++) {
            jtTweets.getColumnModel().getColumn(x).setWidth(200);
            jtTweets.getColumnModel().getColumn(x).setMinWidth(100);
            jtTweets.getColumnModel().getColumn(x).setMaxWidth(100);
        }
        jtTweets.setRowHeight(100);
        jtTweets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtTweets.setShowGrid(false);
        jtTweets.setGridColor(Color.red);
        jtTweets.setIntercellSpacing(new Dimension(0, 0));
        jtTweets.setDefaultRenderer(Object.class, new TabuleiroRenderer());
        
        //Adiciona os componentes no painel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 20, 0);
        jpPrincipal.add(jlName,constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 5, 5);
        jpPrincipal.add(jlUsername,constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        jpPrincipal.add(jlUsername,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        jpPrincipal.add(jtTweets,constraints);
        
        setLayout(new BorderLayout());
        add(jpPrincipal,BorderLayout.CENTER);     
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}