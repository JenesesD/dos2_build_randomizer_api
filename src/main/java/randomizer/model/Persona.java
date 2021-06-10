package randomizer.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    private Gender gender;
    private Race race;
    private boolean undead;
    private List<String> attributes;
    private List<String> abilities;
    private List<String> civilAbilities;
    private String startingTalent;

    public void setAbilities(List<String> raffledAbilities) {
        this.abilities = raffledAbilities;
    }

    public void setAttributes(List<String> raffledAttributes) {
        this.attributes = raffledAttributes;
    }

    public void setCivilAbilities(List<String> raffledCivilAbilities) {
        this.civilAbilities = raffledCivilAbilities;
    }

    public void setStartingTalent(String raffledTalent) {
        this.startingTalent = raffledTalent;
    }
}
