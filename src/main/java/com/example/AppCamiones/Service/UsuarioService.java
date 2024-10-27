package com.example.AppCamiones.Service;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.AppCamiones.Model.UsuarioModel;
import com.example.AppCamiones.Repository.UsuarioRepository;

@Service
public class UsuarioService implements  UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioModel usuario = usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
		
		return new User(usuario.getUsername(),"{noop}"+usuario.getPassword(), getAuthorities(usuario));
	}
	
	private Set<SimpleGrantedAuthority> getAuthorities(UsuarioModel usuario) {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + usuario.getRole()));
    }

}