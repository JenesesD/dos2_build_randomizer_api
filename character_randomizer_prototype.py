# For the prototype, I will create a complete randomizer for the game.
# After creating the base of the api, I will try to apply a ruleset,
# so it creates a build within the realm of possibility.
# Since this is the prototype (and for the sake of practice),
# I will re-create it in Java ruleset and all, and try to make it into
# an API, for future uses (Discord bot, maybe a React based website)
# (this will be present in the readme, aswell as how to use the api)

# If the randomizer creates a variation that can represent an
# original character, I would recommend choosing that.
# eg.: A non-undead male lizard could represent the Red Prince etc.

from random import choice, randint


def character_generator(chr_number=1):
    # Generates a character with no regard to any rules
    # Created a general function for picking attributes/abilities
    # Modified the function to run as many times as the given parameter

    GENDER = ["Male", "Female"]
    # Eternal is not present
    # modified the list so undead doesn't need a seperate list

    RACE = ["Human", "Elf", "Dwarf", "Lizard",
            "Undead Human", "Undead Elf", "Undead Dwarf", "Undead Lizard"]

    # moved all list within scope for generalization
    ATTRIBUTES = ["Strength", "Finesse", "Intelligence",
                  "Constitution", "Memory", "Wits"]

    # For attributes and abilities duplicates are not possible anymore
    ABILITIES = ["Dual Wielding", "Ranged", "Single-Handed", "Two-Handed", "Leadership", "Perserverance",
                 "Retribution", "Aerotheurge", "Geomancer", "Huntsman", "Hydrosophist", "Necromancer", "Polymorph",
                 "Pyrokinetic", "Scoundrel", "Summoning", "Warfare"]  # need 2

    CIVIL_ABILITIES = ["Telekinesis", "Loremaster", "Sneaking", "Thievery", "Bartering",
                       "Persuasion", "Lucky Charm"]  # need 2

    # An idea could be to roll all the players talents that they need to learn throughout the game
    # (would require extensive ruleset, maybe in the future).

    for i in range(chr_number):
        print(f"\nCHARACTER {i + 1}")
        print(f"===========================")
        print(f"\nCharacter Gender: {choice(GENDER)}")
        print(f"\nCharacter Race: {choice(RACE)}")
        print(f"\nAttributes: {', '.join(pick_stats(ATTRIBUTES, 3))}")
        print(f"\nAbilities: {', '.join(pick_stats(ABILITIES, 2))}")
        print(
            f"\nCivil Abilities: {', '.join(pick_stats(CIVIL_ABILITIES, 2))}")
        print(f"\nTalent: {pick_talent()}")
        print("----------------------------\n")


def pick_stats(stats_list, amount):
    picked_stats = []
    # switched to while if there is a duplicate value
    while len(picked_stats) != amount:
        curr_stat = choice(stats_list)
        if curr_stat not in picked_stats:
            picked_stats.append(curr_stat)
    return picked_stats


def pick_talent():
    # Stupid faster, I could have just called this function this way..
    TALENTS = ["All Skilled Up", "Ambidextrous", "Arrow Recovery", "Bigger and better",
               "Comeback Kid", "Demon", "Duck Duck Goose", "Elemental Affinity", "Escapist", "Executioner",
               "Elemental Ranger", "Far Out Man", "Five-Star Diner", "Glass Cannon", "Guerrilla",
               "Hothead", "Ice King", "Leech", "Living Armour", "Lonewolf", "Mnemonic", "Morning Person",
               "Opportunist", "Parry Master", "Pet Pal", "Picture of Health", "Savage Sortilege", "Slingshot",
               "Stench", "The Pawn", "Torturer", "Unstable", "Walk It Off", "What a Rush"]

    # Really simple random pick from talents
    return choice(TALENTS)


def check_number_input(chr_number):
    # Modified logic to prevent a semantic error
    return chr_number.isnumeric()


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
            # if no or wrong input is given the function runs once by default
            if check_number_input(chr_number):
                character_generator(int(chr_number))
            else:
                character_generator()
        elif user_input == "2":
            print(f"\nYour next talent: {pick_talent()}\n")
        elif user_input == "3":
            print(f"See you later!")
            # either option works
            run = False
            # exit()
        else:
            print(f"Wrong Input!")


if __name__ == "__main__":
    main()
