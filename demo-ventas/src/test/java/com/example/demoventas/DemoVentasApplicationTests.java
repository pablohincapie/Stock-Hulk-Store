package com.example.demoventas;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;

import static org.junit.Assert.*;



import com.ventas.demo.common.Util;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoVentasApplicationTests {

	@Test
	public void contextLoads() {
		testCalculateTotal();
	}
	
	@Mock
    public Util util;
 
    
	@Test
    public void testCalculateTotal() {
        float precio =10000;
        int cantidad= 15;
    	int resultado = (int) (cantidad * precio); 
    	int resultadoEsperado  = 150000;
        assertEquals(resultadoEsperado,resultado);
    }

}
