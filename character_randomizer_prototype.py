# For the prototype, I will create a complete randomizer for the game.
# After creating the base of the api, I will try to apply a ruleset,
# so it doesn't necceserily create a completely useless build.
# Since this is the prototype (and for the sake of practice),
# I will re-create it in Java ruleset and all, and try to make it into
# an API, for future uses (Discord bot, maybe a React based website)
# (this will be present in the readme, aswell as how to use the api)

# If the randomizer creates a variation that can represent an
# original character, I would recommend choosing that-
# eg.: A non-undead male lizard could represent the Red Prince etc.

GENDER = ["Male", "Female"]
# Eternal is not present for a reason, there is no such thing when
# you create a character
RACE = ["Human", "Elf", "Dwarf", "Lizard"]
UNDEAD["Yes", "No"]
ATTRIBUTES = ["strength", "Finesse", "Intelligence",
              "Constitution", "Memory", "Wits"]  # need 3
ABILITIES = ["Dual Wielding", "Ranged", "Single-Handed", "Two-Handed",
             "Leadership", "Perserverence", "Retribution", "Aerotheurge", "Geomancer",
             "Huntsman", "Hydrosophist", "Necromancer", "Polymorph", "Pyrokinetic",
             "Scoundrel", "Summoning"]
CIVIL_ABILITIES = ["Telkinesis", "Loremaster", "Sneaking", "Thievery", "Bartering"
                   "persuasion", "Lucky Charm"]  # need 2
TALENTS = ["All Skilled Up", "Ambidextrous", "Arrow Recovery", "Bigger and better",
           "Comeback Kid", "Demon", "Duck Duck Goose", "Elemental Affinity", "Escapist", "Executioner",
           "Elemental Ranger", "Far Out Man", "Five-Star Diner", "Glass Cannon", "Guerrilla",
           "Hothead", "Ice King", "Leech", "Living Armour", "Lonewolf", "Mnemonic", "Morning Person",
           "Opportunist", "Parry Master", "Pet Pal", "Picture of Health", "Savage Sortilege", "Slingshot",
           "Stench", "The Pawn", "Torturer", "Unstable", "Walk It Off", "What a Rush"]
