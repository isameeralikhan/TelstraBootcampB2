import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CharacterData {
    String name;
    String house;
    String role;
    String status;
    String dies;

    public CharacterData(String name, String house, String role, String status, String dies) {
        this.name = name;
        this.house = house;
        this.role = role;
        this.status = status;
        this.dies = dies;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s", name, house, role, status, dies);
    }

    public String getHouse() {
        return this.house;
    }

    public String getName(){
        return this.name;
    }

    public String getDies(){
        return this.dies;
    }

    public String getStatus(){
        return this.status;
    }

    public String getRole(){
        return this.role;
    }
}

public class HarryPotterData {

    private static void membersOfGriffindor(List<CharacterData> characterList) {
        System.out.println("\n The members of Gryffindor are: \n");
        characterList.stream()
                    .filter(character -> ("Gryffindor".equals(character.getHouse())))
                    .map(CharacterData::getName)
                    .forEach(System.out::println);;
    }

    private static Map<String, List<CharacterData>> charactersAlive(List<CharacterData> characterList) {
        System.out.println("\n The characters alive are: \n");
        return characterList.stream()
                    .filter(character -> "No".equals(character.getDies()))
                    .collect(Collectors.groupingBy(CharacterData::getHouse));
    }

    private static void familyMembers(List<CharacterData> characterList) {
        System.out.println("\n The family members of Harry Potter are: \n");
        characterList.stream()
                .filter(character -> "Family".equals(character.getStatus()))
                .forEach(System.out::println);
    }

    private static void facultyWhoDied(List<CharacterData> characterList) {
        System.out.println("\n List of faculty who died in Alphabetical order: \n");
        characterList.stream()
                .filter(character -> ("Yes".equals(character.getDies()) && "Faculty".equals(character.getRole())))
                .sorted(Comparator.comparing(CharacterData::getName))
                .forEach(System.out::println);
    }

    private static List<CharacterData> createHarryPotterData(){

        List<CharacterData> characterList = new ArrayList<>();
        characterList.add(new CharacterData("Harry Potter", "Gryffindor", "Student", "Self", "No"));
        characterList.add(new CharacterData("Ginny Weasley", "Gryffindor", "Student", "Friend", "No"));
        characterList.add(new CharacterData("Ron Weasley", "Gryffindor", "Student", "Friend", "No"));
        characterList.add(new CharacterData("Hermione Granger", "Gryffindor", "Student", "Friend", "No"));
        characterList.add(new CharacterData("Neville Longbottom ", "Gryffindor", "Student", "Friend", "No"));
        characterList.add(new CharacterData("Oliver Wood", "Gryffindor", "Student", "Friend", "No"));
        characterList.add(new CharacterData("Luna Lovegood ", "Ravenclaw", "Student", "Friend", "No"));
        characterList.add(new CharacterData("Cho Chang", "Ravenclaw", "Student", "Friend", "No"));
        characterList.add(new CharacterData("Cedric Diggory", "Hufflepuff", "Student", "Friend", "Yes"));
        characterList.add(new CharacterData("Hannah Abbot ", "Hufflepuff", "Student", "Friend", "No"));
        characterList.add(new CharacterData("Draco Malfoy", "Slytherin", "Student", "Enemy", "No"));
        characterList.add(new CharacterData("Vincent Crabbe", "Slytherin", "Student", "Enemy", "Yes"));
        characterList.add(new CharacterData("Gregory Goyle", "Slytherin", "Student", "Enemy", "No"));
        characterList.add(new CharacterData("Penelope Clearwater", "Slytherin", "Student", "Enemy", "No"));
        characterList.add(new CharacterData("Albus Dumbledore", "Gryffindor", "Faculty", "Friend", "Yes"));
        characterList.add(new CharacterData("Severus Snape", "Slytherin", "Faculty", "Enemy", "Yes"));
        characterList.add(new CharacterData("Remus Lupin", "Gryffindor", "Faculty", "Friend", "Yes"));
        characterList.add(new CharacterData("Horace Slughorn", "Slytherin", "Faculty", "Friend", "No"));
        characterList.add(new CharacterData("Rubeus Hagrid", "Gryffindor", "Faculty", "Friend", "No"));
        characterList.add(new CharacterData("Minerva McGonagall ", "Gryffindor", "Faculty", "Friend", "No"));
        characterList.add(new CharacterData("James Potter", "Gryffindor", "Student", "Family", "Yes"));
        characterList.add(new CharacterData("Sirius Black", "Gryffindor", "Student", "Friend", "Yes"));
        characterList.add(new CharacterData("Lily Potter", "Gryffindor", "Student", "Family", "Yes"));
        characterList.add(new CharacterData("Peter Pettigrew", "Gryffindor", "Student", "Enemy", "Yes"));
        characterList.add(new CharacterData("Tom Marvolo Riddle", "Slytherin", "Student", "Enemy", "Yes"));
        return characterList;
    }

    public static void main(String[] args) {
        // Print the list
        List<CharacterData> characterList = createHarryPotterData();
        characterList.forEach(character -> System.out.println(character.toString()));
        membersOfGriffindor(characterList);
        Map<String, List<CharacterData>> aliveCharactersByHouse = charactersAlive(characterList);
        aliveCharactersByHouse.forEach((house, characters) -> {
            System.out.println(house);
            characters.forEach(System.out::println);
            System.out.print("\n");
        });
        familyMembers(characterList);
        facultyWhoDied(characterList);              
    }
}
