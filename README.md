# ☕ Gerenciador de Tarefas em Console (Java) ✨

💡 Sobre o Projeto
Este é um Gerenciador de Tarefas simples desenvolvido em Java para console. Ele demonstra conceitos fundamentais de Programação Orientada a Objetos (POO) e a manipulação básica de entrada/saída e coleções (ArrayList). Ideal para entender a estrutura de aplicações Java de console.

---

## Conecte-se comigo! 🤝

Ficarei feliz em conectar e trocar ideias! Você pode me encontrar no LinkedIn:

[![Meu LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/salomao-davi)

---

## 🎯 Funcionalidades
* Adicionar Tarefas: Crie novas tarefas.

* Listar Tarefas: Visualize todas as tarefas.

* Marcar como Concluída: Altere o status de uma tarefa.

* Remover Tarefas: Exclua tarefas existentes.

## 🚀 Como Rodar

1. Pré-requisitos: Certifique-se de ter o JDK 8+ instalado.

2. Clone o repositório:

````
git clone https://github.com/salomao-davi/GerenciadorDeTarefasJava.git
cd GerenciadorDeTarefasJava
````

3. Compile e Execute (via terminal ou IntelliJ IDEA):
````
# Se estiver no diretório raiz do projeto:
javac src/GerenciadorDeTarefas.java src/Tarefa.java
java -cp src GerenciadorDeTarefas
````

No IntelliJ, simplesmente clique no botão 'Run' ao lado da função ``main`` em ``GerenciadorDeTarefas.java.``

💻 Código:
``Tarefa.java``

````
// Tarefa.java
class Tarefa {
    private static int proximoId = 1; // Para gerar IDs únicos
    private int id;
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.id = proximoId++;
        this.descricao = descricao;
        this.concluida = false; // Tarefa nova não está concluída por padrão
    }

    // Getters para acessar os atributos da tarefa
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    // Método para marcar a tarefa como concluída
    public void marcarComoConcluida() {
        this.concluida = true;
    }

    // Sobrescrita do método toString() para uma representação amigável da tarefa
    @Override
    public String toString() {
        return String.format("%d. [%s] %s", id, (concluida ? "X" : " "), descricao);
    }
}
````

``GerenciadorDeTarefas.java``

````
import java.util.ArrayList; // Para usar listas dinâmicas
import java.util.List;      // Interface para coleções
import java.util.Scanner;   // Para ler entrada do usuário

// Classe principal do Gerenciador de Tarefas
public class GerenciadorDeTarefas {
    private List<Tarefa> tarefas; // Lista para armazenar as tarefas
    private Scanner scanner;      // Objeto para ler a entrada do console

    // Construtor da classe
    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>(); // Inicializa a lista de tarefas
        this.scanner = new Scanner(System.in); // Inicializa o scanner
    }

    // Método para adicionar uma nova tarefa
    public void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine(); // Lê a descrição
        tarefas.add(new Tarefa(descricao)); // Cria e adiciona a nova tarefa
        System.out.println("Tarefa adicionada com sucesso!");
    }

    // Método para listar todas as tarefas
    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa para exibir.");
            return;
        }
        System.out.println("\n--- Lista de Tarefas ---");
        for (Tarefa tarefa : tarefas) { // Itera sobre a lista e imprime cada tarefa
            System.out.println(tarefa);
        }
        System.out.println("------------------------\n");
    }

    // Método para marcar uma tarefa como concluída
    public void marcarTarefaComoConcluida() {
        System.out.print("Digite o ID da tarefa para marcar como concluída: ");
        int id = scanner.nextInt(); // Lê o ID da tarefa
        scanner.nextLine(); // Consumir a nova linha após ler o int

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) { // Encontra a tarefa pelo ID
                tarefa.marcarComoConcluida(); // Marca como concluída
                System.out.println("Tarefa marcada como concluída!");
                return;
            }
        }
        System.out.println("Tarefa com ID " + id + " não encontrada.");
    }

    // Método para remover uma tarefa
    public void removerTarefa() {
        System.out.print("Digite o ID da tarefa para remover: ");
        int id = scanner.nextInt(); // Lê o ID
        scanner.nextLine(); // Consumir a nova linha

        // Remove a tarefa se o ID corresponder
        boolean removida = tarefas.removeIf(t -> t.getId() == id);
        if (removida) {
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa com ID " + id + " não encontrada.");
        }
    }

    // Método para exibir o menu de opções
    public void exibirMenu() {
        System.out.println("\n--- Gerenciador de Tarefas ---");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Remover Tarefa");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Método principal que inicia a aplicação
    public void iniciar() {
        int opcao;
        do {
            exibirMenu(); // Exibe o menu
            opcao = scanner.nextInt(); // Lê a opção do usuário
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) { // Executa a ação baseada na opção
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
        } while (opcao != 5); // Continua até o usuário escolher sair
        scanner.close(); // Fecha o scanner para liberar recursos
    }

    // Método main onde a execução do programa começa
    public static void main(String[] args) {
        GerenciadorDeTarefas app = new GerenciadorDeTarefas(); // Cria uma instância do gerenciador
        app.iniciar(); // Inicia o aplicativo
    }
}
````
---
![Captura de tela 2025-06-26 190256](https://github.com/user-attachments/assets/77718bde-8982-4990-b0b2-1050f83fe124)

---

## 📚 Exemplo de Uso
Ao executar o programa, você verá um menu interativo no console:

````
--- Gerenciador de Tarefas ---
1. Adicionar Tarefa
2. Listar Tarefas
3. Marcar Tarefa como Concluída
4. Remover Tarefa
5. Sair
Escolha uma opção:
````






# 💡 Próximos Passos (Ideias para Expansão)

* Persistência de Dados: Salvar tarefas em arquivo ou banco de dados.

* Interface Gráfica: Desenvolver uma UI com Swing ou JavaFX.

* Testes Unitários: Adicionar cobertura de testes para a aplicação.


