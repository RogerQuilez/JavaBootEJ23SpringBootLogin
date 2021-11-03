package es.curso.babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.babel.model.entity.Usuario;
import es.curso.babel.model.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private Usuario usuario;
	
	@RequestMapping(value= {"", "login"})
	public String getLogin() {
		return "login";
	}

	@PostMapping("login")
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password, Model model) {
		
		Usuario usuarioRegistered = userService.isUsuarioRegistered(username, password);

		if (usuarioRegistered != null) {
			usuario.setUsername(usuarioRegistered.getUsername());
			usuario.setId(usuarioRegistered.getId());
			return "redirect:/videojuegos";
		} else {
			model.addAttribute("message", "El usuario no se encuentra registrado");
			return "login";
		}

	}
	
	@GetMapping("formLogin")
	public String getFormLogin() {
		return "formRegistro";
	}
	
	@PostMapping("formLogin")
	public String newUser(@RequestParam("username") String username, 
			@RequestParam("password") String password, Model model) {
		
		List<String> messages = userService.añadirUsuario(username, password);
		
		if (messages.get(0) == "Usuario registrado correctamente") {
			model.addAttribute("message", messages.get(0));
			return "redirect:/login";
		} else {
			model.addAttribute("messages", messages);
			return "formRegistro";
		}
		
	}

}
