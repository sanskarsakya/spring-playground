package com.puzan.springhandson.services.player;

import com.puzan.springhandson.model.Player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerService {

    Page<Player> findAll(Pageable pageable) throws Exception;

    Player save(Player player) throws Exception;

    void update(int id, Player player) throws Exception;

    void delete(int id) throws Exception;

    Player findOne(int id) throws Exception;

}