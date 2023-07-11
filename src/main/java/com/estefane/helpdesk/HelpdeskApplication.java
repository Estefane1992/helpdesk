package com.estefane.helpdesk;

import com.estefane.helpdesk.domain.Chamado;
import com.estefane.helpdesk.domain.Cliente;
import com.estefane.helpdesk.domain.Tecnico;
import com.estefane.helpdesk.domain.enums.Perfil;
import com.estefane.helpdesk.domain.enums.Prioridade;
import com.estefane.helpdesk.domain.enums.Status;
import com.estefane.helpdesk.repositores.ChamadoRepository;
import com.estefane.helpdesk.repositores.ClienteRepository;
import com.estefane.helpdesk.repositores.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "estefane", "01681767260", "fanny@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "joana Lima", "04370710227", "joana@gmail.com", "132");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,"Chamado 01", "Primeiro chamado", tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));


	}
}
