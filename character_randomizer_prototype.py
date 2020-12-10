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

from random import choice, choices

GENDER = ["Male", "Female"]
# Eternal is not present for a reason, there is no such thing when
# you create a character
RACE = ["Human", "Elf", "Dwarf", "Lizard"]

# For the time being getting an undead character or not will be
# decided like this
UNDEAD = ["Yes", "No"]

# For attributes and abilities duplicates is still possible
ATTRIBUTES = ["strength", "Finesse", "Intelligence",
              "Constitution", "Memory", "Wits"]  # need 3
ABILITIES = ["Dual Wielding", "Ranged", "Single-Handed", "Two-Handed",
             "Leadership", "Perserverence", "Retribution", "Aerotheurge", "Geomancer",
             "Huntsman", "Hydrosophist", "Necromancer", "Polymorph", "Pyrokinetic",
             "Scoundrel", "Summoning"]  # need 3
CIVIL_ABILITIES = ["Telkinesis", "Loremaster", "Sneaking", "Thievery", "Bartering",
                   "Persuasion", "Lucky Charm"]  # need 2

# Talents are random, it is possible to get the same talents after multiple draws,
# if and when the problem arises rolling another talent will be the solution,
# another idea could be to roll all the players talent that they need to learn throughout the game
# (would require extensive ruleset, maybe in the future).
TALENTS = ["All Skilled Up", "Ambidextrous", "Arrow Recovery", "Bigger and better",
           "Comeback Kid", "Demon", "Duck Duck Goose", "Elemental Affinity", "Escapist", "Executioner",
           "Elemental Ranger", "Far Out Man", "Five-Star Diner", "Glass Cannon", "Guerrilla",
           "Hothead", "Ice King", "Leech", "Living Armour", "Lonewolf", "Mnemonic", "Morning Person",
           "Opportunist", "Parry Master", "Pet Pal", "Picture of Health", "Savage Sortilege", "Slingshot",
           "Stench", "The Pawn", "Torturer", "Unstable", "Walk It Off", "What a Rush"]


def character_generator():
    print(f"\nCharacter Gender: {choice(GENDER)}")
    print(f"\nCharacter Race: {choice(RACE)}")
    print(f"\nUndead: {choice(UNDEAD)}")
    print(f"\nAttributes: {', '.join(choices(ATTRIBUTES, k=3))}")
    print(f"\nAbilities: {', '.join(choices(ABILITIES, k=2))}")
    print(f"\nCivil Abilities: {', '.join(choices(CIVIL_ABILITIES, k=2))}")
    print(f"\nTalent: {choice(TALENTS)}")


def pick_talent():
    print(f"\nYour next talent: {choice(TALENTS)}")


def main():
    print(f"(1) Generate Character")
    print(f"(2) Draw Talent")
    print(f"(3) Exit")
    user_input = input("Choose an option: ")
    if user_input == "1":
        character_generator()
    elif user_input == "2":
        pick_talent()
    else:
        pass


if __name__ == "__main__":
    main()
