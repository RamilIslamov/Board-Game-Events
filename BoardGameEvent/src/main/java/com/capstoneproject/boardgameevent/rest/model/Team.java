package com.capstoneproject.boardgameevent.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    private Integer id;
    private String name;
    private String leader;
    private Integer membersAmount;
    private Integer visited;
    private Integer played;
    private Integer wins;
    private String password;

}
