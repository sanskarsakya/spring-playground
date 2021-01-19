package com.puzan.springhandson.services.tournament;

import java.util.HashSet;
import java.util.Set;

import com.puzan.springhandson.model.Tournament;
import com.puzan.springhandson.model.TournamentPlayer;
import com.puzan.springhandson.repository.TournamentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Override
    public Page<Tournament> findAll(Pageable pageable) throws Exception {
        return tournamentRepository.findAll(pageable);
    }

    @Override
    public Tournament save(Tournament tournament) throws Exception {
        return tournamentRepository.save(tournament);
    }

    @Override
    public Tournament saveWithPlayers(Tournament tournament) throws Exception {
       // for mapping user degree many to many
    //    Set<TournamentPlayer> tournamentPlayers = tournament.getTournamentPlayers();
    //    Tournament finalTournament = tournament;
    //    finalTournament.setTournamentPlayers(new HashSet<TournamentPlayer>());
    //    tournamentPlayers.forEach(tournamentPlayer -> {
    //     finalTournament.addTournamentPlayer(tournamentPlayer);
    //    });

    //    finalTournament.setTournamentPlayers(finalTournament.getTournamentPlayers());
       // end mapping

       return tournamentRepository.save(tournament);
    }

    @Override
    public void update(int id, Tournament tournament) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public Tournament findOne(int id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

   
    
}
