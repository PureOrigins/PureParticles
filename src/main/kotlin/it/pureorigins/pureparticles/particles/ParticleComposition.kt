package it.pureorigins.pureparticles.particles

import org.bukkit.Particle
import org.bukkit.entity.Player

fun interface ParticleComposition {
    fun getParticle(player: Player, iteration: Int): Particle
}