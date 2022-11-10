
package guı;

import java.awt.Font;


public class ozellik1 {
    GUI gui;
    Font ITALIC,BOLD,NORMAL;
    String secilen;
    public ozellik1(GUI gui){
        this.gui = gui;
    }
    public void olusturfont(){
        NORMAL = new Font("NORMAL", Font.PLAIN, 20);
        ITALIC = new Font("ITALIC",Font.ITALIC,20);
        BOLD = new Font("BOLD",Font.BOLD,20);   
        duzenlefont(secilen);
    }
    public void duzenlefont(String font){
      secilen =font;
      
        switch (secilen) {
            case "ITALIC":
                gui.yazi.setFont(ITALIC);
                
                break;
            case "BOLD":
                gui.yazi.setFont(BOLD);
                break;
        }
    }


}
