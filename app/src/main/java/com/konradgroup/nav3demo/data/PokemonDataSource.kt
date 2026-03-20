package com.konradgroup.nav3demo.data

val POKEMONS = listOf(
    Pokemon(
        id = 1,
        name = "Bulbasaur",
        weight = 6.9,
        height = 0.7,
        abilities = listOf("Overgrow", "Chlorophyll"),
        types = listOf("grass", "poison"),
        evolutions = listOf(2),
        description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png"
        )
    ),
    Pokemon(
        id = 2,
        name = "Ivysaur",
        weight = 13.0,
        height = 1.0,
        abilities = listOf("Overgrow", "Chlorophyll"),
        types = listOf("grass", "poison"),
        evolutions = listOf(3),
        description = "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/002.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/2.png"
        )
    ),
    Pokemon(
        id = 3,
        name = "Venusaur",
        weight = 100.0,
        height = 2.0,
        abilities = listOf("Overgrow", "Chlorophyll"),
        types = listOf("grass", "poison"),
        evolutions = emptyList(),
        description = "The plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/003.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/3.png"
        )
    ),
    Pokemon(
        id = 4,
        name = "Charmander",
        weight = 8.5,
        height = 0.6,
        abilities = listOf("Blaze", "Solar Power"),
        types = listOf("fire"),
        evolutions = listOf(5),
        description = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/004.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/4.png"
        )
    ),
    Pokemon(
        id = 5,
        name = "Charmeleon",
        weight = 19.0,
        height = 1.1,
        abilities = listOf("Blaze", "Solar Power"),
        types = listOf("fire"),
        evolutions = listOf(6),
        description = "When it swings its burning tail, it elevates the temperature to unbearably high levels.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/005.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/5.png"
        )
    ),
    Pokemon(
        id = 6,
        name = "Charizard",
        weight = 90.5,
        height = 1.7,
        abilities = listOf("Blaze", "Solar Power"),
        types = listOf("fire", "flying"),
        evolutions = emptyList(),
        description = "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/006.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/6.png"
        )
    ),
    Pokemon(
        id = 7,
        name = "Squirtle",
        weight = 9.0,
        height = 0.5,
        abilities = listOf("Torrent", "Rain Dish"),
        types = listOf("water"),
        evolutions = listOf(8),
        description = "After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/007.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/7.png"
        )
    ),
    Pokemon(
        id = 8,
        name = "Wartortle",
        weight = 22.5,
        height = 1.0,
        abilities = listOf("Torrent", "Rain Dish"),
        types = listOf("water"),
        evolutions = listOf(9),
        description = "Often hides in water to stalk unwary prey. For swimming fast, it moves its ears to maintain balance.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/008.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/8.png"
        )
    ),
    Pokemon(
        id = 9,
        name = "Blastoise",
        weight = 85.5,
        height = 1.6,
        abilities = listOf("Torrent", "Rain Dish"),
        types = listOf("water"),
        evolutions = emptyList(),
        description = "A brutal Pokémon with pressurized water jets on its shell. They are used for high speed tackles.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/009.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/9.png"
        )
    ),
    Pokemon(
        id = 10,
        name = "Caterpie",
        weight = 2.9,
        height = 0.3,
        abilities = listOf("Shield Dust", "Run Away"),
        types = listOf("bug"),
        evolutions = listOf(11),
        description = "Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/010.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/10.png"
        )
    ),
    Pokemon(
        id = 11,
        name = "Metapod",
        weight = 9.9,
        height = 0.7,
        abilities = listOf("Shed Skin"),
        types = listOf("bug"),
        evolutions = listOf(12),
        description = "This Pokémon is vulnerable to attack while its shell is soft, exposing its weak and tender body.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/011.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/11.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/11.png"
        )
    ),
    Pokemon(
        id = 12,
        name = "Butterfree",
        weight = 32.0,
        height = 1.1,
        abilities = listOf("Compound Eyes", "Tinted Lens"),
        types = listOf("bug", "flying"),
        evolutions = emptyList(),
        description = "In battle, it flaps its wings at high speed to release highly toxic dust into the air.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/012.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/12.png"
        )
    ),
    Pokemon(
        id = 13,
        name = "Weedle",
        weight = 3.2,
        height = 0.3,
        abilities = listOf("Shield Dust", "Run Away"),
        types = listOf("bug", "poison"),
        evolutions = listOf(14),
        description = "Often found in forests, eating leaves. It has a sharp venomous stinger on its head.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/013.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/13.png"
        )
    ),
    Pokemon(
        id = 14,
        name = "Kakuna",
        weight = 10.0,
        height = 0.6,
        abilities = listOf("Shed Skin"),
        types = listOf("bug", "poison"),
        evolutions = listOf(15),
        description = "Almost incapable of moving, this Pokémon can only harden its shell to protect itself from predators.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/014.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/14.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/14.png"
        )
    ),
    Pokemon(
        id = 15,
        name = "Beedrill",
        weight = 29.5,
        height = 1.0,
        abilities = listOf("Swarm", "Sniper"),
        types = listOf("bug", "poison"),
        evolutions = emptyList(),
        description = "Flies at high speed and attacks using its large venomous stingers on its forelegs and tail.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/015.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/15.png"
        )
    ),
    Pokemon(
        id = 16,
        name = "Pidgey",
        weight = 1.8,
        height = 0.3,
        abilities = listOf("Keen Eye", "Big Pecks"),
        types = listOf("normal", "flying"),
        evolutions = listOf(17),
        description = "A common sight in forests and woods. It flaps its wings at ground level to kick up blinding sand.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/016.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/16.png"
        )
    ),
    Pokemon(
        id = 17,
        name = "Pidgeotto",
        weight = 30.0,
        height = 1.1,
        abilities = listOf("Keen Eye", "Big Pecks"),
        types = listOf("normal", "flying"),
        evolutions = listOf(18),
        description = "Very protective of its sprawling territorial area, this Pokémon will fiercely peck at any intruder.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/017.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/17.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/17.png"
        )
    ),
    Pokemon(
        id = 18,
        name = "Pidgeot",
        weight = 39.5,
        height = 1.5,
        abilities = listOf("Keen Eye", "Big Pecks"),
        types = listOf("normal", "flying"),
        evolutions = emptyList(),
        description = "When hunting, it skims the surface of water at high speed to pick off unwary prey such as Magikarp.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/018.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/18.png"
        )
    ),
    Pokemon(
        id = 19,
        name = "Rattata",
        weight = 3.5,
        height = 0.3,
        abilities = listOf("Run Away", "Hustle"),
        types = listOf("normal"),
        evolutions = listOf(20),
        description = "Bites anything when it attacks. Small and very quick, it is a common sight in many places.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/019.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/19.png"
        )
    ),
    Pokemon(
        id = 20,
        name = "Raticate",
        weight = 18.5,
        height = 0.7,
        abilities = listOf("Run Away", "Hustle"),
        types = listOf("normal"),
        evolutions = emptyList(),
        description = "It uses its whiskers to maintain its balance. It apparently slows down if they are cut off.",
        images = PokemonImages(
            full = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/020.png",
            spriteFront = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/20.png",
            spriteBack = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/20.png"
        )
    )
)
