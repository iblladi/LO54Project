package fr.utbm.lo54.coursesession.security;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


		/**																							**
				 * 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*																	*
				 * 			CETTE CLASSE (BEAN) N'EST QU'UNE CLASSE DE CONFIGURATION	*
				 * 				DE LA SÉCURITÉ DE L'APPLICATION WEB EN UTILISANT		*
				 * 					"Spring Security" ET QUI SERA DÉTECTÉ ET			*
				 * 						DECLANCHÉ AUTOMATIQUEMENT PAR					*
				 * 								"Spring Boot"							*
				 * 																		*
				 * 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*								
		**																							**/

@Configuration
@EnableWebSecurity	//ACTIVER LE MODULE DE SECURITÉ SPRING SECURITY
@EnableGlobalMethodSecurity(securedEnabled=true) //ACTIVER L'ANNOTATION @SECURED POUR LES CONTROLLEURS DE LA COUCHE WEB
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	/* BEAN QUI PERMET L'ENCODAGE DU MOT DE PASSE */
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	/* CONFIGURATION DE LA CONNEXION AVEC UN IDENTIFIANT ET UN MOT DE PASSE DANS LA DATABASE */
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
				.passwordEncoder(passwordEncoder())
					.usersByUsernameQuery("select c.email as principal, c.password as credentials, c.activated from client c where c.email = ?")
						.authoritiesByUsernameQuery("select c.email, c.role from client c where c.email = ? ")
							.rolePrefix("ROLE_");
	}
	
	
	/* CONFIGURATION SERVEUR HTTP */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.authorizeRequests()			// AUTORISER LES REQUETES HTTP 
				.anyRequest()				//	ET N'IMPORTE QUELLE REQUETE
					.authenticated()		//	QUE SI LE PERSONNEL EST AUTHENTIFIÉ
						.and()				
						
			.formLogin()					// PAGE D'AUTHENTIFICATION
				.loginPage("/login")
						.defaultSuccessUrl("/index")	//SI REQUETE 200 OK --> PAGE D'ACCEUIL
							.failureUrl("/login?error")	//SINON REDIRECTION PAGE D'AUTHENTIFICATION
								.permitAll()
									.and()
									
			.logout()									//SE DECONNECTER
				.logoutUrl("/logout")
					.deleteCookies("JSESSIONID")		//SUPPRESSION DES COOKIES ET DE LA SESSION
						.invalidateHttpSession(true)	//SESSION INVALIDE APRES DÉCONNEXION
							.permitAll()
								.and()
								
			.exceptionHandling().accessDeniedPage("/403");	//ERREUR 403 (REQUETE NON AUTORISÉE)
			
	}

	
}
