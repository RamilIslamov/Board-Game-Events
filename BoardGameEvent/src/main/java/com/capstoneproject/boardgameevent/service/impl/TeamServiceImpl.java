package com.capstoneproject.boardgameevent.service.impl;

import com.capstoneproject.boardgameevent.entity.Team;
import com.capstoneproject.boardgameevent.exception.DataAccessException;
import com.capstoneproject.boardgameevent.repository.TeamRepository;
import com.capstoneproject.boardgameevent.service.AbstractSrdServiceImpl;
import com.capstoneproject.boardgameevent.service.TeamService;
import com.capstoneproject.boardgameevent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class TeamServiceImpl extends AbstractSrdServiceImpl<Integer, Team> implements TeamService {

    private final TeamRepository teamRepository;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Override
    protected CrudRepository<Team, Integer> getRepository() {
        return teamRepository;
    }

    @Override
    protected Class<Team> getEntityClass() {
        return Team.class;
    }

    @Override
    public Team save(Team entity) {
        return teamRepository.save(entity);
    }

    @Override
    public List<Team> findByPercentageOfWins() {
        List<Team> teams = findAll();

        teams.sort((team1, team2) -> {
            double winPercentage1 = team1.getPlayed() > 0 ? (double) team1.getWins() / team1.getPlayed() : 0.0;
            double winPercentage2 = team2.getPlayed() > 0 ? (double) team2.getWins() / team2.getPlayed() : 0.0;
            return Double.compare(winPercentage2, winPercentage1);
        });

        return teams;
    }

    @Override
    public Optional<Team> findByName(String name) {
        return teamRepository.findByName(name);
    }

    @Override
    public void throwOrSave(Team entity) throws RuntimeException {
        userService.loadUserByUsername(entity.getLeader());
        if (findByName(entity.getName()).isPresent()) {
            throw new DataAccessException(String.format("Team name: %s is already exists", entity.getName()));
        }
        save(entity);
    }

    @Override
    public Boolean existByNameAndPassword(String name, String password) {
        return teamRepository.existsByNameAndTeamPassword(name, password);
    }

    @Override
    public Team findByNameAndPassword(String name, String password) {
        return teamRepository.findByNameAndTeamPassword(name, password);
    }

    @Override
    public void join(String name, String password) throws RuntimeException {
        Team team = teamRepository.findByName(name)
                                  .orElseThrow(() -> new RuntimeException("Team not found"));

        if (!passwordEncoder.matches(password, team.getTeamPassword())) {
            throw new RuntimeException("Incorrect password");
        }
        team.setMembersAmount(team.getMembersAmount() + 1);
        save(team);
    }
}
