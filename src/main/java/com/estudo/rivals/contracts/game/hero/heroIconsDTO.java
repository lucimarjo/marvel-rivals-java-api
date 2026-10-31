package com.estudo.rivals.contracts.game.hero;

/*
record é bem legal, quase que feito pra DTOs 
ele coloca automaticamente coloca "private"
em todas as variáveis e faz seu getters.
*/
public record heroIconsDTO (
    String animated,
    String fullbody,
    String lord,
    String regular
){}
