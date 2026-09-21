import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipeTest {

    @BeforeEach 
    void setup(){
        Equipe e1 = new Equipe("cruzeiro");
        Equipe e2 = new Equipe("galo");
        PartidaDeVolei p1 = new PartidaDeVolei(e1, e2);

        p1.registrarPlacarSet(25, 0);
        p1.registrarPlacarSet(25, 0);
        p1.registrarPlacarSet(25, 0);
    }
    
    @Test 
    void registraPartidaCorretamente(){

        
        
    }

    @Test
    void calculaAproveitamentoTotalCorretamente() {
        //TODO

        double resp = e1.aproveitamentoTotal();
        assertEquals(Double.MAX_VALUE, resp);
    }

    @Test
    void calculaAproveitamentoSetsCorretamente() {
        //TODO
    }   
}