/*
import java.time.LocalDate;
import java.time.Period;
*/

public class Cliente {
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String telefone;

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /*
    //Métodos
    public void salvarGalinha() {
        System.out.println("Galinha salva.");
    }

    public boolean excluirGalinha() {
        System.out.println("Galinha excluída.");
        return true;
    }

    public int calculaIdadeGalinha(String dataNascimento) {
        Period period = Period.between(LocalDate.parse(dataNascimento), LocalDate.now());
        return period.getYears();
    }

    public String calculaIdadeCompleta(String dataNascimento) {
        LocalDate nascimento = LocalDate.parse(dataNascimento);
        LocalDate agora = LocalDate.now();
        Period period = Period.between(nascimento, agora);

        int anos = period.getYears();
        int meses = period.getMonths();
        int dias = period.getDays();

        return anos + " anos, " + meses + " meses e " + dias + " dias";
    }

    public void mostrarDadosNaTela() {
        System.out.println("Nome da Galinha: " + nome);
        System.out.println("Idade da Galinha: " + idade);
        System.out.println("Sexo da Galinha: " + sexo);
    }
    */
}