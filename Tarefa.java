// Tarefa.java
class Tarefa {
    private static int proximoId = 1;
    private int id;
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.id = proximoId++;
        this.descricao = descricao;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return String.format("%d. [%s] %s", id, (concluida ? "X" : " "), descricao);
    }
}