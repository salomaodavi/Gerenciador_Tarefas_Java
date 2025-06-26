// GerenciadorDeTarefas.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeTarefas {
    private List<Tarefa> tarefas;
    private Scanner scanner;

    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        tarefas.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa para exibir.");
            return;
        }
        System.out.println("\n--- Lista de Tarefas ---");
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
        System.out.println("------------------------\n");
    }

    public void marcarTarefaComoConcluida() {
        System.out.print("Digite o ID da tarefa para marcar como concluída: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.marcarComoConcluida();
                System.out.println("Tarefa marcada como concluída!");
                return;
            }
        }
        System.out.println("Tarefa com ID " + id + " não encontrada.");
    }

    public void removerTarefa() {
        System.out.print("Digite o ID da tarefa para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        boolean removida = tarefas.removeIf(t -> t.getId() == id);
        if (removida) {
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa com ID " + id + " não encontrada.");
        }
    }

    public void exibirMenu() {
        System.out.println("\n--- Gerenciador de Tarefas ---");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Remover Tarefa");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    marcarTarefaComoConcluida();
                    break;
                case 4:
                    removerTarefa();
                    break;
                case 5:
                    System.out.println("Saindo do Gerenciador de Tarefas. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
        scanner.close();
    }

    public static void main(String[] args) {
        GerenciadorDeTarefas app = new GerenciadorDeTarefas();
        app.iniciar();
    }
}