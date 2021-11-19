DROP DATABASE IF EXISTS dos_2;
CREATE DATABASE dos_2;
\c dos_2;

DROP TABLE IF EXISTS races;
DROP TABLE IF EXISTS attributes;
DROP TABLE IF EXISTS abilities;
DROP TABLE IF EXISTS civil_abilities;
DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS talents;
DROP TABLE IF EXISTS instruments;

CREATE TABLE races (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE attributes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE abilities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE civil_abilities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE skills (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30),
    skill_type VARCHAR(20)
);

CREATE TABLE talents (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE instruments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

INSERT INTO races (id, name) VALUES (1, 'Elf');
INSERT INTO races (id, name) VALUES (2, 'Human');
INSERT INTO races (id, name) VALUES (3, 'Dwarf');
INSERT INTO races (id, name) VALUES (4, 'Lizard');

INSERT INTO attributes (id, name) VALUES (1, 'Strength');
INSERT INTO attributes (id, name) VALUES (2, 'Finesse');
INSERT INTO attributes (id, name) VALUES (3, 'Intelligence');
INSERT INTO attributes (id, name) VALUES (4, 'Constitution');
INSERT INTO attributes (id, name) VALUES (5, 'Memory');
INSERT INTO attributes (id, name) VALUES (6, 'Wits');

INSERT INTO abilities (id, name) VALUES (1, 'Dual-Wielding');
INSERT INTO abilities (id, name) VALUES (2, 'Ranged');
INSERT INTO abilities (id, name) VALUES (3, 'Single-Handed');
INSERT INTO abilities (id, name) VALUES (4, 'Two-Handed');
INSERT INTO abilities (id, name) VALUES (5, 'Leadership');
INSERT INTO abilities (id, name) VALUES (6, 'Perseverance');
INSERT INTO abilities (id, name) VALUES (7, 'Retribution');
INSERT INTO abilities (id, name) VALUES (8, 'Huntsman');
INSERT INTO abilities (id, name) VALUES (9, 'Scoundrel');
INSERT INTO abilities (id, name) VALUES (10, 'Warfare');
INSERT INTO abilities (id, name) VALUES (11, 'Aerotheurge');
INSERT INTO abilities (id, name) VALUES (12, 'Geomancer');
INSERT INTO abilities (id, name) VALUES (13, 'Hydrosophist');
INSERT INTO abilities (id, name) VALUES (14, 'Necromancer');
INSERT INTO abilities (id, name) VALUES (15, 'Polymorph');
INSERT INTO abilities (id, name) VALUES (16, 'Pyrokinetic');
INSERT INTO abilities (id, name) VALUES (17, 'Summoning');

INSERT INTO civil_abilities (id, name) VALUES (1, 'Bartering');
INSERT INTO civil_abilities (id, name) VALUES (2, 'Lucky Charm');
INSERT INTO civil_abilities (id, name) VALUES (3, 'Persuasion');
INSERT INTO civil_abilities (id, name) VALUES (4, 'Loremaster');
INSERT INTO civil_abilities (id, name) VALUES (5, 'Telekinesis');
INSERT INTO civil_abilities (id, name) VALUES (6, 'Sneaking');
INSERT INTO civil_abilities (id, name) VALUES (7, 'Thievery');

INSERT INTO skills (id, name, skill_type) VALUES (1, 'Blinding Radiance', 'Aerotheurge');
INSERT INTO skills (id, name, skill_type) VALUES (2, 'Electric Discharge', 'Aerotheurge');
INSERT INTO skills (id, name, skill_type) VALUES (3, 'Favourable Wind', 'Aerotheurge');
INSERT INTO skills (id, name, skill_type) VALUES (4, 'Shocking Touch', 'Aerotheurge');
INSERT INTO skills (id, name, skill_type) VALUES (5, 'Contamination', 'Geomancer');
INSERT INTO skills (id, name, skill_type) VALUES (6, 'Fortify', 'Geomancer');
INSERT INTO skills (id, name, skill_type) VALUES (7, 'Fossil Strike', 'Geomancer');
INSERT INTO skills (id, name, skill_type) VALUES (8, 'Poison Dart', 'Geomancer');
INSERT INTO skills (id, name, skill_type) VALUES (9, 'Elemental Arrowheads', 'Huntsman');
INSERT INTO skills (id, name, skill_type) VALUES (10, 'First Aid', 'Huntsman');
INSERT INTO skills (id, name, skill_type) VALUES (11, 'Pin Down', 'Huntsman');
INSERT INTO skills (id, name, skill_type) VALUES (12, 'Ricochet', 'Huntsman');
INSERT INTO skills (id, name, skill_type) VALUES (13, 'Armor of Frost', 'Hydrosophist');
INSERT INTO skills (id, name, skill_type) VALUES (14, 'Hail Strike', 'Hydrosophist');
INSERT INTO skills (id, name, skill_type) VALUES (15, 'Rain', 'Hydrosophist');
INSERT INTO skills (id, name, skill_type) VALUES (16, 'Restoration', 'Hydrosophist');
INSERT INTO skills (id, name, skill_type) VALUES (17, 'Blood Sucker', 'Necromancer');
INSERT INTO skills (id, name, skill_type) VALUES (18, 'Decaying Touch', 'Necromancer');
INSERT INTO skills (id, name, skill_type) VALUES (19, 'Mosquito Swarm', 'Necromancer');
INSERT INTO skills (id, name, skill_type) VALUES (20, 'Raise Bloated Corpse', 'Necromancer');
INSERT INTO skills (id, name, skill_type) VALUES (21, 'Bull Horns', 'Polymorph');
INSERT INTO skills (id, name, skill_type) VALUES (22, 'Chameleon Cloak', 'Polymorph');
INSERT INTO skills (id, name, skill_type) VALUES (23, 'Chicken Claw', 'Polymorph');
INSERT INTO skills (id, name, skill_type) VALUES (24, 'Tentacle Lash', 'Polymorph');
INSERT INTO skills (id, name, skill_type) VALUES (25, 'Haste', 'Pyrokinetic');
INSERT INTO skills (id, name, skill_type) VALUES (26, 'Ignition', 'Pyrokinetic');
INSERT INTO skills (id, name, skill_type) VALUES (27, 'Peace of Mind', 'Pyrokinetic');
INSERT INTO skills (id, name, skill_type) VALUES (28, 'Searing Daggers', 'Pyrokinetic');
INSERT INTO skills (id, name, skill_type) VALUES (29, 'Adrenaline', 'Scoundrel');
INSERT INTO skills (id, name, skill_type) VALUES (30, 'Backlash', 'Scoundrel');
INSERT INTO skills (id, name, skill_type) VALUES (31, 'Chloroform', 'Scoundrel');
INSERT INTO skills (id, name, skill_type) VALUES (32, 'Throwing Knives', 'Scoundrel');
INSERT INTO skills (id, name, skill_type) VALUES (33, 'Conjure Incarnate', 'Summoning');
INSERT INTO skills (id, name, skill_type) VALUES (34, 'Dimensional Bolt', 'Summoning');
INSERT INTO skills (id, name, skill_type) VALUES (35, 'Elemental Totem', 'Summoning');
INSERT INTO skills (id, name, skill_type) VALUES (36, 'Farsight Infusion', 'Summoning');
INSERT INTO skills (id, name, skill_type) VALUES (37, 'Battering Ram', 'Warfare');
INSERT INTO skills (id, name, skill_type) VALUES (38, 'Battle Stomp', 'Warfare');
INSERT INTO skills (id, name, skill_type) VALUES (39, 'Bouncing Shield', 'Warfare');
INSERT INTO skills (id, name, skill_type) VALUES (40, 'Crippling Blow', 'Warfare');

INSERT INTO talents (id, name) VALUES (1, 'All Skilled Up');
INSERT INTO talents (id, name) VALUES (2, 'Ambidextrous');
INSERT INTO talents (id, name) VALUES (3, 'Arrow Recovery');
INSERT INTO talents (id, name) VALUES (4, 'Bigger and Better');
INSERT INTO talents (id, name) VALUES (5, 'Comeback Kid');
INSERT INTO talents (id, name) VALUES (6, 'Demon');
INSERT INTO talents (id, name) VALUES (7, 'Duck Duck Goose');
INSERT INTO talents (id, name) VALUES (8, 'Elemental Affinity');
INSERT INTO talents (id, name) VALUES (9, 'Elemental Ranger');
INSERT INTO talents (id, name) VALUES (10, 'Escapist');
INSERT INTO talents (id, name) VALUES (11, 'Executioner');
INSERT INTO talents (id, name) VALUES (12, 'Far Out Man');
INSERT INTO talents (id, name) VALUES (13, 'Five Start Diner');
INSERT INTO talents (id, name) VALUES (14, 'Glass Cannon');
INSERT INTO talents (id, name) VALUES (15, 'Guerilla');
INSERT INTO talents (id, name) VALUES (16, 'Hothead');
INSERT INTO talents (id, name) VALUES (17, 'Ice king');
INSERT INTO talents (id, name) VALUES (18, 'Leech');
INSERT INTO talents (id, name) VALUES (19, 'Living Armour');
INSERT INTO talents (id, name) VALUES (20, 'Lone Wolf');
INSERT INTO talents (id, name) VALUES (21, 'Mnemonic');
INSERT INTO talents (id, name) VALUES (22, 'Morning Person');
INSERT INTO talents (id, name) VALUES (23, 'Opportunist');
INSERT INTO talents (id, name) VALUES (24, 'Parry Master');
INSERT INTO talents (id, name) VALUES (25, 'Pet Pal');
INSERT INTO talents (id, name) VALUES (26, 'Picture of Health');
INSERT INTO talents (id, name) VALUES (27, 'Savage Sortilege');
INSERT INTO talents (id, name) VALUES (28, 'Slingshot');
INSERT INTO talents (id, name) VALUES (29, 'Stench');
INSERT INTO talents (id, name) VALUES (30, 'The Pawn');
INSERT INTO talents (id, name) VALUES (31, 'Torturer');
INSERT INTO talents (id, name) VALUES (32, 'Unstable');
INSERT INTO talents (id, name) VALUES (33, 'Walk It Off');
INSERT INTO talents (id, name) VALUES (34, 'What a Rush');

INSERT INTO instruments(id, name) VALUES (1, 'Bansuri');
INSERT INTO instruments(id, name) VALUES (2, 'Oud');
INSERT INTO instruments(id, name) VALUES (3, 'Tambura');
INSERT INTO instruments(id, name) VALUES (4, 'Cello');