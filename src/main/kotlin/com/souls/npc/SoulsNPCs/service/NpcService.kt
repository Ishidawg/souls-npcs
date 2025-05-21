package com.souls.npc.SoulsNPCs.service

import com.souls.npc.SoulsNPCs.model.Npc
import com.souls.npc.SoulsNPCs.repository.NpcRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus

@Service
class NpcService(private val repo: NpcRepository) {

    @Transactional(readOnly = true)
    fun findAll(): List<Npc> = repo.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Long): Npc = repo.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "NPC not found") }

    @Transactional(readOnly = true)
    fun searchByName(name: String): List<Npc> = repo.findByNameContainingIgnoreCase(name)

    @Transactional(readOnly = true)
    fun searchByGame(game: String): List<Npc> = repo.findByGamesContainingIgnoreCase(game)

    @Transactional(readOnly = true)
    fun findAllSorted(): List<Npc> = repo.findAllByOrderByNameAsc()

    @Transactional
    fun create(npc: Npc): Npc = repo.save(npc.apply { id = null })

    @Transactional
    fun update(id: Long, update: Npc): Npc {
        val existing = findById(id)
        return repo.save(existing.copy(
            name = update.name,
            birthLand = update.birthLand,
            occupation = update.occupation,
            lore = update.lore,
            game = update.game,
            manyGames = update.manyGames,
            games = update.games
        ))
    }

    @Transactional
    fun delete(id: Long) = repo.delete(findById(id))
}