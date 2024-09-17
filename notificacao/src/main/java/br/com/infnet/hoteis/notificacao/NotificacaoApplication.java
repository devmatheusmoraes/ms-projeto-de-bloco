package br.com.infnet.hoteis.notificacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacaoApplication.class, args);
	}

}
