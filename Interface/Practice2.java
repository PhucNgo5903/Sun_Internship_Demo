package Interface;

// Interface to define behavior for checking correct answers
interface CheckCorrect {
    boolean isCorrect(String answer);
}

// Abstract class representing a general question
abstract class Question {
    protected String content;

    public Question(String content) {
        this.content = content;
    }

    public void display() {
        System.out.println("Question: " + content);
    }

    // Abstract method to be implemented by subclasses
    public abstract void showOptions();
}

// Yes/No question class - inherits from Question and implements CheckCorrect
class YesNoQuestion extends Question implements CheckCorrect {
    private String correctAnswer;

    public YesNoQuestion(String content, String correctAnswer) {
        super(content);
        this.correctAnswer = correctAnswer.toLowerCase();
    }

    @Override
    public void showOptions() {
        System.out.println("Options: Yes / No");
    }

    @Override
    public boolean isCorrect(String answer) {
        return correctAnswer.equals(answer.toLowerCase());
    }
}

// Multiple-choice question class - inherits from Question and implements CheckCorrect
class ChoiceQuestion extends Question implements CheckCorrect {
    private String[] choices;
    private int correctIndex;

    public ChoiceQuestion(String content, String[] choices, int correctIndex) {
        super(content);
        this.choices = choices;
        this.correctIndex = correctIndex;
    }

    @Override
    public void showOptions() {
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }

    @Override
    public boolean isCorrect(String answer) {
        return choices[correctIndex].equalsIgnoreCase(answer);
    }
}

// Main class to demonstrate usage
public class Practice2 {
    public static void main(String[] args) {
        Question q1 = new YesNoQuestion("Is Java platform-independent?", "Yes");
        Question q2 = new ChoiceQuestion(
            "Which keyword is used to inherit a class in Java?",
            new String[]{"implements", "extends", "inherit", "instanceof"},
            1
        );

        q1.display();
        q1.showOptions();
        System.out.println("Answer 'yes' is correct? " + ((CheckCorrect) q1).isCorrect("yes"));

        System.out.println("\n---\n");

        q2.display();
        q2.showOptions();
        System.out.println("Answer 'extends' is correct? " + ((CheckCorrect) q2).isCorrect("extends"));
    }
}
