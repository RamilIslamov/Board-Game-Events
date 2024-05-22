package com.capstoneproject.boardgameevent.rest.controller;

import com.capstoneproject.boardgameevent.rest.converter.TeamConverter;
import com.capstoneproject.boardgameevent.rest.model.Team;
import com.capstoneproject.boardgameevent.rest.model.TeamForm;
import com.capstoneproject.boardgameevent.rest.model.TeamJoinForm;
import com.capstoneproject.boardgameevent.service.TeamService;
import com.capstoneproject.boardgameevent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.capstoneproject.boardgameevent.web.Pages.TEAMS;

@Controller
@RequestMapping(path = "/teams")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

    private final TeamConverter teamConverter;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String index(Model model) {
        List<Team> teams = teamConverter.convert(teamService.findByPercentageOfWins());

        model.addAttribute("teams", teams);
        return TEAMS;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(TeamForm form) {
        try {
            form.setTeamPassword(passwordEncoder.encode(form.getTeamPassword()));
            Team team = form.toTeam();
            com.capstoneproject.boardgameevent.entity.Team entity = teamConverter.convert(team);
            teamService.throwOrSave(entity);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("Team created successfully");
    }

    @PostMapping(path = "/join")
    public ResponseEntity<String> join(TeamJoinForm form) {
        try {
            teamService.join(form.getTeamNameJoin(), form.getTeamPasswordJoin());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("You joined team successfully");
    }
}
