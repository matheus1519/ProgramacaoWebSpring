package com.trabalho.security;

import com.trabalho.model.Permissao;
import com.trabalho.model.Usuario;
import com.trabalho.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustom implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarios;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarios.findByLogin(login);
        return new User(usuario.getLogin(), usuario.getSenha(), authorities(usuario.getPermissoes()));
        
    }

    private List<? extends GrantedAuthority> authorities(List<Permissao> permissoes) {
        List<GrantedAuthority> list = new ArrayList<>();
        permissoes.forEach((p) -> {
            list.add(new SimpleGrantedAuthority("ROLE_"+p.getNome()));
        });
        return list;
    }
    
}
