package randomizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    private Gender gender;
    private Race race;
    private boolean undead;
    private List<String> attributes;
    private List<String> abilities;
    private List<String> civilAbilities;
    private String startingTalent;

}
