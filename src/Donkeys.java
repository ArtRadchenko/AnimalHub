public class Donkeys extends PackAnimals {
    public Donkeys(String name) {
        super(name, new String[]{"Bray", "Carry"});
    }

    @Override
    public void train(String newCommand) {
        String[] newCommands = new String[commands.length + 1];
        System.arraycopy(commands, 0, newCommands, 0, commands.length);
        newCommands[commands.length] = newCommand;
        commands = newCommands;
    }
}