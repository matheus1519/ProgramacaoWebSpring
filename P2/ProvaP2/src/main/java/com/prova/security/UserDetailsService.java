package com.prova.security;

import com.prova.model.Permissao;
import com.prova.model.Usuario;
import com.prova.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    private UsuarioRepository usuarios;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarios.findByLogin(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario não encontrado!");
        }
        return new User(usuario.getLogin(), usuario.getSenha(), authorities(usuario.getPermissoes()));
    }

    private List<? extends GrantedAuthority> authorities(List<Permissao> permissoes) {
        List<GrantedAuthority> lista = new ArrayList<>();
        for(Permissao p : permissoes){
            lista.add(new SimpleGrantedAuthority("ROLE_"+p.getNome()));
        }
        return lista;
    }
    
}
