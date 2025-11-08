package com.Agemed.agemed.controller;

import com.Agemed.agemed.dto.UsuarioCadastroDTO;
import com.Agemed.agemed.model.Usuario;
import com.Agemed.agemed.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Exibe a página de login customizada
    @GetMapping("/login")
    public String login() {
        return "login"; // view: /templates/login.html
    }

    // Exibe o formulário de cadastro
    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("usuario", new UsuarioCadastroDTO());
        return "cadastro"; // view: /templates/cadastro.html
    }

    // Processa o cadastro
    @PostMapping("/cadastro")
    public String cadastrarUsuario(@ModelAttribute("usuario") UsuarioCadastroDTO cadastroDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsername(cadastroDTO.getUsername());
        usuario.setPassword(cadastroDTO.getPassword());
        usuarioService.save(usuario);
        return "redirect:/login?success"; // Redireciona para o login com mensagem de sucesso
    }

    // Redirecionamento da página inicial
    @GetMapping("/")
    public String home() {
        return "redirect:/consultas"; // Redireciona para a listagem principal
    }
}