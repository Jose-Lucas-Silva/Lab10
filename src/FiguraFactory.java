public class FiguraFactory {

    private static FiguraFactory instanciaUnica;
    private Circulo circulo;
    private int contadorTriangulos = 0;

    private FiguraFactory() {}

    public static FiguraFactory getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new FiguraFactory();
        }
        return instanciaUnica;
    }

    public Circulo criarCirculo() {
        if (circulo != null) {
            throw new IllegalStateException("Erro: ja existe um circulo criado.");
        }
        circulo = new Circulo();
        return circulo;
    }

    public Triangulo criarTriangulo(String tipo) {
        if (contadorTriangulos >= 3) {
            throw new IllegalStateException("Erro: maximo de tres triangulos ja criados.");
        }
        Triangulo triangulo;
        switch (tipo.toLowerCase()) {
            case "isoceles":
                triangulo = new TrianguloIsosceles();
                break;
            case "equilatero":
                triangulo = new TrianguloEquilatero();
                break;
            case "retangulo":
                triangulo = new TrianguloRetangulo();
                break;
            default:
                throw new IllegalArgumentException("Erro: tipo de triangulo invalido.");
        }
        contadorTriangulos++;
        return triangulo;
    }

    public Quadrado criarQuadrado() {
        return new Quadrado();
    }
}
