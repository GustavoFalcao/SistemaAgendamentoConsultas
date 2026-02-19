import java.util.Scanner;

// Classe principal do sistema
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Usuários fixos para teste
        Usuario admin = new Administrador("admin", "123");
        Usuario operador = new Operador("user", "123");

     // Dados iniciais (Simulação)
        Sistema.pacientes.add(new Paciente("João da Silva", "12345678901"));
        Sistema.pacientes.add(new Paciente("Maria Oliveira", "10987654321"));

        Sistema.medicos.add(new Medico("Dr. Carlos", "Clínico Geral"));
        Sistema.medicos.add(new Medico("Dra. Ana", "Pediatria"));
        
        // Login
        System.out.print("Usuário: ");
        String u = sc.nextLine();
        System.out.print("Senha: ");
        String s = sc.nextLine();

        Usuario logado = null;
        if (admin.autenticar(u, s)) logado = admin;
        else if (operador.autenticar(u, s)) logado = operador;

        if (logado == null) {
            System.out.println("Login inválido.");
            sc.close();
            return;
        }

        Log.registrar(logado.getUsername(), "Login no sistema");

        int op;
        do {
            // Menu
            if (logado.isAdmin()) {
                System.out.println("\n1 - Cadastrar paciente");
                System.out.println("2 - Listar pacientes");
                System.out.println("3 - Remover paciente");
                System.out.println("4 - Cadastrar médico");
                System.out.println("5 - Listar médicos");
                System.out.println("6 - Remover médico");
                System.out.println("7 - Agendar consulta");
                System.out.println("8 - Listar consultas");
                System.out.println("9 - Cancelar consulta");
                System.out.println("0 - Sair");
            } else {
                System.out.println("\n1 - Agendar consulta");
                System.out.println("2 - Listar consultas");
                System.out.println("0 - Sair");
            }

            op = sc.nextInt();
            sc.nextLine();

            // ADMINISTRADOR
            if (logado.isAdmin()) {
                switch (op) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        Sistema.cadastrarPaciente(new Paciente(nome, cpf), logado);
                        break;

                    case 2:
                        Sistema.listarPacientes();
                        break;

                    case 3:
                        Sistema.listarPacientes();
                        System.out.print("Índice do paciente: ");
                        int idxP = sc.nextInt();
                        sc.nextLine();
                        Sistema.removerPaciente(idxP, logado);
                        break;

                    case 4:
                        System.out.print("Nome médico: ");
                        String nm = sc.nextLine();
                        System.out.print("Especialidade: ");
                        String esp = sc.nextLine();
                        Sistema.cadastrarMedico(new Medico(nm, esp), logado);
                        break;

                    case 5:
                        Sistema.listarMedicos();
                        break;

                    case 6:
                        Sistema.listarMedicos();
                        System.out.print("Índice do médico: ");
                        int idxM = sc.nextInt();
                        sc.nextLine();
                        Sistema.removerMedico(idxM, logado);
                        break;

                    case 7:
                        // Validação: precisa existir paciente e médico
                        if (Sistema.pacientes.isEmpty() || Sistema.medicos.isEmpty()) {
                            System.out.println("Não é possível agendar consulta.");
                            System.out.println("É necessário ter paciente e médico cadastrados.");
                            break;
                        }

                        // Escolher paciente
                        System.out.println("Escolha o paciente:");
                        Sistema.listarPacientes();
                        int idxPaciente = sc.nextInt();
                        sc.nextLine();
                        Paciente p = Sistema.pacientes.get(idxPaciente);

                        // Escolher médico
                        System.out.println("Escolha o médico:");
                        Sistema.listarMedicos();
                        int idxMedico = sc.nextInt();
                        sc.nextLine();
                        Medico m = Sistema.medicos.get(idxMedico);

                        // Informar data e horário
                        System.out.print("Data: ");
                        String data = sc.nextLine();

                        System.out.print("Horário: ");
                        String horario = sc.nextLine();

                        // Criar e agendar consulta
                        Consulta c = new Consulta(p, m, data, horario);
                        Sistema.agendarConsulta(c, logado);
                        break;

                    case 8:
                        Sistema.listarConsultas();
                        break;

                    case 9:
                        Sistema.listarConsultas();
                        System.out.print("Índice da consulta: ");
                        int idxC = sc.nextInt();
                        sc.nextLine();
                        Sistema.cancelarConsulta(idxC, logado);
                        break;
                }
            } 
            // USUÁRIO COMUM
            else {
                switch (op) {                  
                    case 1:
                        // Validação: precisa existir paciente e médico
                        if (Sistema.pacientes.isEmpty() || Sistema.medicos.isEmpty()) {
                            System.out.println("Não é possível agendar consulta.");
                            System.out.println("É necessário ter paciente e médico cadastrados.");
                            break;
                        }

                        // Escolher paciente
                        System.out.println("Escolha o paciente:");
                        Sistema.listarPacientes();
                        int idxPaciente = sc.nextInt();
                        sc.nextLine();
                        Paciente p = Sistema.pacientes.get(idxPaciente);

                        // Escolher médico
                        System.out.println("Escolha o médico:");
                        Sistema.listarMedicos();
                        int idxMedico = sc.nextInt();
                        sc.nextLine();
                        Medico m = Sistema.medicos.get(idxMedico);

                        // Informar data e horário
                        System.out.print("Data: ");
                        String data = sc.nextLine();

                        System.out.print("Horário: ");
                        String horario = sc.nextLine();

                        // Criar e agendar consulta
                        Consulta c = new Consulta(p, m, data, horario);
                        Sistema.agendarConsulta(c, logado);
                        break;

                    case 2:
                        Sistema.listarConsultas();
                        break;
                }
            }

        } while (op != 0);

        Log.registrar(logado.getUsername(), "Logout");
        sc.close();
    }
}
