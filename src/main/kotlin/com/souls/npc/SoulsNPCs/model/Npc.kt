package com.souls.npc.SoulsNPCs.model

// I know that I don't need all that is inside jakarta...
import jakarta.persistence.*

@Entity
@Table(name = "npcs")
data class Npc(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null, // I know as well that use Long for a uni project here is just memory waste...

    // Success on post npcs, but failed to get them
    // Need to initialize them with some sort a value or use JPA, no shit I will add more dependencies
    var name: String = "",
    var birthLand: String = "",
    var occupation: String = "",
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(columnDefinition = "TEXT")
    var lore: String = "",

    var game: String = "",
    var manyGames: Boolean = false,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "npc_games", joinColumns = [JoinColumn(name = "npc_id")])
    @Column(name = "game_name")
    var games: List<String> = listOf()
)