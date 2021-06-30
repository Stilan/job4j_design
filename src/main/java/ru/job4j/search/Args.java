package ru.job4j.search;

public class Args {

    private String[] args;
    private String directory;
    private String name;
    private String type;
    private String output;

    public Args(String[] args) {
        this.args = args;
        String[] string = null;
        for (int i = 0; i < args.length; i++) {
            string = args[i].substring(1).split("[=\\-]");
        }
        args = string;
        if (args.length == 8 && args[0].equals("d") && args[2].equals("n") && args[4].equals("t")
                && args[6].equals("o")) {
            this.directory = args[1];
            this.name = args[3];
            this.type = args[5];
            this.output = args[7];
        }
    }


    public String getDirectory() {
        return directory;
    }

    public String getOutput() {
        return output;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
