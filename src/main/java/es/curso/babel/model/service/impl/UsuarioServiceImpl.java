package es.curso.babel.model.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.babel.model.entity.Usuario;
import es.curso.babel.model.repository.UsuarioRepository;
import es.curso.babel.model.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository userRepo;

	@Override
	public List<Usuario> getAllUsuarios() {
		return userRepo.findAll();
	}

	@Override
	public Usuario isUsuarioRegistered(String username, String password) {
		Usuario user = userRepo.findByUsername(username);
		if (user != null) {
			if (user.getUsername().equals(username) &&
					user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<String> añadirUsuario(String username, String password) {
		
		List<String> messages = new LinkedList<String>();
		
		if (username == null) {
			messages.add("El nombre no puede estar vacío");
		}
		
		if (password == null) {
			messages.add("La password no puede estar vacía");
		}		
		
		if (username.length() < 5) {
			messages.add("El número de carácteres de usuario debe ser mayor a 5");
		}
		
		if (password.length() < 7) {
			messages.add("La contraseña debe tener un mínimo de 7 carácteres");
		} 
		
		if (messages.size() == 0){
			Usuario usuario = new Usuario();
			usuario.setUsername(username);
			usuario.setPassword(password);
			userRepo.save(usuario);
			messages.add("Usuario registrado correctamente");
		}
		
		return messages;
	}

	@Override
	public Usuario findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
