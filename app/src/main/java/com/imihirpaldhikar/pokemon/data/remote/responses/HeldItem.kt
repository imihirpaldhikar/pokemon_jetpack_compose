package com.imihirpaldhikar.pokemon.data.remote.responses

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)