public abstract class Animals {
    protected String name;
    protected String[] commands;

    public Animals(String name, String[] commands) {
        this.name = name;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String[] getCommands() {
        return commands;
    }

    public abstract void train(String newCommand);
}