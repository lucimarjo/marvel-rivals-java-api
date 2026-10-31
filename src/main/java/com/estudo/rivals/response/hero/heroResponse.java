package com.estudo.rivals.response.hero;

import java.util.List;
public record heroResponse(
    Integer id,
    String name,
    String real_name,
    String role,
    String description,
    String biography,
    heroIconsResponse icons,
    List<Integer> skins_ids,
    List<heroTeamupResponse> teamups,
    Integer base_hero_id,
    List<Integer> forms
) {}
