
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FiguraFactoryTest {
    private FiguraFactory factory;

    @BeforeEach
    public void setUp() {
        factory = FiguraFactory.getInstance();
    }

    @Test
    public void testSingletonInstance() {
        FiguraFactory factory2 = FiguraFactory.getInstance();
        assertSame(factory, factory2, "Erro: as instâncias de FiguraFactory não são iguais");
    }

    @Test
    public void testCriarCirculo() {
        Circulo circulo1 = factory.criarCirculo();
        assertNotNull(circulo1, "Erro: círculo não foi criado");

        // Testa a exceção ao tentar criar um segundo círculo
        assertThrows(IllegalStateException.class, factory::criarCirculo, "Erro: deveria lançar exceção para círculo duplicado");
    }

    @Test
    public void testCriarTrianguloLimiteMaximo() {
        Triangulo triangulo1 = factory.criarTriangulo("isoceles");
        Triangulo triangulo2 = factory.criarTriangulo("equilatero");
        Triangulo triangulo3 = factory.criarTriangulo("retangulo");

        assertNotNull(triangulo1, "Erro: triângulo isósceles não foi criado");
        assertNotNull(triangulo2, "Erro: triângulo equilátero não foi criado");
        assertNotNull(triangulo3, "Erro: triângulo retângulo não foi criado");

        // Testa a exceção ao tentar criar um quarto triângulo
        assertThrows(IllegalStateException.class, () -> factory.criarTriangulo("isoceles"), "Erro: deveria lançar exceção para limite de triângulos");
    }

    @Test
    public void testCriarTrianguloTipoInvalido() {
        // Testa a exceção ao fornecer um tipo inválido de triângulo
        assertThrows(IllegalArgumentException.class, () -> factory.criarTriangulo("hexagono"), "Erro: deveria lançar exceção para tipo de triângulo inválido");
    }

    @Test
    public void testCriarQuadrado() {
        Quadrado quadrado1 = factory.criarQuadrado();
        assertNotNull(quadrado1, "Erro: quadrado não foi criado");

        Quadrado quadrado2 = factory.criarQuadrado();
        assertNotNull(quadrado2, "Erro: quadrado não foi criado novamente");
    } 
}
