import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.text.DecimalFormat;
public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
       
       // essa seção pode ser reeditada de acordo com o método que o programador deseja ver funcionando.
       // Atualmente: Método para entrar com Contato com o Candidato.
       // O método de entrada de dados pode ser alterado para o método de entrada de dados do candidato.
       String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
       for(String candidato: candidatos){
           entrandoEmContato(candidato);
       }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------

    // Método para entrar com Contato com o Candidato
    static void entrandoEmContato(String candidato){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
            tentativasRealizadas++;
            else
            System.out.println("Contato realizado com Sucesso");

        }while(continuarTentando && tentativasRealizadas < 3);
        if (atendeu) {
            System.out.println("O candidato "+ candidato +" foi atendido em "+tentativasRealizadas+" tentativas");
        } else 
            System.out.println("Não conseguimos contato com " + candidato + " Número máximo de tentativas " + tentativasRealizadas);
    }

    //metodo auxiliar para entrar com Contato com o Candidato.
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------

    // Método para Imprimir a lista de candidatos
    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for(int indice=0; indice < candidatos.length;indice++){
            System.out.println("O candidato de nª " + (indice+1) + " é " + candidatos[indice]);
        }

        System.out.println("Forme abreviada de interação for each");
        for(String candidato : candidatos){
            System.out.println("O candidato Selecionado foi " + candidato);
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------------

    // Método para Selecionar os candidatos com base na sua preferencia de Salário
    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int candidatosAtual=0;
        double salarioBase = 2000.0f;
        DecimalFormat df = new DecimalFormat("#.00");
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + df.format(salarioPretendido));
            if (salarioBase >= salarioPretendido){
                System.out.println("O CANDIDATO " + candidato + " FOI SELECIONADO PARA VAGA");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------

    // Método para Analisar os candidatos com base na sua preferencia de Salário
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0f;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if(salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }else{
            System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
        }
    }
}
