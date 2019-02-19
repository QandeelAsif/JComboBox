
package gui_jcombobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_Jcombobox extends JFrame {

    private JComboBox dd_list;
    private JLabel image;

    private static String[] filename={"download.png","download (1).png","hello.png"}; //string array to hold images names only
    //a real important array of strings to hold the array of files/or picture options
    private Icon[] imageArray={new ImageIcon(getClass().getResource(filename[0])),new ImageIcon(getClass().getResource(filename[1])), new ImageIcon(getClass().getResource(filename[2]))};
    
      
    public static void main(String[] args) {
           new GUI_Jcombobox();
    }
    public GUI_Jcombobox()
    {
        setSize(500,400);
        setTitle("Drop box");
       setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JComboBox<String> box = new JComboBox<>(filename);// tells Jcombobox that it is a drop downlist of string type things
        box.addItemListener(
                new ItemListener()   //anonymous inner class
                {
               public void itemStateChanged(ItemEvent event)
               {
                 if (event.getStateChange()==ItemEvent.SELECTED)//if the state of the lsitener item is selected- 1 ==1  
                     image.setIcon(imageArray[box.getSelectedIndex()]); //sets image to the selected one
               }  }
        );
        add(box);
        image = new JLabel (imageArray [0]); //a starting default picture on the dropbox
        add(image);
        
        setVisible(true);           
        setLocationRelativeTo(null);

        
    }
}