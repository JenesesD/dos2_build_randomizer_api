package randomizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
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

    public void setCivilAbilities(List<String> raffledCivilAbilties) {
        this.civilAbilities = raffledCivilAbilties;
    }
}
