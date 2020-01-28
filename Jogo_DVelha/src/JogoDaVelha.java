
import javax.swing.JOptionPane;


public class JogoDaVelha {
        
    public static void main(String[] args) {
        String [][] tabuleiro = {{".",".","."},{".",".","."},{".",".","."}};           
        Player[] player;
        
        player = new Player[2];
       
        Principal principal = new Principal();
    
        for(int x=0;x<2;x++) // laço para jogadores inserirem nome e símbolo para colocar no tabuleiro
        {
            player[x] = new Player();
            player[x].Nome = JOptionPane.showInputDialog("Digite o nome de um Jogador");
            player[x].Simbolo = JOptionPane.showInputDialog("Jogador: " + player[x].Nome + ", escolha seu símbolo no tabuleiro");            
        }
         
        boolean Jogando; // determina a sequencia das jogadas dos jogadores
        String mesa = ""; // variável para montar tabuleiro
        int VezJogada = 1;  // determinar de quem vai ser a jogada            
        boolean turno = true; // determina se jogo vai continuar rodando
        int linha=0; // variavel para jogador inserir linha para jogada
        int coluna=0; // variavel para jogador inserir coluna para jogada
        boolean digit = true; // variavel para validar linha e coluna com numeros
        int rodada = 0; // variavel q determina se o jogo acaba em empate
        String[] result = new String[2]; // array para pegar informações se teve vencedor e qual foi
        
       
        while(turno == true) // bloco para continuar jogando
        {
            if(VezJogada == 1) // vez de jogada do primeiro jogador
            {   
                Jogando = true;
                while(Jogando == true) // bloco para dar sequencia nas jogadas
                {
                    digit = true; // variavel para entrar no while da linha e coluna
                    while(digit == true)
                    {
                        try{ // trycactch para apontar erro caso seja digitado algo q não seja numero
                        linha = Integer.parseInt(JOptionPane.showInputDialog("Jogador: " + player[0].Nome + "\nDigite sua Linha"));
                        coluna = Integer.parseInt(JOptionPane.showInputDialog("Jogador: " + player[0].Nome + "\nDigita sua Coluna"));
                        digit = false;
                        }
                        catch(Exception ex){
                                JOptionPane.showMessageDialog(null,"Valor inválido\nDigite a posição novamente");
                        }
                    }
                    
                    if( linha<3 && linha>=0 && coluna<3 && coluna>=0) // verifica se numero de linha e coluna estão entre 0 e 2
                    {
                        if(tabuleiro[linha][coluna].equals(".")) // verifica se posição escolhida ja não foi preenchida
                        {
                            tabuleiro[linha][coluna] = player[0].Simbolo;
                            VezJogada = 2;
                            rodada +=1;
                            principal.MontarTabuleiro(tabuleiro, mesa); // monta tabuleiro após jogada
                            result = Player.Resultado(tabuleiro,player[0], player[1],rodada); // método para vericar se jogador ganhou
                            Jogando = false; // definindo variavel como false para sair do while e seguir a vez do proximo jogador
                        }
                        else // Posição ja preenchida
                        {
                            JOptionPane.showMessageDialog(null,"Posição ja preenchida\nDigite a posição novamente");
                        }
                    }                   
                    else // posição inválida
                    {
                        JOptionPane.showMessageDialog(null,"Posição inválida\nDigite a posição novamente");
                    }
                }
                               
                if(result[0] == "Win" || result[0] != null) // verificação se jogador ganhou após jogada
                {                
                    turno = false;
                    break;
                }
                    
            }
            
            else if(VezJogada == 2) // vez de jogada do segundo jogador
            {
               Jogando = true;
               while(Jogando == true) // bloco para dar sequencia nas jogadas
               {
                    digit = true;
                    while(digit == true)// variavel para entrar no while da linha e coluna
                    {
                        try{ // trycactch para apontar erro caso seja digitado algo q não seja numero
                        linha = Integer.parseInt(JOptionPane.showInputDialog("Jogador: " + player[1].Nome + "\nDigite sua Linha"));
                        coluna = Integer.parseInt(JOptionPane.showInputDialog("Jogador: " + player[1].Nome + "\nDigita sua Coluna"));
                        digit = false;
                        }
                        catch(Exception ex){
                                JOptionPane.showMessageDialog(null,"Valor inválido\nDigite a posição novamente");
                        }
                    }
                    
                    if( linha<3 && linha>=0 && coluna<3 && coluna>=0) // verifica se numero de linha e coluna estão entre 0 e 2
                    {
                        if(tabuleiro[linha][coluna].equals("."))
                        {
                            tabuleiro[linha][coluna] = player[1].Simbolo;
                            VezJogada = 1;
                            rodada +=1;
                            principal.MontarTabuleiro(tabuleiro, mesa); // monta tabuleiro após jogada
                            result = Player.Resultado(tabuleiro,player[0], player[1],rodada); // método para veiricar se jogador ganhou
                            Jogando = false; // definindo variavel como false para sair do while e seguir a vez do proximo jogador
                        }
                        else // Posição ja preenchida
                        {
                            JOptionPane.showMessageDialog(null,"Posição ja preenchida\nDigite a posição novamente");
                        }
                    }
                    
                    else // posição inválida
                    {
                        JOptionPane.showMessageDialog(null,"Posição inválida\nDigite a posição novamente");
                    }
               }
               if(result[0] == "Win" || result[0] == "Empate" || result[0] != null) // verificação se jogador ganhou após jogada
               {                
                    turno = false;
                    break;
               }
            }            
            mesa = ""; // deixa a variavel mesa em branco para ser montada novamente atualizada                             
        } 
        JOptionPane.showMessageDialog(null, "Jogo Finalizado");
    }    
}
