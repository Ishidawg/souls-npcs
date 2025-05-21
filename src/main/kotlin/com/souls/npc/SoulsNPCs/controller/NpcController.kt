package com.souls.npc.SoulsNPCs.controller

import com.souls.npc.SoulsNPCs.model.Npc
import com.souls.npc.SoulsNPCs.service.NpcService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/npcs")
class NpcController(private val service: NpcService) {

    @GetMapping
    fun npc() = service.findAll()

    @GetMapping("/search")
    fun search(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) game: String?
    ): List<Npc> {
        return when {
            name != null -> service.searchByName(name)
            game != null -> service.searchByGame(game)
            else         -> service.findAllSorted()
        }
    }

    // need to do a regex here so only decimal numbers is acceptable
    @GetMapping("/{id:\\d+}")
    fun npcs(@PathVariable id: Long): Npc = service.findById(id)

    @PostMapping
    fun createNpc(@RequestBody npc: Npc): Npc = service.create(npc)

    @PutMapping("/{id:\\d+}")
    fun updateNpc(@PathVariable id: Long, @RequestBody npc: Npc): Npc = service.update(id, npc)

    @DeleteMapping("/{id:\\d+}")
    fun deleteNpc(@PathVariable id: Long) = service.delete(id)
}