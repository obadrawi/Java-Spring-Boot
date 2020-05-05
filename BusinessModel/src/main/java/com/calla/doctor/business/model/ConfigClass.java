package com.calla.doctor.business.model;

import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.OpenJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.calla.doctor.business.manager.DoctorManager;
import com.calla.doctor.business.manager.PatientManager;
import com.calla.doctor.business.manager.ReservationManager;


@Configuration
@ComponentScan("com.calla.doctor")
@EnableTransactionManagement
@EnableJpaRepositories("com.calla.doctor.datamodel")
@EntityScan("com.calla.doctor.datamodel")
public class ConfigClass {
	
   @Bean
   public PatientManager patientManager()
   {
	   return new PatientManager();
   }
   
   @Bean
   public DoctorManager doctorManager()
   {
	   return new DoctorManager();
   }
   
   @Bean
   public ReservationManager reservationManager()
   {
	   return new ReservationManager();
   }

}
