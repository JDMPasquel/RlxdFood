package co.edu.unicauca.componentservice.contextLoadsTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.unicauca.componentservice.controller.ComponentController;

@SpringBootTest
class ComponentServiceApplicationContextTests {

	@Autowired
	private ComponentController controller;

	/***
	 * The server port used by the service will be storage into the serverPort variable 
	 */
	@Value("${server.port}")
	private int serverPort;

	@Test
	void contextLoads(){
		assertThat(controller).isNotNull();
	}

	@Test
	void gettingPort(){
		assertThat(serverPort).isNotNull();
		//For the Component service the port wont be assigned automatic, is configured insted.
		assertThat(serverPort).isNotEqualTo(0);
		assertThat(serverPort).isEqualTo(7777);
	}
}
