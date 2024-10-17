public class App {
    public static void main(String[] args) throws Exception {

        //Objeto - Galinha Carijó
        Cliente carijo = new Cliente();

        carijo.setNome("Carijó");
        carijo.setIdade(2);
        carijo.setCor("Amarelo");

        System.out.println("\nEu cadastrei a galinha com nome: " + carijo.getNome() + ", idade: " + carijo.getIdade() + ", cor: " + carijo.getCor());

        //Objeto - Galinha Mimosa
        Cliente mimosa = new Cliente();
        mimosa.setNome("Mimosa");
        mimosa.setIdade(4);
        mimosa.setCor("Vermelho");

        System.out.println("\nEu cadastrei a galinha com nome: " + mimosa.getNome() + ", idade: " + mimosa.getIdade() + ", cor: " + mimosa.getCor());
    }
}