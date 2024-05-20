package com.capstoneproject.boardgameevent.rest.controller;

import com.capstoneproject.boardgameevent.rest.converter.TeamConverter;
import com.capstoneproject.boardgameevent.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/teams")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

    private final TeamConverter teamConverter;
}
