package FinalProject;

public class ResultDisplay {
    //declare local variables
    private int mistakes = 0;

    //setter method
    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

    //constructor
    public ResultDisplay() {
    }

    //method to display results of current game round, based on mistakes
    public void displayResults(int mistakes) {
        this.mistakes = mistakes;

        switch (mistakes){
            case 0:
                System.out.println(
                        " _|____+\n" +
                        "  |/\n" +
                        "  |\n" +
                        "  |\n" +
                        "  |\n" +
                        "__|________\n" +
                        "Lives: "+ (7-mistakes) +", mistakes: " + mistakes);
                break;
            case 1:
                System.out.println(
                        " _|____+\n" +
                        "  |/\n" +
                        "  |    O\n" +
                        "  |\n" +
                        "  |\n" +
                        "__|________\n" +
                        "Lives: "+ (7-mistakes) +", mistakes: " + mistakes);
                break;
            case 2:
                System.out.println(
                        " _|____+\n" +
                        "  |/\n" +
                        "  |    O\n" +
                        "  |    |\n" +
                        "  |\n" +
                        "__|________\n" +
                        "Lives: "+ (7-mistakes) +", mistakes: " + mistakes);
                break;
            case 3:
                System.out.println(
                        " _|____+\n" +
                        "  |/\n" +
                        "  |    O\n" +
                        "  |   /|\n" +
                        "  |\n" +
                        "__|________\n" +
                        "Lives: "+ (7-mistakes) +", mistakes: " + mistakes);
                break;
            case 4:
                System.out.println(
                        " _|____+\n" +
                        "  |/\n" +
                        "  |    O\n" +
                        "  |   /|\\\n" +
                        "  |\n" +
                        "__|________\n" +
                        "Lives: "+ (7-mistakes) +", mistakes: " + mistakes);
                break;
            case 5:
                System.out.println(
                        " _|____+\n" +
                        "  |/\n" +
                        "  |    O\n" +
                        "  |   /|\\\n" +
                        "  |   /\n" +
                        "__|________\n" +
                        "Lives: "+ (7-mistakes) +", mistakes: " + mistakes);
                break;
            case 6:
                System.out.println(
                        " _|____+\n" +
                        "  |/\n" +
                        "  |    O\n" +
                        "  |   /|\\\n" +
                        "  |   / \\\n" +
                        "__|________\n" +
                        "Lives: "+ (7-mistakes) +", mistakes: " + mistakes);
                break;
            case 7:
                System.out.println(
                        " _|____+\n" +
                        "  |/   |\n" +
                        "  |    O\n" +
                        "  |   /|\\\n" +
                        "  |   / \\\n" +
                        "__|________\n" +
                        "Lives: "+ (7-mistakes) +", mistakes: " + mistakes);
                System.out.println("Unfortunately you lost!");
                break;
            default:System.out.println(
                            " _|____+\n" +
                            "  |/\n" +
                            "  |\n" +
                            "  |   \\O/\n" +
                            "  |    |\n" +
                            "__|___/_\\___\n" +
                            "Congratulations, you won!");

        }

    }

    //method to display game statistics
    public void gameStats(int lostGames, int wonGames){
        System.out.println("Games played: " + (lostGames + wonGames) + ".\nGames won: " + wonGames + ".\nGames lost: " + lostGames + ".");
    }

}
