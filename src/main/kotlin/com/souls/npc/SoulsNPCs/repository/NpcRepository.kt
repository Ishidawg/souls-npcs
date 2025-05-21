package com.souls.npc.SoulsNPCs.repository // Need to see if the Spring Boot will fuck this cuz it starts with BIG LETTERS

import com.souls.npc.SoulsNPCs.model.Npc
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NpcRepository : JpaRepository<Npc, Long> {
    fun findByNameContainingIgnoreCase(name: String): List<Npc>
    fun findByGamesContainingIgnoreCase(game: String): List<Npc>
    fun findAllByOrderByNameAsc(): List<Npc>
}