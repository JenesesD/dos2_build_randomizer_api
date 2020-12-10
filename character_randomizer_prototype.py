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
CIVIL_ABILITIES = ["Telekinesis", "Loremaster", "Sneaking", "Thievery", "Bartering",
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


def character_generator(chr_number=1):
    # Generates a character with no regard to any rules
    # Need to create seperate functions in order to prevent duplicates
    # modified the function to run as many times as the given parameter
    for i in range(chr_number):
        print(f"\nCHARACTER {i + 1}")
        print("----------------------------")
        print(f"\nCharacter Gender: {choice(GENDER)}")
        print(f"\nCharacter Race: {choice(RACE)}")
        print(f"\nUndead: {choice(UNDEAD)}")
        print(f"\nAttributes: {', '.join(choices(ATTRIBUTES, k=3))}")
        print(f"\nAbilities: {', '.join(choices(ABILITIES, k=2))}")
        print(f"\nCivil Abilities: {', '.join(choices(CIVIL_ABILITIES, k=2))}")
        print(f"\nTalent: {choice(TALENTS)}")
        print(f"===========================\n")


def pick_talent():
    # Really simple random pick in talents
    print(f"\nYour next talent: {choice(TALENTS)}")


def main():
    # While loop in order for the script to not stop on wrong input or after one execution
    run = True
    while run:
        # Three options: generate a starting character, generate a random talent, or exit the program
        print(f"(1) Generate Character")
        print(f"(2) Draw Talent")
        print(f"(3) Exit")
        # Asks for an user input in order to determine the function to run
        user_input = input("Choose an option: ")
        # Checks the given input by the user
        if user_input == "1":
            # Modification in order to generate multiple starter characters
            chr_number = input("How many characters would you like: ")
            if chr_number == "" or chr_number.isalpha():
                character_generator()
            else:
                character_generator(int(chr_number))
        elif user_input == "2":
            pick_talent()
        elif user_input == "3":
            # either option works
            run = False
            # exit()
        else:
            print(f"Wrong Input!")


if __name__ == "__main__":
    main()
