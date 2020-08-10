package com.desafio.desafio.config;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.desafio.desafio.repositories.ExameRepository;
import com.desafio.desafio.repositories.PacienteRepository;
import com.desafio.desafio.repositories.ProcedimentoRepository;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.desafio.desafio.dto.ExameDTO;
import com.desafio.desafio.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Instantiation implements CommandLineRunner{

        @Autowired
        private ProcedimentoRepository repo;

        @Autowired
        private PacienteRepository repoPaciente;

        @Autowired
        private ExameRepository repoExame;
      
        public void run(String... arg0) throws Exception{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

            repo.deleteAll();
            repoPaciente.deleteAll();
            repoExame.deleteAll();

            Procedimento maria = new Procedimento(null, "lsd", 7);
            Procedimento lucas = new Procedimento(null, "triangulo", 7);
            Paciente paciente1 = new Paciente("Lucas Pereira", "47885889866", "lucas_haya");
            Paciente paciente2= new Paciente("Lucas Fernandes", "47885889866", "lucas_haya");
            Exame exame1 = new Exame(paciente1, maria, sdf.parse("04/02/2018"), sdf.parse("08/02/2018"));
            Exame exame2 = new Exame(paciente2, lucas, sdf.parse("04/02/2019"), sdf.parse("08/02/2019"));
            System.out.println(exame1);
            System.out.println(exame2);
            System.out.println(maria);
            System.out.println(lucas);
            repo.saveAll(Arrays.asList(maria,lucas));
            repoPaciente.saveAll(Arrays.asList(paciente1,paciente2));
            
}
}