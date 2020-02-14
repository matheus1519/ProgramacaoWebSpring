package com.exercicio9.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exercicio9.model.Permissao;
import com.exercicio9.model.Usuario;
import com.exercicio9.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarios;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario user =  usuarios.findByLogin(login);
		return new User(user.getLogin(), user.getSenha(), this.getAuthorities(user.getPermissoes()));
	}
	
	private List<GrantedAuthority> getAuthorities(List<Permissao> permissoes){
		List<GrantedAuthority> lista = new ArrayList<>();
		for(Permissao p: permissoes) {
			lista.add(new SimpleGrantedAuthority("ROLE_"+ p.getNome()));
		}
		return lista;
	}

}
