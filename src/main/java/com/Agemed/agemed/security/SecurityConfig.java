package com.Agemed.agemed.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Define o PasswordEncoder como Bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. Configura a cadeia de filtros de segurança
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Configuração das Autorizações
                .authorizeHttpRequests(auth -> auth
                        // Permite acesso irrestrito a recursos estáticos, cadastro e tela inicial
                        .requestMatchers("/", "/css/**", "/js/**", "/cadastro/**").permitAll()
                        // Permite o acesso irrestrito à API de agenda
                        .requestMatchers("/api/agenda/**").permitAll()
                        // Permite acesso ao console do H2 (se estiver usando)
                        .requestMatchers("/h2-console/**").permitAll()
                        // Todas as outras rotas requerem autenticação
                        .anyRequest().authenticated()
                )
                // Configuração do Formulário de Login
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                // Configuração do Logout
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                // Desabilita CSRF (necessário para H2/API REST)
                .csrf(csrf -> csrf.disable())
                // Usa a sintaxe moderna para desabilitar opções de cabeçalho
                .headers(headers -> headers.disable());

        return http.build();
    }

    // 3. O MÉTODO configureGlobal FOI REMOVIDO
    // O Spring Security irá detectar o UsuarioService (que implementa UserDetailsService)
    // e o PasswordEncoder automaticamente, quebrando o ciclo de dependência.
}