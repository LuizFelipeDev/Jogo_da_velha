
import javax.swing.JOptionPane;


public class Player 
{
    public String Nome;
    public String Simbolo;
    
    
    
    public static String[] Resultado(String[][] tabuleiro, Player nome1, Player nome2, int rodada)
    {
        String[] result = new String[2];
               
        
        for(int x=0;x<3;x++) // Comparações 
        {       
            for(int y=0;y<3;y++)
            {                    
                // Comparação Horizontal
                if(tabuleiro[x-x][y].equals(tabuleiro[x+1-x][y]) && tabuleiro[x+1-x][y].equals(tabuleiro[x+2-x][y]) && !tabuleiro[x][y].equals("."))
                {
                    if(tabuleiro[x-x][y].equals(nome1.Simbolo)) // verifica se primeiro jogador ganhou
                    {
                        JOptionPane.showMessageDialog(null, "Jogador " + nome1.Nome + " venceu!!!");
                        result[0] = "Win";
                        result[1] = nome1.Nome;
                        return result;
                    }
                    else if(tabuleiro[0][0].equals(nome2.Simbolo)) // verifica se segundo jogador ganhou
                    {
                        JOptionPane.showMessageDialog(null, "Jogador " + nome2.Nome + " venceu!!!");
                        result[0] = "Win";
                        result[1] = nome2.Nome;
                        return result;
                    }
                }                
                // Comparação Vertical
                
                else if(tabuleiro[x][y-y].equals(tabuleiro[x][y+1-y]) && tabuleiro[x][y+1-y].equals(tabuleiro[x][y+2-y]) && !tabuleiro[x][y].equals("."))
                {                   
                    if(tabuleiro[x][y-y].equals(nome1.Simbolo)) // verifica se primeiro jogador ganhou
                    {
                        JOptionPane.showMessageDialog(null, "Jogador " + nome1.Nome + " venceu!!!");
                        result[0] = "Win";
                        result[1] = nome1.Nome;
                        return result;
                    }
                    else if(tabuleiro[0][0].equals(nome2.Simbolo)) // verifica se segundo jogador ganhou
                    {
                        JOptionPane.showMessageDialog(null, "Jogador " + nome2.Nome + " venceu!!!");
                        result[0] = "Win";
                        result[1] = nome2.Nome;
                        return result;
                    }
                }
                   
                //Comparação Diagonal
                else if((tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][2]) && !tabuleiro[0][0].equals(".")) ||
                        (tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][0]) && !tabuleiro[0][2].equals(".")))
                {
                    if(tabuleiro[0][0].equals(nome1.Simbolo)) // verifica se primeiro jogador ganhou
                    {
                        JOptionPane.showMessageDialog(null, "Jogador " + nome1.Nome + " venceu!!!");
                        result[0] = "Win";
                        result[1] = nome1.Nome;
                        return result;
                    }
                    else if(tabuleiro[0][0].equals(nome2.Simbolo)) // verifica se segundo jogador ganhou
                    {
                        JOptionPane.showMessageDialog(null, "Jogador " + nome2.Nome + "venceu!!!");
                        result[0] = "Win";
                        result[1] = nome2.Nome;
                        return result;
                    }                     
                }
                else if(rodada>=9)
                {
                    JOptionPane.showMessageDialog(null, "Empate");
                    result[0] = "Empate";                    
                    return result;
                }
            }   
            
        }
        return result;
    }   
}
