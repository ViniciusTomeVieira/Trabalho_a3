/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.view;

import java.awt.BorderLayout;
import java.awt.Color;
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
import twitter.controller.Gerenciador;
import twitter.observer.Observer;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public class TwitterView extends JFrame implements Observer, ActionListener {
    
    //JLabel
    private JLabel jlImage, jlUser, jlAmount, jlUserSample, jlAmountSample, jlOr;
    //JTextField
    private JTextField jtfUser, jtfAmount;
    //JButton
    private JButton jbSearch, jbAddRule;
    //Layout
    private GridBagConstraints constraints;
    private GridBagLayout layout;
    private JPanel jpPrincipal;
    //Referencia do Gerenciador
    private Gerenciador gerenciador;
    
    public TwitterView(){
        
        //Chama o singleton do Gerenciador.java
        gerenciador = Gerenciador.Gerenciador();
        //Se adiciona como observador no gerenciador
        gerenciador.addObservador(this);
        
        initComponents();
        
        //Configura a view
        setTitle("TwitterJersey AV");
        setBounds(200, 200, 400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    //Inicia a tela do sistema
    public static void main(String[] args) {
       try {
            TwitterView view = new TwitterView();
            view.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Inicia os componentes da tela e os ajusta corretamente (GET)
    private void initComponents(){
        //JLabels
        jlImage = new JLabel("TwitterJersey AV");
        jlUser = new JLabel("Usuario: ");
        jlAmount = new JLabel("Quantidade: ");
        jlUserSample = new JLabel("Ex.: DolarBipolar");
        jlAmountSample = new JLabel("Entre 5 e 100");
        jlOr = new JLabel("ou");
        
        ImageIcon iconLogo = new ImageIcon("Images/twitter.png");
        Image newImage = iconLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        iconLogo.setImage(newImage);
        jlImage.setIcon(iconLogo);
        
        //JLabels/Layout
        jlImage.setForeground(Color.white);
        jlUser.setForeground(Color.white);
        jlAmount.setForeground(Color.white);
        jlUserSample.setForeground(Color.white);
        jlAmountSample.setForeground(Color.white);
        jlOr.setForeground(Color.white);
        
        //JTextFields
        jtfUser = new JTextField();
        jtfAmount = new JTextField();
        
        //JTextFields/Layout
        jtfAmount.setPreferredSize( new Dimension( 200, 24 ) ); 
        jtfUser.setPreferredSize( new Dimension( 200, 24 ) ); 
        
        //JButtons
        jbSearch = new JButton();
        jbSearch.setText("PESQUISAR");
        jbAddRule = new JButton();
        jbAddRule.setText("ADICIONAR REGRA");
        
        //JButtons/Layout
        jbSearch.setBackground(new Color(0,185,255));
        jbSearch.setForeground(Color.white);
        jbAddRule.setBackground(new Color(0,185,255));
        jbAddRule.setForeground(Color.white);
        
        //JButtons/Acao
        jbSearch.addActionListener(this);
        jbAddRule.addActionListener(this);
        
        //Inicia os componentes de layout
        constraints = new GridBagConstraints();
        layout = new GridBagLayout();
        jpPrincipal = new JPanel();
        jpPrincipal.setLayout(layout);
        jpPrincipal.setBackground(new Color(0, 172, 238));
        
        //Adiciona os componentes no painel
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 20, 0);
        jpPrincipal.add(jlImage,constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 5, 5);
        jpPrincipal.add(jlUser,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        jpPrincipal.add(jtfUser,constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        jpPrincipal.add(jlUserSample,constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        jpPrincipal.add(jlAmount,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        jpPrincipal.add(jtfAmount,constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 2;
        jpPrincipal.add(jlAmountSample,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        jpPrincipal.add(jbSearch,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 4;
        jpPrincipal.add(jlOr,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.insets = new Insets(5, 0, 5, 5);
        jpPrincipal.add(jbAddRule,constraints);
        
        setLayout(new BorderLayout());
        add(jpPrincipal,BorderLayout.CENTER);     
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbSearch) {
            try{
                int test = Integer.parseInt(jtfAmount.getText()) / 1;
                if(!jtfUser.getText().equals("")){
                    gerenciador.buscarTweetByUsername(jtfUser.getText(), Integer.parseInt(jtfAmount.getText()));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Insira um usuário","Aviso",JOptionPane.WARNING_MESSAGE);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Insira uma quantidade válida","Aviso",JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == jbAddRule) {
                try {
                    TwitterRuleView view = new TwitterRuleView();
                    view.setVisible(true);
                    gerenciador.removeObservador(this);
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    @Override
    public void qntTweetsInvalido() {
        JOptionPane.showMessageDialog(rootPane, "Por favor, digite um valor entre 5 e 100","Aviso", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void AchouUsuario(boolean b) {
        if(!b){
            JOptionPane.showMessageDialog(rootPane, "Usuário não encontrado","Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    @Override
    public void AchouTweets(boolean b) {
        if(b){
           try {
            TweetsView view = new TweetsView("Tweets");
            view.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        }else{
            JOptionPane.showMessageDialog(rootPane, "Não foram encontrados tweets deste usuário","Aviso", JOptionPane.WARNING_MESSAGE);
        }     
    }

    @Override
    public void regraAdicionada(boolean b) {
    }
}
