import java.util.Scanner;

public class QuestionService {
    private Question[] questions = new Question[5];
    private String[] selection = new String[5];

    public QuestionService() {
        loadQuestions();
    }

    private void loadQuestions() {
        questions[0] = new Question(1, "What is the size of int?", "1", "10", "8", "2", "2");
        questions[1] = new Question(2, "What is the size of char?", "1", "4", "8", "10", "1");
        questions[2] = new Question(3, "What is the size of float?", "2", "8", "4", "16", "4");
        questions[3] = new Question(4, "What is the size of enum?", "10", "8", "2", "12", "2");
        questions[4] = new Question(5, "What is the size of long?", "16", "10", "32", "2", "32");
    }

    public void playQuiz() {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < questions.length; i++) {
                Question q = questions[i];
                System.out.println("Question number " + q.getId());
                System.out.println(q.getQuestionText());
                System.out.println("1. " + q.getOpt1());
                System.out.println("2. " + q.getOpt2());
                System.out.println("3. " + q.getOpt3());
                System.out.println("4. " + q.getOpt4());

                String input;
                do {
                    System.out.println("Enter your choice (1-4):");
                    input = sc.nextLine();
                } while (!input.matches("[1-4]"));

                selection[i] = input;
            }
        }
    }

    public void printScore() {
        int count = 0;
        for (int i = 0; i < questions.length; i++) {
            if (questions[i].getAnswer().equals(selection[i])) {
                count++;
            } else {
                System.out
                        .println("Question " + (i + 1) + " was incorrect. Correct answer: " + questions[i].getAnswer());
            }
        }
        System.out.println("Final Score: " + count + "/" + questions.length);
    }
}
