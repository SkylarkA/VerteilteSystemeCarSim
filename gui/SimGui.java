/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import carsim.CarSim;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author debian
 */
public class SimGui extends javax.swing.JFrame{

    private CarSim cs;
    
    
   
    
   
    
    /**
     * Creates new form Gui
     */
    public SimGui(CarSim cs){
        this.cs = cs;
        
      
        initComponents();     
       
        addButtonListeners();
        populateTable();
        populateCombobox();
        
       // gmts.connectToSim();
       // gmts.connectToMonitor();
    }
    
   
    private void addButtonListeners(){
        addNormalCarButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String textfieldContent = normalCarField.getText();
               int count = Integer.parseInt(textfieldContent);
               cs.addCars(count, false);
           } 
        });
        
        addAutoCarButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String textfieldContent = autoCarField.getText();
               int count = Integer.parseInt(textfieldContent);
               cs.addCars(count, true);
           } 
        });
    }
    
    public void populateTable(){
        
       
        DefaultTableModel model =(DefaultTableModel) RoadTable.getModel();     
        
        
        for(int i=0;i<cs.hn.edgeNames.size();i++){
            
            if(i<model.getRowCount()){
                model.setValueAt(cs.hn.edgeUsage.get(i)+"/"+cs.hn.maxEdgeCap.get(i), i, 1);
            }else{
                model.addRow(new Object[]{cs.hn.edgeNames.get(i),cs.hn.edgeUsage.get(i)+"/"+cs.hn.maxEdgeCap.get(i)});
            }
            
            
        }      
       
        model.fireTableDataChanged();       
    }
    
    
    
    private void populateCombobox(){
        
       
        
        for(int i=0;i<cs.hn.edgeNames.size();i++){
            jComboBox1.addItem(cs.hn.edgeNames.get(i));
        }
        
        jComboBox1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String seectedItem =(String)jComboBox1.getSelectedItem();
                System.out.println(seectedItem);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        RoadTable = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        addNormalCarButton = new javax.swing.JButton();
        addAutoCarButton = new javax.swing.JButton();
        normalCarField = new javax.swing.JTextField();
        autoCarField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CarSim Interface");

        RoadTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Status"
            }
        ));
        jScrollPane1.setViewportView(RoadTable);

        jLabel1.setText("Create Jam");

        addNormalCarButton.setText("normal Car");

        addAutoCarButton.setText("auto. Car");

        normalCarField.setText("jTextField1");

        autoCarField.setText("jTextField2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1)
                    .addComponent(addNormalCarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAutoCarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(normalCarField)
                    .addComponent(autoCarField)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNormalCarButton)
                    .addComponent(normalCarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAutoCarButton)
                    .addComponent(autoCarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RoadTable;
    private javax.swing.JButton addAutoCarButton;
    private javax.swing.JButton addNormalCarButton;
    private javax.swing.JTextField autoCarField;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField normalCarField;
    // End of variables declaration//GEN-END:variables
}
