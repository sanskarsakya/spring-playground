package com.puzan.springhandson.services.tournament;

import com.puzan.springhandson.model.Tournament;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TournamentService {

    Page<Tournament> findAll(Pageable pageable) throws Exception;

    Tournament save(Tournament tournament) throws Exception;
    
    Tournament saveWithPlayers(Tournament tournament) throws Exception;

    void update(int id, Tournament tournament) throws Exception;

    void delete(int id) throws Exception;

    Tournament findOne(int id) throws Exception;

}