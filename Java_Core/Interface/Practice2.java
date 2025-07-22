package Interface;

interface AnswerValidator {
    boolean isCorrect(String answer);
}

interface QuestionDisplay {
    void display();
    void showOptions();
}

abstract class BaseQuestion implements QuestionDisplay {
    protected final String content;

    protected BaseQuestion(String content) {
        this.content = content;
    }

    @Override
    public void display() {
        System.out.println("Question: " + content);
    }
}

class YesNoQuestion extends BaseQuestion implements AnswerValidator {
    private final String correctAnswer;

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

class MultipleChoiceQuestion extends BaseQuestion implements AnswerValidator {
    private final String[] choices;
    private final int correctIndex;

    public MultipleChoiceQuestion(String content, String[] choices, int correctIndex) {
        super(content);
        if (correctIndex < 0 || correctIndex >= choices.length) {
            throw new IllegalArgumentException("Invalid correct index");
        }
        this.choices = choices.clone();
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

class QuestionProcessor {
    public void processQuestion(BaseQuestion question, AnswerValidator validator, String answer) {
        question.display();
        question.showOptions();
        System.out.println("Answer '" + answer + "' is correct? " + validator.isCorrect(answer));
    }
}

public class Practice2 {
    public static void main(String[] args) {
        QuestionProcessor processor = new QuestionProcessor();
        
        YesNoQuestion q1 = new YesNoQuestion("Is Java platform-independent?", "Yes");
        MultipleChoiceQuestion q2 = new MultipleChoiceQuestion(
            "Which keyword is used to inherit a class in Java?",
            new String[]{"implements", "extends", "inherit", "instanceof"},
            1
        );

        processor.processQuestion(q1, q1, "yes");
        System.out.println("\n---\n");
        processor.processQuestion(q2, q2, "extends");
    }
}
