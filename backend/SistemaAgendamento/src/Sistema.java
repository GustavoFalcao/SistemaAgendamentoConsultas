import java.util.ArrayList;

// Classe que contém as regras de negócio
public class Sistema {

    public static ArrayList<Paciente> pacientes = new ArrayList<>();
    public static ArrayList<Medico> medicos = new ArrayList<>();
    public static ArrayList<Consulta> consultas = new ArrayList<>();

    // ===== CRUD PACIENTE =====

    // CREATE - somente administrador
    public static void cadastrarPaciente(Paciente p, Usuario u) {
        if (!u.isAdmin()) {
            System.out.println("Apenas administradores podem cadastrar pacientes.");
            return;
        }
        pacientes.add(p);
        Log.registrar(u.getUsername(), "Cadastro de paciente: " + p.getNome());
    }

    // READ
    public static void listarPacientes() {
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + " - " + pacientes.get(i));
        }
    }

    // DELETE - somente administrador
    public static void removerPaciente(int index, Usuario u) {
        if (!u.isAdmin()) {
            System.out.println("Apenas administradores podem remover pacientes.");
            return;
        }
        Paciente p = pacientes.remove(index);
        Log.registrar(u.getUsername(), "Remoção de paciente: " + p.getNome());
    }

    // ===== CRUD MÉDICO =====

    // CREATE - somente administrador
    public static void cadastrarMedico(Medico m, Usuario u) {
        if (!u.isAdmin()) {
            System.out.println("Apenas administradores podem cadastrar médicos.");
            return;
        }
        medicos.add(m);
        Log.registrar(u.getUsername(), "Cadastro de médico: " + m.getNome());
    }

    // READ
    public static void listarMedicos() {
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(i + " - " + medicos.get(i));
        }
    }

    // DELETE - somente administrador
    public static void removerMedico(int index, Usuario u) {
        if (!u.isAdmin()) {
            System.out.println("Apenas administradores podem remover médicos.");
            return;
        }
        Medico m = medicos.remove(index);
        Log.registrar(u.getUsername(), "Remoção de médico: " + m.getNome());
    }

    // ===== CONSULTAS =====

    // CREATE
    public static void agendarConsulta(Consulta c, Usuario u) {
        consultas.add(c);
        Log.registrar(u.getUsername(), "Consulta agendada");
    }

    // READ
    public static void listarConsultas() {
        for (Consulta c : consultas) {
            System.out.println(c);
        }
    }

    // Relatório: consultas por data
    public static void listarConsultasPorData(String data) {
        for (Consulta c : consultas) {
            if (c.getData().equals(data)) {
                System.out.println(c);
            }
        }
    }

    // DELETE lógico (cancelamento) - somente administrador
    public static void cancelarConsulta(int index, Usuario u) {
        if (!u.isAdmin()) {
            System.out.println("Apenas administradores podem cancelar consultas.");
            return;
        }
        consultas.get(index).cancelar();
        Log.registrar(u.getUsername(), "Consulta cancelada");
    }
}
