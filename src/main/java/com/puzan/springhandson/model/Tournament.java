package com.puzan.springhandson.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tournaments")
public class Tournament {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player", orphanRemoval = true)
    private Set<TournamentPlayer> tournamentPlayers = new HashSet<TournamentPlayer>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addTournamentPlayer(TournamentPlayer tournamentPlayer) {
        tournamentPlayer.setTournament(this);
        tournamentPlayers.add(tournamentPlayer);
    }

    public Set<TournamentPlayer> getTournamentPlayers() {
        return tournamentPlayers;
    }

    public void setTournamentPlayers(Set<TournamentPlayer> tournamentPlayers) {
        this.tournamentPlayers = tournamentPlayers;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}