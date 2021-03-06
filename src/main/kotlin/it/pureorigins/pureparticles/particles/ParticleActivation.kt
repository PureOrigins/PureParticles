package it.pureorigins.pureparticles.particles

import org.bukkit.entity.Player

fun interface ParticleActivation {
    fun isActive(player: Player): Boolean

    companion object {
        val ALWAYS_ACTIVE = ParticleActivation { true }
    }
}