package br.com.fatec.sistemacomercioweb;

import br.com.fatec.sistemacomercioweb.model.Cliente;
import br.com.fatec.sistemacomercioweb.service.ClienteService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class TesteCliente {
    public static void main(String[] args) {
        // Inicializa o Spring Boot
        try (ConfigurableApplicationContext context =
                     SpringApplication.run(SistemaComercioWebApplication.class, args)) {

            // Obtém o Service gerido pelo Spring
            ClienteService service = context.getBean(ClienteService.class);

            // TESTE 1 - CADASTRAR CLIENTE
            Cliente cliente = new Cliente(
                    "Maria Oliveira",
                    "12345678909",
                    "11999999999",
                    "maria@email.com"
            );
            Cliente clienteSalvo = service.cadastrar(cliente);
            System.out.println("Cliente cadastrado! ID: " + clienteSalvo.getId());

            // TESTE 2 - LISTAR CLIENTES
            System.out.println("\nLISTA DE CLIENTES:");
            for (Cliente c : service.listar()) {
                System.out.println("- " + c.getNome() + " (" + c.getCpf() + ")");
            }
        }
    }
}