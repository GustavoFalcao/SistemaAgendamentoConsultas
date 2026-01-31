// Classe que representa uma consulta médica
public class Consulta {

    private Paciente paciente;
    private Medico medico;
    private String data;
    private String horario;
    private boolean ativa;

    // Construtor
    public Consulta(Paciente paciente, Medico medico, String data, String horario) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
        this.ativa = true;
    }

    // Cancela a consulta (DELETE lógico)
    public void cancelar() {
        this.ativa = false;
    }

    // Retorna a data da consulta
    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Paciente: " + paciente.getNome() +
               " | Médico: " + medico.getNome() +
               " | Data: " + data +
               " | Horário: " + horario +
               " | Status: " + (ativa ? "Ativa" : "Cancelada");
    }
}
