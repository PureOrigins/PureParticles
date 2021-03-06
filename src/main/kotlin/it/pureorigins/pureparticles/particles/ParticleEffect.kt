package it.pureorigins.pureparticles.particles

data class ParticleEffect(val effectId: String, val particleParts: List<ParticlePart>) {
    constructor(stringId: String, vararg parts: ParticlePart) : this(stringId, listOf(*parts))
}
