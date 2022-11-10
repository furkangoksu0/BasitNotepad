/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guı;

import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.red;


public class ozellik2 {
   GUI gui;
       public ozellik2(GUI gui){
        this.gui = gui;
    }
       public void renkdegis(String renk){
          
           switch(renk){
              case "ORIGINAL":
                 gui.pencere.getContentPane().setBackground(Color.white);
                 gui.yazi.setBackground(Color.white);
                 gui.yazi.setForeground(Color.black);
                  break;
              case "KIRMIZI":
                 gui.pencere.getContentPane().setBackground(Color.red);
                 gui.yazi.setBackground(Color.red); 
                 
                  break; 
              case "MAVI":
                 gui.pencere.getContentPane().setBackground(Color.blue);
                 gui.yazi.setBackground(Color.blue);
                 
                  break;
       }
   
}

}