package com.authenticationservice.security;

import com.authenticationservice.core.service.RightService;
import com.authenticationservice.core.service.RoleService;
import com.authenticationservice.core.service.UserService;
import com.authenticationservice.dto.Right;
import com.authenticationservice.dto.Role;
import com.authenticationservice.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class MyUserDetailService implements UserDetailsService, Serializable{

    private final UserService userService;
    private final RoleService roleService;
    private final RightService rightService;

    @Autowired
    public MyUserDetailService(UserService userService, RoleService roleService, RightService rightService){
        this.userService=userService;
        this.roleService=roleService;
        this.rightService=rightService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userService.findByName(name);
        Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthority(userService.findByName(name));
        final UserDetails userDetails = new org.springframework.security.core.userdetails.User
                        (user.getEmail(), null, true, false,
                                false, false, grantedAuthorities);
        return userDetails;
    }

    private Collection<GrantedAuthority> getGrantedAuthority(User user) {

        // get the list of rights for a specified user from db.
        Collection<Right> rights;
        Collection<Role> roles;
        try {
            rights = rightService.findRightsByUser(user);
            roles = user.getRoles();

            // create the list for the spring grantedRights
            final ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(rights.size() + roles.size());

            // now create for all rights a GrantedAuthority entry
            // and fill the GrantedAuthority List with these authorities.
            for (final Right right : rights) {
                grantedAuthorities.add(new SimpleGrantedAuthority(right.getRightName()));
            }

            // now create for all roles a GrantedAuthority entry
            // and fill the GrantedAuthority List with these authorities.
            for (final Role role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }

            return grantedAuthorities;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
