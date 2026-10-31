package com.estudo.rivals.contracts.game.hero;

import java.util.List;

public record heroDetailDTO (
    Integer id,
    String name,
    String description,
    String role,
    heroIconsDTO icons,
    List<heroTeamupDTO> teamups,
    Integer base_hero_id,
    List<Integer> forms
){}