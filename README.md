# Ejercicio Mer. Lib. Nivel 3 (Agosto 2019)
###### Autor: [Manuel Moya - mmoyam@gmail.com]
El objetivo de este documento es detallar la resolución del caso Mer. Lib. Nivel 3, donde se debe crear una api y desplegarlo en un servicio Cloud. Esto basado en el algortimo que detecta mutantes basados su secuencia de ADN del ejercicio anterior [(Nivel 1)](https://github.com/manumoya/MerLibNiv1/) y en la API /mutant/ publicada en [(Nivel 2)](https://github.com/manumoya/MerLibNiv2/).

### Enunciado

* Anexar una base de datos, la cual guarde los ADN’s verificados con la API.
* Solo 1 registro por ADN.
* Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las verificaciones de ADN:
 
		{“count_mutant_dna”:40, “count_human_dna”:100, “ratio”:0.4}

* Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico (Entre 100 y 1 millón de peticiones por segundo).
* Test-Automáticos, Code coverage > 80%
* Diagrama de Secuencia 
* Arquitectura del sistema.

### Entregables

* Código Fuente en repositorio github.
* Instrucciones de cómo ejecutar el programa o la API. 
* URL de la API.
* Documento en PDF.
* Dirgrama secuencia
* Diseño arquitectura

### Idea principal

* Tomar la API [(Nivel 2)](https://github.com/manumoya/MerLibNiv2/) y agregarle una Api para estadisticas.
* Usar base de datos MySql (servicio Azure).
* Crear DAO y procesos relacionados para que inserte y obtenga estadisticas.
* Explicar la forma de escalar la API.

### Supuestos
* No hay supuestos adicionales

### Descripción del programa

El programa considera los siguientes Packages

* **com.merlib.dao**: Contiene los programas que harán el acceso a la BD.
* **com.merlib.models**: Contiene los java beans utilizados.
* **com.merlib.process**: Contiene los programas que tienen algun proceso de negocio.
* **com.merlib.services**: Contiene los programas que habilitan la APIs.

Los programas son los siguientes:

* **com.merlib.dao**: 
	* AdnJDBC.java
* **com.merlib.models**: 
	* Estadistica.java
	* Persona.java
	* Respuesta.java
* **com.merlib.process**: 
	* Mutant.java
	* Stats.java
* **com.merlib.services**: 
	* Mutante.java
	* StatApi.java
	

### Pruebas automáticas

Las pruebas unitarias que cubren son:
 
* [MutantTest.java](https://github.com/manumoya/MerLibNiv3/tree/master/src/test/java/com/merlib/process/MutantTest.java).
* [AdnJDBCTest.java](https://github.com/manumoya/MerLibNiv3/tree/master/src/test/java/com/merlib/dao/AdnJDBCTest.java).
* [StatsTest.java](https://github.com/manumoya/MerLibNiv3/tree/master/src/test/java/com/merlib/process/StatsTest.java).

Adicionalmente, las API se probaron directamente con Postman y Jmeter.

### Arquitectura del sistema

Las arquitectura del sistema de un servidor es el siguiente:

![](img/diag_sol.png)

#### Escalabilidad

Las arquitectura del sistema es:

![](img/diag_sol_esc.png)


### Tecnología utilizada
* java 7.*
* Jersey 2.* (api framework)
* Junit 4.*
* Azure Cloud
* Linux Server
* Apache Tomacat 8.*
* Deploy basado en GitHub
* Postman (request client)
* Apache Jmeter 3.* (Performance tool)
* Maven (construcción y gestión del proyecto)
* BD MySql
* MAC OS X 	

### Traza
Los casos probados fueron los mismos casos de Nivel 2. Algunas de las trazas:

|Caso 1 = true | Caso 4 = true |
|---|---|
| ![](img/traza_caso1.png) | ![](img/traza_caso4.png) | 
| Caso 10 = false | Caso 11 = false |  
|![](img/traza_caso10.png) | ![](img/traza_caso11.png) |
|Caso 13 = true | Caso 16 = true | 
|![](img/traza_caso13.png) | ![](img/traza_caso16.png) | 
 

### ¿Se puede mejorar?

Se puede mejorar agregando persistencia BD como MyBatis o Hibernate.

### Ejecución del programa

* La url de la API es: [merlibniv2app2.azurewebsites.net](https://merlibniv2app2.azurewebsites.net/)

#### API /api/mutant/

* API Método: 
		
		POST
		
* API Path:
 
		/api/mutant/


* API json request:

		{
			“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
		}
		
* Response Status:

		200 ok o 403 Forbiden
		
* Response Body:

		{"mensaje": true} o {"mensaje": false}
		
* Header debe ser configurado con Content-Type = application/json

#### API /api/stats/

* API Método: 
		
		GET
		
* API Path:
 
		/api/stats/
		
* Response Status:

		200 ok
		
* Response Body:

		{"ratio":2.0,"mutante":6,"humano":3}	
	
* Header debe ser configurado con Content-Type = application/json