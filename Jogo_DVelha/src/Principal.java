
import javax.swing.JOptionPane;

public class Principal {
    
    public void MontarTabuleiro(String[][] tabuleiro, String mesa)
    {
        for(int x=0;x<3;x++)
        {
            for(int y=0;y<3;y++)
            {                         
                if(x == 0 && y == 2)
                {
                    mesa += (tabuleiro[x][y]) + "     \n";
                }
                else if(x == 1 && y == 2 )
                {
                    mesa += (tabuleiro[x][y]) + "     \n";
                }                        
                else
                {
                    mesa += (tabuleiro[x][y])+ "      ";
                }                   
            }
        }
        JOptionPane.showMessageDialog(null, mesa);
    }                         
}
