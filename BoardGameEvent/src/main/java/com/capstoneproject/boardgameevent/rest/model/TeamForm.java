package com.capstoneproject.boardgameevent.rest.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Data
public class TeamForm {

    private String teamName;
    private String teamLeader;
    private String teamMembers;
    private String teamPassword;

    public Team toTeam() throws UsernameNotFoundException {
        Team team = new Team();
        team.setLeader(teamLeader);
        team.setName(teamName);
        team.setPassword(teamPassword);
        team.setMembersAmount(Integer.parseInt(teamMembers));
        return team;
    }
}
