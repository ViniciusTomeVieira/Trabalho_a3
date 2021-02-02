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
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public class TweetsView extends JFrame{
    
    //JLabel
    private JLabel jlName, jlId, jlUsername, jlDate;
    //JTable
    private JTable jtTweets;
    //Layout
    private GridBagConstraints constraints;
    private GridBagLayout layout;
    private JPanel jpPrincipal, jpUser, jpTweets;
    //Referencia do Gerenciador
    private Gerenciador gerenciador;
    
    public TweetsView(String title){
        
        //Chama o singleton do Gerenciador.java
        gerenciador = Gerenciador.Gerenciador();
        
        initComponents();
        
        //Configura a view
        setTitle(title);
        setBounds(200, 200, 1000, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    class TweetsTableModel extends AbstractTableModel {

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
                String texto = "Usuário:  " + gerenciador.getUsuarios().getData().get(0).getName() + "      Tweet:  " +
                        gerenciador.getTweets().getData().get(row).getText();
                return texto;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }

    }
    class TweetsRenderer extends DefaultTableCellRenderer {

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
        jlId = new JLabel("ID: "+gerenciador.getUsuarios().getData().get(0).getId());
        jlName = new JLabel("Nome: "+gerenciador.getUsuarios().getData().get(0).getName());
        jlUsername = new JLabel("Username: "+gerenciador.getUsuarios().getData().get(0).getUsername());
        
        ImageIcon iconLogo = new ImageIcon("Images/twitter.png");
        Image newImage = iconLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        iconLogo.setImage(newImage);
        //jlImage.setIcon(iconLogo);
        
        //JLabels/Layout
        jlId.setForeground(Color.white);
        jlName.setForeground(Color.white);
        jlUsername.setForeground(Color.white);
        
        //Inicia os componentes de layout
        constraints = new GridBagConstraints();
        layout = new GridBagLayout();
        jpPrincipal = new JPanel();
        jpUser = new JPanel();
        jpTweets = new JPanel();
        jpPrincipal.setLayout(new BorderLayout());
        jpUser.setLayout(layout);
        jpUser.setBackground(new Color(0, 172, 238));;
        jpTweets.setLayout(new BorderLayout());
        jpPrincipal.setBackground(new Color(0, 172, 238));
        
        
        //JTable
        jtTweets = new JTable();
        jtTweets.setModel(new TweetsTableModel());
        for (int x = 0; x < jtTweets.getColumnModel().getColumnCount(); x++) {
            jtTweets.getColumnModel().getColumn(x).setWidth(1000);
            jtTweets.getColumnModel().getColumn(x).setMinWidth(1000);
            jtTweets.getColumnModel().getColumn(x).setMaxWidth(1000);
        }
        jtTweets.setRowHeight(40);
        jtTweets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtTweets.setShowGrid(true);
        jtTweets.setGridColor(Color.blue);
        jtTweets.setIntercellSpacing(new Dimension(0, 5));
        jtTweets.setDefaultRenderer(Object.class, new TweetsRenderer());
        
        //jtTweets.setPreferredSize(new Dimension(600, 600));
        jtTweets.setFillsViewportHeight(true);
        
        JScrollPane js=new JScrollPane(jtTweets);
        //js.setBounds(10, 0, jtTweets.getBounds().width,  jtTweets.getBounds().height);
        js.setVisible(true);
        
        //Adiciona os componentes no painel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 20, 0);
        jpUser.add(jlName,constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 5, 5);
        jpUser.add(jlUsername,constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        jpUser.add(jlId,constraints);
        
        jpTweets.add(js, BorderLayout.CENTER); 
        
        jpPrincipal.add(jpUser, BorderLayout.NORTH);
        jpPrincipal.add(jpTweets, BorderLayout.CENTER);
        
        setLayout(new BorderLayout());
        add(jpPrincipal,BorderLayout.CENTER);        
    }   
}