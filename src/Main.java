public class Main {
    public static void main(String[] args) {
        try {
            FiguraFactory fabrica = FiguraFactory.getInstance();

            // Criando um circulo
            Circulo circulo = fabrica.criarCirculo();

            // Tentando criar um segundo circulo (deve lancar excecao)
            try {
                Circulo outroCirculo = fabrica.criarCirculo();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Criando tres tipos de triângulos
            Triangulo t1 = fabrica.criarTriangulo("isoceles");
            Triangulo t2 = fabrica.criarTriangulo("equilatero");
            Triangulo t3 = fabrica.criarTriangulo("retangulo");

            // Tentando criar um quarto triangulo (deve lançar excecao)
            try {
                Triangulo t4 = fabrica.criarTriangulo("equilatero");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Criando multiplos quadrados
            Quadrado q1 = fabrica.criarQuadrado();
            Quadrado q2 = fabrica.criarQuadrado();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
