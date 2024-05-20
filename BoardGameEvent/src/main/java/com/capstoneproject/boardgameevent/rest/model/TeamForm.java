package com.capstoneproject.boardgameevent.rest.model;

import com.capstoneproject.boardgameevent.security.UserDetailsService;
import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class TeamForm {

    private String name;
    private String leader;
    private String membersAmount;
    private String visited;
    private String played;
    private String wins;
    private String password;

    public Team toTeam(PasswordEncoder passwordEncoder, UserDetailsService userService) throws UsernameNotFoundException {
        Team team = new Team();
        team.setLeader(userService.loadUserByUsername(leader).getUsername());
        team.setName(name);
        team.setPassword(passwordEncoder.encode(password));
        team.setMembersAmount(Integer.parseInt(membersAmount));
        return team;
    }
}
