package com.curso.api.cursoApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.api.cursoApi.entities.Curso;

@SpringBootApplication
public class CursoApiApplication {

	public static void main(String[] args) throws ParseException {
		
		SpringApplication.run(CursoApiApplication.class, args);
		
		
		
	}
	
}
