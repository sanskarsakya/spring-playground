package com.puzan.springhandson.services.player;

import java.util.Set;

import com.puzan.springhandson.model.Player;
import com.puzan.springhandson.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Page<Player> findAll(Pageable pageable) throws Exception {
        return playerRepository.findAll(pageable);
    }

    @Override
    public Player save(Player player) throws Exception {
        return playerRepository.save(player);
    }

    @Override
    public void update(int id, Player player) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public Player findOne(int id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    
}
