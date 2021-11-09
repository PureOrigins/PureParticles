package it.pureorigins.fancyparticles.particles

import it.pureorigins.fancyparticles.PositionReference.FEET
import it.pureorigins.fancyparticles.PositionReference.HEAD
import it.pureorigins.fancyparticles.particles.shapes.OrbitalParticle
import it.pureorigins.fancyparticles.particles.shapes.ParallelepipedParticle
import net.minecraft.block.Blocks
import net.minecraft.particle.BlockStateParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.particle.ParticleTypes.*
import org.apache.logging.log4j.LogManager
import kotlin.math.PI

object ParticleEffects {
    val effects = HashMap<String, ParticleEffect>()

    private fun register(id: String, particleEffect: ParticleEffect): ParticleEffect {
        effects[id] = particleEffect
        return particleEffect
    }

    private fun register(id: String, vararg particlePart: ParticlePart): ParticleEffect {
        return register(id, ParticleEffect(id, listOf(*particlePart)))
    }

    val MUSIC = register(
        "music",
        ParallelepipedParticle() madeOf NOTE period 13L at HEAD,
        ParallelepipedParticle() madeOf NOTE delay 5L period 17L at HEAD atY 0.05,
        ParallelepipedParticle() madeOf NOTE period 41L at HEAD atY 0.2
    )
    val CLOUD = register(
        "cloud",
        ParallelepipedParticle(x = 0.3, z = 0.3, count = 5) madeOf FALLING_WATER delay 30L period 4L at FEET atY 2.5,
        ParallelepipedParticle(0.35, 0.1, 0.35, count = 10) madeOf ParticleTypes.CLOUD period 4L at FEET atY 2.4

    )
    val SAND_SPIRAL = register(
        "sand_spiral", OrbitalParticle(angularSpeed = PI/18) madeOf BlockStateParticleEffect(FALLING_DUST, Blocks.SAND.defaultState) period 2 at HEAD
    )

    val LOVE = register(
        "love",
        ParallelepipedParticle() madeOf HEART period 40 at HEAD,
        ParallelepipedParticle() madeOf HEART delay 4 period 40 at HEAD,
        ParallelepipedParticle() madeOf HEART delay 12 period 40 at HEAD
    )

    val KNOWLEDGE = register("knowledge", ParallelepipedParticle(speed = 0.75) madeOf ENCHANT at HEAD)

    val ASHEN = register("ashen", ParallelepipedParticle(0.1, 0.05, 0.1, 5) madeOf SMOKE period 3 at HEAD)

    val SHINING =
        register("shining", ParallelepipedParticle(0.25, 0.5, 0.25) madeOf HAPPY_VILLAGER period 10 at FEET atY 0.9)

    fun fromString(string: String): ParticleEffect {
        LogManager.getLogger().info("Looking for effect $string")
        return effects.getOrDefault(string, ParticleEffect())
    }
}
