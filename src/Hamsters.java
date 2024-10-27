public class Hamsters extends DomesticAnimals {
    public Hamsters(String name) {
        super(name, new String[]{"Run", "Spin"});
    }

    @Override
    public void train(String newCommand) {
        String[] newCommands = new String[commands.length + 1];
        System.arraycopy(commands, 0, newCommands, 0, commands.length);
        newCommands[commands.length] = newCommand;
        commands = newCommands;
    }
}