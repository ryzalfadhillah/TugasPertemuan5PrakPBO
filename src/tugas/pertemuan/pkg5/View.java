package tugas.pertemuan.pkg5;

import javax.swing.*;
import java.awt.event.*;
import java.util.InputMismatchException;

public class View extends JFrame implements ActionListener{
    // ========== Component ==========
    
    //title
    JLabel ltitle = new JLabel("Cube Calculator");
    
    //Input length
    JLabel llength = new JLabel("Length");
    JTextField flength = new JTextField();
    
    //input width
    JLabel lwidth = new JLabel("Width");
    JTextField fwidth = new JTextField();
    
    //input height
    JLabel lheight = new JLabel("Height");
    JTextField fheight = new JTextField();
    
    //button
    JButton btncount = new JButton("Count");
    JButton btnreset = new JButton("Reset");
    
    //result
    JLabel lresult = new JLabel("Result");
    JLabel larea = new JLabel();
    JLabel lcircumference = new JLabel();
    JLabel lvolume = new JLabel();
    JLabel lsurface = new JLabel();
    
    // ========== END Component ==========
    
    // ========== Frame ==========
    public View (){
        setTitle("Cube Calculator");
        setSize(500, 600);
        setLayout(null);
        
        //add component to frame
        add(ltitle);
        add(llength);
        add(flength);
        add(lwidth);
        add(fwidth);
        add(lheight);
        add(fheight);
        add(lresult);
        add(lresult);
        add(larea);
        add(lcircumference);
        add(lvolume);
        add(lsurface);
        add(btncount);
        add(btnreset);
        
        
        //bounds
        ltitle.setBounds(195, 30, 130, 25);
        llength.setBounds(50, 100, 100, 25);
        flength.setBounds(150, 100, 250, 25);
        lwidth.setBounds(50, 140, 100, 25);
        fwidth.setBounds(150, 140, 250, 25);
        lheight.setBounds(50, 180, 100, 25);
        fheight.setBounds(150, 180, 250, 25);
        lresult.setBounds(220, 220, 100, 25);
        larea.setBounds(50, 260, 200, 25);
        lcircumference.setBounds(50, 300, 200, 25);
        lvolume.setBounds(50, 340, 200, 25);
        lsurface.setBounds(50, 380, 200, 25);
        btncount.setBounds(160, 500, 80, 25);
        btnreset.setBounds(260, 500, 80, 25);
        
        //Event
        btncount.addActionListener(this);
        btnreset.addActionListener(this);
        btncount.setActionCommand("count");
        btnreset.setActionCommand("reset");
        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
    }
    
    // ========== END Frame ==========

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch(command){
            case "count" :
                double length = 0;
                double width = 0 ;
                double height = 0;
                
                try{
                    length = Double.parseDouble(flength.getText());
                    width = Double.parseDouble(fwidth.getText());
                    height = Double.parseDouble(fheight.getText());
                }catch(Exception error ){
                    JOptionPane.showMessageDialog(null, error.getMessage());                    
                }finally{
                    double area =  length * width;
                    double circumference = 2*(length + width);
                    double volume = length * width * height;
                    double surface = 2 * (length*width + length*height + width*height);

                    larea.setText("Square Area              : " + area);
                    lcircumference.setText("Square Circumference : " + circumference);
                    lvolume.setText("Cube Volume              : " + volume);
                    lsurface.setText("Cube Surface Area      : " + surface);
                }               
                break;
            case "reset" :
                flength.setText("");
                fwidth.setText("");
                fheight.setText("");
                larea.setText("");
                lcircumference.setText("");
                lvolume.setText("");
                lsurface.setText("");
                break;
            default : 
                break;
        }
    }

}
