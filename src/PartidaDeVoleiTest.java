
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PartidaDeVoleiTest {
    PartidaDeVolei partida;
    Equipe equipe1;
    Equipe equipe2;

    @BeforeEach
    public void setUp(){
        //Arrange
        equipe1 = new Equipe("Equipe1");
        equipe2 = new Equipe("Equipe2");
        partida = new PartidaDeVolei(equipe1, equipe2);
    }

    public void partida3Sets(){
        partida.registrarPlacarSet(25, 20);
        partida.registrarPlacarSet(25, 20);
        partida.registrarPlacarSet(25, 20);
    }

    public void partida4Sets(){
        partida.registrarPlacarSet(25, 20);
        partida.registrarPlacarSet(25, 20);
        partida.registrarPlacarSet(20, 25);
        partida.registrarPlacarSet(20, 25);
    }

    @Test
    void registrarPlacarSetCorretamente() {
        //Act
        boolean primeiroSet = partida.registrarPlacarSet(25, 20);
        //Assert
        assertTrue(primeiroSet);
    }

    @Test
    void naoAceitaSetIncompleto() {
        //Act
        boolean primeiroSet = partida.registrarPlacarSet(23, 20);
        //Assert
        assertFalse(primeiroSet);
    }

    @Test
    void registraSetComVaiADois() {
        //Act
        boolean primeiroSet = partida.registrarPlacarSet(31, 29);
        //Assert
        assertTrue(primeiroSet);
    }

    @Test
    void registrarQuintoSetCorretamente() {
        //Arrange
        partida4Sets();
        //Act
        boolean quintoSet = partida.registrarPlacarSet(15, 9);
        //Assert
        assertTrue(quintoSet);
    }

    @Test
    void naoRegistraQuintoSetCom25Pontos() {
        //Arrange
        partida4Sets();
        //Act
        boolean quintoSet = partida.registrarPlacarSet(25, 10);
        //Assert
        assertFalse(quintoSet);
    }

    @Test
    void calculaPontosTotaisMandante() {
        //Arrange
        partida3Sets();
        //Act
        int pontos = partida.pontosTotaisEquipe("Equipe1");
        //Assert
        assertEquals(75, pontos);
    }

    @Test
    void calculaPontosTotaisVisitante() {
        //Arrange
        partida3Sets();
        //Act
        int pontos = partida.pontosTotaisEquipe("Equipe2");
        //Assert
        assertEquals(60, pontos);
    }

    @Test
    void retornaVencedorDoJogo(){
        //Arrange
        partida3Sets();
        //Act
        String vencedor = partida.vencedorDoJogo();
        //Assert
        assertEquals("Equipe1", vencedor);
    }
    
    @Test
    void testExibirPlacar() {
        //Arrange
        partida3Sets();
        String cabecalho = String.format("%16s\t1\t2\t3\t4\t5\tFINAL\n", " ");
        String placar1 = String.format("%16s\t25\t25\t25\t--\t--\t3\n", "Equipe1");
        String placar2 = String.format("%16s\t20\t20\t20\t--\t--\t0\n", "Equipe2");
        //Act
        String placar = partida.exibirPlacar();
        //Assert
        assertTrue(placar.contains(cabecalho) && placar.contains(placar1) && placar.contains(placar2));
    }
    

    @Test
    void testSetsDisputados() {
        //Arrange
        partida4Sets();
        //Act
        int sets = partida.setsDisputados();
        //Assert
        assertEquals(4, sets);
    }

    @Test
    void testSetsVencidosEquipe() {
        //Arrange
        partida4Sets();
        //Act
        int vencidos = partida.setsVencidosEquipe("Equipe2");
        //Assert
        assertEquals(2, vencidos);
    }

    
}
